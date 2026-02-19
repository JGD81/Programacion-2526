package com.unidad4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unidad4.utils.Db;

public class CrudDAO {
    //Conexión a la base de datos
    public Connection con;
    //Se le asignará desde una clase hija y así será reutilizable
    //por todas las tablas
    public String nombreTabla;
    //Lista para el nombre de las columnas
    public List<String> campos;

    //Cada vez que se crea el DAO:
    //Se conecta automáticamente
    //Guarda la conexión en la variable con
    //(No hay que conectarse manualmente cada vez)
    public CrudDAO(){
        this.con = Db.conectar();
    }

    //Object es más flexible que int, ya que se puede trabajar con
    //cualquier tipo, no necesariamente con int
    public ResultSet cargarPorId(Object id){
        //Se declara una variable para guardar los resultados
        ResultSet rs = null;
        //Bloque Try Catch
        try {
            //Se construye dinámicamente la consulta
            String query = "select * from " + nombreTabla + " where id = ?";
            // Preparación de la consulta
            PreparedStatement stmt = this.con.prepareStatement(query);
            //Se rellena el primer ? con el valor de id
            stmt.setObject(1, id);
            //Ejecución de la consulta, que devuelve un Resulset
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    //Método para cargar lista por id
    public Map<String, Object> cargarListaPorId(Object id){
        //Se declaran las variables
        ResultSet rs = null;
        Map registro = null;

        try {
            //Se repite la misma lógica que en el método anterior
            //Se construye dinámicamente la consulta
            String query = "select * from " + nombreTabla + " where id = ?";
            // Preparación de la consulta
            PreparedStatement stmt = this.con.prepareStatement(query);
            //Se rellena el primer ? con el valor de id
            stmt.setObject(1, id);
            //Ejecución de la consulta, que devuelve un Resulset
            rs = stmt.executeQuery();
            //Crea un mapa vacío
            // Ejemplo de crear un único registro, actor
            /*
             * Map actor = new HashMap<String,Object>();
             * actor.put("id",3);
             * actor.put("nombre","Juan José");
             * actor.put("nacionalidad", "Frances");
             * actor.put("fecha_nac",LocalDate.now().minusYears(18));
             */
            registro = new HashMap<String, Object>();

            //Campos es la lista de nombres de columnas
            //- rs.getObject(campo) obtiene su valor
            //- Se guarda en el Map
            for (String campo : campos){
                registro.put(campo, rs.getObject(campo));
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return registro;
    }

    //Método cargarTodos (devuelve todos los registros)
    //sin introducir WHERE en la consulta
    public ResultSet cargarTodos(){
        ResultSet rs = null;

        try {
            //Creamos la consulta sql
            String query = "select * from " + nombreTabla;

            //Preparamos la consulta
            PreparedStatement stmt = this.con.prepareStatement(query);

            //Ejecutamos y guardamos los datos en un resulset
            rs = stmt.executeQuery();
        
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    //Método cargarListaTodos
    //Devuelve: Lista de registros
    //Cada registro = Map
    public List<Map<String, Object>> cargarListaTodos(){
        //Variable para guardar los resultados
        ResultSet rs = null;
        //Variable del tipo lista
        List<Map<String,Object>> listaDatos = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + nombreTabla;

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

            //Crear lista vacía
            listaDatos = new ArrayList<Map<String, Object>>();

            //Se recorre el resultset
            //Cada vuelta, una fila
            while (rs.next()) {
                // Cargamos en un map los datos del resultset actual
                // utilizando la lista de campos que tenemos
                Map<String, Object> registro = new HashMap<String, Object>();
                //Se cargan dinámicamente las columnas
                 for (String campo : campos) {
                    registro.put(campo, rs.getObject(campo));
                }
                //Se añade ese registro a la lista
                listaDatos.add(registro);
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return listaDatos;
    }
}
