package UNIDAD2;

import java.util.Scanner;

public class EntradaCine {
    public static void main(String[] args) {
        
        //Creamos la clase Scanner para introducir valores por teclado
        Scanner teclado = new Scanner(System.in);
        
        //Creamos una constante con el precio base de las entradas
        final Double PRECIO_BASE = 12.0;

        //Declaramos las variables que vamos a utilizar durante el programa
        //Se definen fuera de los if para que se puedan usar tanto dentro
        //de los concicionales como después de ellos
        double precioDescuento = 0;
        boolean esFinde = false;
        boolean diaSinDescuento = false;
        boolean esMiercoles = false;
        int numEntradas = 0;

        //Pedimos datos por teclado
        System.out.print("Introduce la edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Día de la semana: ");
        String diaSemana = teclado.nextLine();

        //Creamos un condicional para guardar los días de la semana como 
        //booleanos y facilitar el proceso en los condicionales posteriores

        if (diaSemana.equalsIgnoreCase("Miercoles")){
            esMiercoles = true;
        }else if (diaSemana.equalsIgnoreCase("Viernes") || diaSemana.equalsIgnoreCase("Sabado") || diaSemana.equals("Domingo")) {
            esFinde = true;
        }else if (diaSemana.equalsIgnoreCase("Lunes") || diaSemana.equalsIgnoreCase("Martes") || diaSemana.equals("Jueves")){
            diaSinDescuento = true;
        }

        //Continuación pedir por teclado

        System.out.println("Es festivo? (true/false): ");
        boolean esFestivo = teclado.nextBoolean();
        System.out.print("Eres estudiante? (true/false): ");
        boolean esEstudiante = teclado.nextBoolean();
        System.out.print("Cuántas entradas?: ");
        numEntradas = teclado.nextInt();
        System.out.println("Tiene discapacidad? (true/false): ");
        boolean tieneDiscapacidad = teclado.nextBoolean();

        //Condicionales con los descuentos aplicados

        if (tieneDiscapacidad){
            precioDescuento = 0;
        }else if (esFestivo) {
            precioDescuento = PRECIO_BASE * numEntradas;
        }else if (edad < 25 && esMiercoles) {
            precioDescuento = (PRECIO_BASE * numEntradas) * 0.80;
        }else if (edad >= 60 || esEstudiante) {
            precioDescuento = (PRECIO_BASE * numEntradas) * 0.85;
        }else if (numEntradas >= 2 && esFinde) {
            precioDescuento = (PRECIO_BASE * numEntradas) * 0.90;
        }else{
            precioDescuento = PRECIO_BASE *numEntradas;
        }
        
        System.out.printf("El precio total de las entradas es: $%.2f",precioDescuento);
    }
}
