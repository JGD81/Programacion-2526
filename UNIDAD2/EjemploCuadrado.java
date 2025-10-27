package UNIDAD2;

import java.util.Scanner;

/*
 * El programa deberá dibujar un cuadrado
 * Habrá 2 variantes de la primera solo un cuadrado de x espacios de lado
 * La segunda igual pero hueco
 */

public class EjemploCuadrado {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int tamCuadrado = 0;

        System.out.print("De qué tamaño quieres el cuadrado: ");
        tamCuadrado=teclado.nextInt();

        for(int i = 0; i < tamCuadrado; i++){
            for(int j =0; j < tamCuadrado; j++){
            System.out.print("*");
        }
        System.out.println();
        }

    }
}
