package UNIDAD2.REFUERZOUD2;

public class Ej14NumParesHasta100 {
    public static void main(String[] args) {
        
        int contador = 0;

        for(int i = 1; i<=100;i++){
            if(i % 2 == 0){
                contador++;
            }
        }
        System.out.println("El número de números pares del 1 al 100 son: " + contador);
    }
}
