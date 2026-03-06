package com.examenes.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    // ArrayList con el número de personajes (limitados por topN) ordenados de mayor
    // a menor
    public ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) {
        // Si el límite es 0 o menos, devuelve un ArrayList vacío
        if (topN <= 0) {
            return new ArrayList<>();
        }
        // Crear un nuevo ArrayList a partir del stream de listaJugadores:
        // - Ordenados de mayor a menor y el número de personajes limitados por topN
        ArrayList<PersonajeRPG> personajesPorVidaTop = new ArrayList<>(listaJugadores.stream()
                .sorted((a1, a2) -> a2.getPuntosVida() - a1.getPuntosVida())
                .limit(topN).toList());

        return personajesPorVidaTop;
    }

    // Buscar el personaje más fuerte según el gremio. Si hay empate, comparar nivel
    public PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio) {
        PersonajeRPG personajeMasFuerteGremio = listaJugadores.stream()
                // Filtramos por nombre del gremio
                .filter(p -> p.getGuildName()
                        .equals(nombreGremio))
                // Comparamos los puntos de daño de los personajes y guardamos el que tiene el
                // máximo
                // en caso de empate, se compara el nivel
                .max(Comparator.comparingDouble(PersonajeRPG::getPuntosDanio).thenComparingInt(PersonajeRPG::getNivel))
                // si no existe, devuelve null
                .orElse(null);
        return personajeMasFuerteGremio;
    }

    // Incrementa el nivel de todos los personaes en la cantidad especificada (sin
    // superar 100)
    // Después del incremento, elimina a todos los personajes del torneo cuyo nivel
    // sea menor que
    // nivelMinimoSupervivencia
    // Actualiza jugadoresRegistrados correctamente
    // Devuelve true si se eliminó al menos un personaje, false en caso contrario.
    public boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int nivelMinimoSupervivencia) {

        listaJugadores.forEach(p -> {
            int nuevoNivel = p.getNivel() + incrementoNivel;

            if (nuevoNivel > 100) {
                nuevoNivel = 100;
            }

            p.setNivel(nuevoNivel);
        });

        boolean eliminado = listaJugadores.removeIf(p -> p.getNivel() < nivelMinimoSupervivencia);

        jugadoresRegistrados = listaJugadores.size();

        return eliminado;
    }

    // MÉTODOS EXTRA PARA EL ESTUDIO
    // Obtener todas las habilidades de todos los personajes del torneo
    // -Sin repetir habilidades
    // Devuelve un ArrayList<String>
    // Usando Streams
    public ArrayList<String> obtenerTodasLasHabilidades() {
        // Con stream, se convierte ArrayList<PersonajeRPG> a Stream<PersonajeRPG>, que
        // contiene
        // - Personaje1, personaje2...
        // flat.Map(p -> p.getHabilidades().stream()):
        // - Se obtiene un Stream<String>, pero como cada personaje tiene su propio
        // Stream, se obtiene:
        // - Stream<Stream<String>>, que seria [Fuego, Teletransporte] [Rayo,Barrera]
        // flatmap lo transforma a Fuego, Teletransporte, Rayo, Barrera
        // distinct elimiina los duplicados
        // toList convierte finalmente el Stream en Una lista
        return new ArrayList<>(listaJugadores.stream().flatMap(p -> p.getHabilidades().stream()).distinct().toList());
    }

    // Sacar los nombres de los personajes legendarios
    public List<String> obtenerNombresPersonajesLegendarios() {

        // Convierte listaJugadores en un stream, filtra los personajes legendarios,
        // extrae sus nombres con map() y devuelve el resultado como una lista
        return listaJugadores.stream().filter(p -> p.isEsLegendario()).map(c -> c.getNombrePersonaje()).toList();
    }

    // Convierte la lista en stream, ordena los personajes por nivel de mayor a
    // menor y devuelve el resultado como una lista
    public List<PersonajeRPG> obtenerPersonajesOrdenadosPorNivel() {
        // Mediante sorted
        // return listaJugadores.stream().sorted((a1, a2) -> a2.getNivel() -
        // a1.getNivel()).toList();
        // Mediante sorted + Comparator
        return listaJugadores.stream().sorted(Comparator.comparingInt(PersonajeRPG::getNivel).reversed()).toList();
    }

    //Agrupar los personajes por clase
    public Map<Integer, List<PersonajeRPG>> agruparPersonajesPorClase() {
        // Convierte la lista en stream y agrupa los personajes según su clase,
        // devolviendo un Map donde la clave es la clase y el valor la lista de
        // personajes
        return listaJugadores.stream().collect(Collectors.groupingBy(PersonajeRPG::getClasePersonaje));
    }
    //Obtener todas las habilidades ordenadas
    public List<String> obtenerHabilidadesOrdenadas(){
        //En este caso, sorted, se deja vacío porque son Strings, que ya implementa comparable
        //Si fuesen objetos, sí se necesitaría .sorted(Comparator.comparing(Objeto::getCampo))
        return listaJugadores.stream().flatMap(p -> p.getHabilidades().stream()).distinct().toList();
    }

}
