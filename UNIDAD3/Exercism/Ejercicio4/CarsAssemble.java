package UNIDAD3.Exercism.Ejercicio4;

/**
 * En este ejercicio, escribirás código para analizar la producción de una línea de montaje en una fábrica de automóviles. 
 * La velocidad de la línea de montaje puede variar de 0(desactivada) a 10(máxima).

A su velocidad mínima ( 1), se producen 221 automóviles cada hora. La producción aumenta linealmente con la velocidad. 
Por lo tanto, con la velocidad establecida en 4, debería producir 4 * 221 = 884 automóviles por hora. 
Sin embargo, a velocidades más altas, aumenta la probabilidad de que se produzcan automóviles defectuosos, 
que luego deben desecharse. La siguiente tabla muestra cómo la velocidad influye en la tasa de éxito:
- 1 a 4: tasa de éxito del 100%.
- 5 a 8: 90% tasa de éxito.
- 9: 80% tasa de éxito.
- 10: 77% tasa de éxito.
 */

public class CarsAssemble {
    //Ratio de producción de coches por hora dependiendo de la velocidad
    public double productionRatePerHour(int speed){
        double result = 0;
        if(speed >= 1 && speed <= 4){
            result = speed * 221;
        }else if (speed >= 5 && speed <= 8) {
            result = (speed * 221) * 0.9;
        }else if (speed == 9) {
            result = (speed * 221) * 0.8;
        }else if (speed == 10) {
            result = (speed * 221) * 0.77;
        }

        return result;
    }
    //Cuantos coches buenos se producen por minuto
    public int workingItemsPerminute(int speed){
        //Reutilizarmos el método para obtener los coches por hora
        double itemsPerHour = productionRatePerHour(speed);
        //Lo pasamos a coches por minuto
        double itemsPerMinute = itemsPerHour / 60;
        //Como el resultado es double, truncamos a int
        return (int)itemsPerMinute;
    }
    
}
