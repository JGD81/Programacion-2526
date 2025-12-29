package UNIDAD3.Exercism.Ejercicio6;

public class Main {
    public static void main(String[] args) {
        //Creamos el objeto car mediante el método buy
        JedliksToyCar car = JedliksToyCar.buy();
        //Mostramos la distancia recorrida
        System.out.println(car.distanceDisplay());
        //Mostramos la batería restante
        System.out.println(car.batteryDisplay());
        //Recorremos 20 m y gastamos 1% de batería llamando al método drive
        car.drive();
        //Actualizamos el estado de la distancia y la batería
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());  
    }
}
