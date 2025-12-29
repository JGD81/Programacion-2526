package UNIDAD3.Exercism.Ejercicio6;

/**
 * En este ejercicio jugarás con un coche teledirigido, para el cual finalmente 
 * ahorraste suficiente dinero para comprarlo.
Los coches arrancan con la batería al 100 %. Cada vez que conduces el coche con 
el mando a distancia, recorre 20 metros y se descarga el 1 % de la batería.
El coche teledirigido tiene una elegante pantalla LED que muestra dos datos:
- La distancia total recorrida, mostrada como: "Driven <METERS> meters".
- La carga restante de la batería, mostrada como: "Battery at <PERCENTAGE>%".
Si la batería está al 0%, ya no podrás conducir el coche y la pantalla de 
la batería mostrará "Battery empty".
Tienes seis tareas, cada una de las cuales funcionará con instancias de 
automóviles controlados a distancia.
 */

/**
 * Implemente el método (estático) JedliksToyCar.buy()para devolver una nueva 
 * instancia de automóvil controlado remotamente:
ObJedliksToyCar car = JedliksToyCar.buy();
 */
public class JedliksToyCar {
    private int distance = 0;
    private int battery = 100;
    //Método estático que devuelve una nueva instancia de JedliksToyCar
    public static JedliksToyCar buy(){
        return new JedliksToyCar();
    }

    /**
     * Implemente el JedliksToyCar.distanceDisplay()método para devolver 
     * la distancia tal como se muestra en la pantalla LED:
     */
    public String distanceDisplay(){
        return "Driven " + distance + " meters";
    }

    /**
     * Implemente el JedliksToyCar.batteryDisplay()método para devolver el 
     * porcentaje de batería como se muestra en la pantalla LED:
    */
    public String batteryDisplay(){
        if(battery==0){
            return "Battery empty";
        }else{
            return "Battery at " + battery + "%";
        }
   }

    /**
    * Implementar el JedliksToyCar.drive()método que actualiza el número 
    * de metros recorridos:
    */
    public void drive(){
        if (battery != 0){
            distance = distance + 20;
            battery = battery - 1;         
        }
    }
    
}
