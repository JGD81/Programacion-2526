package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej28OrdenadoCreciente {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[5];
        boolean esCreciente = true;
        int numAnterior = 0;

        for (int i=0; i<5; i++){
            System.out.println("Introduce el número " + (i+1) + ":");
            numeros[i] = teclado.nextInt();
        }

        numAnterior = numeros[0];

        for (int i=1; i<5; i++){
            if (numeros[i] >= numAnterior){
                numAnterior = numeros[i];
            }else{
                esCreciente = false;
            }
        }

        if (esCreciente){
            System.out.println("Los números están ordenados de forma creciente");
        }else{
            System.out.println("Los números no están ordenados de forma creciente");
        }
    }
}
