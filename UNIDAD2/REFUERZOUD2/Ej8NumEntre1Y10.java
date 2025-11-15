package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej8NumEntre1Y10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        if (num > 0 && num <= 10){
            System.out.println("El número " + num + ", está entre el 1 y el 10");
        }else{
            System.out.println("El número " + num + ", no está entre el 1 y el 10");
        }
    }
}
