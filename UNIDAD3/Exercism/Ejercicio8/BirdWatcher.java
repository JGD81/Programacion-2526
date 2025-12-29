package UNIDAD3.Exercism.Ejercicio8;

/**
 * Eres un ávido observador de aves que lleva un registro de cuántas aves han 
 * visitado tu jardín en los últimos siete días.
 */
public class BirdWatcher {
    private final int[] birdsPerDay;
    
    //Constructor
    public BirdWatcher (int[] birdsPerDay){
        this.birdsPerDay = birdsPerDay.clone();
    }
    
    //Método para el recuento de pájaros de la semana pasada
    public int[] getLastWeek(){
        int[] birdsWeek = {0, 2, 5, 3, 7, 8, 4};
        return birdsWeek;
    }

    //Método para obtener la cantad de aves que visitaron el jardín
    //en el día de hoy. Primer elemento, día más antiguo. Último elemento,
    //día actual.
    public int getToday(){
        return birdsPerDay[birdsPerDay.length - 1];
    }
    //Método para incrementar el recuento de hoy
    public void incrementTodaysCount(){
        birdsPerDay[birdsPerDay.length -1] = birdsPerDay[birdsPerDay.length -1] + 1;
    }
    //Método que retorna true si hubo un día que no hubo pájaros. False si es lo contrario.
    public boolean hasDayWithoutBirds(){
        for (int i = 0; i<birdsPerDay.length; i++){
            if(birdsPerDay[i] == 0){
                return true;
            }
        }
        return false;
    }
    //Método que suma los pájaros desde el inicio de la semana, pero sólo hasta
    //un día especificado
    public int getCountForFirstDays(int numberOfDays){
        int suma = 0;
        //Condicional que evita error en el caso de que el número de días sea 
        //mayor al tamaño del array
        if (numberOfDays < birdsPerDay.length){
            for(int i = 0; i<numberOfDays; i++){    
            suma = suma + birdsPerDay[i];
            }
        }else{
            for(int i = 0; i<birdsPerDay.length; i++){    
            suma = suma + birdsPerDay[i];
            }
        }
        return suma;
    }
    //Método que obtiene los días en los que las visitas han sido de 5 pájaros
    //o más.
    public int getBusyDays(){
        int suma = 0;
        for(int i = 0; i<birdsPerDay.length;i++){
            if(birdsPerDay[i] >= 5){
                suma = suma + 1;
            }
        }
        return suma;
    }
}
