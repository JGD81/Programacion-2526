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


}
