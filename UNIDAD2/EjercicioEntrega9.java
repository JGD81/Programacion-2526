package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega9 {
    public static void main(String[] args) {
        
        //Scaner para introducir las jugadas
        Scanner teclado = new Scanner(System.in);

        //Matriz con el tablero
        int[][] tablero = {
            {1,0,0,0,0,0,1,0},
            {1,0,1,1,1,0,0,0},
            {1,0,0,0,0,0,0,0},
            {1,0,1,0,1,0,0,0},
            {0,0,1,0,0,0,1,0},
            {1,0,1,0,0,0,1,0},
            {0,0,0,0,1,0,0,0},
            {1,1,0,0,0,0,1,1},
        };

        //Contadores para los barcos
        int barcos1Pos = 0;
        int barcos2Pos = 0;
        int barcos3Pos = 0;
        int barcos4Pos = 0;

        //Variables para guardar las coordenadas introducidas por usuario
        int xFila;
        int yColumna;

        //Bucle para recorrer el tablero
        for(int fila = 0; fila < 8; fila++){
            for(int columna = 0; columna < 8; columna++){
                //Encontramos barco (un 1)
                if(tablero[fila][columna] == 1){
                    //Contamos a partir de la casilla que detecte un 1
                    int tamañoBarco = 1;
                    //Eliminamos la casilla o marcamos la casilla como contada
                    tablero[fila][columna] = -1;
                    //Nos movemos por la fila (hacia la derecha), mientras se encuentren 1 
                    int detectColumna = columna + 1;
                    //Mientras a la derecha haya 1, se aumenta el tamaño del barco detectado
                    //y se marca la casilla para que no se vuelva a comprobar
                    while (detectColumna < 8 && tablero[fila][detectColumna] == 1) {
                        tamañoBarco++;
                        tablero[fila][detectColumna] = -1;
                        detectColumna++;
                    }
                    //Mismo método, pero para contar los barcos hacia abajo (vertical)
                    //Detectamos según las filas con la variable detectFila
                    int detectFila = fila + 1;
                    //De la misma manera que se ha hecho anteriormente, se comprueba la vertical
                    while (detectFila < 8 && tablero[detectFila][columna] == 1) {
                        tamañoBarco++;
                        tablero[detectFila][columna] = -1;
                        detectFila++;
                    }

                    //Añadir valores a los contadores de barcos según tamaño
                    if (tamañoBarco == 1) {
                        barcos1Pos++;
                    }else if (tamañoBarco == 2){
                        barcos2Pos++;
                    }else if (tamañoBarco == 3){
                        barcos3Pos++;
                    }else if (tamañoBarco ==4){
                        barcos4Pos++;
                    }
                }


            }
        }
    }
}
