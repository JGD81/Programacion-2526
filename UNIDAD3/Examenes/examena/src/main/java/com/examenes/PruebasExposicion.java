package com.examenes;

import java.util.ArrayList;
import com.examenes.model.ExposicionRetro;
import com.examenes.model.JuegoRetro;

public class PruebasExposicion {

    public static void main(String[] args) {

        // =========================
        // CREACIÓN DE CARACTERÍSTICAS
        // =========================

        ArrayList<String> c1 = new ArrayList<>();
        c1.add("Multijugador");
        c1.add("Cooperativo");

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Historia");
        c2.add("Exploración");

        ArrayList<String> c3 = new ArrayList<>();
        c3.add("Arcade");
        c3.add("Retro");

        ArrayList<String> c4 = new ArrayList<>();
        c4.add("Online");
        c4.add("Competitivo");

        ArrayList<String> c5 = new ArrayList<>();
        c5.add("Supervivencia");

        ArrayList<String> c6 = new ArrayList<>();
        c6.add("Puzzles");

        // =========================
        // CREACIÓN DE JUEGOS
        // =========================

        JuegoRetro j1 = new JuegoRetro("Super Mario Bros", "NES", 1985, 30, 9.5, JuegoRetro.PLATAFORMAS, false, c1);

        JuegoRetro j2 = new JuegoRetro("Street Fighter II", "SNES", 1991, 25, 9.2, JuegoRetro.LUCHA, false, c4);

        JuegoRetro j3 = new JuegoRetro("The Legend of Zelda", "NES", 1986, 40, 9.8, JuegoRetro.AVENTURAS, false, c2);

        JuegoRetro j4 = new JuegoRetro("Doom", "PC", 1993, 15, 9.0, JuegoRetro.SHOOTER, true, c3);

        JuegoRetro j5 = new JuegoRetro("Contra", "NES", 1987, 8, 8.5, JuegoRetro.SHOOTER, false, c1);

        JuegoRetro j6 = new JuegoRetro("Tetris", "GameBoy", 1989, 5, 9.1, JuegoRetro.PLATAFORMAS, true, c6);


        // =========================
        // CREAR EXPOSICIÓN
        // =========================

        ArrayList<JuegoRetro> listaJuegos = new ArrayList<>();

        listaJuegos.add(j1);
        listaJuegos.add(j2);
        listaJuegos.add(j3);
        listaJuegos.add(j4);
        listaJuegos.add(j5);
        listaJuegos.add(j6);

        ExposicionRetro expo = new ExposicionRetro(
                12345,
                "RetroGames Expo",
                listaJuegos,
                "Madrid",
                20,
                true
        );


        // =========================
        // MOSTRAR TOSTRING DE JUEGOS
        // =========================

        System.out.println("=== MOSTRAR JUEGOS ===");
        System.out.println(j1);
        System.out.println(j3);

        // =========================
        // PROBAR calcularValorTotalColeccion
        // =========================

        System.out.println("\n=== VALOR TOTAL DE LA COLECCIÓN ===");
        System.out.println(expo.calcularValorTotalColeccion());

        // =========================
        // PROBAR buscarJuegosPorConsolaYRangoPuntuacion
        // =========================

        System.out.println("\n=== BUSCAR JUEGOS NES ENTRE 8 Y 10 ===");
        System.out.println(expo.buscarJuegosPorConsolaYRangoPuntuacion("NES", 8, 10));

        // =========================
        // PROBAR cantidadJuegosBaratos
        // =========================

        System.out.println("\n=== JUEGOS BARATOS DE NES ===");
        System.out.println(expo.cantidadJuegosBaratos("Nes"));

        // =========================
        // PROBAR eliminarJuegosPorTipo
        // =========================

        System.out.println("\n=== ELIMINAR JUEGOS DE TIPO SHOOTER ===");
        System.out.println(expo.eliminarJuegosPorTipo(JuegoRetro.SHOOTER));

        // =========================
        // PROBAR juegoMejorValoracionConCaracteristica
        // =========================

        System.out.println("\n=== MEJOR JUEGO CON MULTIJUGADOR ===");
        System.out.println(expo.juegoMejorValoracionConCaracteristica("Multijugador"));
    }
}