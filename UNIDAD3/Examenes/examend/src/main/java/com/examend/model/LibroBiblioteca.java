package com.examend.model;

import java.util.ArrayList;

public class LibroBiblioteca {
    
    public static final int NOVELA = 1;
    public static final int CIENCIA = 2;
    public static final int HISTORIA = 3;
    public static final int TECNOLOGIA = 4;
    private int idLibro;
    public String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;
    private int numeroPrestamos;
    private double valoracionMedia;
    private boolean esDigital;
    private ArrayList<String> temas;
    private int tipoLibro;

    public LibroBiblioteca() {

        this.idLibro = (int) (Math.random() * 9000) + 1000;
        this.titulo = "";
        this.autor = "";
        this.anioPublicacion = (int) (Math.random() * 71) + 1950;
        this.numeroPaginas = (int) (Math.random() * 801) + 100;
        this.numeroPrestamos = (int) (Math.random() * 501);
        this.valoracionMedia = (Math.random() * 5);
        this.esDigital = false;
        this.temas = new ArrayList<>();
        this.tipoLibro = (int) (Math.random()*4)+1;
    }

    public LibroBiblioteca(String titulo, String autor, int anioPublicacion, int numeroPaginas, int numeroPrestamos,
            double valoracionMedia, boolean esDigital, ArrayList<String> temas, int tipoLibro) {
        this.idLibro = (int) (Math.random() * 9000) + 1000;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.numeroPrestamos = numeroPrestamos;
        this.valoracionMedia = valoracionMedia;
        this.esDigital = esDigital;
        this.temas = (temas != null ? temas : new ArrayList<>());
        this.tipoLibro = tipoLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }

    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    public void setEsDigital(boolean esDigital) {
        this.esDigital = esDigital;
    }

    public ArrayList<String> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String> temas) {
        this.temas = temas;
    }

    public int getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(int tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    @Override
    public String toString() {

        String esDigitalTexto = esDigital ? "Sí" : "No";

        String tipoLibroTexto = "";

        switch (tipoLibro) {
            case NOVELA:
                tipoLibroTexto = "Novela";
                break;
            case CIENCIA:
                tipoLibroTexto = "Ciencia";
                break;
            case HISTORIA:
                tipoLibroTexto = "Historia";
                break;
            case TECNOLOGIA:
                tipoLibroTexto = "Tecnología";
                break;
        }
        
        return "=== LIBRO ===\n" +
                        "ID: <" + idLibro + ">\n" +
                        "Título: <" + titulo + ">\n" +
                        "Autor: < " + autor + ">\n" +
                        "Año: <" + anioPublicacion + ">\n" +
                        "Páginas: <" + numeroPaginas + ">\n" +
                        "Préstamos: <" + numeroPrestamos + ">\n" +
                        "Valoración: <" + valoracionMedia + ">/5\n" +
                        "Tipo: <" + tipoLibroTexto + ">\n" +
                        "Digital: <" + esDigitalTexto + ">\n" +
                        "Temas: " + temas + ">\n" +
                        "============\n";
    }

}
