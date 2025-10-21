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

        double sumaCartasJugador = 0;
        double sumaCartasBanca = 0;
        double numAleatorio = (Math.random() * 10) + 1;
        if (numAleatorio >= 6 && numAleatorio <= 10) {
            numAleatorio = 0.5;
        }
        boolean CartasJugador = false;

        while (numAleatorio <= 5) {
            if (numAleatorio >= 0 && numAleatorio <= 5) {
                sumaCartasBanca = sumaCartasBanca + numAleatorio;
            }
        }
    }
}
