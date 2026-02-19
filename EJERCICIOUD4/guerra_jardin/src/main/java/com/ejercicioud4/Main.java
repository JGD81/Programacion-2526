package com.ejercicioud4;

import java.sql.Connection;

import com.ejercicioud4.utils.ConexionBD;

public class Main {
    public static void main(String[] args) {
        Connection con = ConexionBD.conectar();

         if (con != null) {
            System.out.println("La conexión funciona correctamente.");
        } else {
            System.out.println("No se pudo conectar.");
        }
    }
}