package com.unidad4.model;

//Objeto que envía consultas SQL a la base de datos
import java.sql.Statement;
//Representa la conexión abierta con la base de datos
import java.sql.Connection;
//Contiene los resultados de una consulta SELECT
import java.sql.ResultSet;
//Db es la clase que se encarga de conectar la BD
import com.unidad4.utils.Db;

//DAO: Data Access Object
//La responsabilidad de esta clase es:
//Hablar con la base de datos, ejecutar consultas y
//devolver datos
public class PeliculasDAO {

    // Variable que guarda la conexión a la BDD
    // Es private porque sólo esta clase debe usarla
    // y porque desde fuera nadie debe tocarla
    private Connection con;

    // Este método se ejecuta automáticamente cuando hacemos:
    // new PeliculasDAO(); y llama a Db.conectar()
    // Estos significa que en el momento que se crea el objeto
    // ya estás conectado a la BD
    public PeliculasDAO() {
        this.con = Db.conectar();
    }

    // Obtiene todas las películas de la base de datos
    // Devuelve un Resulset con los resultados
    public ResultSet getPeliculas() {

        // Inicializamos rs en null porque todavía no hay resultado
        // y si algo falla, se devuelve null
        ResultSet rs = null;

        try {

            // Se crea la consulta SQL que se quiere ejecutar
            String query = "select * from pelicula";

            // Se crea la sentencia:
            // createStatement() - Se crea el "mensajero"
            // Statement - Es quien manda el SQL a la BD
            // Sin Statement no puedes ejecutar SQL
            Statement stmt = this.con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            // Se envía la consluta a la BD, MySQL la ejecuta
            // devuelve los resultados y se guardan en rs
            // executeQuery sólo se usa para SELECT
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        // Devuelve los datos al programa que llamó al método
        return rs;
    }

}
