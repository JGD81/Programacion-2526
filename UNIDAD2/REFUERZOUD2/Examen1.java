package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Examen1 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cuántos videojuegos se van a introducir?");
        int videojuegosN = teclado.nextInt();
        //Vaciado de buffer después de los int o double
        teclado.nextLine();

        //Arrays para guardar cada característica del videojuego
        String[]nombresVideojuegos = new String[videojuegosN];
        double[]precioVideojuegos = new double[videojuegosN];
        String[]categoriaVideojuegos = new String[videojuegosN];
        int[]stockVideojuegos = new int[videojuegosN];
        String[]plataformaVideojuegos = new String[videojuegosN];
        int[]puntuacionVideojuegos = new int[videojuegosN];

        //Variables
        double sumaMedia = 0;
        double precioBarato = 99999;
        double precioCaro = 0;
        String nombreCaro = " ";
        String nombreBarato = " ";
        boolean existeSwitchAventura = false;
        boolean existeSwitchPuntuaciónPrecio = false;
        int stockPlayStation = 0;
        boolean existenProductosSinStock = false;

        //Array para productos sin stock
        String[] productosSinStock = new String[videojuegosN];

        //Guardamos por teclado los datos de los videojuegos
        for(int i=0;i<videojuegosN;i++){
            System.out.println("Introduce el nombre del videojuego " + (i+1) + ":");
            nombresVideojuegos[i] = teclado.nextLine();
   
            System.out.println("Introduce el precio del videojuego " + (i+1) + ":");
            precioVideojuegos[i] = teclado.nextDouble();

            teclado.nextLine();
            //Validación
            do {
                System.out.println("Introduce la categoría del videojuego (Aventura, plataformas, terror ó Shooter) " + (i+1) + ":");
                categoriaVideojuegos[i] = teclado.nextLine();
                
            } while (!(categoriaVideojuegos[i].equalsIgnoreCase("aventura") || categoriaVideojuegos[i].equalsIgnoreCase("plataformas") || categoriaVideojuegos[i].equalsIgnoreCase("terror") || categoriaVideojuegos[i].equalsIgnoreCase("shooter")));

            System.out.println("Introduce el stock del videojuego " + (i+1) + ":");
            stockVideojuegos[i] = teclado.nextInt();

            teclado.nextLine();
            //Validación
            do{
                System.out.println("Introduce la plataforma del videojuego (switch, xbox, playstation ó pc) " + (i+1) + ":");
                plataformaVideojuegos[i] = teclado.nextLine();

            }while(!(plataformaVideojuegos[i].equalsIgnoreCase("switch") || plataformaVideojuegos[i].equalsIgnoreCase("xbox") || plataformaVideojuegos[i].equalsIgnoreCase("playstation") || plataformaVideojuegos[i].equalsIgnoreCase("pc")));
            

            System.out.println("Introduce la puntuación del videojuego " + (i+1) + ":");
            puntuacionVideojuegos[i] = teclado.nextInt();

            teclado.nextLine();

            System.out.println("----------------------------");

        }

        //Media de precios
        for(int j=0;j<precioVideojuegos.length;j++){
            sumaMedia =  sumaMedia + precioVideojuegos[j];
            //Juego más caro
            if(precioVideojuegos[j] > precioCaro){
                precioCaro = precioVideojuegos[j];
                nombreCaro = nombresVideojuegos[j];
            }

            if(precioVideojuegos[j] < precioBarato){
                precioBarato = precioVideojuegos[j];
                nombreBarato = nombresVideojuegos[j];
            }
        }

        //Mostrar nombres de juegos switch de aventura
        System.out.print("Juegos de switch de aventuras: ");
        for (int k = 0; k <categoriaVideojuegos.length; k++){
            if(categoriaVideojuegos[k].equalsIgnoreCase("aventura") && plataformaVideojuegos[k].equalsIgnoreCase("switch")){
                System.out.print(nombresVideojuegos[k] + " ");
                existeSwitchAventura = true;    
            }
        }

        if (!existeSwitchAventura){
            System.out.print("No existen");
        }

        System.out.println();

        //Mostrar nombres de juegos de switch con puntuación mayor de 9 y que cuesten más de 39 €
        System.out.print("Juegos de switch con puntuación mayor de 9 y cuestan más de 39 €: ");
        for (int l= 0; l < plataformaVideojuegos.length; l++){
            if(plataformaVideojuegos[l].equalsIgnoreCase("switch") && puntuacionVideojuegos[l] > 9 && precioVideojuegos[l] > 39){
                System.out.print(nombresVideojuegos[l] + " ");
                existeSwitchPuntuaciónPrecio = true;
            }
        }

        if(!existeSwitchPuntuaciónPrecio){
            System.out.print("No existen");
        }

        System.out.println();

        //Stock de videojuegos de PlayStation
        for (int m = 0; m < plataformaVideojuegos.length; m++){
            if (plataformaVideojuegos[m].equalsIgnoreCase("PlayStation")){
                stockPlayStation = stockPlayStation + stockVideojuegos[m];
            }
        }

        for (int n = 0; n < nombresVideojuegos.length; n++){
            if(nombresVideojuegos[n].startsWith("z") && stockVideojuegos[n] < 10 && puntuacionVideojuegos[n] >6){
                productosSinStock[n] = nombresVideojuegos[n];
                existenProductosSinStock = true;
            }
            
        }

        System.out.println("La media de precios de los videojuegos es: " + (sumaMedia/precioVideojuegos.length));
        System.out.println("El juego más caro es: " + nombreCaro);
        System.out.println("El videojuego más barato es: " + nombreBarato);
        System.out.println("El stock de juegos de PlayStation es: " + stockPlayStation);
        
        System.out.print("Productos sin stock: ");
        if (existenProductosSinStock){
            for (int o = 0; o < productosSinStock.length; o++){
                if(productosSinStock[o] != null){
                System.out.print(productosSinStock[o] + " ");
                }
            }    
        }else{
            System.out.print("No existen productos sin stock");
        }

        teclado.close();
        
    }    
}
