package com.festival;

import java.util.ArrayList;
import java.util.List;

import com.festival.model.Artista;

public class MainPrueba {

    public static void main(String[] args) {
        // Crea una lista de artistas

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

        // Buscar un nuevo artista con equals
        Artista prueba = new Artista(99, "Metallica", 10);
        System.out.println("¿Existe Metallica en el festival?");
        System.out.println(artistas.contains(prueba));

        // Buscar artista por nombre
        boolean encontrado = false;

        for (Artista artista : artistas) {
            if (artista.getNombreArtistico().equals("Metallica")) {
                encontrado = true;
                break;
            }
        }

        System.out.println("¿Existe Metallica en el festival?: " + encontrado);

        // Eliminar artistas con poca energía
        artistas.removeIf(a -> a.getEnergia() < 60);

        //Lo que nos ahorramos con removeIf
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getEnergia() < 60) {
                artistas.remove(i);
                i--; // Al eliminarse un artista, los índices se reordenan
                // Si eliminas al artista 2, el 3 pasa al 2. Con lo que ese
                // artista ya no se revisaría.
            }
        }
    }

}
