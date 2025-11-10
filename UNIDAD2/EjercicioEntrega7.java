package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega7 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce un número: ");
        int n = teclado.nextInt();


        //Bucle para recorrer el array y sacar los números que se encuentran en el rango
        System.out.println("Los divisores impares del número " + n + " son los siguientes: ");
        for (int i = 1; i <= n; i++){
            //Saber los números del rango que son divisores
            if (n % i == 0 && i % 2 != 0){
                    System.out.print(i + " ");
            }

        }
    }
}
