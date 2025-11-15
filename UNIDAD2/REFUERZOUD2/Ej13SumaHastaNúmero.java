package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej13SumaHastaNúmero {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número: ");
        int num = teclado.nextInt();

        int suma = 0;

        for(int i=1; i <= num; i++){
            suma = suma + i;
            System.out.print(i);
            if(i == num){
                System.out.print(" = " + suma);
            }else{
                System.out.print(" + ");
            }
        }
    }
}
