package UNIDAD2;

public class SumaArrayPositivos {
    public static void main(String[] args) {
        int[] numeros = {-5,4,3,-1};
        int suma = 0;
        int i = 0;

        for (i = 0; i < numeros.length;i++){
            if (numeros[i] >= 0){
                suma = suma + numeros[i];
            }
        }
        System.out.println("La suma de los positivos es: " + suma);
    }
}
