package UNIDAD2;

/**
 * El programa generará 20 números aleatorios y verificará
 * si son pares o impares. Mostrará un mensaje del tipo el número
 * x es par ó impar
 * Después sacaremos la cantidad de cada tipo y el porcentaje
 */
public class ContarPares {
    public static void main(String[] args) {

        int numImpares = 0;
        int numPares = 0;

        for (int i = 0; i <= 19; i++) {
            int numeroAleatorio = (int) (Math.random() * 100) + 1;

            if (numeroAleatorio % 2 == 0) {
                System.out.println("El numero " + numeroAleatorio + " es par");
                numPares++;
            } else {
                System.out.println("El numero " + numeroAleatorio + " es impar");
                numImpares++;
            }
        }

        System.out.println("Los números pares son: " + numPares + " y los números impares son: " + numImpares);

        System.out.println("El porcentaje de pares ha sido " + (numPares * 100 / 20));
        System.out.println("El porcentaje de impares ha sido " + (numImpares * 100 / 20));
    }
}
