package UNIDAD2.REFUERZOUD2;

import java.util.Scanner;

public class Ej17Password {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la contraseña: ");
        String passwUsuario = teclado.nextLine();

        String password = "1234";

        while (!passwUsuario.equals(password)) {
            System.out.println("La contraseña es incorrecta, vuelva a introducirla: ");
            passwUsuario = teclado.nextLine();
        }

        System.out.println("La contraseña es correcta!");
    }
}
