package UNIDAD2;

import java.util.Scanner;

/**
 * El programa simulará el juego de cartas de las 7 y 1/2, primero el jugador
 * sacará cartas
 * hasta que quiera parar, si se pasa de 7 y media directamente pierde
 * Si no pierde, entonces juega la banca contra la suma de las cartas del
 * jugador
 * La banca querrá siempre más cartas mientras su suma sea menor o igual de 5
 */

public class EjemploSieteyMedia {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        float carta = 0;
        float sumaJugador = 0;
        float sumaBanca = 0;
        String quiereContinuar ="si";

        while (quiereContinuar.equalsIgnoreCase("si") && sumaJugador < 7.5f){
            carta = (int)(Math.random()*10 + 1);
            //Es media si  sale un 8 un 9 y un 10
            if (carta > 7){
                carta = 0.5f;
            }
            //Sumamos la carta que hemos sacado al conjunto de cartas
            sumaJugador = sumaJugador + carta;

            //Le preguntamos al jugador si quiere seguir
            System.out.println("Ha salido un " + carta + " en total llevas " + sumaJugador);
            if (sumaJugador > 7.5f){
                System.out.println("Te has pasao bacalao, me quedo con tu pasta");
            }else{
                System.out.print("Quieres seguir jugando (Si/No)?");
                quiereContinuar = teclado.next();
            }
        }

        //La banca sólo empieza si el jugador no se ha pasado
        if (sumaJugador <= 7.5f){
             while (sumaBanca < sumaJugador  && sumaBanca < 7.5f){
            //Es media si  sale un 8 un 9 y un 10
            if (carta > 7){
                carta = 0.5f;
            }
            //Sumamos la carta que hemos sacado al conjunto de cartas
            sumaBanca = sumaBanca + carta;

            //Le preguntamos al jugador si quiere seguir
            System.out.println("Ha salido un " + carta + " en total la banca lleva " + sumaBanca);
           
        }

         if (sumaBanca > 7.5f){
                System.out.println("La banca ha perdido, espera a final de mes");
        }else{
            //La banca no se ha pasado
            //Si el jugador tampoco se ha pasado
            if(sumaJugador <= 7.5f){
                if (sumaJugador>sumaBanca){
                    System.out.println("Ha ganado el jugador!!");
                    if (sumaJugador == 7.5f){
                        System.out.println("Felicidades por sacar 7.5, te pagamos el doble");
                    }
                }else{
                    System.out.println("Ha ganado la banca");
                }
            }
        }
        teclado.close();
    }
}
}  


