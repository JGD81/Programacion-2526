package UNIDAD2;

import java.util.Random;

public class EjerciciosEntrega5 {
    public static void main(String[] args) {
        int dado = 10;

        if (dado < 4) {
            System.out.println("Fracaso crítico");
        } else if (dado >= 10) {
            System.out.println("Fracaso crítico");
        } else {
            System.out.println("Resultado normal");
        }

        System.out.println("Valor obtenido: " + dado);

    }
}
