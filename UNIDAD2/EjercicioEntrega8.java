package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega8 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el número n: ");
        int n = teclado.nextInt();
        System.out.println("Introduce el número d: ");
        int d = teclado.nextInt();
        //Inicializamos suma para su uso en el bucle y en el println final
        int suma = 0;
        //Bucle para recorrer los números de d en d veces, con el número dado n
        for(int i=d; i < n; i += d){
            suma = suma + i;
           //Condicional para imprimir correctamente el último "+"
            if (i + d < n){
                System.out.print(i + " + ");
            }else{
                System.out.print(i);
            }    
        }
        System.out.println(" = " + suma);
    }
}
