package UNIDAD2;

import java.util.Scanner;

public class Sumatorios2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();
        
        int suma = 0;
        int pintarSuma = 0;
        int i = 1;
        int j = 0;

        for (i = 1; i <= num; i++){
            suma = suma + i;
            j++;
            System.out.println(num + " + " + j + " = " + suma);
        }
        
    }
}
