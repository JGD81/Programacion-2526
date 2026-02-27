package com.ejercicioud4.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ejercicioud4.model.CrudModel;

public class HadaMadrinaDAO extends CrudModel {

    // Primero se ejecuta el constructor padre (CrudModel)
    // que abre la conexión con la BDD. Después se ejecuta
    // el constructor
    public HadaMadrinaDAO() {

        // Nombre tabla que usará el CRUD
        this.table = "HadaMadrina";

        // Columna con clave primaria
        this.idColumn = "idHadaMadrina";

        // Construye Maps en executeQuery()
        // Columnas de la tabla
        this.columns = Arrays.asList(
                "idHadaMadrina",
                "nombre",
                "apodoGuerra",
                "edad",
                "envergaduraAlas",
                "nivelPasivoAgresividad",
                "polvoPurpurina");
    }

    @Override

    // Método filtrar
    public List<Map<String, Object>> filtrar(String campo, Object valor) {

        // Consulta SQL
        String sql = "SELECT * FROM " + table + " WHERE " + campo + " = ?";

        // Llama al método auxiliar padre
        return executeQuery(sql, valor);
    }

    @Override

    // Método que permite comparaciones dinámicas
    public List<Map<String, Object>> buscar(String campo, String comparador, String texto) {

        // Se valida que el comparador sea el correcto
        if (!comparador.equals(">") &&
                !comparador.equals("<") &&
                !comparador.equals(">=") &&
                !comparador.equals("<=") &&
                !comparador.equals("!=") &&
                !comparador.equalsIgnoreCase("LIKE")) {

            // Excepción si el comparador no es el correcto
            throw new IllegalArgumentException("Comparador no válido");
        }

        // Construcción del SQL completo
        String sql = "SELECT * FROM " + table + " WHERE " + campo + " " + comparador + " ?";

        // Búsqueda con LIKE con coincidencias parciales
        if (comparador.equalsIgnoreCase("LIKE")) {
            texto = "%" + texto + "%";
        }

        return executeQuery(sql, texto);
    }

}
