package UNIDAD3.EjercicioEntrega;

import java.util.ArrayList;

public class Escenario {
    //Variables miembro
    private String nombre;
    private int tipoEscenario;
    private ArrayList<Artista> artistas;
    private int aforoMaximo;
    private boolean efectosEspeciales;
    //Constantes estáticas
    public static final int PRINCIPAL = 1;
    public static final int SECUNDARIO = 2;
    public static final int ACUSTICO = 3;
    public static final int UNDERGROUND = 4;

    //Constructor vacío
    public Escenario(){
        this.nombre = "Desconocido";
        this.tipoEscenario = (int) (Math.random()*4)+1;
        this.artistas = new ArrayList<>();
        this.aforoMaximo = 0;
        this.efectosEspeciales = false;
    }

    //Constructor con parámetros
    public Escenario(String nombre, int tipoEscenario, int aforo){
        this.nombre = nombre;
        this.tipoEscenario = tipoEscenario;
        this.aforoMaximo = aforo;
        this.artistas = new ArrayList<>();
        this.efectosEspeciales = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoEscenario() {
        return tipoEscenario;
    }

    public void setTipoEscenario(int tipoEscenario) {
        this.tipoEscenario = tipoEscenario;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public boolean getEfectosEspeciales(){
        return efectosEspeciales;
    }

    public void setEfectosEspeciales(boolean efectosEspeciales) {
        this.efectosEspeciales = efectosEspeciales;
    }

    /*
    El método subierAlEscenario realiza:
    - Si el artista ya está en el escenario, devuelve false
    - Si el número de artistas >= aforoMaximo, devuelve false
        - En caso contrario, lo añade y devuelve true
    */
    public boolean subirAlEscenario(Artista a){
        //Si el artista ya está en el escenario, no se añade
        if(artistas.contains(a)){
            return false;
        }
        //Si el escenario ha alcanzado el aforo máximo, no se añade
        if(artistas.size() >= this.getAforoMaximo()){
            return false;
        }
        //Si no se dan las dos condiciones, se añade el artista
        artistas.add(a);
        return true;
    }

    /*
    El método bajarDelEscenario:
    - Busca el artista por el nombre artístico
        - Si existe, lo elimina y devuelve true
        - Si no existe, devuelve false
    */
    public boolean bajarDelEscenario(String nombreArtista){
        //removeIf recorre la lista y elimina aquellos que cumplan sue su nombre artístico coincida
        //devuelve true si se ha eliminadoalgún elemento, false si no se ha eliminado ninguno
        return artistas.removeIf(a -> a.getNombreArtistico().equals(nombreArtista));  
   }

   /*
   El método obtenerArtistaPorGenero:
   - Devuelve la lista de artistas del género introducido
   - Si no hay, lista vacía (isEmpty)
   */
    public ArrayList<Artista> obtenerArtistaPorGenero(int genero){
        
   }

    @Override
    public String toString() {
        return "Nombre escenario: " + this.getNombre() + "\n"
        + "Tipo escenario: " + this.getTipoEscenario() + "\n"
        + "Aforo máximo: " + this.getAforoMaximo() + "\n"
        + "Número de artistas: " + this.artistas.size() + "\n"
        + "Efectos especiales: " + (efectosEspeciales ? "Sí" : "No");

    }

}
