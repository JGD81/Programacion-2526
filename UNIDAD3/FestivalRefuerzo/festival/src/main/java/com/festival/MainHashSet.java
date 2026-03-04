package com.festival;

import java.util.HashSet;
import java.util.Set;

import com.festival.model.Artista;

public class MainHashSet {

    public static void main(String[] args) {

        // Crear un HashSet
        Set<Artista> artistasHS = new HashSet<>();

        // Añadir artistas
        artistasHS.add(new Artista(1, "Chiquetete", 50));
        artistasHS.add(new Artista(2, "Chiquetete", 999));

        //Imprimir el tamaño
        System.out.println(artistasHS.size());

        //Imprimir el contenido con for-each
        for (Artista artista : artistasHS) {
            System.out.println(artista);
        }
    }

}
