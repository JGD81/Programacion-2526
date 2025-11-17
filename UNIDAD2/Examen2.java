package UNIDAD2;

import java.util.Scanner;

public class Examen2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Cuántos coches se van a introducir?");
        int coches = teclado.nextInt();

        String[] modelo = new String[coches];
        String[] marca = new String[coches];
        String[] categoria = new String[coches];
        int[] stockCoches = new int[coches];
        int[] potencia = new int[coches];
        String[] colorCoches = new String[coches];
        int[] precio = new int[coches];
        String[] deportivosSinStock = new String[coches];
        int contadorDeportivosSinStock = 0;
        int contadorTodoterreno = 0;
        int contadorUtilitario = 0;
        int contadorDeportivos = 0;
        boolean existeCitroen = false;
        int citroenMasCaro = 0;
        String modeloMasCaroCitroen = " ";
        int citroenMenosPotente = 9999;
        String modeloMenosPotenteCitroen = " ";
        int contadorTotalCitroen = 0;


        teclado.nextLine();

        for(int i = 0; i < modelo.length; i++){
            System.out.println("Introduce el modelo del coche: ");
            modelo[i] = teclado.nextLine();
            System.out.println("Introduce la marca del coche: ");
            marca[i] = teclado.nextLine();
            System.out.println("Introduce la categoría del coche (TodoTerreno, Deportivo, Utilitario): ");
            categoria[i] = teclado.nextLine();
            
            while (!(categoria[i].equalsIgnoreCase("todoterreno") || categoria[i].equalsIgnoreCase("deportivo") || categoria[i].equalsIgnoreCase("utilitario"))) {
                System.out.println("Categoría incorrecta. Vuelve a introducir la categoría del coche: ");
                categoria[i] = teclado.nextLine();
            }

            if(categoria[i].equalsIgnoreCase("todoterreno")){
                contadorTodoterreno++;
            }else if(categoria[i].equalsIgnoreCase("deportivo")){
                contadorDeportivos++;
            }else if(categoria[i].equalsIgnoreCase("utilitario")){
                contadorUtilitario++;
            }

            System.out.println("Introduce el stock del coche: ");
            stockCoches[i] = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Introduce la potencia del coche: ");
            potencia[i] = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Introduce el precio del coche: ");
            precio[i] = teclado.nextInt();
            System.out.println("Introduce el color del coche (rojo, negro, azul)");
            colorCoches[i] = teclado.nextLine();
            while (!(colorCoches[i].equalsIgnoreCase("rojo") || colorCoches[i].equalsIgnoreCase("negro") || colorCoches[i].equalsIgnoreCase("azul"))){
                System.out.println("Color incorrecto. Vuelve a introducir el color del coche (rojo, negro, azul): ");
                colorCoches[i] = teclado.nextLine();
            }

            System.out.println("-------------------------");
        }

        //Deportivos sin stock
        for(int i= 0; i < stockCoches.length;i++){
            if(categoria[i].equalsIgnoreCase("deportivo") && stockCoches[i] == 0 && potencia[i] > 200){
                //Se cuenta con el contador, para sólo mostrar las posiciones guardadas y no las null
                deportivosSinStock[contadorDeportivosSinStock] = modelo[i]; 
                contadorDeportivosSinStock++;
            }
        }

        for(int i=0; i<contadorDeportivosSinStock;i++){
            System.out.println("La lista de deportivos sin stock es: " + deportivosSinStock[i] + " ");
        }

        //Citroen con potencia entre 60 y 100, rojo y negro
        System.out.println("Coches Citroen, con color rojo o negro, con una potencia entre 60 y 100cv: ");
        for (int i = 0; i<colorCoches.length; i++){
            if(marca[i].equalsIgnoreCase("citroen") && (colorCoches[i].equalsIgnoreCase("rojo") || colorCoches[i].equalsIgnoreCase("negro")) && ((potencia[i] >= 60 && potencia[i]<=100))){
                System.out.print(modelo[i] + " ");
                System.out.print(marca[i]);
                existeCitroen = true;
            }
        }

        if(!existeCitroen){
            System.out.println("No existen");
        }

        existeCitroen = false;

        //Citroen mas caro y menos potente
        for (int i = 0; i < marca.length; i++){
            if(marca[i].equalsIgnoreCase("citroen")){
                contadorTotalCitroen = contadorTotalCitroen + stockCoches[i];
                existeCitroen = true;
                if(precio[i]>citroenMasCaro){
                    citroenMasCaro = precio[i];
                    modeloMasCaroCitroen = modelo[i];
                }
                if(potencia[i] < citroenMenosPotente){
                    citroenMenosPotente = potencia[i];
                    modeloMenosPotenteCitroen = modelo[i];
                }
            }
        }
        if (existeCitroen){
            System.out.println("El modelo más caro de Citroen es: " + modeloMasCaroCitroen);
            System.out.println("El modelo menos potente de citroen es: " + modeloMenosPotenteCitroen);
        }

        System.out.println("El stock de coches citroen es: " + contadorTotalCitroen);
        

        //Lista de coches por categoría
        System.out.println("La lista de coches por categoría es: ");
        System.out.println("Coches Todoterreno: " + contadorTodoterreno);
        System.out.println("Coches deportivos: " + contadorDeportivos);
        System.out.println("Coches utilitarios: " + contadorUtilitario);
    }
}
