package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej7TablaMultiplicar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número para pintar su tabla de multiplicar: ");
        int num = teclado.nextInt();

        for(int i = 0; i <= 10;i++){
            System.out.println(num + " * " + i + " = " + num * i );
        }
    }
}
