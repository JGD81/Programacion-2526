package com.unidad4;

//Necesario para recibir los resultados de la BD
//y recorrerlos con next()
import java.sql.ResultSet;
import java.util.HashMap;

//Clase que se encarga del acceso a datos
import com.unidad4.model.PeliculasDAO;
import com.unidad4.utils.Db;

public class EjemploConexionBruto2 {
    public static void main(String[] args) {

        // Se crea el objeto DAO, que ejecuta su constructor
        // que abre la conexión a la BD
        PeliculasDAO BDPeliculas = new PeliculasDAO();

        // El main le pide al DAO que le de todas las películas
        // guardadas en el ResulSet
        // Prueba del método getPeliculas()
        /*ResultSet rs = BDPeliculas.getPeliculas();

        try {
            // Recorremos el resultset y mostramos los datos
            // rs.next() va moviendo el cursos al siguiente registro
            // en el momento que no existe un siguiente registro, se
            // sale del bucle while
            while (rs.next()) {
                // getString e getInt va devolviendo los valores de las columnas
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Para comprobar el correcto funcionamiento del método
        // getPeliculasClasificacion,
        // se realizó una llamada desde la clase principal utilizando la constante
        // Db.CLASIF_MENORES, la cual representa las películas aptas para menores.
        rs = BDPeliculas.getPeliculasClasificacion(Db.CLASIF_MENORES);

        try {
            // Recorremos el resultset y mostramos los datos
            // rs.next() va moviendo el cursos al siguiente registro
            // en el momento que no existe un siguiente registro, se
            // sale del bucle while
            while (rs.next()) {
                // getString e getInt va devolviendo los valores de las columnas
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Comprobar el correcto funcionamiento del método getPeliculas con argumentos
        ResultSet rs = BDPeliculas.getPeliculas(1, 5, "duracion", Db.ORDEN_DESC);

        try {
            // Recorremos el resultset y mostramos los datos
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("titulo:" + rs.getString("titulo"));
                System.out.println("duracion:" + rs.getString("duracion"));
                System.out.println("clasificacion:" + rs.getInt("clasificacion"));
                System.out.println("sinopsis:" + rs.getString("sinopsis"));
                System.out.println("-----------------------------------\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Comprobar el funcionamiento de modificarPelicula

        //Creamos el HashMap con los campos a modificar
        HashMap<String, String> cambios = new HashMap<>();
        cambios.put("titulo", "Nuevo titulo de prueba");
        cambios.put("duracion", "150");
        cambios.put("sinopsis", "Sinopsis modificada desde Java");

        //Llamamos al método
        BDPeliculas.modificarPelicula(3, cambios);

        //Probar método crearPelicula
        int resultado = BDPeliculas.crearPelicula("Pulp Fiction", 1, 140, "Peli de Tarantino");
        if (resultado == 1){
            System.out.println("Pelicula creada correctamente");
        }else{
            System.out.println("Error al crear la película");
        }*/

        //Probar método borrarPelicula
        int resultado = BDPeliculas.eliminarPeliculas(7);
        if(resultado == 1){
            System.out.println("Película borrada correctamente");
        }else if (resultado == 0){
            System.out.println("No existe ninguna película con ese id");
        }else{
            System.out.println("Error al borrar la película");
        }


        

    }

}
