package com.festival.model;

import java.util.ArrayList;

public class Artista {

    private final int id; //Si un campo define identidad, debe ser final y no tener setter
    private String nombreArtistico;
    private int energia;
    private ArrayList<String> canciones;

    public Artista(int id, String nombreArtistico, int energia) {
        
        this.id = id;
        this.nombreArtistico = nombreArtistico;
        this.energia = energia;
        this.canciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Nombre Artístico: " + nombreArtistico + "| Energía: " + energia;
    }

    public ArrayList<String> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<String> canciones) {
        this.canciones = canciones;
    }



    //OJO, SÓLO PARA CUANDO QUERAMOS QUE SE COMPAREN POR EL ATRIBUTO NOMBRE ARTÍSTICO
    // Definimos cuándo dos Artista deben considerarse iguales
    // En este caso: si tienen el mismo nombreArtistico
    /*@Override
    public boolean equals(Object obj) {
        // Si ambas referencias apuntan al mismo objeto en memoria, iguales
        if (this == obj)
            return true;
        // Si el objeto es null, false
        if (obj == null)
            return false;
        // Si no es un objeto artista, false
        if (getClass() != obj.getClass())
            return false;
        // Dos artistas se consideran iguales si tenen el mismo nombreArtístico
        Artista other = (Artista) obj;

        return this.nombreArtistico.equals(other.nombreArtistico);
    }*/

    @Override
    public int hashCode() {
        return nombreArtistico.hashCode();
    }
}
