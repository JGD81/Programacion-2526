package UNIDAD2.REFUERZOUD2;

public class Ej26RellenarArray {
    public static void main(String[] args) {
        
        int[] numeros = new int[10];
        for (int i=0; i<10; i++){
            numeros[i] = i + 1;
        }
        
        for (int i=0; i<10; i++){
            System.out.print(numeros[i] + " ");
        }
    }
}
