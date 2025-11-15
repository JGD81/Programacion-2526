package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej15Media10Numeros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double suma = 0;
        double media = 0; 

        for(int i=1;i<11;i++){
            System.out.println("Introduce el número " + i + ":");
            int num = teclado.nextInt();
            suma = suma + num;
            if (i==10){
                media = suma / i;
            }
        }

        System.out.println("La media de los números introducidos es: " + media);
    }
}
