package UNIDAD3.Exercism.Ejercicio4;

public class Main {
    public static void main(String[] args) {
        //Creamos una instancia de la clase, ya que los métodos no son static
        CarsAssemble factory = new CarsAssemble();
        //Producción de coches por hora
        System.out.println(factory.productionRatePerHour(5));
        //Producción de coches por minuto
        System.out.println(factory.workingItemsPerminute(5));
    }
}
