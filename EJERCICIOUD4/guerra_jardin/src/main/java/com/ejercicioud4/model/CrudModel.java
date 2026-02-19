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

        //Creamos la lista
        List<Map<String,Object>> lista = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql)){

            for(int i= 0; i < params.length; i++){
                stmt.setObject( i + 1, params[i]);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Map<String, Object> registro = new HashMap<>();

                for (String col : columns){
                    registro.put(col, rs.getObject(col));
                }

                lista.add(registro);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


}
