import java.util.ArrayList;
import java.util.Comparator;
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
        this.jugadoresRegistrados = (int) (Math.random() * 101);
        this.listaJugadores = new ArrayList<>();
        this.servidorRegion = "";
        this.poolPremios = 0;
        this.requiereNivelMinimo = 1;
        this.esRanked = false;
    }

    public TorneoEsports(String codigoTorneo, String nombreTorneo,
            ArrayList<PersonajeRPG> listaJugadores, String servidorRegion,
            double poolPremios, int requiereNivelMinimo, boolean esRanked) {
        this.codigoTorneo = codigoTorneo;
        this.nombreTorneo = nombreTorneo;
        this.listaJugadores = new ArrayList<>(listaJugadores);
        this.jugadoresRegistrados = listaJugadores.size();
        this.servidorRegion = servidorRegion;
        this.poolPremios = poolPremios;
        this.requiereNivelMinimo = requiereNivelMinimo;
        this.esRanked = esRanked;
    }

    public String getCodigoTorneo() {
        return codigoTorneo;
    }

    public void setCodigoTorneo(String codigoTorneo) {
        this.codigoTorneo = codigoTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public int getJugadoresRegistrados() {
        return listaJugadores.size();
    }

    public ArrayList<PersonajeRPG> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<PersonajeRPG> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public String getServidorRegion() {
        return servidorRegion;
    }

    public void setServidorRegion(String servidorRegion) {
        this.servidorRegion = servidorRegion;
    }

    public double getPoolPremios() {
        return poolPremios;
    }

    public void setPoolPremios(double poolPremios) {
        this.poolPremios = poolPremios;
    }

    public int getRequiereNivelMinimo() {
        return requiereNivelMinimo;
    }

    public void setRequiereNivelMinimo(int requiereNivelMinimo) {
        this.requiereNivelMinimo = requiereNivelMinimo;
    }

    public boolean isEsRanked() {
        return esRanked;
    }

    public void setEsRanked(boolean esRanked) {
        this.esRanked = esRanked;
    }

    // Calcula el daño promedio de todos los personajes que
    // pertenecen a la clase especificada
    double calcularDanioPromedioClase(int claseFiltro) {

        int contador = 0;
        double suma = 0;

        for (int i = 0; i < listaJugadores.size(); i++) {

            if (listaJugadores.get(i).getClasePersonaje() == claseFiltro) {
                suma = suma + listaJugadores.get(i).getPuntosDanio();
                contador++;
            }
        }

        if (contador == 0) {
            return 0.0;
        } 
        
        return (double) suma / contador;
    }

    /*
    Devuelve un entero con el número de jugadores que, dentro de la lista de jugadores, 
    son legendarios y que además tienen en su lista de habilidades alguna que coincida 
    con la habilidad buscada, sin importar mayúsculas o minúsculas. El resultado se obtiene
    contando los elementos que cumplen ambas condiciones.
    */
   //Personajes legendarios con la habilidad buscada
    int contarPersonajesLegendariosConHabilidad(String habilidadBuscada){
        //Stream con la lista de jugadores para buscar los legendarios
        //Strean de nuevo para buscar en la lista de habilidades
        //anyMatch te busca si hay coincidencias.
        return (int) listaJugadores.stream()
        .filter(p -> p.isEsLegendario())
        .filter(p -> p.getHabilidades()
        .stream().anyMatch(h -> h.equalsIgnoreCase(habilidadBuscada)))
        .count();
    }

    //Arraylist con topN personajes con más puntos de vida, ordenados de mayor a menor
    ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN){

        //Devuelve una lista vacía
        if (topN <= 0){
            return new ArrayList<>();
        }
        //listaJugadores.stream(): Convierte el ArrayList en un flujo de datos (stream)
        //sorted(): Ordena los elementos del Stream usando el criterio definido en el Comparator.
        //Comparator.comparingInt: Crea un Comparator que ordena los objetos usando el valor entero devuelto por el método indicado.
        //PersonajeRPG::getPuntosVida: Compara los puntos de vida de los personajes de la lista PersonajeRPG
        //.reversed: Ordena de mayor a menor.
        //.limit (topN): Limita el resultado a los primeros topN elementos del Stream ya ordenado
        //.collect(Collectors.toCollection(ArrayList::new)): Convierte el Stream final en un ArrayList nuevo

        return listaJugadores.stream()
        .sorted(Comparator.comparingInt(PersonajeRPG::getPuntosVida).reversed())
        .limit(topN).collect(Collectors.toCollection(ArrayList::new));
    }

    
}
