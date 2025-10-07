package UNIDAD1;

import java.util.Scanner;

public class EjerciciosEntrega6 { //Faltaba el nombre de la clase
    
    public static void  main(String arg[]){ //Método main mal definido (faltaba public)
        
        float numero1,numero2,numero3,media;
        /*
        Cuando se hacen divisiones es recomendable usar double en vez de float.
        Con números enteros no tendríamos decimales.
        Para separar las variables de un mismo tipo se usan comas. 
        También he puesto la variable "numero3" y "media" en la misma fila, ya
        que es del mismo tipo.
        */ 
        Scanner teclado = new Scanner(System.in); //Faltaba declarar el objeto Scanner
        
        System.out.println("Introduce el primer número: ");//Faltaba pedir los números por pantalla
        numero1 = teclado.nextFloat();
        System.out.println("Introduce el segundo número: ");
        numero2 = teclado.nextFloat();
        System.out.println("Introduce el tercer número: ");
        numero3 = teclado.nextFloat();
        //Las variables no pueden tener tíldes. Nest no existe, lo corecto es nextFloat()
        //Es recomendable ordenar las variables para que luego no haya confusiones en las operaciones
        media = (numero1 + numero2 + numero3) / 3; 
        //Faltaba declarar la variable media. La suma tiene que ir dentro de paréntesis para que se haga antes de la división
        System.out.println("La media es: " + media);
    }
}

