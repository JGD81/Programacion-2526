package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class NumMayor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer número: ");
        int num1 = teclado.nextInt();

        System.out.println("Introduce el segundo número: ");
        int num2 = teclado.nextInt();

        if (num1 > num2){
            System.out.println("El número " + num1 + " es mayor que el número " + num2);
        }else if(num1 == num2){
            System.out.println("Los números son iguales");
        }else{
            System.out.println("El número " + num2 + " es mayor que el número " + num1);
        }
    }
}
