package com.examenc;

import java.util.ArrayList;

import com.examenc.Model.CancionDigital;
import com.examenc.Model.PlaylistStreaming;

public class PruebasPlaylist {
    public static void main(String[] args) {
        
        //Lista etiquetas
        ArrayList<String> et1 = new ArrayList<>();
        et1.add("Metal");
        et1.add("Trash");
        et1.add("Solo");

        //Instancia canciones
        CancionDigital c1 = new CancionDigital("Countdown to extinction", "Megadeth", CancionDigital.ROCK, 240, 6, 1000, true, et1);
        CancionDigital c2 = new CancionDigital("One", "Metallica", CancionDigital.ROCK, 300, 6, 2000, true, et1);
        CancionDigital c3 = new CancionDigital("Fear of the dark", "Iron Maiden", CancionDigital.POP, 400, 8, 5000, true, et1);
        CancionDigital c4 = new CancionDigital("My hero", "Foo fighters", CancionDigital.ROCK, 350, 5, 1000, false, et1);
        CancionDigital c5 = new CancionDigital("Speed of light", "Stratovarius", CancionDigital.RAP, 240, 9, 20000, true, et1);
        CancionDigital c6 = new CancionDigital("Carrie", "Europe", CancionDigital.ROCK, 500, 6, 11000, true, et1);
        CancionDigital c7 = new CancionDigital("Rock you hurricane", "Scorpions", CancionDigital.ELECTRONICA, 430, 8, 123000, false, et1);
        CancionDigital c8 = new CancionDigital("Crazy", "Aerosmith", CancionDigital.ROCK, 540, 10, 331000, true, et1);

        //Playlist
        ArrayList<CancionDigital> pl1 = new ArrayList<>();
        pl1.add(c1);
        pl1.add(c8);
        pl1.add(c7);
        pl1.add(c6);

        ArrayList<CancionDigital> pl2 = new ArrayList<>();
        pl2.add(c2);
        pl2.add(c3);
        pl2.add(c4);
        pl2.add(c5);

        //Funciones
        PlaylistStreaming playlist1 = new PlaylistStreaming(1, "Primera playlist", pl1, "Jose", false, 1000);
        PlaylistStreaming playlist2 = new PlaylistStreaming(2, "Segunda playlist", pl2, "Antonio", true, 2000);

        System.out.println("Promedio canciones");
        System.out.println(playlist1.calcularDuracionPromedioCanciones());

        System.out.println("Canciones por género y popularidad");
        System.out.println(playlist2.buscarCancionesPorGeneroYPopularidad(CancionDigital.ROCK, 3, 10));

        System.out.println("Contar canciones explicit");
        System.out.println(playlist2.contarCancionesExplicit());

        System.out.println("Eliminar canciones con pocas reproducciones");
        System.out.println(playlist1.eliminarCancionesConPocasReproducciones(50000));

        System.out.println("Obtener canción más popular");
        System.out.println(playlist2.obtenerCancionMasPopular());

        System.out.println("Canciones más reproducidas");
        System.out.println(playlist1.topCancionesMasReproducidas(1000));

        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Buscar canciones por artista");
        System.out.println(playlist2.buscarCancionesPorArtista("Metallica"));

        System.out.println("Obtener todas las etiquetas");
        System.out.println(playlist2.obtenerTodasLasEtiquetas());

        System.out.println("Contar canciones por género");
        System.out.println(playlist1.contarCancionesPorGenero(CancionDigital.ROCK));

        System.out.println("Canción más larga");
        System.out.println(playlist1.obtenerCancionMasLarga());

        System.out.println("Duración total playlist");
        System.out.println(playlist1.obtenerDuracionTotalPlaylist());
        /* 
        System.out.println("Obtener títulos canciones");
        System.out.println(playlist2.obtenerTitulosCanciones());
        */
        
        System.out.println("Canciones explicit ordenadas");
        System.out.println(playlist1.obtenerCancionesExplicitOrdenadas());

        System.out.println("Canciones más largas con límite n");
        System.out.println(playlist2.topCancionesMasLargas(400));

        System.out.println("Obtener artistas sin repetir");
        System.out.println(playlist2.obtenerArtistas());
    }   
}