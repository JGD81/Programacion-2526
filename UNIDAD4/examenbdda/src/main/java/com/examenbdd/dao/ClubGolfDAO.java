package com.examenbdd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.examenbdd.utils.ConexionBD;

public class ClubGolfDAO {

    public static void mostrarClub(int idClubGolf) {

        Connection con = ConexionBD.conectar();

        String sql = "SELECT * FROM clubgolf WHERE idClubGolf = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idClubGolf);

            ResultSet rs = stmt.executeQuery();

            String nombre = "";
            String localidad = "";
            int recordGolpes = 0;
            int escuela = 0;
            
            if (rs.next()) {
                nombre = rs.getString("nombre");
                localidad = rs.getString("localidad");
                recordGolpes = rs.getInt("recordGolpes");
                escuela = rs.getInt("escuela");
            }

            System.out.println("\n---Club de golf seleccionado---\n" +
                "Nombre del club: " + nombre + "\n" +
                "Localidad: " + localidad + "\n" +
                "Récord de golpes: " + recordGolpes + "\n" +
                "Escuela: " + escuela + "\n"
            );
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void modificarClub(String nombreParametro, int idClubGolf, Object valorParametro) {

        Connection con = ConexionBD.conectar();

        String sql = "UPDATE clubgolf SET " + nombreParametro + " = ? WHERE idClubGolf = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setObject(1, valorParametro);
            stmt.setInt(2, idClubGolf);

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Club actualizado correctamente");
            } else {
                System.out.println("No existe club con ese ID");
            }

        } catch (Exception e) {
            System.out.println("No se han modificado valores");
        }

    }
}
