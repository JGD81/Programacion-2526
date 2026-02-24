package com.ejercicioud4.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Importa la clase base que contiene el CRUD
import com.ejercicioud4.model.CrudModel;

//Hereda los métodos y atributos protegidos de CrudModel
public class GnomoAncianoDAO extends CrudModel {
    
    //Primero se ejecuta el constructor padre (CrudModel)
    //que abre la conexión con la BDD. Después se ejecuta 
    //el constructor
    public GnomoAncianoDAO(){
        
        //Nombre tabla que usará el CRUD
        this.table = "GnomoAnciano";

        //Columna con clave primaria
        this.idColumn = "idGnomoAnciano";

        //Construye Maps en executeQuery()
        //Columnas de la tabla
        this.columns = Arrays.asList(
            "idGnomoAnciano",
            "nombre",
            "apodoGuerra",
            "edad",
            "alturaBarba",
            "nivelCascarrabias",
            "energiaRefunfuño"
        );
    }

    @Override
    
    //Método filtrar
    public List<Map<String, Object>> filtrar(String campo, Object valor){

        //Consulta SQL
        String sql = "SELECT * FROM " + table + " WHERE " + campo + " = ?";

        //Llama al método auxiliar padre
        return executeQuery(sql, valor);
    }

    @Override

    //Método que permite comparaciones dinámicas
    public List<Map<String, Object>> buscar(String campo, String comparador, String texto){

        if (!comparador.equals(">") &&
            !comparador.equals("<") &&
            !comparador.equals(">=") &&
            !comparador.equals("<=") &&
            !comparador.equals("!=") &&
            !comparador.equalsIgnoreCase("LIKE")){

            throw new IllegalArgumentException("Comparador no válido");
        }

        String sql = "SELECT * FROM " + table + " WHERE " + campo + " " + comparador + " ?";

        if (comparador.equalsIgnoreCase("LIKE")){
            texto = "%" + texto + "%";
        }

        return executeQuery(sql, texto);
    }
}
