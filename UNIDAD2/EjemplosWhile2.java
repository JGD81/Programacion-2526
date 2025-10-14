package UNIDAD2;

public class EjemplosWhile2 {
    public static void main(String[] args) {
        /*
         * Primero vamos a hacer un programa que haga una cuenta atrás de un cohete.
         * Contará desde 10 hasta 1 y después dira ignición, cuando sea 3 además
         * mostrará el mensaje "preparados", cuando sea 2 "listos" y cuando sea "rezad
         * mucho"
         */

        int i = 10;

        while (i >= 1) {
            if (i == 3)
                System.out.println("Quedan 3 --- Preparados");
            else if (i == 2)
                System.out.println("Quedan 2 --- Listossss");
            else if (i == 1)
                System.out.println("Quedan 1 --- rezad todo lo que sepais, inconscientes");
            else
                System.out.println(i);
            i--;
        }

        System.out.println("Zero Ignicionnn!");

    }
}
