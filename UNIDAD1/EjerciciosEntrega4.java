package UNIDAD1;

import java.util.Scanner;

public class EjerciciosEntrega4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el radio del círculo: ");
        double radio = teclado.nextDouble();

        double area = 3.1416 * radio * radio;
        System.out.println("El área del círculo es: " + area);
    }
}
