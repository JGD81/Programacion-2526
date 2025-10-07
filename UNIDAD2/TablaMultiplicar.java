package UNIDAD2;

public class TablaMultiplicar {

    public static void main(String[] args) {
        // Creamos un número aleatorio entre el 1 y el 10 para la tabla de multiplicar
        int numero = (int) (Math.random() * 10) + 1;
        int contador = 1;

        /*
         * Para sacar la tabla de multiplicar, mostramos por pantalla la
         * expresión de cada multiplicación.
         * La variable contador (i), la vamos incrementando para usarla
         * en la multiplicaicón y que cada vez sea por el siguiente número.
         */

        System.out.println("Tabla del " + numero);

        while (contador <= 10) {
            System.out.println(numero + " x " + contador + " = " + (numero * contador));
            contador = contador + 1;
        }
    }

}
