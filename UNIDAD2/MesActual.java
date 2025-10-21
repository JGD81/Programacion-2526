package UNIDAD2;

import java.time.LocalDate;
import java.util.Scanner;

public class MesActual {
    public static void main(String[] args) {
        
        //Creamos la clase Scanner para pedir el mes por teclado
        Scanner teclado = new Scanner(System.in);
        
        //Pedimos al usuario que introduzca el mes
        System.out.print("Introduce un mes: ");
        int mesUsuario = teclado.nextInt();

        //Obtener el mes actual y los días que tiene cada mes
        int mesActual = LocalDate.now().getMonthValue();

        //Número de mes a convertir con switch
        String doceMesesUsuario = "";
        String doceMesesActual = "";

        //Valor a guardar para sumar y restar meses
        int valorFuturoPasado = 0;

        //Obtener el mes del usuario por medio de switch
        switch (mesUsuario) {
            case 1:
               doceMesesUsuario = "Enero"; 
                break;
            case 2:
                doceMesesUsuario = "Febrero";
                break;
             case 3:
                doceMesesUsuario = "Marzo"; 
                break;
            case 4:
                doceMesesUsuario = "Abril";
                break;
             case 5:
                doceMesesUsuario = "Mayo"; 
                break;
            case 6:
                doceMesesUsuario = "Junio";
                break;
            case 7:
                doceMesesUsuario = "Julio"; 
                break;
            case 8:
                doceMesesUsuario = "Agosto";
                break;
             case 9:
                doceMesesUsuario = "Septiembre"; 
                break;
            case 10:
                doceMesesUsuario = "Octubre";
                break;
             case 11:
                doceMesesUsuario = "Noviembre"; 
                break;
            case 12:
                doceMesesUsuario = "Diciembre";
                break; 
            default:
                doceMesesUsuario = "No existe el mes";
                break;
        }

        //Obtener el mes del actual por medio de switch
        switch (mesActual) {
            case 1:
               doceMesesActual = "Enero"; 
                break;
            case 2:
                doceMesesActual = "Febrero";
                break;
             case 3:
                doceMesesActual = "Marzo"; 
                break;
            case 4:
                doceMesesActual = "Abril";
                break;
             case 5:
                doceMesesActual = "Mayo"; 
                break;
            case 6:
                doceMesesActual = "Junio";
                break;
            case 7:
                doceMesesActual = "Julio"; 
                break;
            case 8:
                doceMesesActual = "Agosto";
                break;
             case 9:
                doceMesesActual = "Septiembre"; 
                break;
            case 10:
                doceMesesActual = "Octubre";
                break;
             case 11:
                doceMesesActual = "Noviembre"; 
                break;
            case 12:
                doceMesesActual = "Diciembre";
                break; 
            default:
                doceMesesActual = "No existe el mes";
                break;
        }

        //Condicionales para mostrar los mensajes por pantalla
        if (mesUsuario == mesActual){
            System.out.println("Estamos en " + doceMesesActual);
        }else if (mesUsuario > mesActual) {
            valorFuturoPasado = mesUsuario - mesActual;
            System.out.println("Faltan " + valorFuturoPasado + " mes/meses para " + doceMesesUsuario);
        }else if (mesUsuario < mesActual){
            valorFuturoPasado = mesActual - mesUsuario;
            System.out.println(doceMesesUsuario + " fue hace " + valorFuturoPasado + " mes/meses" );
        }

        //Mostrar los días que tiene el mes
        int diasMes = LocalDate.now().lengthOfMonth();
        System.out.println("El mes actual tiene " + diasMes + " días");
    }
}
