package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej16NumParHastaNum {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        for(int i=0;i<=num;i++){
            if(i % 2 == 0){
                System.out.println(i + " ");
            }
        }
    }
}
