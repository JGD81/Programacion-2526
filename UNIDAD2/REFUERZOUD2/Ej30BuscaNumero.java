package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej30BuscaNumero {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int[] numeros = {2,4,7,10,13,16,18,20,39,22};
        boolean numEsEcontrado = false;

        System.out.println("Introduce el número a buscar: ");
        int num = teclado.nextInt();

        for(int i=0; i<numeros.length; i++){
            if (numeros[i] == num){
                numEsEcontrado = true;
                break;
            }
        }

        if(!numEsEcontrado){
            System.out.println("El número no se encuentra en el array");
        }else{
            System.out.println("El número " + num + " se encuentra en el array");
        }
    }
}
