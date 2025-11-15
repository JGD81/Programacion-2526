package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej20Multiplos4 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        for(int i=1; i <=50; i++){
            if (i % 4 == 0){
                continue;
            }
            System.out.print(i + " ");
        }
    }
}

