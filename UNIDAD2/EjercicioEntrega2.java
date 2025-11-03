package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
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
        teclado.nextLine();

        for(contador = 1; contador <= numDados;contador++){
            System.out.println("\nRealiza la tirada " + contador + " (Pulsa Enter)");
            teclado.nextLine();

            tirada = (int)(Math.random()*carasDados)+1;
            System.out.println("La tirada es: " + tirada);

            if (contador == 1){
                primeraTirada = tirada;
            }else if (tirada != primeraTirada){
                tiradaEpica = false;
            }

            sumaTotalDados = sumaTotalDados + tirada;
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
