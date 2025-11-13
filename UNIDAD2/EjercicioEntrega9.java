package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega9 {
    public static void main(String[] args) {
        
        //Scaner para introducir las jugadas
        Scanner teclado = new Scanner(System.in);

        //Matriz con el tablero: 0 = agua; 1 = barco
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

        //Contadores para el tamaño de los barcos
        int barcos1Casilla = 0;
        int barcos2Casillas = 0;
        int barcos3Casillas = 0;
        int barcos4Casillas = 0;

        //Total de casillas ocupadas por los barcos (controlamos si existen barcos sin hundir)
        int casillasTotalesConBarcos = 20;

        //Comenzamos el juego
        // Repetimos el pedir coordenadas hasta que todos los barcos estén hundidos
        while (casillasTotalesConBarcos > 0) {
            System.out.println("Introduce la fila (del 1 al 8): ");
            int filaUsuario = teclado.nextInt();
            System.out.println("Introduce la columna (del 1 al 8): ");
            int columnaUsuario = teclado.nextInt();
            //Como los bucles en java empiezan en el índice 0, se le resta 1 para ajustarlos
            filaUsuario = filaUsuario -1;
            columnaUsuario = columnaUsuario -1;
            //En el caso de que el usuario introduzca valores fuera de rango, vuelve a pedir las coordenadas
            while (filaUsuario < 0 ||filaUsuario > 7 || columnaUsuario < 0 || columnaUsuario > 7) {
                System.out.println("Los datos introducidos son incorrectos. Vuelve a introducirlos");
                System.out.println("Introduce la fila: ");
                filaUsuario = teclado.nextInt();
                System.out.println("Introduce la columna: ");
                columnaUsuario = teclado.nextInt();
                filaUsuario = filaUsuario -1;
                columnaUsuario = columnaUsuario -1;     
            }

            if (tablero[filaUsuario][columnaUsuario] == 1){
                System.out.println("Tocado!");
                casillasTotalesConBarcos--;
                //Se marca para hacerle saber al usuario que ya realizó ese disparo
                tablero[filaUsuario][columnaUsuario] = -1;
            }else if(tablero[filaUsuario][columnaUsuario] == 0){
                System.out.println("Agua");
                //Se marca para hacerle saber al usuario que ya realizó ese disparo
                tablero[filaUsuario][columnaUsuario] = 2;
            }else{
                System.out.println("Ya has disparado aquí, prueba otra casilla");
            }
        }

        System.out.println("Felicidades! Has eliminado todos los barcos del tablero!");
       
        //Bucle para recorrer el tablero y comprobar que el número de barcos es correcto
        for(int fila = 0; fila < 8; fila++){
            for(int columna = 0; columna < 8; columna++){
                //Encontramos barco (un 1)
                if(tablero[fila][columna] == 1){
                    //Empezamos a contar las casillas que ocupa el barco (como mínimo, 1)
                    int tamañoBarco = 1;
                    //Cambiamos el valor a -1 para marcar la casilla (para que cuando vuelva a pasar el bucle, no vuelva a contar otro 1)
                    tablero[fila][columna] = -1;
                    //Creamos una variable para ir sumando y buscar más 1 hacia la derecha (o siguiente columna), sin modificar la fila
                    int columnaContadora = columna + 1;
                    //Sustituímos columna por columnaContadora, para poder ir comprobando si hay más 1 a la derecha
                    //Mientras las columnas no se salgan del tablero y se encuentren 1, entra en el bucle
                    while (columnaContadora < 8 && tablero[fila][columnaContadora] == 1) {
                        //Si ha entrado en el while, quiere decir que ha encontrado otro 1 a la derecha
                        //Por ello, se suma otra casilla al tamaño del barco
                        tamañoBarco++;
                        //Se marca igualmente para que con el paso del bucle principal no se vuelva a contar
                        tablero[fila][columnaContadora] = -1;
                        //Y se suma 1 al contador de la columna para pasar a la siguiente posición
                        columnaContadora++;
                    }
                    //Mismo método, pero para contar los barcos hacia abajo (vertical)
                    //Creamos la variable para recorrer hacia abajo el array, desde la misma columna pero cambiando filas
                    int filaContadora = fila + 1;
                    //De la misma manera que se ha hecho anteriormente, se comprueba la vertical
                    while (filaContadora < 8 && tablero[filaContadora][columna] == 1) {
                        tamañoBarco++;
                        tablero[filaContadora][columna] = -1;
                        filaContadora++;
                    }

                    //Añadir valores a los contadores de barcos según tamaño
                    if (tamañoBarco == 1) {
                        barcos1Casilla++;
                    }else if (tamañoBarco == 2){
                        barcos2Casillas++;
                    }else if (tamañoBarco == 3){
                        barcos3Casillas++;
                    }else if (tamañoBarco ==4){
                        barcos4Casillas++;
                    }
                }
            }
        }

        //Pintar los barcos por tamaño
        System.out.println("Barcos de tamaño 1: " + barcos1Casilla);
        System.out.println("Barcos de tamaño 2: " + barcos2Casillas);
        System.out.println("Barcos de tamaño 3: " + barcos3Casillas);
        System.out.println("Barcos tamaño 4: " + barcos4Casillas);

        //Comprobar si el número de barcos en el tablero son los correctos
        if (barcos1Casilla == 4 && barcos2Casillas == 3 && barcos3Casillas == 2 && barcos4Casillas == 1){
            System.out.println("El número de barcos está correcto");
        }else{
            System.out.println("El número de barcos está incorrecto");
        }  
        
    }

}
