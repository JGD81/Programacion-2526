package com.festival;

import java.util.HashMap;
import java.util.Map;

import com.festival.model.Artista;

public class MainHashMap {
    public static void main(String[] args) {
        
        //Crear un nuevo HashMap
        //Clave - Valor. No se puede repetir la clave, si se repite
        //se sustituye por el anterior
        Map<Integer, Artista> artistasMap = new HashMap<>();

        //Añadir clave, valor a Hashmap (clave, objeto Artista)
        artistasMap.put(1, (new Artista(1, "Scorpions", 50)));
        artistasMap.put(2, (new Artista(2, "Bon Jovi", 60)));
        artistasMap.put(1, (new Artista(1, "Iron Maiden", 70)));

        System.out.println(artistasMap.size());

        //Se puede recorrer un HashMap de 3 maneras diferentes
        //Recorrer las Keys
        for (Integer id : artistasMap.keySet()) {
            System.out.println("Clave: " + id);
        }

        //Recorrer los valores (values)
        for (Artista artista : artistasMap.values()) {
            System.out.println(artista);
        }

        //Recorrer clave - valor
        for (Map.Entry<Integer, Artista> entry : artistasMap.entrySet()){
            Integer clave = entry.getKey();
            Artista valor = entry.getValue();

            System.out.println("ID: " + clave + " -> " + valor);
        }

        //containsKey() Comprobar si existe una clave
        System.out.println(artistasMap.containsKey(2));
        //containsKey() Comprobar si existe una clave
        System.out.println(artistasMap.containsKey(99));
        //containsValue() Comprobar si existe un artista nuevo con los mismos datos que uno ya guardado
        System.out.println(artistasMap.containsValue((new Artista(1, "Iron Maiden", 70))));
        //containsValue() busca por objetos completos, no busca dentro del objeto
        

        //Buscar un artista con un nombre
        for (Artista artista : artistasMap.values()) {
            if(artista.getNombreArtistico().equals("Iron Maiden")){
                System.out.println("Existe Iron Maiden");
            }
            
        }
    }
}
