package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej18NumHastaNegativo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numTotales = 0;
        int num;

        do{
            System.out.println("Introduce un número: ");
            num = teclado.nextInt();
            numTotales++;

        }while(num > 0);

        System.out.println("El número total de números introducidos es: " + numTotales);
    }
}
