package UNIDAD1;

import java.util.Scanner;

public class EjerciciosEntrega5 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); //Creamos el objeto Scanner
        
        System.out.println("Introduce tu sueldo bruto anual:");
        double sueldoBruto = teclado.nextDouble(); //Leemos el sueldo bruto anual
        double sueldoMensual = sueldoBruto / 14; //Calculamos el sueldo mensual
        System.out.println("Introduce las retenciones totales al mes en porcentaje (sin el símbolo %):");
        double retenciones = teclado.nextDouble(); //Leemos las retenciones
        double retencionesTotales = sueldoMensual * (retenciones/100); //Calculamos lo que se lleva hacienda
        double sueldoMensualTotal = sueldoMensual - retencionesTotales; //Calculamos el sueldo neto mensual
        System.out.println("Tu sueldo bruto mensual es: " + sueldoMensual + " euros, hacienda te retiene " + retencionesTotales + " euros, por lo que pasas a cobrar: " + sueldoMensualTotal + " míseros euros al mes"); //Mostramos el sueldo bruto mensual
    }
}
