package com.ejercicioud4.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ejercicioud4.model.CrudModel;

public class TopoCombateDAO extends CrudModel {

    public TopoCombateDAO(){
        
        //Nombre de la tabla que usará el CRUD
        this.table = "TopoCombate";
        
        //Columna con la clave primaria
        this.idColumn = "idTopoCombate";

        //Construye Maps en executeQuery()
        //Columnas de la tabla
        this.columns = Arrays.asList(
            "idTopoCombate",
            "nombre",
            "apodoGuerra",
            "modelo",
            "fuerzaExcavacion",
            "agudezaOlfativa",
            "horasSueño",
            "tiempoTierraEnOjos",
            "idGnomoAnciano"
        );
    }

    @Override

    //Método filtrar
    public List<Map<String, Object>> filtrar(String campo, Object valor){

        //Construcción SQL
        String sql = "SELECT * FROM " + table + " WHERE " + campo + " = ?";

        //Llama al métido auxiliar padre
        return executeQuery(sql, valor);
    }

    @Override
    //Método que permite comparaciones dinámicas
    public List<Map<String, Object>> buscar(String campo, String comparador, String texto){
        
        //Se valida que el comparador sea el correcto
        if (!comparador.equals(">") &&
            !comparador.equals("<") &&
            !comparador.equals(">=") &&
            !comparador.equals("<=") &&
            !comparador.equals("!=") &&
            !comparador.equalsIgnoreCase("LIKE")) {
            
            //Excepción si el comparado no es el correcto
            throw new IllegalArgumentException("Comparador no válido");
        }

        String sql = "SELECT * FROM " + table + " WHERE " + campo + " " +
        comparador + " ?";

        //Búsqueda con LIKE con coincidencias parciales
        if (comparador.equalsIgnoreCase("LIKE")) {
            texto = "%" + texto + "%";
        }

        return executeQuery(sql, texto);
    }


    

}
