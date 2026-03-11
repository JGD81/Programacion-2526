package com.examenbdd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.examenbdd.utils.ConexionBD;

public class HoyoDAO {
    
    public static void eliminarHoyo(int idHoyo){

        Connection con = ConexionBD.conectar();

        String sql = "DELETE FROM hoyo WHERE idHoyo = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idHoyo);

            stmt.executeUpdate();

            System.out.println("Hoyo eliminado correctamente");
            
        } catch (SQLException e) {
            System.out.println("No existe un hoyo con ese ID");
        }
    }
}
