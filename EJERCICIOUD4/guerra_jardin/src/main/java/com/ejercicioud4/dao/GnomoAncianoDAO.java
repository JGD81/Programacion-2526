package com.ejercicioud4.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Importa la clase base que contiene el CRUD
import com.ejercicioud4.model.CrudModel;
import com.ejercicioud4.model.GnomoAncianoDO;
import com.ejercicioud4.model.TopoCombateDO;

//Hereda los métodos y atributos protegidos de CrudModel
public class GnomoAncianoDAO extends CrudModel {

    // Primero se ejecuta el constructor padre (CrudModel)
    // que abre la conexión con la BDD. Después se ejecuta
    // el constructor
    public GnomoAncianoDAO() {

        // Nombre tabla que usará el CRUD
        this.table = "GnomoAnciano";

        // Columna con clave primaria
        this.idColumn = "idGnomoAnciano";

        // Construye Maps en executeQuery()
        // Columnas de la tabla
        this.columns = Arrays.asList(
                "idGnomoAnciano",
                "nombre",
                "apodoGuerra",
                "edad",
                "alturaBarba",
                "nivelCascarrabias",
                "energiaRefunfuño");
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

    // Método que devuelve la lista de los topos lideradpos por un gnomo
    // especificado
    public ArrayList<TopoCombateDO> cargarTopos(int idGnomoAnciano) {

        // Se crea una lista vacía para guardar resultados
        ArrayList<TopoCombateDO> listaTopos = new ArrayList<>();

        // Se define la consulta
        String sql = "SELECT * FROM topoCombate WHERE idGnomoAnciano = ?";

        // Se usa la conexión con de CrudModel y se prepara la consulta
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Se asigna el parámetro 1, correspondiente a la clave primaria
            stmt.setInt(1, idGnomoAnciano);

            // Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            // Se ejecuta while una vez por cada topo encontrado
            while (rs.next()) {

                // Se crea el objeto DO
                TopoCombateDO topo = new TopoCombateDO(
                        rs.getInt("idTopoCombate"),
                        rs.getString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getString("modelo"),
                        rs.getInt("fuerzaExcavacion"),
                        rs.getInt("agudezaOlfativa"),
                        rs.getInt("horasSueño"),
                        rs.getInt("tiempoTierraEnOjos"),
                        rs.getInt("idGnomoAnciano"));

                // Se guarda el objeto en la lista
                listaTopos.add(topo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Se devuelve la lista
        return listaTopos;
    }

    // Método que devuelve la suma de energía de refunfuño de todos
    // los gnomos con nivelCascarrabias > 5
    public int calcularEnergiaRefunfunioTotal() {

        // Iniciamos la variable para guardar el total
        int total = 0;

        // LLama al método findALL (SELECT * FROM GnomoAnciano)
        // y devuelve lista de registros para obtener todos los gnomos
        List<Map<String, Object>> listaGnomos = findAll();

        // Se recorren todos los registros
        for (Map<String, Object> gnomo : listaGnomos) {

            // Se accede al valor asociado a la clave "nivelCascarrabias"
            // Se castea el Object obtenido a int
            int nivel = (int) gnomo.get("nivelCascarrabias");

            // Se guarda la energía de los gnomos con nivel > 5
            if (nivel > 5) {
                int energia = (int) gnomo.get("energiaRefunfuño");
                total += energia;
            }
        }

        // Se devuelve la energía total
        return total;
    }

    // Método que devuelve el gnomo con mayor nivel de cascarrabias
    public GnomoAncianoDO obtenerGnomoMasCascarrabias() {

        // Variable para guardar el máximo
        GnomoAncianoDO gnomoMax = null;

        // Consulta SQL
        String sql = "SELECT * FROM GnomoAnciano";

        // Preparación de la sentencia
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            // Se recorren los resultados
            while (rs.next()) {

                // Crea un objeto por cada fila
                GnomoAncianoDO gnomo = new GnomoAncianoDO(
                        rs.getInt("idGnomoAnciano"),
                        rs.getString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getInt("edad"),
                        rs.getDouble("alturaBarba"),
                        rs.getInt("nivelCascarrabias"),
                        rs.getInt("energiaRefunfuño"));

                // Lógica para encontrar el máximo
                // Se guarda el primer gnomo como referencia inicial
                if (gnomoMax == null) {
                    gnomoMax = gnomo;
                }
                // Comparación para encontrar el máximo
                else if (gnomo.getNivelCascarrabias() > gnomoMax.getNivelCascarrabias()) {
                    gnomoMax = gnomo;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Se devuelve el resultado
        return gnomoMax;
    }

    // Método generar informe
    public String generarInformeGnomos() {

        // Crear StringBuilder
        StringBuilder informe = new StringBuilder();

        // Consulta SQL
        String sql = "SELECT * FROM GnomoAnciano";

        // Variables auxiliares
        int contador = 0;
        int energiaTotal = 0;

        // Cabecera del informe
        informe.append("=== INFORME DE GNOMOS ANCIANOS ===\n");

        // Preparación de la sentencia
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Ejecutar consulta
            ResultSet rs = stmt.executeQuery();

            // Se recorren los resultados
            while (rs.next()) {

                // Incrementar contador
                contador++;

                // Se leen los datos de la fila
                String nombre = rs.getString("nombre");
                String apodo = rs.getNString("apodoGuerra");
                int energia = rs.getInt("energiaRefunfuño");

                // Se acumula la energía
                energiaTotal += energia;

                // Se construye la línea del informe de cada gnomo
                informe.append(contador)
                        .append(". ")
                        .append(nombre)
                        .append(" - Apodo: ")
                        .append(apodo)
                        .append(" - Energía: ")
                        .append(energia)
                        .append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Final del informe
        informe.append("----------------------------------\n");
        informe.append("Total: ").append(contador).append(" gnomos\n");
        informe.append("----------------------------------\n");
        informe.append("Energía total del ejército: ")
                .append(energiaTotal);

        // Devuelve el informe, convirtiendo el StringBuilder en String final
        return informe.toString();
    }
}
