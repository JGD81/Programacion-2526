package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej11NumPos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int suma = 0;

        for(int i = 1; i <= 10; i++){
            System.out.println("Introduce el número " + i + ":");
            int num = teclado.nextInt();
            if(num > 0){
                suma++;
            }
        }

        System.out.println("El número de números positivos es: " + suma);
    }
}
