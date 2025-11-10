package UNIDAD2;

public class EjemploArrays {
    public static void main(String[] args) {
        String[] calcetines = {"marrón", "rojo", "verde", "negro", "rojo", "verde"};
        
        String nombre = "pedro";

        System.out.println("El calcetín que está en cuarta posición es " + calcetines[3]);

        System.out.println("Hay " + calcetines.length + " calcetines.");

        //Sobreescribimos el calcetín en la posición 5

        calcetines[4] = "negro";

        //Creamos un array de números aleatorios y calculamos us estadísticas

        int[] numeros = new int[10];
        int suma = 0;
        int media = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<numeros.length;i++){

            numeros [i] = (int)(Math.random()*100) + 1;
            System.out.println("Número aleatorio en pos " + i + " es " + numeros[i]);
            suma = suma + numeros[i];
        }
        /*
         * Estructura for específica para recorrer arrays
         * para cada elemento del array, repite el código de dentro
         * y guarda el valor de la posición actual en la variable numero
         */
        for (int numero : numeros){
            //Vamos sumando todos los números en sum
            //Al final del bucle tendremos la suma de todos
            suma = suma + numero;

            //Para el máximo tenemos que comprobar si el número actual es el mayor
            if(numero>max){
                max = numero;
            }

            if(numero<min){
                min = numero;
            }

        }
        
        System.out.println("El número máximo es: " + max);
        System.out.println("El número mínimo es: " + min);
        System.out.println("La suma total es de : " + suma);
        System.out.println("La media de los números es: " + suma / numeros.length);
        System.out.println("El número total de elementos: " + numeros.length);
    }
    
}
