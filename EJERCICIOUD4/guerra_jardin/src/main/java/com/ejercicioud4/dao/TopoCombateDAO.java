package com.ejercicioud4.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ejercicioud4.model.CrudModel;
import com.ejercicioud4.model.TopoCombateDO;

public class TopoCombateDAO extends CrudModel {

    public TopoCombateDAO() {

        // Nombre de la tabla que usará el CRUD
        this.table = "TopoCombate";

        // Columna con la clave primaria
        this.idColumn = "idTopoCombate";

        // Construye Maps en executeQuery()
        // Columnas de la tabla
        this.columns = Arrays.asList(
                "idTopoCombate",
                "nombre",
                "apodoGuerra",
                "modelo",
                "fuerzaExcavacion",
                "agudezaOlfativa",
                "horasSueño",
                "tiempoTierraEnOjos",
                "idGnomoAnciano");
    }

    @Override

    // Método filtrar
    public List<Map<String, Object>> filtrar(String campo, Object valor) {

        // Construcción SQL
        String sql = "SELECT * FROM " + table + " WHERE " + campo + " = ?";

        // Llama al métido auxiliar padre
        return executeQuery(sql, valor);
    }

    @Override
    // Método que permite comparaciones dinámicas
    public List<Map<String, Object>> buscar(String campo, String comparador, String texto) {

        // Se valida que el comparador sea el correcto
        if (!comparador.equals(">") &&
                !comparador.equals("<") &&
                !comparador.equals(">=") &&
                !comparador.equals("<=") &&
                !comparador.equals("!=") &&
                !comparador.equalsIgnoreCase("LIKE")) {

            // Excepción si el comparado no es el correcto
            throw new IllegalArgumentException("Comparador no válido");
        }

        String sql = "SELECT * FROM " + table + " WHERE " + campo + " " +
                comparador + " ?";

        // Búsqueda con LIKE con coincidencias parciales
        if (comparador.equalsIgnoreCase("LIKE")) {
            texto = "%" + texto + "%";
        }

        return executeQuery(sql, texto);
    }

    // Método devolver topos del gnomo que tengan tiempoTierraEnOjos > 0
    public ArrayList<TopoCombateDO> cargarToposConTierraEnOjos(int idGnomoAnciano) {

        //Se crea la lista para guardar los topos
        ArrayList<TopoCombateDO> lista = new ArrayList<>();

        //Se crea la consulta SQL
        String sql = "SELECT * FROM TopoCombate " +
                "WHERE IdGnomoAnciano = ? AND tiempoTierraEnOjos > 0";
       
        //Se crea el PreparedStatement con la conexión con. El try cierra
        //automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            //Se pasa el valor recibido por parámetro
            stmt.setInt(1, idGnomoAnciano);

            //Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            //Devuelve true mientras haya registros
            while (rs.next()) {

                //Se leen las columnas y se convierte al tipo indicado
                TopoCombateDO topo = new TopoCombateDO(
                        rs.getInt("idTopoCombate"),
                        rs.getNString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getString("modelo"),
                        rs.getInt("fuerzaExcavacion"),
                        rs.getInt("agudezaOlfativa"),
                        rs.getInt("horasSueño"),
                        rs.getInt("tiempoTierraEnOjos"),
                        rs.getInt("idGnomoAnciano"));
                
                //Se añade el objeto a la lista
                lista.add(topo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Se devuelve la lista ya cargada
        return lista;
    }

    // Método devuelve topos con horasSueño >= 8
    public ArrayList<TopoCombateDO> cargarToposDescansados(){

        //Se crea la lista vacía
        ArrayList<TopoCombateDO> lista = new ArrayList<>();

        //Se crea la consulta SQL
        String sql = "SELECT * FROM TopoCombate";

        //Se crea el PreparedStatement con la conexión con. El try cierra
        //automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)){
           
            //Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            //Devuelve true mientras haya registros
            while (rs.next()) {
                
                //Guardamos las horas en una variable auxiliar
                int horas = rs.getInt("horasSueño");

                //Se crea el objeto si cumple esta condición
                if (horas >= 8){

                    //Se leen las columnas y se convierte al tipo indicado
                    TopoCombateDO topo = new TopoCombateDO(
                        rs.getInt("idTopoCombate"),
                        rs.getNString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getString("modelo"),
                        rs.getInt("fuerzaExcavacion"),
                        rs.getInt("agudezaOlfativa"),
                        rs.getInt("horasSueño"),
                        rs.getInt("tiempoTierraEnOjos"),
                        rs.getInt("idGnomoAnciano")
                    );

                    //Se añade a la lista
                    lista.add(topo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Se devuelve la lista
        return lista;
    }

    //Método calcular promedio de excavación en topos del gnomo
    public double calcularPromedioFuerzaExcavacion(int idGnomoAnciano){

        //Se crea la consulta
        String sql = "SELECT * FROM TopoCombate WHERE idGnomoAnciano = ?";

        //Se crean variables acumuladoras
        //Suma acumula fuerzas, contador cuenta topos
        int suma = 0;
        int contador = 0;

        //Se crea el PreparedStatement con la conexión con. El try cierra
        //automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)){

            //Se pasa el valor recibido por parámetro
            stmt.setInt(1, idGnomoAnciano);

            //Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();
            
            //Devuelve true mientras haya registros
            while (rs.next()) {
                
                //Se suma las fuerzas
                suma += rs.getInt("fuerzaExcavacion");
                //Se cuentan los topos
                contador ++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Se evita dividir entre 0
        if (contador == 0){
            return 0;
        }

        //Se convierte la suma a duble para hacer la división entera
        return (double) suma / contador;
    }

    //Método paginación topos con LIMIT y OFFSET
    public ArrayList<TopoCombateDO> cargarToposPaginado(int numElem, int numPag){

        //Se crea la lista vacía
        ArrayList<TopoCombateDO> lista = new ArrayList<>();

        //Se crea la consulta
        String sql = "SELECT * FROM TopoCombate LIMIT ? OFFSET ?";

        //Calcula cuántos registros saltar
        int offset = (numPag - 1) * numElem;

        //Se crea el PreparedStatement con la conexión con. El try cierra
        //automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            
            //Se pasa el valor por los parámetros
            stmt.setInt(1, numElem);
            stmt.setInt(2, offset);

            //Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            //Devuelve true mientras haya registros
            while (rs.next()) {

                //Se leen las columnas y se convierte al tipo indicado
                TopoCombateDO topo = new TopoCombateDO(
                        rs.getInt("idTopoCombate"),
                        rs.getNString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getString("modelo"),
                        rs.getInt("fuerzaExcavacion"),
                        rs.getInt("agudezaOlfativa"),
                        rs.getInt("horasSueño"),
                        rs.getInt("tiempoTierraEnOjos"),
                        rs.getInt("idGnomoAnciano")
                    );

                    //Se añaden a la lista
                    lista.add(topo);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Se devuelve la lista
        return lista;
    }

}
