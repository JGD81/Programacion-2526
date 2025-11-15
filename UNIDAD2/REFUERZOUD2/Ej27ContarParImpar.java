package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej27ContarParImpar {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[10];
        int contadorPares = 0;
        int contadorImpares = 0;

        for (int i = 0; i < 10; i++){
        System.out.println("Introduce el número " + (i+1) + ":");
        numeros[i] = teclado.nextInt();
        }

        for (int j = 0; j < 10; j++){
            if (numeros[j] % 2 == 0){
            contadorPares++;
            }else{
            contadorImpares++;
            }
        }
        System.out.println("El número de números pares es: " + contadorPares);
        System.out.println("El número de números impares es: " + contadorImpares);
    }   
}
