package com.unidad4.utils;
// Representa la conexión abierta con la base de datos
import java.sql.Connection;
//
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

//Creamos la clase Db (DataBase), que contendrá los métodos para
//conectarse a la base de datos
public class Db {
    
    //Creamos el método conectar static, para que no haga falta crear un objeto
    //db y para realizar desde cualquier sitio Db.conectar()
    public static Connection conectar(){
        
        //Al crear un Dotenv, cargamos esl archivo .env que contiene todas las variables
        //Podemos añadir la ubicación en el caso de que se produzca el error
        //de que no se encuentra el archivo .env
        Dotenv dotenv = Dotenv.configure().directory("UNIDAD4/peliculas").load();
        
        //Se lee cada variable del .env y se guarda en variables Java
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String dbName = dotenv.get("DB_NAME");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        //Se crea la URL de conexión con el formato para mysql
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        //La conexión empieza con el valor null, por si algo falla
        //Así sabemos que la conexión no se pudo crear
        Connection con = null;

        try {
            //Se comprueba si el driver MySQL está en el proyecto.
            //Si no se encuentra, se devuelve error de inmediato
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Se realiza la conexión a la base de datos usando los datos necesarios
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            //Muestra los errores por pantalla
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        //Se devuelve la conexión. Si no se conectó, devuelve null
        return con;
    }

    //En este caso, se reciben los datos de conexión por parámetros,
    //no a través del archivo .env
    public static Connection conectar(String url, String user, String password){
            
        //Si algo falla, se devuelve null
        Connection con = null;

        try {
            //Se comprueba si el driver de MySQL está disponible
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Se conecta a la base de datos recibiendo los parámetros recibidos
            //Permite también cambiar BD, usuario o contraseña en tiempo de ejecución
            con = DriverManager.getConnection(url, user, password);

            //Este error aparece si falta el driver de MySQL o falta la dependencia en Maven
        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
            //Este error aparece si:
            //Usuario o contraseña incorrecta, BD no existe, puerto incorrecto
            //mySQL apagado
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        //Si todo va bien, conexión válida. Si algo falló, null
        return con;
        
    }
}
