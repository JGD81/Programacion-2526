package UNIDAD3.Exercism.Ejercicio1;

    /* INSTRUCCIONES:
En este ejercicio, escribirás código para ayudarte a cocinar una lasaña espectacular
de tu libro de cocina favorito. Tienes cuatro tareas, todas relacionadas con el tiempo
de cocción de la lasaña.
 */

public class Lasagna {
    /*
    Define el método expectedMinutesInOven(), que no toma parámetros y devuelve 
    cuántos minutos debe estar la lasaña en el horno. Según el libro de cocina,
    el tiempo de cocción esperado en minutos es de 40:
    */
   public int expectedMinutesInOven(){
        return 40;
   }
   /*
   Define el método remainingMinutesInOven() que toma los minutos reales que la
   lasaña ha estado en el horno como parámetro y devuelve cuántos minutos todavía
   le quedan a la lasaña en el horno, en función del tiempo de horno esperado en 
   minutos de la tarea anterior.
    */
   public int remainingMinutesInOven(int minutesInOven){
        return expectedMinutesInOven() - minutesInOven;
   }
   /*
   Define el método PreparationTimeInMinutes() que toma la cantidad de capas que 
   agregaste a la lasaña como parámetro y devuelve cuántos minutos tardaste en preparar 
   la lasaña, asumiendo que cada capa tarda 2 minutos en prepararse.
   */
  public int preparationTimeInMinutes(int numLayers){
    return numLayers * 2;
  }
  /*
  Define el método totalTimeInMinutes(), que acepta dos parámetros: el primero es el número
  de capas que añadiste a la lasaña y el segundo, los minutos que lleva horneándose. La función 
  debe devolver el total de minutos que has trabajado en la cocción de la lasaña, es decir, la 
  suma del tiempo de preparación en minutos y el tiempo en minutos que lleva horneándose.
   */
  public int totalTimeInMinutes(int numLayers, int minutesInOven){
    return minutesInOven + preparationTimeInMinutes(numLayers);
  }
}
