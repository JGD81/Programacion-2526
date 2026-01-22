package UNIDAD3.EjercicioEntrega;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.HashSet;

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
        return artistas.removeIf(a -> a.getNombreArtistico().equalsIgnoreCase(nombreArtista));  
    }

   /*
   El método obtenerArtistaPorGenero:
   - Devuelve la lista de artistas del género introducido
   - Si no hay, lista vacía (isEmpty)
   */
    public ArrayList<Artista> obtenerArtistaPorGenero(int genero){
        //Mismo caso que en la clase Artista con método obtenerInstrumentosMarcianos
        return new ArrayList<>(artistas.stream().filter(a-> a.getGeneroMusical() == genero)
        .collect(Collectors.toList()));        
    }

   /*
   El método obtenerGenerosEnEscenario:
   - Recorre todos los artistas del escenario
   - Devuelve un HashSet con los géneros musicales presentes (sin repetir)
   - Usar HashSet para evitar duplicados
   */
  public HashSet<Integer> obtenerGenerosEnEscenario(){
        //Creamos el HashSet donde se guardarán los géneros sin duplicar
        HashSet<Integer> generos = new HashSet<>();
        //Recorremos la lista de artistas
        for(int i = 0; i < artistas.size(); i++){
            //Obtenemos el artista en la posición i
            Artista a = artistas.get(i);
            //Obtenemos su género musical a partir del objeto a
            int genero = a.getGeneroMusical();
            //Se añade al HashSet, si está repetido, se ignora
            generos.add(genero);
        }
        //Devolvemos el HashSet con la lista de géneros
        return generos;
    }

    /*
    El método calcularEspectacularidad:
    - Suma el poder escénico de todos los artistas
    - Si efectosEspeciales == true, multiplica el resultado por 1.5
    - Devuelve el valor (casteado a int)
    */
    public int calcularEspectacularidad(){
        //Guardamos en la variable totalPoder la suma total de poder escénico de todos los artistas
        //Mediante stream recorremos el Arraylist de los artistas, mapToInt convierte Artista -> int
        //y sum hace la suma del poder de cada artista que se obtiene a través del método calcularPoderEscenico
        int totalPoder = artistas.stream()
        .mapToInt(a -> a.calcularPoderEscenico())
        .sum();
        //Si hay efectos especiales, se multiplica el resultado total por 1.5
        if(efectosEspeciales){
            //Se castea el valor a int, ya que estamos multiplicando un int por un double
            totalPoder = (int) (totalPoder*1.5); 
        }
        //Devolvemos el total
        return totalPoder;
    }

    /*
    El método obtenerArtistasAgotados:
    - Devuelve artistas con energía < 30
    - Ordena de menor a mayor la energía
    */
    public ArrayList<Artista> obtenerArtistasAgotados(){
        //Envolvemos en Arraylist porque Collectors.toList devuelve List
        //Creamos un stream a partir del ArrayList de artistas
        return new ArrayList<>(artistas.stream()
        //Filtramos los artistas con energía menor a 30
        .filter(a -> a.getEnergia() < 30)
        //Ordenamos los artistas por energía de menor a mayor
        .sorted(Comparator.comparingInt(a -> a.getEnergia()))
        //Convertimos el resultado del stream en una lista
        .collect(Collectors.toList()));
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
