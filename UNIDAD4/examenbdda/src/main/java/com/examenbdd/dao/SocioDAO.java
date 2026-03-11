package com.examenbdd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.examenbdd.utils.ConexionBD;

public class SocioDAO {
    
    public static void insertarSocio(int idSocio, String nombre, int edad, int sexo, int cuota){

        //Realizar la conexión con la base de datos
        Connection con = ConexionBD.conectar();

        String sql = "INSERT INTO socio (idSocio, nombre, edad, sexo, cuota) VALUES(?,?,?,?,?)";
        
        try (PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setInt(1, idSocio);
            stmt.setString(2, nombre);
            stmt.setInt(3, edad);
            stmt.setInt(4, sexo);
            stmt.setInt(5, cuota);

            stmt.executeUpdate();

            System.out.println("Socio insertaco correctamente");
            
        } catch (SQLException e) {
            
            System.out.println("Error al insertar el socio");
        }

    }
}
