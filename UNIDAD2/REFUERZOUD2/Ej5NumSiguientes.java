package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej5NumSiguientes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número");
        int num = teclado.nextInt();

        for(int i = 1; i <= 5; i++){
            System.out.println(num + i);
        }
    }
}
