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
        System.out.println("---Números mayor y menor---");
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
        // Variable para guardar el menor
        int numMenor = 0;
        // Condicionales para obener el mayor
        if ((num1 >= num2) && (num1 >= num3) && (num1 >= num4) && (num1 >= num5)) {
            numMayor = num1;
        } else if ((num2 >= num1) && (num2 >= num3) && (num2 >= num4) && (num2 >= num5)) {
            numMayor = num2;
        } else if ((num3 >= num1) && (num3 >= num2) && (num3 >= num4) && (num3 >= num5)) {
            numMayor = num3;
        } else if ((num4 >= num1) && (num4 >= num2) && (num4 >= num3) && (num4 >= num5)) {
            numMayor = num4;
        } else if ((num5 >= num1) && (num5 >= num2) && (num5 >= num3) && (num5 >= num4))
            numMayor = num5;
        // Condicionales para obtener el menor
        if ((num1 <= num2) && (num1 <= num3) && (num1 <= num4) && (num1 <= num5)) {
            numMenor = num1;
        } else if ((num2 <= num1) && (num2 <= num3) && (num2 <= num4) && (num2 <= num5)) {
            numMenor = num2;
        } else if ((num3 <= num1) && (num3 <= num2) && (num3 <= num4) && (num3 <= num5)) {
            numMenor = num3;
        } else if ((num4 <= num1) && (num4 <= num2) && (num4 <= num3) && (num4 <= num5)) {
            numMenor = num4;
        } else if ((num5 <= num1) && (num5 <= num2) && (num5 <= num3) && (num5 <= num4))
            numMenor = num5;

        // Imprimimos el mayor y el menor
        System.out.println("---Resultado---");
        System.out.println("El número mayor es: " + numMayor);
        System.out.println("El número menor es: " + numMenor);

        // Añadimos 3 nuevos números
        System.out.println("---Introduce 3 nuevos números---");
        System.out.print("Introduce el sexto número: ");
        int num6 = teclado.nextInt();
        System.out.print("Introduce el séptimo número: ");
        int num7 = teclado.nextInt();
        System.out.print("Introduce el octavo número: ");
        int num8 = teclado.nextInt();

        // Condicionales para obtener pares y mayores de 10
        if (num6 % 2 == 0 && num6 > 10) {
            System.out.println("El sexto número, el " + num6 + ", es par y mayor que 10");
        }
        if (num7 % 2 == 0 && num7 > 10) {
            System.out.println("El séptimo número, el " + num7 + ", es par y mayor que 10");
        }
        if (num8 % 2 == 0 && num8 > 10) {
            System.out.println("El octavo número, el " + num8 + ", es par y mayor que 10");
        }
    }
}
