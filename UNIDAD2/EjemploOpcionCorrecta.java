package UNIDAD2;

import java.util.Scanner;

public class EjemploOpcionCorrecta {
    /**
     * Este programa realizará un menú en el cual preguntará al alumno cuál
     * es el destino final de la raza humana, tendrá cuatro opciones
     * Si el usuario elige la opción correcta mostrará un mensaje tipo "Has salvado nuestro destino!
     * y sino, pondrá un mensaje tipo "Cataclismo Zombie!! Try Again!!"
     * Pista: usar switch, el usuario responde con una letra o número de opción
     * El programa, en caso que no acierte, le seguirá preguntando hasta que de con la buena
     */

     public static void main(String[] args) {

        char opcion = ' ';
        Scanner teclado = new Scanner(System.in);
        String mensaje= "";
        mensaje = "Tienes que ayudarme a salvar el mundo.\n Cuál es el destino final de la humanidad, elige la opción correcta\n";
        mensaje += "Las opciones son:\n";
        mensaje += "A - Volver a la agricultura y recolección y dejar la tecnología\n";
        mensaje += "B - Encontrar planeta colonizable y dejar la tierra\n";
        mensaje += "C - Dejar que la IA guíe nuestros destinos y decida la mejor para nosotros\n";
        mensaje += "D - Paso de tó\n";
        mensaje += "\nElibe una opción: ";

        //Escribimos el mensaje
        System.out.println(mensaje);

        //Leemos de teclado la opción elegida
        //Leemos un string, sobre ese string lo convertimos a mayúsculas, y de esa salida cogemos el primer caracter (pos0)
        opcion = teclado.next().toUpperCase().charAt(0);
        do {
            switch (opcion) {
                case 'A':   
                case 'B':
                case 'D':
                    System.out.println ("La cagaste burlancaster! Intentalo de Nuevo!");
                    break;
                case 'C':
                    System.out.println("Felicidades, salvaste a la humanidad!");
                    break;
                default:
                    System.out.println("Escribe una letra de la A a la D");
                    break;
            }
        }while (opcion !='C');    
    }
    
}
