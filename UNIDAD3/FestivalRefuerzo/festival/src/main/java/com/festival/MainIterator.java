package com.festival;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.festival.model.Artista;

public class MainIterator {
    public static void main(String[] args) {

        List<Artista> artistas = new ArrayList<>();

        Artista artista1 = new Artista(1, "Iron Maiden", 50);
        Artista artista2 = new Artista(2, "Metallica", 60);
        Artista artista3 = new Artista(3, "AC/DC", 70);

        // Añadir artistas a la lista
        artistas.add(artista1);
        artistas.add(artista2);
        artistas.add(artista3);

        // Añadir canciones a la lista de canciones
        artista1.getCanciones().add("Fear of the Dark");
        artista1.getCanciones().add("The Trooper");
        artista2.getCanciones().add("One");
        artista2.getCanciones().add("Master of Puppets");

        // Añadir canciones mediante bucle (Todas de una vez)
        for (Artista artista : artistas) {
            if (artista.getNombreArtistico().equals("AC/DC")) {
                artista.getCanciones().add("Thunderstruck");
                artista.getCanciones().add("Highway to Hell");
                // Para que no recurra todos los artistas de la lista
                break;
            }
        }

        // Mostrar el festival
        System.out.println("ARTISTAS DEL FESTIVAL\n");
        for (Artista artista : artistas) {
            System.out.println(artista.getNombreArtistico());
            for (String cancion : artista.getCanciones()) {
                System.out.println("- " + cancion);
            }
        }

        //Se crea el iterator
        Iterator<Artista> it = artistas.iterator();

        //Mientras queden elementos
        while (it.hasNext()) {
            //Obtiene el siguiente artista (empieza fuera del array)
            Artista artista = it.next();
            //Condición
            if(artista.getEnergia() < 60){
                it.remove();
            }
        }
    }
}
