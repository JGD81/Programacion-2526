package UNIDAD2;

import java.util.Scanner;

public class UltimoDigito {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        

        while (num != 0 && num % 3 != 0 ) {
            num = num / 10;
        }

        if (num % 3 == 0 && num != 0){
            System.out.println(num);
        }else{
            System.out.println("-1");
        }
    }
}
