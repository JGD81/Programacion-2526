package UNIDAD3.Examen;
//José García Díaz
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;


public class TorneoEsports {
    private String codigoTorneo;
    private String nombreTorneo;
    private int jugadoresRegistrados;
    private ArrayList<PersonajeRPG> listaJugadores;
    private String servidorRegion;
    private int poolPremios;
    private int requiereNivelMinimo;
    private boolean esRanked;

    public TorneoEsports(){
        this.codigoTorneo = "";
        this.nombreTorneo = "";
        this.jugadoresRegistrados = (int) (Math.random()*101);
        this.listaJugadores = new ArrayList<>();
        this.servidorRegion = "";
        this.poolPremios = 0;
        this.requiereNivelMinimo = 1;
        this.esRanked = false;
    }

    public TorneoEsports(String codigoTorneo, String nombreTorneo, int jugadoresRegistrados, 
        ArrayList<PersonajeRPG> listaJugadores, String servidorRegion, int poolPremios,
        int requiereNivelMinimo,boolean esRanked){
            this.codigoTorneo =  codigoTorneo;
            this.nombreTorneo = nombreTorneo;
            this.jugadoresRegistrados = jugadoresRegistrados;
            this.listaJugadores = (listaJugadores != null) ? new ArrayList<>(listaJugadores) : new ArrayList<>();
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
        return jugadoresRegistrados;
    }

    public void setJugadoresRegistrados(int jugadoresRegistrados) {
        this.jugadoresRegistrados = jugadoresRegistrados;
    }

    public ArrayList<PersonajeRPG> getListaJugadores() {
        return new ArrayList<>(listaJugadores);
    }

    public void setListaJugadores(ArrayList<PersonajeRPG> listaJugadores) {
        this.listaJugadores = (listaJugadores != null) ? new ArrayList<>(listaJugadores) : new ArrayList<>();
    }

    public String getServidorRegion() {
        return servidorRegion;
    }

    public void setServidorRegion(String servidorRegion) {
        this.servidorRegion = servidorRegion;
    }

    public int getPoolPremios() {
        return poolPremios;
    }

    public void setPoolPremios(int poolPremios) {
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

    public double calcularDanioPromedioClase(int claseFiltro){
        double sumaJugadores = 0;
        int contador = 0;

        for(int i = 0; i < listaJugadores.size(); i++){
            if(listaJugadores.get(i).getClasePersonaje() == claseFiltro){
                sumaJugadores = sumaJugadores + listaJugadores.get(i).getPuntosDanio();
                contador ++;
            }
        }
        if (contador == 0){
            return 0.0;
        }

        return sumaJugadores / contador;
    }

    int contarPersonajesLegendariosConHabilidad(String habilidadBuscada){
        return (int) listaJugadores.stream().filter(c -> (c.isEsLegendario() 
        && c.getHabilidades().contains(habilidadBuscada))).count();
    }

    /*ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN){
        ArrayList<PersonajeRPG> resultado = new ArrayList<>();
        for(int i = 0; i < listaJugadores.size();i++){
            Ciclista ciclistaPesado = this.listaCiclistas.stream().max(Comparator.comparingDouble(Ciclista::getPeso))
                .orElse(null);
        }
    }*/

    PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio){

        int claseBuscada = -1;

        switch (nombreGremio.toUpperCase()) {
            case "CLASE_GUERRERO":
                claseBuscada = PersonajeRPG.CLASE_GUERRERO;
                break;
            case "CLASE_MAGO":
                claseBuscada = PersonajeRPG.CLASE_MAGO;
                break;
            case "CLASE_ARQUERO":
                claseBuscada = PersonajeRPG.CLASE_ARQUERO;
                break;
            case "CLASE_ASESINO":
                claseBuscada = PersonajeRPG.CLASE_ASESINO;
                break;
            default:
                return null;
        }

        listaJugadores.stream().filter(c -> (c.getClasePersonaje() == claseBuscada));


    }

    



}
