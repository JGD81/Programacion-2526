package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class NumPos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        if (num >= 0){
            System.out.println("El número es positivo");
        }else{
            System.out.println("El número es negativo");
        }

        teclado.close();
    }
}
