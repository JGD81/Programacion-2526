package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega2 {
    public static void main(String[] args) {
        //Scanner para introducir datos por teclado
        Scanner teclado = new Scanner(System.in);
        //Variables necesarias
        int contador;
        int tirada;
        int sumaTotalDados = 0;
        int sumaCriticos = 0;
        int primeraTirada = 0;
        boolean tiradaEpica = true;

        System.out.println("¿Cuántos dados quieres lanzar?: ");
        int numDados = teclado.nextInt();

        System.out.println("¿De cuántas caras quieres los dados?");
        int carasDados = teclado.nextInt();
        teclado.nextLine();//Pausa en la ejecución

        //Bucle que se repetirá dependiendo del número de dados elegido por usuario
        for(contador = 1; contador <= numDados;contador++){
            System.out.println("\nRealiza la tirada " + contador + " (Pulsa Enter)");
            teclado.nextLine();//Pausa para que el usuario pulse ENTER en cada tirada
            //La tirada será random y el intervalo dependerá de las caras de los dados elegidas
            tirada = (int)(Math.random()*carasDados)+1;
            System.out.println("La tirada es: " + tirada);
            //Guardamos la primera tirada (con el contador 1)
            //Vamos comparando las siguientes con la primera. En el momento que una no sea igual,
            //el booleano pasa a false y ya no cambiará.
            //Si son iguales, tenemos una tirada épica.
            if (contador == 1){
                primeraTirada = tirada;
            }else if (tirada != primeraTirada){
                tiradaEpica = false;
            }
            
            sumaTotalDados = sumaTotalDados + tirada;
            //Comparamos la tirada con las caras del dado (que será el número más alto)
            if (tirada == carasDados){
                sumaCriticos++;
            }
        }
        System.out.println("\n------Resultados------");
        System.out.println("La suma total de las tiradas es: " + sumaTotalDados);
        System.out.println("El número de críticos es: " + sumaCriticos);
        if (tiradaEpica){
            System.out.println("Tirada épica!");
        }
    }
}
