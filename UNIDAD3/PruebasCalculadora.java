package UNIDAD3;

public class PruebasCalculadora {
    
    public static void main(String[] args) {
        
        Utilidades util = new Utilidades();

        System.out.println("La suma de 2 + 2 es: " + util.suma(2, 2));

        int[] listaNumeros = {3, 4, 23, 123, 123};

        System.out.println("La suma de los elementos del array es: " + Utilidades.suma(listaNumeros));
    }
}
