package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class AprobadoSuspenso {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la nota");
        double nota = teclado.nextDouble();

        if (nota < 0 || nota > 10){
            System.out.println("La nota introducida no es válida");
        }else if(nota >= 5){
            System.out.println("Con la nota de " + nota + ", el alumno está aprobado");
        }else{
            System.out.println("Con la nota de " + nota + ", el alumno está suspenso");
        }
    }
}
