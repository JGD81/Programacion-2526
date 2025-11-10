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

        //Si hay una bomba en esa posición y se acabó, haber usado un robot
        //o el perro, no el dedo
        if(mapaBombas[posy][posx] == 1){
            System.out.println("BOOMBA");
        }else{
            for(int i=posx-1; i<=posx+1;i++){
                for(int j=posy-1;i<=posy-1;j++){
                    
                }
            }
        }

        teclado.close();
        
    }
}
