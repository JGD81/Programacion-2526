package UNIDAD2.REFUERZOUD2;

public class Ej31NumMay50 {
    public static void main(String[] args) {

        int[] numeros = new int[10];
        int contador = 0;

        for(int i=0; i<numeros.length; i++){
            numeros[i] = (int) (Math.random()*100 + 1);

        }

        System.out.println("Los números mayores de 50 son: ");

        for(int i=0; i<numeros.length; i++){
            if (numeros[i] > 50){
                System.out.print(numeros[i] + " ");
                contador++;
            }
        }

        System.out.println();
        System.out.println("Números totales: " + contador);

    }
}

