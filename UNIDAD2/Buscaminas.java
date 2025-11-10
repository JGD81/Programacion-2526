package UNIDAD2;

import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        

        /*
         * Definimos el mapa de buscaminas de 3X3
         * De cara a entenderlo se puede interpretar que cada
         * elemento del primer corcherte es, a su vez, un array. Es decir,
         * mapa[0] no es un número, si un array de números.
         * Para hundir la flota, es igual pero de caracteres y 8 posiciones.
         */
        int[][] mapaBombas = {{0,0,1}, {0,1,0},{0,0,0}};
        int[][] mapaJugador = {{9,9,9}, {9,9,9},{9,9,9}};

        Scanner teclado = new Scanner(System.in);

        System.out.println("En qué posiciónes quieres comprobar (x y)");
        int posx = teclado.nextInt();
        int posy = teclado.nextInt();
        //Variable para contar las bombas
        int cantBombas = 0;

        //Si hay una bomba en esa posición y se acabó, haber usado un robot
        //o el perro, no el dedo
        if(mapaBombas[posy][posx] == 1){
            System.out.println("BOOMBA");
        }else{
            /*
             * Recorremos con la i las posiciones anteriores y posteriores a la introducida
             * y con la j las verticales anteriores y posteriores
             */
            for(int i=posx-1; i<=posx+1;i++){
                for(int j=posy-1;j<=posy-1;j++){
                    //Comprobamos si las coordenadas están dentro del mapa
                    if (i>=0 && i<=2 && j>= 0 && j <= 2)
                    //Si en las coordenadas i j hay 1, implica que hay
                    //una bomba. Incrementamos la cantidad de bombas
                    if (mapaBombas[j][i]==1){
                        cantBombas++;
                    } 
                }
            }
            System.out.println("Cerca de esa posición (" + posx + "," + posy + ") hay " + cantBombas + "bombas");
        }

        teclado.close();
        
    }
}
