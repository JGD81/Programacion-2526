package UNIDAD3.Exercism.Ejercicio2;

/*
Instrucciones
En este ejercicio, procesará líneas de registro.
Cada línea de registro es una cadena con el siguiente formato: "[<NIVEL>]: <MENSAJE>".
Hay tres niveles de registro diferentes:
INFORMACIÓN
ADVERTENCIA
ERROR
Tiene tres tareas; cada una tomará una línea de registro y le solicitará que haga algo 
con ella.
*/

public class LogLevels {

    /*
    Implementa un método que sólo muestre el mensaje
    */
   //El método es estático, así que pertenece a la clase
   //no a un objeto. Por ello, no es necesario crear el 
   //objeto con new
    public static String message(String logLine){
        //Variable para guardar la posición de ":" dentro del texto
        int index = logLine.indexOf(":");
        //Mediante substring se está creando una nueva cadena, 
        //que la toma desde la posición de ":" + 1.
        //Mediante trim, eliminamos espacios al final y al principio
        //y también elimina saltos de línea y tabuladores
        return logLine.substring(index + 1).trim();
    }

    //Sacar el tipo de error que se encuentra entre [] y
    //mostrarlo en minúsculas
    public static String logLevel(String logLine){
        //Se crean dos índices para saber dónde empieza y dónde acaba
        //Ojo: Cuando se incluyen dos índices en indexOf, el primer carácter lo incluye,
        //el segundo, lo excluye.
        int index = logLine.indexOf("[");
        int index2 = logLine.indexOf("]");
        return logLine.substring(index + 1, index2).toLowerCase();
    }

    //Reformatear el mensaje: Operation completed (info)
    public static String reformat(String logLine){
        //Reutilizamos los métodos creados anteriormente
        return message(logLine) + " (" + logLevel(logLine) + ")"; 
    }

    
}
