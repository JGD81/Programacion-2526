package UNIDAD2;

import java.util.Scanner;

/*Pide una palabra y muestra solo los caracteres que están en posiciones pares (0, 2, 4, ...).
Ejemplo:
Entrada → "Programar"
Salida → "Pormr"
 */

public class EjerciciosRefuerzo2 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce una palabra: ");
        String palabra = teclado.nextLine();

        for (int i = 0; i < palabra.length();i++){
            if (i % 2 == 0){
                System.out.print(palabra.charAt(i));
            }
        }
        
    }
}
