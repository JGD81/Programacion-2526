package UNIDAD2;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
       
        //Para introducir datos por teclado
        Scanner teclado = new Scanner(System.in);

        //Variable para conversión
        double conversion = 0;

        //Pedir datos a usuario
        //Cantidad a convertir
        System.out.print("Introduzca la cantidad de dinero a convertir: ");
        double cantidadMoneda = teclado.nextDouble();
       
        System.out.printf("""
                %n Conversor de monedas:\s
                --------------------------
                \t- Pulse 1 para convertir Euros a Dólar
                \t- Pulse 2 para convertir de Dólar a Euro
                \t- Pulse 3 para convertir de Euros a Libras
                \t- Pulse 4 para convertir de Libras a Euros
                \t- Pulse 5 para convertir de Dólar a Libras
                \t- Pulse 6 para convertir de Libras a Dólar
                """);
        int monedaOrigen = teclado.nextInt();

        switch (monedaOrigen) {
            case 1://Euro a dólar
                conversion = cantidadMoneda * 1.1;
                break;
            case 2://Dólar a euro
                conversion = cantidadMoneda / 1.10;
                break;
            case 3: //Euros a libras
                conversion = cantidadMoneda * 0.85;
                break;
            case 4: //Libras a euros
                conversion = cantidadMoneda /0.85;
                break;
            case 5://Dólar a libras
                conversion = (cantidadMoneda / 1.10) * 0.85;
                break;
            case 6://Libras a dólares
                conversion = (cantidadMoneda / 0.85) * 1.10;
                break;
            default:
                System.out.println("El número introducido no es válido");
                break;
        }
        //Mostrar por pantalla el resultado con 2 decimales
        if (monedaOrigen >= 1 && monedaOrigen <= 6) {
            System.out.printf("El resultado de la conversión es: %.2f", conversion);
        }
    }
}
