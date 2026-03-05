package com.examenes.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TorneoEsports {

    private String codigoTorneo;
    public String nombreTorneo;
    private int jugadoresRegistrados;
    private ArrayList<PersonajeRPG> listaJugadores;
    private String servidorRegion;
    private double poolPremios;
    private int requiereNivelMinimo;
    private boolean esRanked;

    public TorneoEsports() {
        this.codigoTorneo = "";
        this.nombreTorneo = "";
        this.jugadoresRegistrados = (int) (Math.random() * 101);
        this.listaJugadores = new ArrayList<>();
        this.servidorRegion = "";
        this.poolPremios = 0;
        this.requiereNivelMinimo = 1;
        this.esRanked = false;
    }

    public TorneoEsports(String codigoTorneo, String nombreTorneo, ArrayList<PersonajeRPG> listajugadores,
            String servidorRegion, double poolPremios, int requiereNivelMinimo, boolean esRanked) {

        this.codigoTorneo = codigoTorneo;
        this.nombreTorneo = nombreTorneo;
        // Los jugadores registrados dependen del tamaño del ArrayList
        this.jugadoresRegistrados = listajugadores.size();
        // Evita error si la lista es null, creando un nuevo ArrayList vacío
        this.listaJugadores = (listajugadores != null) ? listajugadores : new ArrayList<>();
        this.servidorRegion = servidorRegion;
        this.poolPremios = poolPremios;
        this.requiereNivelMinimo = requiereNivelMinimo;
        this.esRanked = esRanked;
    }

    // Calcular el daño promedio de la clase introducida
    // Si no hay personanjes de esa clase o el torneo no tiene participantes
    // se devuelve 0.0
    public double calcularDanioPromedioClase(int claseFiltro) {

        // Variables para guardar el dañototal y el número de personajes por clase
        double danioTotalPromedioPorClase = 0;
        int personajesClase = 0;

        for (PersonajeRPG personajeRPG : listaJugadores) {
            // Comparamos la clase introducida con la de los personajes de la lista
            if (personajeRPG.getClasePersonaje() == claseFiltro) {
                // Se suma el daño de los personajes de la clase
                danioTotalPromedioPorClase += personajeRPG.getPuntosDanio();
                // Se suman los personajes para el promedio
                personajesClase++;
            }
        }

        // Si no hay personajes, se devuelve 0.0
        if (personajesClase == 0) {
            return 0.0;
        }

        // Se devuelve el promedio
        return danioTotalPromedioPorClase / personajesClase;
    }

    public int contarPersonajesLegendariosConHabilidad(String habilidadBuscada) {
        // Tipo long (streams devuelven long)
        long personajesLH = listaJugadores.stream()
                // Se filtran los personajes que:
                // 1. Sean legendarios
                // 2. Tengan en su lista de habilidades la habilidad buscada
                // Para comprobar la habilidad se usa otro stream porque habilidades es un
                // ArrayList<String>
                // anyMatch() devuelve true si alguna habilidad coincide (ignorando
                // mayúsculas/minúsculas)
                .filter(p -> p.isEsLegendario()
                        && p.getHabilidades().stream().anyMatch(h -> h.equalsIgnoreCase(habilidadBuscada)))
                // Cuenta los elementos que cumplen el filtro
                .count();

        // Devuelve el resultado casteado a int (era long)
        return (int) personajesLH;
    }

    //ArrayList con el número de personajes (limitados por topN) ordenados de mayor a menor 
    public ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN){
        //Si el límite es 0 o menos, devuelve un ArrayList vacío
        if(topN <= 0){
            return new ArrayList<>();
        }
        //Crear un nuevo ArrayList a partir del stream de listaJugadores:
        //- Ordenados de mayor a menor y el número de personajes limitados por topN
        ArrayList<PersonajeRPG> personajesPorVidaTop = new ArrayList<>(listaJugadores.stream()
        .sorted((a1, a2) -> a2.getPuntosVida() - a1.getPuntosVida())
        .limit(topN).toList()); 

        return personajesPorVidaTop;
    }

    public PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio){
        PersonajeRPG personajeMasFuerteGremio = listaJugadores.stream()
        //Filtramos por nombre del gremio
        .filter(p -> p.getGuildName()
        .equals(nombreGremio))
        //Comparamos los puntos de daño de los personajes y guardamos el que tiene el máximo
        //en caso de empate, se compara el nivel
        .max(Comparator.comparingDouble(PersonajeRPG::getPuntosDanio).thenComparing(PersonajeRPG::getNivel))
        //si no existe, devuelve null
        .orElse(null);
        return personajeMasFuerteGremio; 
    }
}
