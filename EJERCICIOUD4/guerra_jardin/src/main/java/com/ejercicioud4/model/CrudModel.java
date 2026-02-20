package com.ejercicioud4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ejercicioud4.utils.ConexionBD;

public abstract class CrudModel {
    
    //Atributos
    //Conexión a la base de datos
    protected Connection con;
    //Atributo para guardar el nombre de la tabla
    protected String table;
    //Atributo para el id de cada columna
    protected String idColumn;
    //Atributo para guardar el nombre de las columnas
    protected List<String> columns;

    //Llama al método conectar() de la clase ConexionDB para
    //reutilizar la lógica de conexión.
    public CrudModel(){
        this.con = ConexionBD.conectar();
    }

    //Método auxiliar
    protected List<Map<String, Object>> executeQuery(String sql, Object... params){

        //Creamos la lista de resultados
        List<Map<String,Object>> lista = new ArrayList<>();

        //Try con recursos (el PreparedStatement se cerrará automáticamente)
        try (PreparedStatement stmt = con.prepareStatement(sql)){

            //Asignación de parámetros
            for(int i= 0; i < params.length; i++){
                stmt.setObject( i + 1, params[i]);
            }
            
            //Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();
            
            //Se recorren los resultados 
            while (rs.next()) {

                //Crear un registro
                Map<String, Object> registro = new HashMap<>();

                //Cargar las columnas dinámicamente
                for (String col : columns){
                    registro.put(col, rs.getObject(col));
                }

                //Añade el registro a la lista
                lista.add(registro);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Se devuelve la lista
        return lista;
    }

    //Método Obtener todos los registros de la tabla
    public List<Map<String,Object>> findAll(){
        
        //Creamos la consulta
        String sql = "SELECT * FROM " + table;

        //Devolvemos el resultado de la consulta usando el método auxilar
        return executeQuery(sql);
    }

    //Método buscar por ID
    public Map<String,Object> findById(Object id){

        //Se construye la consulta
        String sql = "SELECT * FROM " + table + "WHERE " + idColumn + " = ?";

        //Ejecutamos la consulta
        List<Map<String,Object>> lista = executeQuery(sql, id);
        
        //Devuelve true si la lista no tiene elementos
        //o el elemento obtenido
        return lista.isEmpty() ? null : lista.get(0);
    }

    //Método eliminar por ID
    public boolean delete(Object id){
        
        //Se construye la consulta
        String sql = "DELETE FROM " + table + " WHERE " + idColumn + " = ?";

        //Try con recursos
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            
            //Se le asigna el ID al ? (1 indica columna del ID)
            stmt.setObject(1, id);

            //Se utiliza executeUpdate() para realizar INSERT, UPDATE ó DELETE
            //Devuelve un int con las filas afectadas
            int filasAfectadas = stmt.executeUpdate();

            //Si se elimina una fila, true
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Si ocurre excepción, devuelve false
        return false;
    }

    //Método que actualiza el registro (UPDATE)
    public boolean update(Object id, Map<String,Object> data){
        
        //Crear SQL dinámico
        StringBuilder sql = new StringBuilder("UPDATE " + table + " SET ");

        //Se recorren las columnas
        for(String col : data.keySet()){
            
            //Añade texto al StringBuilder
            sql.append(col).append(" = ?, ");
        }

        //Se elimina la coma y el espacio final
        sql.setLength(sql.length() - 2);

        //Se añade el WHERE a la consulta
        sql.append(" WHERE ").append(idColumn).append(" = ?");

        //Try con recursos, que también convierte StringBuilder en String normal
        try (PreparedStatement stmt = con.prepareStatement(sql.toString())){
            
            //Índice de parámetros (JDBD ? empiezan en 1)
            int index = 1;

            //Se asignan los valores del Map
            for (Object value : data.values()){
                
                //Se devuelve la colección con los valores
                //index++ para usar el valor actual, luego incrementar
                stmt.setObject(index++, value);
            }

            //Asignar ID (se asigna al último ?)
            stmt.setObject(index, id);

            //Ejecutar el UPDATE
            int filasAfectadas = stmt.executeUpdate();

            //Devolver resultado (true actualizó)
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Si ocurre excepción, devuelve false
        return false;

    }

    //Método insert (Inserta registro y devuelve ID generado)
    public long insert(Map<String,Object> data){

        //Se crea el inicio de la consulta SQL
        StringBuilder sql = new StringBuilder("INSERT INTO " + table + " (");

        //Añadir los nombres de las columnas
        for(String col : data.keySet()){

            //Se añade los valores del insert, separados por comas
            sql.append(col).append(", ");
        }

        //Quitar la última coma y el espacio
        sql.setLength(sql.length() - 2);

        //Se añade VALUES a la consulta
        sql.append(") VALUES (");

        //Se añaden ? segun el número de columnas
        for(int i = 0; i < data.size(); i++){
            
            //Se añade ?
            sql.append("?, ");
        }

        //Quitar la última coma y el espacio
        sql.setLength(sql.length() - 2);

        //Cerrar el paréntesis
        sql.append(")");

        //Después del INSERT, se devuelve el ID autogenerado
        try (PreparedStatement stmt = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS)){
            
            //Índice de parámetros (JDBD ? empiezan en 1)
            int index = 1;

             //Se asignan los valores del Map
            for(Object value : data.values()){
                
                //Se devuelve la colección con los valores
                //index++ para usar el valor actual, luego incrementar
                stmt.setObject(index++, value);
            }

            //Inserta el registro
            stmt.executeUpdate();

            //Devuelve un resulset con el ID nuevo
            ResultSet rs = stmt.getGeneratedKeys();

            //Mueve al primer resultado
            if (rs.next()){

                //Obtiene la primera columna (ID)
                return rs.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Si algo falla (-1 no puede ser un valor ID)
        return -1;
    }




}
