package UNIDAD2;

import java.util.Scanner;

public class EjemploTriangulo {
    public static void main(String[] args) {
        /*
         * El programa leera la base y dibujará un triangulo de ese tamaño
         * Primero versión Rectángulo y luego isósceles
         */

         Scanner teclado = new Scanner(System.in);
         int baseTriangulo = 0;

         System.out.print("De qué tamaño es la base del triángulo: ");
         baseTriangulo = teclado.nextInt();

        /*
         * Dibujamos cada nivel del triángulo, en total hay baseTriangulo veces niveles
         */

         for (int i = 0; i < baseTriangulo;i++){
            //En cada nivel tengo que dibujar i+1 asteriscos
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            //Después de dibujar un nivel, pasamos a la siguiente línea
            System.out.println();
         }


         teclado.close();
    }
}
