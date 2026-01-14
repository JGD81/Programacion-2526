package UNIDAD3.EjercicioEntrega;

import java.util.ArrayList;

public class Artista {
    //Variables miembro
    private String nombreArtistico;
    private int generoMusical;
    private int nivel;
    private int energia;
    private int seguidores;
    private ArrayList<Instrumento> instrumentos;
    public boolean enGira;
    //Constantes estáticas
    //Géneros
    public static final int DEATH_METAL_COSMICO = 1;
    public static final int REGGAETON_MARCIANO = 2;
    public static final int JAZZ_CUANTICO = 3;
    public static final int POLKA_INTERGALACTICA = 4;
    public static final int TRAP_ESPACIAL = 5;
    //Energía
    public static final int MINIMA = 10;
    public static final int MAXIMA = 100;

    public Artista(){
        //La variable nombreArtistico no se asigna y aceptamos como valor null
        //Aleatorio del 1 al 5 (Según constantes de los géneros)
        this.generoMusical = (int) (Math.random()*5)+1;
        this.nivel = 1;
        //Aleatorio del 10 al 100
        this.energia = (int) (Math.random()*91)+10;
        this.seguidores = 0;
        //Inicialización lista vacía
        this.instrumentos = new ArrayList<>();
        this.enGira = false;
    }

    public Artista(String nombreArtistico, int generoMusical, int nivel, int energia){
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        //Para reutilizar la validación de los setters y evitar duplicar el código, llamamos directamente al setter
        this.setNivel(nivel);
        this.setEnergia(energia);
        //Inicializamos variables para que el objeto quede en estádo válido desde el primer momento
        this.seguidores = 0;
        this.instrumentos = new ArrayList<>();
        this.enGira = false;
    }

    //Getters y setters
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public int getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(int generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        //Validamos que nivel empiece como mínimo en 1
        if(nivel >= 1){
            this.nivel = nivel;
        } 
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        //El rango 0–100 indica el límite teórico, mientras que MINIMA = 10 representa el valor mínimo operativo;
        //Para evitar errores en el método tocarInstrumento a la hora de restar energía al artista, el mínimo se 
        //limita en 0.
        if(energia >= 0 && energia <= MAXIMA){
            this.energia = energia;
        }  
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        //Validamos que no sean valores negativos
        if (seguidores >= 0){
            this.seguidores = seguidores;
        }
        
    }

    public void setInstrumentos(ArrayList<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public boolean getEnGira(){
        return enGira;
    }
    
    public void setEnGira(boolean enGira) {
        this.enGira = enGira;
    }

    //Métodos
    /*
    Comprueba:
    - Que el instrumento sea compatible con el género de artista
    - Que el instrumento no esté ya en uso
    - Si la energía del artista < 20 (no puede tocar: return false)
    - Si todo ok, añade instrumento a la lista, marca enUso = true, resta 15 energía y return true
    - Si falla, return false
    */
   public boolean tocarInstrumento(Instrumento i){
        //Validación energía artista. Uso de this para dejar claro que son atributos del artista
        if (this.energia < 20){
            return false;
        }
        //Validación compatibilidad del intrumento con género. Mismo uso del this
        if (!i.esCompatible(this.generoMusical)){
            return false;
        }
        //Comprobar si está en uso
        if (i.getEnUso()){
            return false;
        }
        
        //Si no entra en nigún condicional, añadimos el instrumento a la lista, lo marcamos
        //como en uso, restamos la energía al artista y retornamos true
        this.instrumentos.add(i);
        //Aprovechamos los setters con validaciones para enUso y energía
        i.setEnUso(true);
        this.setEnergia(this.energia - 15);
        return true;
   }


}
