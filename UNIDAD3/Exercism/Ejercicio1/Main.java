package UNIDAD3.Exercism.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        //Crear el objeto lasagna
        Lasagna lasagna = new Lasagna();
        //Mostar el tiempo esperado de coción 
        System.out.println(lasagna.expectedMinutesInOven());
        //Mostrar el tiempo que le falta cuando ya lleva en coción
        //un tiempo determinado
        System.out.println(lasagna.remainingMinutesInOven(20));
        //Mostrar el tiempo que se tarda en preparar la lasaña según
        //las capas
        System.out.println(lasagna.preparationTimeInMinutes(2));
        //Calcular el tiempo invertido hasta ahora en la lasaña
        System.out.println((lasagna.totalTimeInMinutes(3, 20)));
        
    }
}
