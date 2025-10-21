package UNIDAD2;

import java.util.Scanner;

public class EjemploAciertaNumero {
    public static void main(String[] args) {
        /**********************************/
        // DECLARACION DE VARIABLES
        /**********************************/
        int numBuscado = (int) (Math.random() * 100) + 1;
        int numJugado = 0;
        int numIntentos = 5;
        boolean encontrado = false;

        Scanner teclado = new Scanner(System.in);

        while (numIntentos > 0 && !encontrado) {
            System.out.println("Prueba suerte, tienes " + numIntentos + " intentos restate");
            numJugado = teclado.nextInt();
            if (numBuscado == numBuscado) {
                System.out.println("Has acertado");
                encontrado = true; // O opción break, que se sale del bucle
            } else if (numJugado > numBuscado) {
                System.out.println("El número buscado es mayor");
            } else {
                System.out.println("El número buscado es menor");
            }

            // Pasar al siguiente elemento

            numIntentos--;
        }

        if (!encontrado) {
            System.out.println("Lo siento, el número era: " + numBuscado);
        }

    }
}
