package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega4 {
    public static void main(String[] args) {
        
        //Scanner para poder introducir datos por teclado
        Scanner teclado = new Scanner(System.in);
        // Monedas totales
        int monedasIniciales = 100;
        // Booleano para salir de la partida
        boolean salirPartida = false;
        // Valores de los rodillos
        int[] valoresRodillo = { 1, 2, 3, 4, 5, 7 };
        // Array para guardar las tiradas
        int[] resultadoTirada = new int[3];
        // Guardar resultado del trío
        int ganaTrio = 0;
        // Guardar resultado pareja
        int ganaPareja = 0;
  
        //Bucle que te permite seguir jugando si no se sale de la partida
        //o si se tiene más de 5 monedas
        while (!salirPartida && monedasIniciales >= 5) {
            // Bucle para recorrer los valores y guardar los resultados en
            // los 3 rodillos
            for (int i = 0; i < 3; i++) {
                // Seleccionamos aleatoriamente un índice del array valoresRodillo
                int posicionAleatoriaArray = (int) (Math.random() * valoresRodillo.length);
                // Guardamos en cada iteración el valor aleatorio obtenido de valoresRodillo
                // en el array resultadoTirada
                resultadoTirada[i] = valoresRodillo[posicionAleatoriaArray];
            }
            // Mostrar el resultado de la tirada
            System.out.println("Resultado de la tirada:");
            System.out.println(resultadoTirada[0] + "  " + resultadoTirada[1] + "  " + resultadoTirada[2]);
            // Restar monedas de tiradas
            monedasIniciales = monedasIniciales - 5;
            // Calcular monedas restantes con premios
            // Premio trio y parejas
            if (resultadoTirada[0] == resultadoTirada[1] && resultadoTirada[1] == resultadoTirada[2]) {
                ganaTrio = resultadoTirada[0] * 10;
                System.out.println("Has conseguido 3 iguales!, has ganado: " + ganaTrio);
                monedasIniciales = monedasIniciales + ganaTrio;
            } else if (resultadoTirada[0] == resultadoTirada[1] || resultadoTirada[0] == resultadoTirada[2]
                    || resultadoTirada[1] == resultadoTirada[2]) {
                if (resultadoTirada[0] == resultadoTirada[1] || resultadoTirada[0] == resultadoTirada[2]) {
                    ganaPareja = resultadoTirada[0] * 2;
                    System.out.println("Has conseguido 2 iguales!, has ganado: " + ganaPareja);
                    monedasIniciales = monedasIniciales + ganaPareja;
                } else {
                    ganaPareja = resultadoTirada[1] * 2;
                    System.out.println("Has conseguido 2 iguales!, has ganado: " + ganaPareja);
                    monedasIniciales = monedasIniciales + ganaPareja;
                }
            } else {
                System.out.println("No has conseguido premio");
            }
            //Mensaje con las monedas restantes
            System.out.println("Te quedan " + monedasIniciales + " monedas restantes");
            //Mensaje por si se quiere continuar
            System.out.println("¿Quieres continuar? (escribe 'salir' para terminar o pulsa Enter para seguir)");
            String respuesta = teclado.nextLine();
            //Condicional para cambiar el valor del booleano y salir de la partida
            if (respuesta.equalsIgnoreCase("salir")) {
                salirPartida = true;
            }
        }
        //Mensaje que indica el final del juego y las monedas restantes
        System.out.println("Juego terminado. Te quedan " + monedasIniciales + " monedas.");
        teclado.close();

    }
}
