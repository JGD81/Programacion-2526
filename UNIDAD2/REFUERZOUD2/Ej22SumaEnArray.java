package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej22SumaEnArray {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int [] numeros = new int[10];
        int suma = 0;

        for(int i=0;i<10;i++){

            System.out.println("Introduce el número " + (i+1) + ":");
            numeros[i] = teclado.nextInt();
            suma = suma + numeros[i];
        }

        System.out.println("-----Resultado Suma-----");

        for (int i=0;i<10;i++){
            if(i< 9){
                System.out.print(numeros[i] + " + ");
            }else{
                System.out.print(numeros[i] + " = " + suma);
            }
        }
    }
}
