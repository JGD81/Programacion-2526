package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega5 {
    public static void main(String[] args) {
       
        //Se ha agregado Scanner para poder hacer las paradas
        //en cada tirada
        Scanner teclado = new Scanner(System.in);

        //Constante para meta
        final int META = 30;

        //Posición de cada caracol
        int posCaracol1 = 0;
        int posCaracol2 = 0;
        int posCaracol3 = 0;

        //Tirada de cada caracol
        int tirCaracol1 = 0;
        int tirCaracol2 = 0;
        int tirCaracol3 = 0;

        //Variable para comparar las tiradas
        int tiradaAnteriorC1 = -1;
        int tiradaAnteriorC2 = -1;
        int tiradaAnteriorC3 = -1;

        //Comprobar si está dormido
        boolean dormCaracol1 = false;
        boolean dormCaracol2 = false;
        boolean dormCaracol3 = false;

        //Comprobar si ha llegado a la meta
        boolean llegadaMeta = false;

        //Suma de tiradas
        int sumaTirada = 0;

        //Bucle para repetir tiradas hasta la llegada a meta
        while (!llegadaMeta) {
            //Tirada caracol 1
            //Comprobación de si está dormido o no
            if (dormCaracol1){
                dormCaracol1 = false;
            }else{//Si no está dormido
                tirCaracol1 = (int)(Math.random()*4);
                //Se compara la tirada con la anterior, para dormirse o turbo
                if (tirCaracol1 == tiradaAnteriorC1){
                    //Se duerme
                    if (tirCaracol1 == 0 && tiradaAnteriorC1 == 0){
                    dormCaracol1 = true;
                    //Gana turbo
                    }else if(tirCaracol1 == 3 && tiradaAnteriorC1 == 3){
                    tirCaracol1 = tirCaracol1 + 2;
                    }
                }
                //Suma la tirada para obtener la posición
                posCaracol1 = posCaracol1 + tirCaracol1;     
            }
            //Guarda la última tirada para guardarla como anterior en la 
            //siguiente iteración.
            tiradaAnteriorC1 = tirCaracol1;

            //Tirada caracol 2
            if (dormCaracol2){
                dormCaracol2 = false;
            }else{//Si no está dormido
                tirCaracol2 = (int)(Math.random()*4);
                //Se compara la tirada con la anterior, para dormirse o turbo
                if (tirCaracol2 == tiradaAnteriorC2){
                    //Se duerme
                    if (tirCaracol2 == 0 && tiradaAnteriorC2 == 0){
                    dormCaracol2 = true;
                    //Gana turbo
                    }else if(tirCaracol2 == 3 && tiradaAnteriorC2 == 3){
                    tirCaracol2 = tirCaracol2 + 2;
                    }
                }
                //Suma la tirada para obtener la posición
                posCaracol2 = posCaracol2 + tirCaracol2;     
            }
            //Guarda la última tirada para guardarla como anterior en la 
            //siguiente iteración.
            tiradaAnteriorC2 = tirCaracol2;

            //Tirada caracol 3
            if (dormCaracol3){
                dormCaracol3 = false;
            }else{//Si no está dormido
                tirCaracol3 = (int)(Math.random()*4);
                //Se compara la tirada con la anterior, para dormirse o turbo
                if (tirCaracol3 == tiradaAnteriorC3){
                    //Se duerme
                    if (tirCaracol3 == 0 && tiradaAnteriorC3 == 0){
                    dormCaracol3 = true;
                    //Gana turbo
                    }else if(tirCaracol3 == 3 && tiradaAnteriorC3 == 3){
                    tirCaracol3 = tirCaracol3 + 2;
                    }
                }
                //Suma la tirada para obtener la posición
                posCaracol3 = posCaracol3 + tirCaracol3;     
            }
            //Guarda la última tirada para guardarla como anterior en la 
            //siguiente iteración y así poder realizar la comparación.
            tiradaAnteriorC3 = tirCaracol3;

            //Mostrar última tirada
            System.out.println("Caracol 1 : " + tirCaracol1);
            System.out.println("Caracol 2: " + tirCaracol2);
            System.out.println("Caracol 3: " + tirCaracol3);

            //Pintar la posoción de los caracoles (@ _)
            for (int i = 0; i < META; i++){
                if (i == posCaracol1){
                    System.out.print("@");
                }else{
                    System.out.print("_");
                }
            }

            System.out.println("[META]");

            for (int i = 0; i < META; i++){
                if (i == posCaracol2){
                    System.out.print("@");
                }else{
                    System.out.print("_");
                }
            }

            System.out.println("[META]");

            for (int i = 0; i < META; i++){
                if (i == posCaracol3){
                    System.out.print("@");
                }else{
                    System.out.print("_");
                }
            }

            System.out.println("[META]");

            //Realizar parada del código después de cada tirada
            System.out.println("Pulsa ENTER para continuar...");
            teclado.nextLine();

            //Comprobar si algún caracol llegó a meta para parar el bucle while
            if (posCaracol1 >= META || posCaracol2 >= META || posCaracol3 >= META){
                llegadaMeta = true;
                //Comprobar el ganador
                if (posCaracol1 >= META && posCaracol1 >= posCaracol2 && posCaracol1 >= posCaracol3) {
                    System.out.println("¡El caracol 1 ha ganado!");
                } else if (posCaracol2 >= META && posCaracol2 >= posCaracol1 && posCaracol2 >= posCaracol3) {
                    System.out.println("¡El caracol 2 ha ganado!");
                } else if (posCaracol3 >= META && posCaracol3 >= posCaracol1 && posCaracol3 >= posCaracol2) {
                    System.out.println("¡El caracol 3 ha ganado!");
                }
            }
        }

        teclado.close();
        
    }
}
