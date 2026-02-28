package com.ejercicioud4.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ejercicioud4.model.CrudModel;
import com.ejercicioud4.model.DuendeCombateDO;
import com.ejercicioud4.model.HadaMadrinaDO;

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

    // Método que devuelve la lista de duendes liderados por hada especificada
    public ArrayList<DuendeCombateDO> cargarDuendes(int idHadaMadrina) {

        // Se crea la lista vacía
        ArrayList<DuendeCombateDO> lista = new ArrayList<>();

        // Se construye la consulta SQL
        String sql = "SELECT * FROM DuendeCombate WHERE idHadaMadrina = ?";

        // Se crea el PreparedStatement con la conexión con. El try cierra
        // automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Se pasa el valor por parámetro
            stmt.setInt(1, idHadaMadrina);

            // Se ejecuta la sentencia
            ResultSet rs = stmt.executeQuery();

            // Devuelve true mientras haya registros
            while (rs.next()) {

                // Se leen las columnas y se convierte al tipo indicado
                DuendeCombateDO duende = new DuendeCombateDO(
                        rs.getInt("idDuendeCombate"),
                        rs.getString("nombre"),
                        rs.getString("apodoGuerra"),
                        rs.getString("modelo"),
                        rs.getInt("agilidad"),
                        rs.getInt("nivelSarcasmo"),
                        rs.getInt("tiempoBrilloCegador"),
                        rs.getInt("idHadaMadrina"));

                // Se añade a la lista
                lista.add(duende);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Se devuelve la lista
        return lista;
    }

    // Méotodo que suma el povlo de purpurina con nivelPasivoAgresividad > 3
    public double calcularPolvoPurpurinaTotal() {

        // Se crea la consulta SQL
        String sql = "SELECT * FROM HadaMadrina";

        // Variable acumuladora
        double suma = 0;

        // Se crea el PreparedStatement con la conexión con. El try cierra
        // automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Se ejecuta la consulta SQL
            ResultSet rs = stmt.executeQuery();

            // Devuelve true mientras haya registros
            while (rs.next()) {

                // Guardamos el nivel en variable auxiliar
                int nivel = rs.getInt("nivelPasivoAgresividad");

                // Filtro para que pasen las Hadas con nivel > 3
                if (nivel > 3) {

                    // Acumula sólo las que cumplen el filtro
                    suma += rs.getDouble("polvoPurpurina");
                }

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        // Se devuelve la suma
        return suma;
    }

    // Método que devuelve el hada con mayor edad
    public HadaMadrinaDO obtenerHadaMasVeterana() {

        // Se crea la consulta
        String sql = "SELECT * FROM HadaMadrina";

        // Variable para guardar la mejor candidata
        HadaMadrinaDO masVeterana = null;

        // Inicializamos el valor en -1
        int edadMax = -1;

        // Se crea el PreparedStatement con la conexión con. El try cierra
        // automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            // Ejecutamos la consulta
            ResultSet rs = stmt.executeQuery();

            // Devuelve true mientras haya registros
            while (rs.next()) {

                // Guardamos la edad
                int edad = rs.getInt("edad");

                // Si se encuentra una mayor, se actualiza
                if (edad > edadMax) {

                    // Se guarda la nueva máxima
                    edadMax = edad;

                    // Se crea el objeto completo
                    masVeterana = new HadaMadrinaDO(
                            rs.getInt("idHadaMadrina"),
                            rs.getString("nombre"),
                            rs.getString("apodoGuerra"),
                            rs.getInt("edad"),
                            rs.getInt("envergaduraAlas"),
                            rs.getInt("nivelPasivoAgresividad"),
                            rs.getInt("polvoPurpurina"));
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        // Devuelve la más veterana
        return masVeterana;
    }

    // Método que devuelve las hadas con las alas más pequeñas
    public ArrayList<HadaMadrinaDO> cargarHadasConAlasPequenias(double envergaduraMaxima){
        
        //Se crea la lista vacía
        ArrayList<HadaMadrinaDO> lista = new ArrayList<>();

        //Se crea la consulta con StringBuilder. Además se proteje de SQL injection
        StringBuilder sql = new StringBuilder("SELECT * FROM HadaMadrina WHERE 1=1");

        //Se le añade a la consulta AND
        sql.append(" AND envergaduraAlas < ?");

        // Se crea el PreparedStatement con la conexión con. El try cierra
        // automáticamente el statement
        try (PreparedStatement stmt = con.prepareStatement(sql.toString())) {

            //Se pasa el valor por parámetro
            stmt.setDouble(1, envergaduraMaxima);

            //Se ejecuta la consulta
            ResultSet rs = stmt.executeQuery();

            //Devuelve true mientras hay registros
            while (rs.next()) {

                //Se crea el objeto completo
                HadaMadrinaDO hada = new HadaMadrinaDO(
                    rs.getInt("idHadaMadrina"),
                    rs.getString("nombre"),
                    rs.getString("apodoGuerra"),
                    rs.getInt("edad"),
                    rs.getInt("envergaduraAlas"),
                    rs.getInt("nivelPasivoAgresividad"),
                    rs.getInt("polvoPurpurina")
                    );
                
                //Se añade a la lista
                lista.add(hada);
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        //Se devuelve la lista
        return lista;
    }

}
