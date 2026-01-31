//Este archivo aparece en otra carpeta, porque pertenece al modelo de
//datos, no al programa principal
package com.unidad4.model;

//Objeto que envía consultas SQL a la base de datos
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
//Representa la conexión abierta con la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    // Public: puede usarse fuera del DAO
    // Resulset: Devolverá los resultados de la BD
    // int clasificacion: recibe un valor para filtrar las películas
    public ResultSet getPeliculasClasificacion(int clasificacion) {
        // Inicializamos rs en null porque todavía no hay resultado
        // y si algo falla, se devuelve null

        ResultSet rs = null;

        try {

            // Consulta SQL con parámetro. Mediante ?, hacemos el parámetro
            // dinámico y evitamos inyección SQL, siendo más seguro y permitiendo
            // reutilizar la consulta
            String query = "select * from pelicula where clasificacion = ?";
            // A diferencia con Statement, PrepareStatement es SQL con parámetros
            // y más seguro. Permite:
            // - Enviar consultas SQL a la base de datos
            // - Usar parámetros dinámicos (?)
            // - Evitar inyección SQL
            // - Mejorar el rendimiento
            // Proviene de private Connection con, y se inicializa en el
            // constructor this.com = DB.conectar();
            // prepareStatement le dice a la base de datos "Prepárate para
            // ejecutar esta consulta SQL (String query = "select * from
            // pelicula where clasificacion ?""
            PreparedStatement stmt = this.con.prepareStatement(query);
            // Asigna un valor real al símbolo ?
            // -Inserta un número entero en ?
            // -1 indica la posición del = en la consulta (número de ?)
            // clasificacion es el valor que sustituirá a ?
            stmt.setInt(1, clasificacion);
            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    // En el siguiente método, se introducen los siguientes parámetros:
    // - pagina: Qué página quieres ver
    // - numElementos: Cuántos registros por página
    // - orden: Columna por la que ordenar
    // - sentidoorden: ascendente o descendente
    public ResultSet getPeliculas(int pagina, int numElementos, String orden, int sentidoOrden) {

        // Inicializamos rs en null porque todavía no hay resultado
        // y si algo falla, se devuelve null
        ResultSet rs = null;

        try {
            // Le dice a MySQL desde qué fila empezar
            // Comienza en la página introducida y se muestran un número determinado de
            // elementos
            int offset = (pagina - 1) * numElementos;

            // Se crea la consulta básica y, a partir de aquí, se va modificando:
            // orden, limit y offset
            String query = "select * from pelicula";

            // Para que no de errores al ordenar (el usuario no quiere ordenar)
            // se evitan errores si orden es null
            if (orden != null) {
                // Se le añade a la consulta ORDER BY
                query += " order by " + orden;
                if (sentidoOrden == Db.ORDEN_DESC)
                    // Si el orden es descentente
                    // sino, será ascendente por defecto
                    query += " desc ";
            }

            // Añadimos la paginación
            // - Limita el número de resultados y desde donde se empieza
            query += " limit " + numElementos + " offset " + offset;

            // Se crea la sentencia:
            // createStatement() - Se crea el "mensajero"
            // Statement - Es quien manda el SQL a la BD
            // Sin Statement no puedes ejecutar SQL
            Statement stm = this.con.createStatement();

            // Ejecutamos la consluta y guardamos los resultados en un
            // resulset
            rs = stm.executeQuery(query);

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    // Método que modifica una película en la BD. Sólo cambia los campos que
    // se le pasen y devuelve cuántas filas se modificaron
    public int modificarPelicula(int id, HashMap<String, String> campos) {

        // Por defecto: -1 (error), 1 (se modificó), 0 (no se encontró la película)
        int columnasModificadas = -1;

        try {

            // Query base para hacer modificaciones en SQL
            // UPDATE: Modifica la tabla
            // SET: Qué columnas cambian
            String query = "update pelicula set ";

            // Sirve para no poner coma antes del primer campo
            boolean primerCampo = true;

            // La forma adecuada de recorrer este HashMap es con entrySet,
            // ya que lo recorre devolviendo clave + valor juntos
            // MapEntry es un objeto que contiene clave y valor
            // Significado del for: Para cada clave-valor dentro del HashMap campos
            for (Map.Entry<String, String> campo : campos.entrySet()) {
                // Si es el primer campo, no pongo coma y marco que sl siguiente ya
                // no será el primero y sí que se pone
                if (primerCampo) {
                    primerCampo = false;
                } else {
                    query += ",";
                }
                // Vamos construyendo la query con cada iteración
                // titulo=?, duracion=?,...
                query += campo.getKey() + "=?";
            }

            // Una vez construída dinámicamente la Query con los campos,
            // añadimos lo siguiente para modificar SOLO esa película
            // (si no se añade, se modifican TODAS)
            query += " where id = ?";
            // Preparamos la consulta
            PreparedStatement stmt = con.prepareStatement(query);

            // Ajustamos la posición el el prepareStatement (empieza en 1, no 0)
            int posicion = 1;
            // Mediante el siguiente for, vamos a ir añadiendo los valores a ?
            for (Map.Entry<String, String> campo : campos.entrySet()) {

                // Si el campo es texto (casos de titulo y sinopsis)
                if (campo.getKey().equals("titulo") || campo.getKey().equals("sinopsis")) {
                    // Se utiliza la posición y el valor para texto
                    stmt.setString(posicion, campo.getValue());
                } else {
                    // Se utiliza la posición y el valor para entero
                    // Se usa Integer.valueOF porque el HashMap guarda todo como
                    // String (hay que cambiar el tipo a entero)
                    stmt.setInt(posicion, Integer.valueOf(campo.getValue()));
                }

                // Pasamos de posición
                posicion++;
            }
            // Asignamos al ? del WERE el id
            stmt.setInt(posicion, id);
            // Ejecutamos la consulta
            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return columnasModificadas;
    }

    // Método para insertar películas
    // Parámetros - datos de la película.
    // Aquí NO se pasa SQL, sólo los datos de la película
    public int crearPelicula(String titulo, int clasificacion, int duracion, String sinopsis) {

        // Variable de control con -1 por defecto (error)
        // Se sobreescribe con 1 si todo va bien
        int columnasModificadas = -1;

        try {
            // Insert into (insertar nuevo registro)
            // ? son parámetros
            // No se concatenan strings (más seguro)
            String query = "insert into pelicula (titulo,clasificacion, duracion, sinopsis) values (?, ?, ?, ?)";

            // Preparamos la consulta
            PreparedStatement stmt = con.prepareStatement(query);

            // Se le asignan los valores a cada ?, recibidos por parámetros
            stmt.setString(1, titulo);
            stmt.setInt(2, clasificacion);
            stmt.setInt(3, duracion);
            stmt.setString(4, sinopsis);

            // Ejecutamos el INSERT (devuelve las filas modificadas)
            columnasModificadas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return columnasModificadas;

    }

    //Método para eliminar películas por medio de su id
    public int eliminarPeliculas(int id){

        //Variable de control
        // -1 Error, Se sobreescribe, correcto
        int columnasBorradas = -1;

        try {
            
            //Delete from - elimina registros
            //Where id=? - solo una película
            //? Parámetro seguro
            String query = "delete from pelicula where id=?";
            
            //Preparamos la sentencia
            PreparedStatement stmt = con.prepareStatement(query);

            //Asignamos el parámetro
            stmt.setInt(1, id);

            //Ejecutamos el Delete
            columnasBorradas = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("hubo un problema al borrar la id " + id);
            e.printStackTrace();
        }

        return columnasBorradas;
    }

}
