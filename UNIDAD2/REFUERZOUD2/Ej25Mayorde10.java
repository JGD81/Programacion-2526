package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;


public class Ej25Mayorde10 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int [] numeros = new int[10];
        int mayor = 0;

        for(int i=0; i<10; i++){
            System.out.println("Introduce el número " + (i+1) + ":");
            numeros[i] = teclado.nextInt();
            
        }

        mayor = numeros[0];

        for(int i=1; i<10; i++){
            if (numeros[i] > mayor){
                mayor = numeros[i];
            }
        }

        System.out.println("El número introducido mayor es: " + mayor);
    }
}
