package com.examenes.model;

import java.util.ArrayList;

public class JuegoRetro {

    public static final int PLATAFORMAS = 1;
    public static final int LUCHA = 2;
    public static final int AVENTURAS = 3;
    public static final int SHOOTER = 4;
    private String codigoJuego;
    public String titulo;
    private String consola;
    private int anioLanzamiento;
    private double precioActual;
    private double puntuacionCritica;
    private int tipoJuego;
    private boolean esDigital;
    private ArrayList<String> caracteristicasEspeciales;

    public JuegoRetro() {

        this.codigoJuego = "RET-" + ((int) (Math.random() * 900) + 100);
        this.titulo = "";
        this.consola = "";
        this.anioLanzamiento = (int) (Math.random() * 20) + 1980;
        this.precioActual = (Math.random() * 480) + 20;
        this.puntuacionCritica = (Math.random() * 5.0) + 5.0;
        this.tipoJuego = (int) (Math.random() * 4) + 1;
        this.esDigital = false;
        this.caracteristicasEspeciales = new ArrayList<>();
    }

    public JuegoRetro(String titulo, String consola, int anioLanzamiento, double precioActual,
            double puntuacionCritica, int tipoJuego, boolean esDigital, ArrayList<String> caracteristicasEspeciales) {

        this.codigoJuego = "RET-" + ((int) (Math.random() * 900) + 100);
        this.titulo = titulo;
        this.consola = consola;
        this.anioLanzamiento = anioLanzamiento;
        this.precioActual = precioActual;
        this.puntuacionCritica = puntuacionCritica;
        this.tipoJuego = tipoJuego;
        this.esDigital = esDigital;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    public String getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(String codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public double getPuntuacionCritica() {
        return puntuacionCritica;
    }

    public void setPuntuacionCritica(double puntuacionCritica) {
        this.puntuacionCritica = puntuacionCritica;
    }

    public int getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(int tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }

    public ArrayList<String> getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<String> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    @Override
    public String toString() {

        String tipojuegoTexto = "";

        switch (tipoJuego) {
            case PLATAFORMAS:
                tipojuegoTexto = "Plataformas";
                break;
            case LUCHA:
                tipojuegoTexto = "Lucha";
                break;
            case AVENTURAS:
                tipojuegoTexto = "Aventuras";
                break;
            case SHOOTER:
                tipojuegoTexto = "Shooter";
                break;
        }

        String esDigitalTexto = esDigital ? "Sí" : "No";
        
        return "Juego Retro: \n" + 
        "<-\n" +
        "** Código: <" + codigoJuego + ">\n" +
        "** Título: <" + titulo + ">\n" +
        "** Consola: <" + consola + "> - Año: <" + anioLanzamiento + ">\n" + 
        "** Precio: <" + precioActual + ">€\n" +
        "** Puntuación: <" + puntuacionCritica + ">/10\n" + 
        "** Tipo: <" + tipojuegoTexto + ">\n" +
        "** Digital: <" + esDigitalTexto + ">\n" +
        "** Características: <" + caracteristicasEspeciales + ">\n" +
        "\n" +
        "->";
    }
}
