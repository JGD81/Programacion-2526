package com.festival;

import java.util.ArrayList;
import java.util.List;

import com.festival.model.Artista;

public class MainArraylist {

    public static void main(String[] args) {
        // Crear Arraylist
        List<Artista> artistasAL = new ArrayList<>();

        // Crear artistas
        Artista artista1 = new Artista(1, "Chiquetete", 50);
        Artista artista2 = new Artista(2, "El Fary", 60);
        Artista artista3 = new Artista(3, "Manolo Escobar", 70);
        Artista artista4 = new Artista(4, "Raphael", 90);

        // Añadir artistas
        artistasAL.add(artista1);
        artistasAL.add(artista2);
        artistasAL.add(artista3);
        artistasAL.add(artista4);

        // Imprimir artistas ArrayList
        for (int i = 0; i < artistasAL.size(); i++) {
            System.out.println(artistasAL.get(i));
        }

        // Imprimir el tamaño del Arraylist
        System.out.println("Tamaño del Arraylist: " + artistasAL.size());

        // contains()
        System.out.println(artistasAL.contains(artista1));
        // Imprime true si existe el objeto

        //Si creamos otro objeto con los mismos datos, devolverá false
        //ya que busca el objeto en sí el mismo objeto, no los mismos
        //atributos
        Artista artista5 = new Artista(5, "Chiquetete", 50);
        System.out.println(artistasAL.contains(artista5));

        //Formas de recorrer ArrayList
        //for tradicional
        for(int i = 0; i < artistasAL.size();i++){
            System.out.println(artistasAL.get(i));
        }

        //foreach
        for (Artista artista : artistasAL) {
            System.out.println(artista);
        }

        for (Artista artista : artistasAL) {
            String nombre = artista.getNombreArtistico();
            int energia = artista.getEnergia();

            System.out.println("Nombre: " + nombre + " - Energía: " + energia);
        }

        artista1.getCanciones().add("Fear of the Dark");
        System.out.println(artista1.getCanciones());
        artista1.getCanciones().add("Dance of death");
        System.out.println(artista1.getCanciones());

        //Recorrer canciones de un artista
        for (Artista artista : artistasAL) {
            System.out.println("Artista : " + artista.getNombreArtistico());
            for (String cancion : artista.getCanciones()) {
                System.out.println(" - " + cancion);
            }
        }

    }
}
