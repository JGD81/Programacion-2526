package UNIDAD2;

import java.util.Scanner;

public class NumerosDivisores {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();
        int i;
        int contadorNumeros = 0;

        for(i = 1; i <= num; i++){
            if(num % i == 0){
                contadorNumeros++;
            }
        }
        System.out.println("El total de números divisibles es: " + contadorNumeros);
    }
}
