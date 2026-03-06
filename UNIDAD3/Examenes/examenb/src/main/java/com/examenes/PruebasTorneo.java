package com.examenes;

import java.util.ArrayList;

import com.examenes.model.PersonajeRPG;
import com.examenes.model.TorneoEsports;

public class PruebasTorneo {
    public static void main(String[] args) {
        
        //Personaje con constructor vacío
        PersonajeRPG p1 = new PersonajeRPG();

        //Necesitamos la lista de habilidades para agregarlas a cada personaje
        ArrayList<String> habilidades1 = new ArrayList<>();
        habilidades1.add("Fuego");
        habilidades1.add("Teletransportarse");

        ArrayList<String> habilidades2 = new ArrayList<>();
        habilidades2.add("Rayo");
        habilidades2.add("Barrera");

        //Personajes con constructor con parámetros
        PersonajeRPG p2 = new PersonajeRPG("Frodo", PersonajeRPG.CLASE_MAGO, 50, 80, 100, true, habilidades1, "MagosSupremos");
        PersonajeRPG p3 = new PersonajeRPG("Himan", PersonajeRPG.CLASE_GUERRERO, 70, 200, 200, true, habilidades2, "GuerrerosSupremos");
        PersonajeRPG p4 = new PersonajeRPG("Gatchet", PersonajeRPG.CLASE_ASESINO,100, 100, 100, false, habilidades1, "AsesinosSupremos");
        PersonajeRPG p5 = new PersonajeRPG("Legolas", PersonajeRPG.CLASE_ARQUERO, 100, 200, 300, true, habilidades2, "ArquerosSupremos");
        PersonajeRPG p6 = new PersonajeRPG("Terminator", PersonajeRPG.CLASE_GUERRERO, 200, 200, 200, false, habilidades1, "GuerrerosPeliculeros");
        PersonajeRPG p7 = new PersonajeRPG("Gandalf", PersonajeRPG.CLASE_MAGO, 50, 80, 100, true, habilidades2, "MagosPeliculeros");

        //Listas de personajes para agregar a torneo
        ArrayList<PersonajeRPG>torneo1 = new ArrayList<>();
        torneo1.add(p6);
        torneo1.add(p7);
        
        ArrayList<PersonajeRPG> torneo2 = new ArrayList<>();
        torneo2.add(p1);
        torneo2.add(p2);
        torneo2.add(p3);
        torneo2.add(p4);
        torneo2.add(p5);

        //Instancias a torneos
        TorneoEsports t1 = new TorneoEsports("t01-01", "TorneoRegional", torneo1, "Europe", 500, 50, true);
        TorneoEsports t2 = new TorneoEsports("t02-01", "TorneoMundial", torneo2, "USA", 1000, 100, true);

        //Funciones
        System.out.println("===Calcular daño promedio por clase===");
        System.out.println(t2.calcularDanioPromedioClase(PersonajeRPG.CLASE_GUERRERO));
        System.out.println("===Contar personajes legencarios con habilidad===");
        System.out.println(t2.contarPersonajesLegendariosConHabilidad("Fuego"));
        System.out.println("===Obtener top personajes por vida");
        System.out.println(t2.obtenerTopPersonajesPorVida(3));
        System.out.println("===Buscar personaje más fuerte del gremio===");
        System.out.println(t2.buscarPersonajeMasFuerteDeGremio("GuerrerosSupremos"));
        System.out.println("===Actualizar niveles y eliminar débiles");
        System.out.println(t2.actualizarNivelesYEliminarDebiles(20, 100));

        //Mostrat toString de 2 personajes
        System.out.println("===Mostrar tostring 2 personajes===");
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("===Agrupar personajes por clase===");
        System.out.println(t2.agruparPersonajesPorClase());
    }
}