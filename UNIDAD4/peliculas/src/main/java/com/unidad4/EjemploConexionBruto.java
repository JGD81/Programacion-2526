package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class EjemploConexionBruto {
    public static void main(String[] args) {
        //Creamos la variable dotenv para poder cargar las variables del archivo .env
        Dotenv dotenv= Dotenv.configure().directory("UNIDAD4/peliculas").load();

        //Se asignan los valores a las variables java desde el fichero .env
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbNambe = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        //Creamos la url de conexión con el formato para mysql
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbNambe;

        //Declaramos la conexión
        Connection con = null;

        //Se comprueba todo en lo que la base de datos puede fallar
        try {
            
            //Comprobamos si el driver de la conexión a bd está en el proyecto
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Se realiza la conexión a la base de datos
            con = DriverManager.getConnection(url, user, password);
            
            //Se realiza una consulta a la base de datos
            String query = "select * from pelicula";
            
            //Se crea el Statement (objeto que envía SQL a la base de datos)
            Statement stmt = con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            ResultSet rs = stmt.executeQuery(query);

            // Al hacer next sobre los resultados nos posicionamos en el primer
            // elemento/registro
            rs.next();

            // Con rs.getxxx('campo') nos devuelve el valor
            System.out.println("Titulo " + rs.getString("titulo") + " y duracion " + rs.getString("duracion"));

            // Al hacer next sobre los resultados nos posicionamos en el primer
            // elemento/registro
            rs.next();

            // Con rs.getxxx('campo') nos devuelve el valor
            System.out.println("Titulo " + rs.getString("titulo") + " y duracion " + rs.getString("duracion"));

            // Al hacer next sobre los resultados nos posicionamos en el primer
            // elemento/registro
            rs.next();

            // Con rs.getxxx('campo') nos devuelve el valor
            System.out.println("Titulo " + rs.getString("titulo") + " y duracion " + rs.getString("duracion"));

            // Si metemos dentro de la condicion el rs.next() pasa al siguiente elemento
            // Y solo entra si existe un siguiente registro
            if (rs.next()) {

                // Con rs.getxxx('campo') nos devuelve el valor
                System.out.println("Titulo " + rs.getString("titulo") + " y duracion " + rs.getString("duracion"));
            }

            // Cierra la conexion a la bd
            con.close();
            
         } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
    }
}
