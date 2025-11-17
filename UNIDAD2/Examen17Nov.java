package UNIDAD2;

import java.util.Scanner;

public class Examen17Nov {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        //Variables
        boolean pcPegiPrecio = false;
        int contadorGeneroAccion = 0;
        int contadorGeneroRpg = 0;
        int contadorGeneroDeportes = 0;
        int contadorGeneroEstrategia = 0;
        int numVideojuegos = 0;
        int contadorUnidadesVendidas = 0;

        
        //Pedir al usuario el número de videojuegos
        System.out.println("Introducir el número de videojuegos (entre 3 y 20): ");
        numVideojuegos = teclado.nextInt();
        //Validar número de videojuegos
        while (!(numVideojuegos>= 3 && numVideojuegos <= 20)){
            System.out.println("El número de videojuegos introducidos es incorrecto, asegúrate que sea entre 3 y 20: ");
            numVideojuegos = teclado.nextInt(); 
        }

        //Arrays para guardar los datos de los videojuegos
        String [] tituloVideojuegos = new String[numVideojuegos];
        String [] estudioVideojuegos = new String[numVideojuegos];
        String [] generoVideojuegos = new String[numVideojuegos];
        double [] precioVideojuegos = new double[numVideojuegos];
        int[] unidadesVendidasVideojuegos = new int[numVideojuegos];
        int[] edadPegiVideojuegos = new int[numVideojuegos];
        String [] plataformaVideojuegos = new String[numVideojuegos];

        //Array 100 unidades
        String[] menos100Unidades = new String[numVideojuegos];

        //Arrays unidades vendidas por género
        int unidadesVendidasAcción = 0;
        int unidadesVendidasRpg = 0;
        int unidadesVendidasDeportes = 0;
        int unidadesVendidasEstrategia = 0;

        //Unidades vendidas por plataforma
        int unidadesVendidasPC = 0;
        int unidadesVendidasPlayStation = 0;
        int unidadesVendidasXbox = 0;
        int unidadesVendidasNintendo = 0;
        double porcentajePc = 0;
        double porcentajePlayStation = 0;
        double porcentajeXbox = 0;
        double porcentajeNintendo = 0;


        

        teclado.nextLine();//Vaciamos buffer

        for(int i=0; i<tituloVideojuegos.length; i++){
            System.out.println("Introduce el título del videojuego " + (i+1) + ":");
            tituloVideojuegos[i]= teclado.nextLine();

            System.out.println("Introduce el estudio del videojuego " + (i+1) + ":");
            estudioVideojuegos[i] = teclado.nextLine();

            System.out.println("Introduce el género del videojuego " + (i+1) + ":");
            generoVideojuegos[i] = teclado.nextLine();
            //Validación
            while(!(generoVideojuegos[i].equalsIgnoreCase("Accion") || generoVideojuegos[i].equalsIgnoreCase("RPG") || generoVideojuegos[i].equalsIgnoreCase("Deportes") || generoVideojuegos[i].equalsIgnoreCase("Estrategia"))){
                System.out.println("El género introducido no es válido (validos: Accion, RPG, Deportes o Estrategia): ");
                generoVideojuegos[i] = teclado.nextLine();
            }

            System.out.println("Introduce el precio del videojuego " + (i+1) + ":");
            precioVideojuegos[i] = teclado.nextDouble();
            //Validación
            while (precioVideojuegos[i] < 0) {
                System.out.println("El precio del videojuego no puede ser negativo, vuelve a introducirlo: ");
                precioVideojuegos[i] = teclado.nextDouble();
            }

            System.out.println("Las unidades vendidas del videojuego " + (i+1) + ":");
            unidadesVendidasVideojuegos[i] = teclado.nextInt();
            //Guardar array de menos de 100 unidades vendidas
            if(unidadesVendidasVideojuegos[i] < 100){
                menos100Unidades[contadorUnidadesVendidas] = tituloVideojuegos[i];
                contadorUnidadesVendidas++;
            }
            //Validación
            while (unidadesVendidasVideojuegos[i] < 0) {
                System.out.println("Las unidades no pueden ser negativas, vuelve a introducirla: ");
                unidadesVendidasVideojuegos[i] = teclado.nextInt();
            }

            System.out.println("Introduce la edad PEGUI del videojuego (3,7,12,16,18) " + (i+1) + ":");
            edadPegiVideojuegos[i] = teclado.nextInt();
            //Validación
            while (!(edadPegiVideojuegos[i] == 3 || edadPegiVideojuegos[i] == 7 || edadPegiVideojuegos[i] == 12 || edadPegiVideojuegos[i] == 16 || edadPegiVideojuegos[i] == 18)){
                System.out.println("La edad PEGUI no es correcta (3, 7, 12, 16, 18), introduce una correcta: ");
                edadPegiVideojuegos[i] = teclado.nextInt();
            }

            teclado.nextLine();

            System.out.println("Introduce la plataforma (PC, PlayStation, Xbox, Nintendo) del videojuego " + (i+1) + ":");
            plataformaVideojuegos[i] = teclado.nextLine();
            //Validación
            while (!(plataformaVideojuegos[i].equalsIgnoreCase("pc") || plataformaVideojuegos[i].equalsIgnoreCase("playstation") || plataformaVideojuegos[i].equalsIgnoreCase("xbox") || plataformaVideojuegos[i].equalsIgnoreCase("nintendo"))) {
                System.out.println("La plataforma inroducida no es correcta (valido: pc, playstation,xbox,nintendo), introduce una correcta: ");
                plataformaVideojuegos[i] = teclado.nextLine();
                
            }

        }

        //Título y estudio de todos los videojuegos de PC con edad PEGUI <=12 y precio inferior a 30
        System.out.println("Titulos PC con edad PEGUI <= 12 y precio inferior a 30 euros");
        for (int i = 0; i<tituloVideojuegos.length;i++){

            if (plataformaVideojuegos[i].equalsIgnoreCase("PC") && edadPegiVideojuegos[i] <=12 && precioVideojuegos[i] < 30){
                pcPegiPrecio = true;
                System.out.print(tituloVideojuegos[i] + " ");
                System.out.print(estudioVideojuegos[i]);
                System.out.print("/ ");
            }
        }

        if (!pcPegiPrecio){
            System.out.print("No existen");
        }

        //Mostrar cuántos videojuegos hay de cada género y las unidades vendidas totales de cada género
        for(int i = 0;i<tituloVideojuegos.length;i++){
            if (generoVideojuegos[i].equalsIgnoreCase("accion")) {
                contadorGeneroAccion++;
                unidadesVendidasAcción =  unidadesVendidasAcción + unidadesVendidasVideojuegos[i];
            }
            if (generoVideojuegos[i].equalsIgnoreCase("deportes")){
                contadorGeneroDeportes++;
                unidadesVendidasDeportes = unidadesVendidasDeportes + unidadesVendidasVideojuegos[i];
            }
            if(generoVideojuegos[i].equalsIgnoreCase("rpg")){
                contadorGeneroRpg++;
                unidadesVendidasRpg = unidadesVendidasRpg + unidadesVendidasVideojuegos[i];
            }
            if(generoVideojuegos[i].equalsIgnoreCase("estrategia")){
                contadorGeneroEstrategia++;
                unidadesVendidasEstrategia = unidadesVendidasEstrategia + unidadesVendidasVideojuegos[i];
            }
        }

        //Juegos por género
        System.out.println("Contador juegos por género");
        System.out.println("----------------------");
        System.out.println("Accion: " + contadorGeneroAccion);
        System.out.println("Rpg: " + contadorGeneroRpg);
        System.out.println("Deportes: " + contadorGeneroDeportes);
        System.out.println("Estrategia: " + contadorGeneroEstrategia);
        //Total vendidos por género
        System.out.println("Total vendidas accion: " + unidadesVendidasAcción);
        System.out.println("Total vendidas RPG: " + unidadesVendidasRpg);
        System.out.println("Total vendidas Deportes: " + unidadesVendidasDeportes);
        System.out.println("Total vendidas Estrategia: " + unidadesVendidasEstrategia);

        //Array de títulos con menos de 100 unidades vendidas
        System.out.print("Juegos con menos de 100 unidades vendidas: ");
        for (int i = 0; i<contadorUnidadesVendidas;i++){
            System.out.println(menos100Unidades[i] + " ");
        }

        //Catálogo total para porcentajes
        for(int i = 0;i<tituloVideojuegos.length;i++){
            if (plataformaVideojuegos[i].equalsIgnoreCase("pc")){
                unidadesVendidasPC = unidadesVendidasPC + unidadesVendidasVideojuegos[i];
            }

            if (plataformaVideojuegos[i].equalsIgnoreCase("Playstation")){
                unidadesVendidasPlayStation  = unidadesVendidasPlayStation + unidadesVendidasVideojuegos[i];
            }

            if (plataformaVideojuegos[i].equalsIgnoreCase("Xbox")){
                unidadesVendidasXbox = unidadesVendidasXbox + unidadesVendidasVideojuegos[i];
            }

            if (plataformaVideojuegos[i].equalsIgnoreCase("Nintendo")){
                unidadesVendidasNintendo = unidadesVendidasNintendo + unidadesVendidasVideojuegos[i];
            }
        }

        //Porcentajes
        porcentajePc = (unidadesVendidasPC / numVideojuegos) + 100;
        System.out.println("El porcentaje de juegos de pc es: " + porcentajePc);






    }
}
