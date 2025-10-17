package UNIDAD2;

import java.util.Scanner;

public class EjemploSwitch {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int codPostal = 0;

        System.out.println("Introduce el código postal de tu ciudad y te digo la comunidad autónoma");
        // Leemos el código postal
        codPostal = teclado.nextInt();
        // Con if sería de la siguiente manera
        if (codPostal == 28)
            System.out.println("Eres de la comunidad de Madrid");
        else if (codPostal == 8)
            System.out.println("Eres de la comunidad de Barcelona");
        String comunidad = " ";
        // Con Switch
        switch (codPostal) {
            case 8:
                comunidad = "Barcelona";
                System.out.println("Eres de la comunidad de Barcelona");
                break;
            case 28:
                comunidad = "Madrid";
                break;
            case 51:
                comunidad = "Ceuta";
                break;
            case 52:
                comunidad = "Melilla";
                break;
            case 1:
                comunidad = "Alava";
                break;
            case 50:
                comunidad = "Zaragoza";
                break;
            case 11:
                comunidad = "Cádiz";
                break;
            default:
                comunidad = "ninguna parte";
        }

        System.out.println("Eres de la Comunidad de " + comunidad);

        teclado.close();

    }
}
