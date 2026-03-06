package com.examenes.model;

import java.util.ArrayList;
import java.util.Comparator;

public class ExposicionRetro {
    private int idExposicion;
    public String nombreEvento;
    private ArrayList<JuegoRetro> juegosExhibidos;
    private String localizacion;
    private int entradasVendidas;
    private double precioEntrada;
    private boolean esCompetitivo;

    public ExposicionRetro() {
        this.idExposicion = (int) (Math.random() * 9000) + 1000;
        this.nombreEvento = "";
        this.juegosExhibidos = new ArrayList<>();
        this.localizacion = "";
        this.entradasVendidas = (int) (Math.random() * 5001);
        this.precioEntrada = (Math.random() * 40) + 10;
        this.esCompetitivo = false;
    }

    public ExposicionRetro(int idExposicion, String nombreEvento, ArrayList<JuegoRetro> juegosExhibidos,
            String localizacion, double precioEntrada, boolean esCompetitivo) {

        this.idExposicion = idExposicion;
        this.nombreEvento = nombreEvento;
        this.juegosExhibidos = juegosExhibidos;
        this.localizacion = localizacion;
        this.entradasVendidas = juegosExhibidos.size();
        this.precioEntrada = precioEntrada;
        this.esCompetitivo = esCompetitivo;
    }

    // Suma el precio total de todos los juegos del Array
    public double calcularValorTotalColeccion() {

        /*
         * double sumaTotal = 0.0;
         * 
         * for (JuegoRetro juegoRetro : juegosExhibidos) {
         * sumaTotal += juegoRetro.getPrecioActual();
         * }
         * 
         * return sumaTotal;
         */

        return juegosExhibidos.stream().mapToDouble(p -> p.getPrecioActual()).sum();
    }

    // Filtra por consola y rango de puntuación. También valida
    public ArrayList<JuegoRetro> buscarJuegosPorConsolaYRangoPuntuacion(String consola, double minPuntuacion,
            double maxPuntuacion) {

        if (minPuntuacion < 0 || maxPuntuacion > 10 || maxPuntuacion < minPuntuacion) {

            return new ArrayList<>();
        }

        return new ArrayList<>(juegosExhibidos.stream()
                .filter(p -> p.getConsola().equalsIgnoreCase(consola)
                        && (p.getPuntuacionCritica() >= minPuntuacion && p.getPuntuacionCritica() <= maxPuntuacion))
                .toList());
    }

    // Cuenta los juegos baratos por consola
    public int cantidadJuegosBaratos(String consola) {

        return (int) juegosExhibidos.stream()
                .filter(p -> p.getConsola().equalsIgnoreCase(consola))
                .filter(p -> p.getPrecioActual() < 10)
                .count();
    }

    // Elimina los juegos por el tipo especificado
    public int eliminarJuegosPorTipo(int tipoEliminar) {

        // Cuenta los juegos actuales en lista
        int juegosTotalesAntes = juegosExhibidos.size();

        // Elimina por tipo
        juegosExhibidos.removeIf(p -> p.getTipoJuego() == tipoEliminar);

        // Resta los juegos totales del principio con los finales
        return juegosTotalesAntes - juegosExhibidos.size();
    }

    public JuegoRetro juegoMejorValoracionConCaracteristica(String caracteristicaBuscada) {

        return juegosExhibidos.stream()
                // Stream<JuegoRetro> que contiene todos los juegos de la lista
                // getCaracteristicasEspeciales(): devuelve List<String> con las características
                // del juego
                // stream(): convierte la lista en Stream<String>
                // anyMatch(): devuelve true si alguna característica coincide con la buscada
                // filter mantiene en el stream solo los juegos que tengan esa característica
                // Resultado: Stream<JuegoRetro>
                // max(): devuelve Optional<JuegoRetro> con el juego de mayor puntuación
                // orElse(null): devuelve el JuegoRetro encontrado o null si el Optional está
                // vacío
                .filter(p -> p.getCaracteristicasEspeciales().stream()
                        .anyMatch(j -> j.equalsIgnoreCase(caracteristicaBuscada)))
                .max(Comparator.comparingDouble(k -> k.getPuntuacionCritica())).orElse(null);

    }
}
