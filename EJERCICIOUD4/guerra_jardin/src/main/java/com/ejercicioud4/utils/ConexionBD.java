package com.ejercicioud4.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConexionBD {

    //Método en static para que no se necesite la creación
    //del objeto y para realizar la conexión desdde cualquier clase
    public static Connection conectar(){
        
        //Creamos el Dotenv para cargar las variables del archivo .env
        Dotenv dotenv = Dotenv.configure().directory("EJERCICIOUD4/guerra_jardin") .load();
        //Se lee cada variable del .env y se guarda en variables Java
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME"); 
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        //Se crea la URL de conexión con el formato para mysql
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        //La conexión empieza en null, por si algo falla
        Connection con = null;

        try {
            
            //Se comprueba si el driver MySQL está en el proyecto
            //Si no se encuentra, se devuelve error de inmediato
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Se realiza la conexión usando los datos necesarios
            con = DriverManager.getConnection(url, user,password);
            
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Error al conectar la base de datos");
            e.printStackTrace();
        }

        //Se devuelve la conexión. Si no se conectó, devuelve null
        return con;
    }   
}
