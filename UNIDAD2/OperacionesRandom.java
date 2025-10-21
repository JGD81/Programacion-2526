package UNIDAD2;

import java.util.Scanner;

public class OperacionesRandom {
    public static void main(String[] args) {

        // Crear la clase Scanner para introducir datos por teclado
        Scanner teclado = new Scanner(System.in);

        // Declaración de variables
        int num1 = 0;
        int num2 = 0;
        int resultado = 0;

        // Pedir datos por teclado
        System.out.println("Introduce el primer número: ");
        num1 = teclado.nextInt();
        System.out.println("Introduce el segundo número: ");
        num2 = teclado.nextInt();
        System.out.println("Introduce el resultado");
        resultado = teclado.nextInt();

        // Condicionales para obtener la operación
        if (resultado == num1 + num2) {
            System.out.println("La operación realizada es una suma");
        } else if (resultado == num1 - num2) {
            System.out.println("La operación realizada es una resta");
        } else if (resultado == num1 * num2) {
            System.out.println("El resultado es una multiplicación");
        } else if (resultado == num1 / num2) {
            System.out.println("La operación realizada es una división");
        } else if (resultado == num1 % num2) {
            System.out.println("La operación realizada es el módulo");
        } else if (resultado == (int) Math.pow(num1, num2)) {
            System.out.println("La operación realizada es de una potencia");
        } else if (resultado == (int) Math.sqrt(num1)) {
            System.out.println("La operación realizada es una raíz cuadrada");
        } else if (resultado == (int) Math.sqrt(num2)) {
            System.out.println("La operación realizada es de una raíz cuadrada");
        } else {
            System.out.println("La operación es indefinida");
        }
    }
}
