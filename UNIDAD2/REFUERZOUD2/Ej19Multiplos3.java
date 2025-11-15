package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej19Multiplos3 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        for(int i=1; i <= num; i++){
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
    }
}
