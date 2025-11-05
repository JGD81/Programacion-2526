package UNIDAD2;

import java.util.Scanner;

/*1️⃣ Contar letras manualmente
Pide una palabra y muestra cuántas letras tiene.
Usa .length() para saber cuántas veces repetir el bucle, y un contador que se incremente dentro.
💡 Ejemplo:
Entrada → “hola”
Salida → Tiene 4 letras */

public class EjerciciosRefuerzo1 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una palabra: ");
        String palabra = teclado.nextLine();

        int longitudTotal= 0;

        for (int i = 0; i < palabra.length(); i++){
            longitudTotal++; //Se cuentan las iteraciones del bucle
        }

        System.out.println("La longitud total de la cadena es: " +longitudTotal);

        teclado.close();

    }
    
}
