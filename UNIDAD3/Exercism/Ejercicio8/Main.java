package UNIDAD3.Exercism.Ejercicio8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Creamos un array de prueba para poder crear el objeto
        //a través del constructor, ya que al no existir un constructor
        //vacío, no se puede dejar vacío.
        int[] birds = {1,2,3,0,5,6,7};
        //Creamos el objeto de tipo BirdWatcher usando el constructor con array
        BirdWatcher watcher = new BirdWatcher(birds);
        //Guardamos en la variable de tipo Array lastweek, el Array del
        //método getLastWeek.
        int[] lastWeek = watcher.getLastWeek();
        //Pintamos usando Arrays.toString, para que no imprima la referencia en memoria.
        //Este método convierte cada elemento a texto y devuelve una cadena legible.
        //También se podría con un bucle for/for each
        System.out.println(Arrays.toString(lastWeek));
        for(int i = 0; i < lastWeek.length; i++){
            System.out.print(lastWeek[i] + " ");
        }
        System.out.println();
        for(int bird : lastWeek){
            System.out.print(bird + " ");
        }
        System.out.println();
        //Pintamos el último elemento del array, que equivale al día de hoy
        System.out.println(watcher.getToday());
        //Incrementamos el último elemento del array (equivalente a hoy)
        watcher.incrementTodaysCount();
        System.out.println(watcher.getToday());
        //Pintamos si hay algún día con 0
        System.out.println(watcher.hasDayWithoutBirds());
        //Pintamos la suma de los pájaros que han visitado durante x días
        System.out.println(watcher.getCountForFirstDays(3));
        //Número de días con 5 pájaros o más
        System.out.println(watcher.getBusyDays());

    }
}
