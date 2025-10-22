package UNIDAD2;

import java.util.Scanner;

public class TrioDados {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        // Variables de tiradas
        int tirada1Jugador1, tirada2Jugador1, tirada3Jugador1;
        int tirada1Jugador2, tirada2Jugador2, tirada3Jugador2;
        
        // Jugador 1
        System.out.println("***Tiradas Jugador 1***");
        System.out.print("Pulsa ENTER para realizar la primera tirada, Jugador 1: ");
        teclado.nextLine();
        tirada1Jugador1 = (int)(Math.random() * 6) + 1;
        System.out.println("La primera tirada es de: " + tirada1Jugador1);

        System.out.print("Pulsa ENTER para realizar la segunda tirada, Jugador 1: ");
        teclado.nextLine();
        tirada2Jugador1 = (int)(Math.random() * 6) + 1;
        System.out.println("La segunda tirada es de: " + tirada2Jugador1);

        System.out.print("Pulsa ENTER para realizar la tercera tirada, Jugador 1: ");
        teclado.nextLine();
        tirada3Jugador1 = (int)(Math.random() * 6) + 1;
        System.out.println("La tercera tirada es de: " + tirada3Jugador1);

        // Jugador 2
        System.out.println("\n***Tiradas Jugador 2***");
        System.out.print("Pulsa ENTER para realizar la primera tirada, Jugador 2: ");
        teclado.nextLine();
        tirada1Jugador2 = (int)(Math.random() * 6) + 1;
        System.out.println("La primera tirada es de: " + tirada1Jugador2);

        System.out.print("Pulsa ENTER para realizar la segunda tirada, Jugador 2: ");
        teclado.nextLine();
        tirada2Jugador2 = (int)(Math.random() * 6) + 1;
        System.out.println("La segunda tirada es de: " + tirada2Jugador2);

        System.out.print("Pulsa ENTER para realizar la tercera tirada, Jugador 2: ");
        teclado.nextLine();
        tirada3Jugador2 = (int)(Math.random() * 6) + 1;
        System.out.println("La tercera tirada es de: " + tirada3Jugador2);

        // Comprobar tríos y parejas
        boolean trioJugador1 = (tirada1Jugador1 == tirada2Jugador1) && (tirada2Jugador1 == tirada3Jugador1);
        boolean trioJugador2 = (tirada1Jugador2 == tirada2Jugador2) && (tirada2Jugador2 == tirada3Jugador2);
        
        // Para parejas, debe haber DOS dados iguales pero NO tres (no trío)
        boolean parejaJugador1 = !trioJugador1 && ((tirada1Jugador1 == tirada2Jugador1) || (tirada2Jugador1 == tirada3Jugador1) || (tirada1Jugador1 == tirada3Jugador1));
        boolean parejaJugador2 = !trioJugador2 && ((tirada1Jugador2 == tirada2Jugador2) || (tirada2Jugador2 == tirada3Jugador2) || (tirada1Jugador2 == tirada3Jugador2));

        System.out.println("\n*** RESULTADO ***");
        
        // Ambos tienen trío
        if (trioJugador1 && trioJugador2) {
            int valorTrioJ1 = tirada1Jugador1;
            int valorTrioJ2 = tirada1Jugador2;
            
            if (valorTrioJ1 > valorTrioJ2) {
                System.out.println("El jugador 1 es el ganador! (Trío de " + valorTrioJ1 + " vs Trío de " + valorTrioJ2 + ")");
            } else if (valorTrioJ2 > valorTrioJ1) {
                System.out.println("El jugador 2 es el ganador! (Trío de " + valorTrioJ2 + " vs Trío de " + valorTrioJ1 + ")");
            } else {
                System.out.println("Empate técnico");
            }
        } 
        // Solo jugador 1 tiene trío
        else if (trioJugador1 && !trioJugador2) {
            System.out.println("El jugador 1 es el ganador! (Tiene trío)");
        } 
        // Solo jugador 2 tiene trío
        else if (!trioJugador1 && trioJugador2) {
            System.out.println("El jugador 2 es el ganador! (Tiene trío)");
        } 
        // Ambos tienen pareja (pero ninguno tiene trío)
        else if (parejaJugador1 && parejaJugador2) {
            int sumaJ1 = tirada1Jugador1 + tirada2Jugador1 + tirada3Jugador1;
            int sumaJ2 = tirada1Jugador2 + tirada2Jugador2 + tirada3Jugador2;
            
            if (sumaJ1 > sumaJ2) {
                System.out.println("El jugador 1 es el ganador! (Pareja con suma " + sumaJ1 + " vs " + sumaJ2 + ")");
            } else if (sumaJ2 > sumaJ1) {
                System.out.println("El jugador 2 es el ganador! (Pareja con suma " + sumaJ2 + " vs " + sumaJ1 + ")");
            } else {
                System.out.println("Empate técnico");
            }
        } 
        // Solo jugador 1 tiene pareja
        else if (parejaJugador1 && !parejaJugador2) {
            System.out.println("El jugador 1 es el ganador! (Tiene pareja)");
        } 
        // Solo jugador 2 tiene pareja
        else if (!parejaJugador1 && parejaJugador2) {
            System.out.println("El jugador 2 es el ganador! (Tiene pareja)");
        } 
        // Ninguno tiene pareja ni trío (suma total)
        else {
            int sumaJ1 = tirada1Jugador1 + tirada2Jugador1 + tirada3Jugador1;
            int sumaJ2 = tirada1Jugador2 + tirada2Jugador2 + tirada3Jugador2;
            
            if (sumaJ1 > sumaJ2) {
                System.out.println("El jugador 1 es el ganador! (Suma total: " + sumaJ1 + " vs " + sumaJ2 + ")");
            } else if (sumaJ2 > sumaJ1) {
                System.out.println("El jugador 2 es el ganador! (Suma total: " + sumaJ2 + " vs " + sumaJ1 + ")");
            } else {
                System.out.println("Empate técnico");
            }
        }
        
        teclado.close();
    }
}