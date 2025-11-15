package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej10SwitchDiaSemana {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número del 1 al 7");
        int num = teclado.nextInt();
        
         switch (num) {
                case 1:
                    System.out.println("Lunes");
                    break;
                case 2:
                    System.out.println("Martes");
                    break;
                case 3:
                    System.out.println("Miércoles");
                    break;
                case 4:
                    System.out.println("Jueves");
                    break;
                case 5:
                    System.out.println("Viernes");
                    break;
                case 6:
                    System.out.println("Sábado");
                    break;
                case 7:
                    System.out.println("Domingo");
                    break;    
                default:
                    System.out.println("El número introducido no es válido");
                    break;
        }
    }
}
