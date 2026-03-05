package com.festival;

import java.util.ArrayList;
import java.util.List;

import com.festival.model.Artista;

public class MainStreams {
    
    public static void main(String[] args) {
        
        List<Artista> artistas = new ArrayList<>();

        artistas.add(new Artista(1, "Iron Maiden", 50));
        artistas.add(new Artista(2, "Metallica", 80));
        artistas.add(new Artista(3, "AC/DC", 40));
        artistas.add(new Artista(4, "Ghost", 70));
        artistas.add(new Artista(5, "Ramstein", 90));

        System.out.println("Prueba");
        for (Artista artista : artistas) {
            System.out.println(artista);
        }

        //Obtener una lista con artistas mayor que 60
        List<Artista> fuertes = artistas.stream().filter(p -> p.getEnergia() > 60).toList();

        for (Artista artista : fuertes) {
            System.out.println("Artista: " + artista.getNombreArtistico());
            System.out.println("Fuerza: " + artista.getEnergia());
            System.out.println("--------------------------------");
        }

        //Obtener una lista sólo con los nombres
        List<String> nombres = artistas.stream().map(a->a.getNombreArtistico()).toList();
        //OJO: Se busca en una lista de streams, no de objetos Artista
        for (String nombre : nombres) {
            System.out.println("Nombre del artista: " + nombre);
            System.out.println("------------------------");
        }

        //Contar artistas con energía menor que 60
        long cansados = artistas.stream().filter(i->i.getEnergia() < 60).count();
        System.out.println("¿Cuántos artistas hay cansados?: " + cansados);

        //Comprobar si existe un artista (anyMatch devuelve booleano)
        boolean existe = artistas.stream().anyMatch(a->a.getNombreArtistico().equals("Metallica"));
        System.out.println("¿Existe Metallica?: " + existe);

        //Sumar la energía total de todos los artistas
        int energiaTotal = artistas.stream().mapToInt(a-> a.getEnergia()).sum();
        System.out.println("La energía total es: " + energiaTotal);

        //Ordenar artistas por energía
        List<Artista> ordenados = artistas.stream().sorted((a1, a2) -> a1.getEnergia() - a2.getEnergia()).toList();
        System.out.println("Ordenados por energía: ");
        for (Artista artista : ordenados) {
            System.out.println(artista);
        }

        //Artista más fuerte
        Artista masFuerte = artistas.stream().max((a1, a2) -> a1.getEnergia() - a2.getEnergia()).get();
        System.out.println("Artista más fuerte:");
        System.out.println(masFuerte);


        //Lista de artistas con energía menor a 70
        List<Artista> artistasMenorSetenta = artistas.stream().filter(a -> a.getEnergia() < 70).toList();
        System.out.println("Artistas con energía menor a 70: ");
        for (Artista artista : artistasMenorSetenta) {
            System.out.println(artista.getNombreArtistico());
        }

        //Lista con solo los noombres de artista con energía mayor que 50
        List<String>artistasMayorCicuenta = artistas.stream().filter(a-> a.getEnergia() > 50).map(a -> a.getNombreArtistico()).toList();
        System.out.println("Artistas con energía mayor que 50: ");
        for (String artista : artistasMayorCicuenta) {
            System.out.println(artista);
        }

        //Comprobar si existe artista con energía mayor a 90
        boolean existeArtista = artistas.stream().anyMatch(a->a.getEnergia() > 90);
        System.out.println("¿Existe un artista con energía mayor a 90?: " + existeArtista);
        
        //Obtener el nombre del artista con más energía
        //orElse se usa por si no hay artistas, no de error y muestre el mensaje
        String artistaMasFuerte = artistas.stream().max((a1, a2) -> a1.getEnergia() - a2.getEnergia()).map(a -> a.getNombreArtistico()).orElse("No hay artistas");
        System.out.println("El nombre del artista más fuerte es: " + artistaMasFuerte);

        //Obtener una lista con los NOMBRES de los artistas con energía mayor que 60
        List<String> nombresMasSesenta = artistas.stream().filter(a->a.getEnergia() > 60).map(a -> a.getNombreArtistico()).toList();
        System.out.println("Nombres de artistas con energía mayor a 60: ");
        for (String nombre : nombresMasSesenta) {
            System.out.println(nombre);
        }

        //Energía total de artistas fuertes
        int energiaTotalArtistasFuertes = artistas.stream().filter(a -> a.getEnergia() > 50).mapToInt(a -> a.getEnergia()).sum();
        System.out.println("La energía total de los artistas más fuertes es: " + energiaTotalArtistasFuertes);

        //Obtener artistas ordenados por nombre OJO, ara Streams usar compareTO
        System.out.println("Artistas ordenados por nombre: ");
        List<Artista> ordenadosNombre = artistas.stream().sorted((a1, a2) -> a1.getNombreArtistico().compareTo(a2.getNombreArtistico())).toList();
        for (Artista artista : ordenadosNombre) {
            System.out.println(artista.getNombreArtistico());
        }

        //NOMBRE del artista más cansado
        String nombreCansado = artistas.stream().min((a1, a2) -> a1.getEnergia() - a2.getEnergia()).map(a -> a.getNombreArtistico()).orElse("No hay artistas");
        System.out.println("Artista más cansado: ");
        System.out.println(nombreCansado); 

    }
}
