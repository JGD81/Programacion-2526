package UNIDAD2;

import java.util.Scanner;

public class CincoEnteros {
    public static void main(String[] args) {
        /*
         * Creamos la clase Scanner para poder leer los números por el
         * teclado
         */
        Scanner teclado = new Scanner(System.in);
        // Leer 5 números por teclado
        System.out.print("Introduce el primer número: ");
        int num1 = teclado.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = teclado.nextInt();
        System.out.print("Introduce el tercer número: ");
        int num3 = teclado.nextInt();
        System.out.print("Introduce el cuarto número: ");
        int num4 = teclado.nextInt();
        System.out.print("Introduce el quinto número: ");
        int num5 = teclado.nextInt();
        // Variable para guardar el mayor
        int numMayor = 0;

        if ((num1 > num2) && (num1 > num3) && (num1 > num4) && (num1 > num5)) {
            numMayor = num1;
        }

    }
}
