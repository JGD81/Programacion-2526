import java.util.ArrayList;

public class PersonajeRPG {

    private int idPersonaje;
    public String nombrePersonaje;
    private int clasePersonaje;
    public static final int CLASE_GUERRERO = 1;
    public static final int CLASE_MAGO = 2;
    public static final int CLASE_ARQUERO = 3;
    public static final int CLASE_ASESINO = 4;
    private int nivel;
    private int puntosVida;
    private double puntosDanio;
    private boolean esLegendario;
    private ArrayList<String> habilidades;
    private String guildName;

    public PersonajeRPG() {
        this.idPersonaje = (int) (Math.random() * 90000) + 10000;
        this.nombrePersonaje = "";
        this.clasePersonaje = (int) (Math.random() * 4) + 1;
        this.nivel = (int) (Math.random () * 50) + 1;
        this.puntosVida = (int) (Math.random() * 4000) + 1000;
        this.puntosDanio = (Math.random() * 200) + 50;
        this.esLegendario = false;
        this.habilidades = new ArrayList<>();
        this.guildName = "";
    }

    public PersonajeRPG(String nombrePersonaje, int clasePersonaje,
            int nivel, int puntosVida, double puntosDanio,
            boolean esLegendario, ArrayList<String> habilidades, String guildName) {

        this.idPersonaje = (int) (Math.random() * 90000) + 10000;
        this.nombrePersonaje = nombrePersonaje;
        this.clasePersonaje = clasePersonaje;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.puntosDanio = puntosDanio;
        this.esLegendario = esLegendario;
        this.habilidades = new ArrayList<>(habilidades);
        this.guildName = guildName;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setClasePersonaje(int clasePersonaje) {
        this.clasePersonaje = clasePersonaje;
    }

    public int getClasePersonaje() {
        return clasePersonaje;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosDanio(double puntosDanio) {
        this.puntosDanio = puntosDanio;
    }

    public double getPuntosDanio() {
        return puntosDanio;
    }

    public boolean isEsLegendario() {
        return esLegendario;
    }

    public void setEsLegendario(boolean esLegendario) {
        this.esLegendario = esLegendario;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public String getGuildName() {
        return guildName;
    }

    @Override
    public String toString() {

        String nombreClase = "";

        switch (clasePersonaje) {
            case CLASE_GUERRERO:
                nombreClase = "Guerrero";
                break;
            case CLASE_MAGO:
                nombreClase = "Mago";
                break;
            case CLASE_ARQUERO:
                nombreClase = "Arquero";
                break;
            case CLASE_ASESINO:
                nombreClase = "Asesino";
                break;
        }

        String legendarioTexto = esLegendario ? "Sí" : "No";

        String gremioTexto = guildName.isEmpty() ? "Sin gremio" : guildName;

        return "=== PERSONAJE RPG ===\r\n" + //
                        "-> ID: " + idPersonaje + "\n" +
                        "-> Nombre: " + nombrePersonaje + "\n" +
                        "-> Clase: " + nombreClase + "\n" + 
                        "-> Nivel: " + nivel + "\n" +
                        "-> Vida: " + puntosVida + " HP\n" + 
                        "-> Daño: " + puntosDanio + "\n" +
                        "-> Legendario: " + legendarioTexto + "\n" + 
                        "-> Gremio: " + gremioTexto + "\n" +
                        "-> Habilidades: " + habilidades + "\n" +
                        "=====================================";
    }
}
