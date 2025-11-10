package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega6 {
    public static void main(String[] args) {
        
        //Introducir datos por teclado
        Scanner teclado = new Scanner(System.in);

        //Preguntar al usuario qué tamaño tendrá la lista de series
        System.out.println("Cuántas series desea introducir el usuario?");
        int numSeries = teclado.nextInt();
        teclado.nextLine();
        //Preguntar al usuario de cuántas horas es el maratón perfecto
        System.out.println("De cuántas horas quieres que sea tú maratón perfecto?");
        int horasMaraton = teclado.nextInt();

        teclado.nextLine();

        //Crear arrays en el que cada índice será una serie completa
        //El tamaño del array dependerá del número de series introducidas
        String nombres[] = new String[numSeries];
        String generos[] = new String[numSeries];
        int temporadas[] = new int[numSeries];
        double puntuaciones[] = new double[numSeries];
        int anios[] = new int[numSeries];

        //Variables para guardar los máximos
        int maxTemporadas = 0;
        int serieMasLarga = 0;

        //Variables para guardar los géneros y hacer los
        //promedios por género
        int contadorAccion = 0;
        int contadorComedia = 0;
        int contadorDrama = 0;
        int contadorTerror = 0;
        int contadorDocumental = 0;
        double sumaAccion = 0;
        double sumaComedia = 0;
        double sumaDrama = 0;
        double sumaTerror = 0;
        double sumaDocumental = 0;
        double mediaAccion = 0;
        double mediaComedia = 0;
        double mediaDrama = 0;
        double mediaTerror = 0;
        double mediaDocumental = 0;

        //Constante con las horas por temporada de cada serie
        final int HORAS_TEMPORADA = 8;
        //Variable para calcular las horas totales y el maratón perfecto
        int horasSerie;
        //Variable para controlar si no se encuentran series que cumplan el maratón perfecto
        boolean serieMaratonEncontrada = false;


        //Recorremos con for todos los datos de las series
        for (int i=0;i<numSeries;i++){
            System.out.println("Introduce el nombre de la serie: ");
            nombres [i] = teclado.nextLine();
            System.out.println("Introduce el genero: ");
            generos[i] = teclado.nextLine();
            System.out.println("Introduce el número de temporadas: ");
            temporadas[i] = teclado.nextInt();
            System.out.println("Introduce la puntuación: ");
            puntuaciones[i] = teclado.nextDouble();
            System.out.println("Introduce el año de la serie: ");
            anios[i] = teclado.nextInt();
            System.out.println("-------------------------");
            
            //Comprobar qué serie cumple el maratón perfecto
            horasSerie = temporadas[i] * HORAS_TEMPORADA;
            if (horasSerie == horasMaraton){
                System.out.println("Se ha encontrado una serie para un maratón perfecto: " + nombres[i]);
                serieMaratonEncontrada = true;
            }

            //Encontrar joyas ocultas
            if(temporadas[i] < 3 && puntuaciones[i] > 8){
                System.out.println("Se ha encontrado una joya oculta!. La serie se llama: " + nombres[i] + ". La serie tiene " + temporadas[i] + " temporadas " + "y una puntuación de " + puntuaciones[i]);
            }

            //Guardamos, mientras recorremos el bucle, la serie que vaya
            //teniendo el mayor número de temporadas
            if (temporadas[i] > maxTemporadas){
                maxTemporadas = temporadas[i];
                serieMasLarga = i;
            }

            //Guardamos las puntuaciones por género para hacer la media
            //de puntuaciones por género
            if (generos[i].equalsIgnoreCase("accion")){
                contadorAccion++;
                sumaAccion = sumaAccion + puntuaciones[i];     
            }

            if (generos[i].equalsIgnoreCase("comedia")){
                contadorComedia++;
                sumaComedia = sumaComedia + puntuaciones[i];     
            }

            if (generos[i].equalsIgnoreCase("drama")){
                contadorDrama++;
                sumaDrama = sumaDrama + puntuaciones[i];     
            }

            if (generos[i].equalsIgnoreCase("terror")){
                contadorTerror++;
                sumaTerror = sumaTerror + puntuaciones[i];     
            }

            if (generos[i].equalsIgnoreCase("documental")){
                contadorDocumental++;
                sumaDocumental = sumaDocumental + puntuaciones[i];     
            }

            teclado.nextLine();
        }

        //Pintar por pantalla la serie más larga
        System.out.println("La serie más larga es: " + nombres[serieMasLarga]);

        //Medias por género
            if (contadorAccion > 0){
                mediaAccion = sumaAccion / contadorAccion;
                System.out.println("La media de las series de acción es: " + mediaAccion);
            }else{
                System.out.println("No existen series de acción. No se puede calcular la media.");
            }

            if (contadorComedia > 0){
                mediaComedia = sumaComedia / contadorComedia;
                System.out.println("La media de las series de comedia es: " + mediaComedia);
            }else{
                System.out.println("No existen series de comedia. No se puede calcular la media");
            }

            if (contadorDrama > 0){
                mediaDrama = sumaDrama / contadorDrama;
                System.out.println("La media de las series de drama es: " + mediaDrama);
            }else{
                System.out.println("No existen series de drama. No se puede calcular la media");
            }

            if (contadorTerror > 0){
                mediaTerror = sumaTerror / contadorTerror;
                System.out.println("La media de las series de terror es: " + mediaTerror);
            }else{
                System.out.println("No existen series de terror. No se puede calcular la media");
            }

            if (contadorDocumental > 0){
                mediaDocumental = sumaDocumental / contadorDocumental;
                System.out.println("La media de las series documentales es: " + mediaDocumental);
            }else{
                System.out.println("No existen series documentales. No se puede calcular la media");
            }

            if (!serieMaratonEncontrada){
                System.out.println("No se han encontrado series que cumplan el maratón perfecto");
            }        
    }
}
