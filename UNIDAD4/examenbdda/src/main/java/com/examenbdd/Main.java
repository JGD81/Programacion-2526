package com.examenbdd;

import java.sql.Connection;
import java.util.Scanner;

import com.examenbdd.dao.ClubGolfDAO;
import com.examenbdd.dao.HoyoDAO;
import com.examenbdd.dao.SocioDAO;
import com.examenbdd.utils.ConexionBD;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n" +
                    "**** Bienvenido a GolfistaPlusUltra ****\n" +
                    "****     Administración   *******\n" +
                    "\n" +
                    "1. Alta de socios\n" +
                    "2. Modificar Club Golf \n" +
                    "3. Cálculos\n" +
                    "4. Eliminar Hoyo\n" +
                    "5. Salir" +
                    "\n" +
                    "Opción (1-5): ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("\n--- Alta de socio ---");

                    System.out.println("Introduce idSocio:");
                    int idSocio = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce nombre:");
                    String nombre = teclado.nextLine();

                    System.out.println("Introduce edad:");
                    int edad = teclado.nextInt();

                    System.out.println("Introduce sexo:");
                    int sexo = teclado.nextInt();

                    System.out.println("Introduce cuota:");
                    int cuota = teclado.nextInt();

                    SocioDAO.insertarSocio(idSocio, nombre, edad, sexo, cuota);

                    break;

                case 2:

                    System.out.println("\n--- Modificar club de golf ---");
                    System.out.println("Introduce el ID del club a modificar");
                    int idClubMod = teclado.nextInt();
                    ClubGolfDAO.mostrarClub(idClubMod);
                    teclado.nextLine();
                    System.out.println("Escribe el campo a modificar: \n" +
                            "1. nombre\n" +
                            "2. localidad\n" +
                            "3. recordGolpes\n" +
                            "4. escuela\n");
                    int opcionCampo = teclado.nextInt();
                    teclado.nextLine();

                    String nombreParametro = "";

                    switch (opcionCampo) {
                        case 1:
                            nombreParametro = "nombre";
                            break;
                        case 2:
                            nombreParametro = "localidad";
                            break;
                        case 3:
                            nombreParametro = "recordGolpes";
                            break;
                        case 4:
                            nombreParametro = "escuela";
                            break;
                        default:
                            System.out.println("Campo no válido");
                    }
                    System.out.println("Introduce el valor:");
                    Object valorParametro = teclado.nextLine();

                    ClubGolfDAO.modificarClub(nombreParametro, idClubMod, valorParametro);
                    break;

                case 3:

                    break;

                case 4:

                    System.out.println("\n--- Eliminar hoyo ---");
                    System.out.println("Introduce el ID del hoyo a eliminar");
                    int idHoyo = teclado.nextInt();

                    HoyoDAO.eliminarHoyo(idHoyo);

                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:

                    System.out.println("\nOpción incorrecta. Vuelva a introducir el número\n");
            }

        } while (opcion != 5);

        teclado.close();
    }
}