package com.examenc.Model;

import java.util.ArrayList;

public class CancionDigital {
    
    public static final int POP = 1;
    public static final int ROCK = 2;
    public static final int ELECTRONICA = 3;
    public static final int RAP = 4;

    private int idCancion;
    public String titulo;
    private String artista;
    private int generoMusical;
    private int duracionSegundos;
    private double popularidad;
    private int numeroReproducciones;
    private boolean esExplicit;
    private ArrayList<String> etiquetas;

    public CancionDigital(){
        this.idCancion = (int) (Math.random()*9000)+1000;
        this.titulo = "";
        this.artista = "";
        this.generoMusical = (int) (Math.random()*4)+1;
        this.duracionSegundos = (int) (Math.random()*241)+120;
        this.popularidad = (Math.random()*5)+ 5;
        this.numeroReproducciones = (int) (Math.random()*1000001);
        this.esExplicit = false;
        this.etiquetas = new ArrayList<>();
    }

    public CancionDigital(String titulo, String artista, int generoMusical, int duracionSegundos, double popularidad, int numeroReproducciones, boolean esExplicit, ArrayList<String> etiquetas){
        
        this.idCancion = (int) (Math.random()*8000)+1000;
        this.titulo = titulo;
        this.artista = artista;
        this.generoMusical = generoMusical;
        this.duracionSegundos = duracionSegundos;
        this.popularidad = popularidad;
        this.numeroReproducciones = numeroReproducciones;
        this.esExplicit = esExplicit;
        this.etiquetas = etiquetas;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(int generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    public int getNumeroReproducciones() {
        return numeroReproducciones;
    }

    public void setNumeroReproducciones(int numeroReproducciones) {
        this.numeroReproducciones = numeroReproducciones;
    }

    public boolean isEsExplicit() {
        return esExplicit;
    }

    public void setEsExplicit(boolean esExplicit) {
        this.esExplicit = esExplicit;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    @Override
    public String toString() {
        
        String generoTexto = "";

        switch (generoMusical) {
            case POP:
                generoTexto = "POP";
                break;
            case ROCK:
                generoTexto = "ROCK";
                break;
            case ELECTRONICA:
                generoTexto = "ELECTRÓNICA";
                break;
            case RAP:
                generoTexto = "RAP";
                break;
        }

        String explicit = esExplicit ? "Sí" : "No";
        
        return "=== CANCIÓN DIGITAL ===\n" +
                        "\n" +
                        "ID: <" + idCancion + ">\n" +
                        "Título: <" + titulo + ">\n" +
                        "Artista: <" + artista + ">\n" +
                        "Género: <" + generoTexto + ">\n" +
                        "Duración: <" + duracionSegundos + "> segundos\n" +
                        "Popularidad: <" + popularidad + ">/10\n" +
                        "Reproducciones: <" + numeroReproducciones + ">\n" +
                        "Explícita: <" + explicit + ">\n" +
                        "Etiquetas: <" + etiquetas + ">\n" +
                        "\n" + 
                        "=======================\n" +
                        "";
    }
        
}
