package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej24NombresAlReves {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        String [] nombres = new String[6];

        for(int i=0; i<6; i++){
            System.out.println("Introduce el nombre " + (i +1) + ":");
            nombres[i] = teclado.nextLine();
        }

        System.out.println("Nombres al revés: ");
        
        for(int i = 5; i >= 0; i--){
            System.out.print(nombres[i] + " ");
        }
    }
}
