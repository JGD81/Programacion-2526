package com.ejerciciorefuerzo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

//La clase es abstracta porque no se puede instanciar
//Será la clase base para los DAO
//Cotendrá lógica comun
public abstract class CrudModel {

    // Guarda la conexión a la base de datos
    // Es protected para que las clases hijas puedan usarla
    // No es private porque las DAO la necesitan
    protected Connection con;
    // Aquí se guardará el nombre de la tabla.
    // No se define aquí porque cada DAO tendrá su tabla
    protected String table;
    // Lista de columnas de la tabla
    // Sirve para construir SQL dinámico
    // Controla el orden de los parámetros
    protected List<String> columns;

    // Recibe la conexión
    // La guarda en el atributo
    // Las clases hijas llamarán a super(con)
    public CrudModel(Connection con) {
        this.con = con;
    }

    public long insert(Map<String, Object> data) {

        // Devolvemos -1 en caso de error
        long generateId = -1;

        try {
            // Se crea la primera parte de la consulta
            // INSERT INTO table (
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ")
                    .append(table)
                    .append(" (");

            // Se recorre la lista columns
            for (int i = 0; i < columns.size(); i++) {
                // Se van añadiendo las columnas
                sql.append(columns.get(i));
                // Se van añadiendo comas después de la columna
                // Menos la última (que no tiene, por eso el -1)
                if (i < columns.size() - 1) {
                    sql.append(", ");
                }
            }

            // Resultado parcial: INSERT INTO table (columna1, columna2...
            // Cerramos las columnas y abrimos VALUES
            sql.append(") VALUES (");
            // Resultado parcial:
            // INSERT INTO table (columna1, columna 2...) VALUES(
            // Introducimos en values los ? para el PreparedStatement
            for (int i = 0; i < columns.size(); i++) {
                sql.append("?");
                // Igualmente, no añadimos coma en el útlimo ?
                if (i < columns.size() - 1) {
                    sql.append(", ");
                }
            }

            // Cerramos el último )
            sql.append(")");

            // Convertimos el StringBuilder a String, ya que PreparedStatement
            // necesita un String, no un StringBuilder
            String finalSql = sql.toString();

            if(!data.keySet().containsAll(columns)){
                throw new IllegalArgumentException("Faltan columnas en el Map");
            }

            // Creación del PreparedStatement
            // con: es la conexión
            // finalSql: es el insert dinámico
            // Statement.RETURN_GENERATED_KEYS: indica que queremos recuperar la clave
            // autogenerada
            // Si no se añade esto último, getGeneratedKeys() no devolvería nada.
            PreparedStatement stmt = con.prepareStatement(finalSql, Statement.RETURN_GENERATED_KEYS);

            

            // Recorremos los nombres de las columnas guardados en la lista columns
            for (int i = 0; i < columns.size(); i++) {
                // Obtenemos el valor correspondiente a la columna actual desde el Map
                Object valor = data.get(columns.get(i));
                // Asignamos el valor al parámetro correspondiente del PreparedStatement
                // (recordar que en JDBC los índices empiezan en 1)
                stmt.setObject(i + 1, valor);
            }

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                generateId = rs.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generateId;

    }
}
