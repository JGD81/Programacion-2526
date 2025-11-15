package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej23Mayores100 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int [] numeros = new int[8];
        int contador = 0;

        for(int i = 0; i<8; i++){
            System.out.println("Introduce el número " + (i + 1) + ":");
            numeros[i] = teclado.nextInt();
            if (numeros[i] > 100){
                contador++;
            }
        }

        System.out.println("-----Números mayores de 100: ");

        for(int i = 0; i<8; i++){
            if (numeros[i] > 100){
                System.out.print(numeros[i] + " ");
            }
        }

        System.out.println();
        System.out.println("El número de números introducidos mayores que 100 es: " + contador);

    }
}
