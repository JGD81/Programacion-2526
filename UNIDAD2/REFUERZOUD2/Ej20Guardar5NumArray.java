package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej20Guardar5NumArray {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int [] numeros = new int[5];

        for (int i=0;i<5;i++){

            System.out.print("Introduce el número " + (i+1) + ": ");
            numeros[i] = teclado.nextInt();
        }

        for (int i=0;i<5;i++){
            System.out.print(numeros[i] + " ");
        }
    }
}
