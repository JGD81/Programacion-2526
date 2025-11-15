package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej29SoloParesArray {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i=0;i<10;i++){
            System.out.println("Introduce el número " + (i+1) + ": ");
            numeros[i] = teclado.nextInt();
        }

        for (int i=0;i<10;i++){
            if (i % 2 == 0){
                System.out.print(numeros[i] + " ");
            }
        }

        teclado.close();
    }
}
