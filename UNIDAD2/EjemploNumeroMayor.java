package UNIDAD2;

import java.util.Scanner;

public class EjemploNumeroMayor {
    public static void main(String[] args) {
        /**
         * El programa lee o genera aleaotriamente tres números y muestra el mayor de
         * los tres
         */

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer numero: ");
        num1 = teclado.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2 = teclado.nextInt();
        System.out.println("Introduce el primer numero: ");
        num3 = teclado.nextInt();
        // Para que el num1 sea el mayor, tiene que ser mayor que los otros dos
        if (num1 >= num2 && num1 >= num3)
            System.out.println("El número mayor es: " + num1);
        else if (num2 >= num3)
            System.out.println("El número mayor es: " + num2);
        else
            System.out.println("El número mayor es: " + num3);
    }
}
