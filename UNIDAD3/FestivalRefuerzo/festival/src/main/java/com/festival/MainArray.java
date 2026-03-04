package com.festival;

import com.festival.model.Artista;

public class MainArray {
    public static void main(String[] args) {
        
        //Creación de objetos artista
        Artista artista1 = new Artista(1,"Chiquetete", 50);
        Artista artista2 = new Artista(2, "El Fary", 60);
        Artista artista3 = new Artista(3, "Manolo Escobar", 70);
        Artista artista4 = new Artista(4, "Raphael", 90);

        //Creación de array con artistas
        Artista[] artistas = {artista1, artista2, artista3};

        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };

        //Nuevo Array más grande
        Artista[] artistas2 = new Artista[4];
        //Copiar los artistas de otro array
        for(int i = 0; i < artistas.length; i++){
            artistas2[i] = artistas[i];
        }
        //Añadir otro artista
        artistas2[3] = artista4;

        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };

        //Ejemplo para comprender referencias de las variables
        //Si hacemos esto:
        artistas = artistas2;
        //Y volvemos a imprimir
        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };

        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };
        //Ambas variables ahora apuntan al mismo array, así que el
        //el contenido ahora es el mismo

        //Si ahora actualizamos una de las dos variables, al estar
        //las dos apuntando al mismo array en memoria, se actualizan
        //las dos

        artistas[0] = new Artista(0, "Artista actualizado", 100);

        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };

        for(int i = 0; i < artistas.length; i++){
            System.out.println(artistas[i]);
        };
    }
}