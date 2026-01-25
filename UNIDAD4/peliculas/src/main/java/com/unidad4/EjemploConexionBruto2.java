package com.unidad4;

//Necesario para recibir los resultados de la BD
//y recorrerlos con next()
import java.sql.ResultSet;
//Clase que se encarga del acceso a datos
import com.unidad4.model.PeliculasDAO;

public class EjemploConexionBruto2 {
    public static void main(String[] args) {
        
        //Se crea el objeto DAO, que ejecuta su constructor
        //que abre la conexión a la BD
        PeliculasDAO BDPeliculas = new PeliculasDAO();

        //El main le pide al DAO que le de todas las películas 
        //guardadas en el ResulSet
        ResultSet rs = BDPeliculas.getPeliculas();

        try {
            // Recorremos el resultset y mostramos los datos
            //rs.next() va moviendo el cursos al siguiente registro
            //en el momento que no existe un siguiente registro, se
            //sale del bucle while
            while (rs.next()) {
                //getString e getInt va devolviendo los valores de las columnas
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
