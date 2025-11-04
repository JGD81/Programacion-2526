package UNIDAD2;

import java.util.Scanner;

public class EjercicioEntrega3 {
    public static void main(String[] args) {
        //Scanner para introducir dato por teclado
        Scanner teclado = new Scanner(System.in);
        
        //Pedir datos
        System.out.print("Introduce el número de empleados: ");
        int numEmpleados = teclado.nextInt();
        System.out.print("Introduce el número de pizzas: ");
        int numPizzas = teclado.nextInt();
        
        //Constante (todas las pizzas se dividen en 8 trozos)
        
        final int TROZOS_POR_PIZZA = 8;
        
        //Pizzas completas por empleado
        int pizzasPorEmpleado = numPizzas / numEmpleados;
        //Pizzas completas sobrantes
        int pizzasSobrantes = numPizzas  % numEmpleados;
        //Trozos totales sobrantes
        int trozosSobrantes = pizzasSobrantes * TROZOS_POR_PIZZA;
        
        for(int i = 1; i <= numEmpleados; i++){ //Bucle para pintar los empleados
            System.out.print("Empleado " + i + ":");
            for (int j = 0; j < pizzasPorEmpleado;j++){//Bucle para pintar los asteriscos por empleado
                System.out.print("*");
            }
            System.out.println();//Salto de línea para pasar al siguiente empleado
        }

        System.out.println("Sobran " + trozosSobrantes + " porciones");//Pinta los trozos sobrantes
        
    }

}
