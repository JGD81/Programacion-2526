package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej12NumMayor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el primer número");
        int mayor = teclado.nextInt();

        for(int i=2;i<=5;i++){
            System.out.println("Introduce el número " + i + ":");
            int num = teclado.nextInt();
            if(num >= mayor){
                mayor = num;
            }
        }
        System.out.println("El número mayor de los introducidos es: " + mayor);
    }
}
