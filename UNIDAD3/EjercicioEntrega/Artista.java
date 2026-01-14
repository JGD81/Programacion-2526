package UNIDAD3.EjercicioEntrega;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    tocarInstrumento Comprueba:
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
   
   /*
   dejarInstrumento realiza:
   - Busca en la lista un instrumento con el nombre introducido
        - Si lo encuentra: lo marca como no en uso, lo elimina de la lista,
        recupera 10 de energía y lo devuelve
   */
   public Instrumento dejarInstrumento(String nombreInstrumento){
        // Recorremos la lista de instrumentos con un for clásico,
        // ya que permite eliminar elementos sin problemas
        for(int i = 0; i < instrumentos.size(); i++){
            //Obtenermos el instrumento en la posición actual
            Instrumento inst = instrumentos.get(i);
            //Comprobamos si el nombre del instrumento coincide con el recibido
            if(inst.getNombre().equals(nombreInstrumento)){
                //Marcamos el instrumento como no en uso
                inst.setEnUso(false);
                //Eliminamos el instrumento de la lista del artista
                instrumentos.remove(i);
                //El artista recupera 10 puntos de energía (usamos setter para validaciones)
                this.setEnergia(this.energia + 10);
                //Se devuelve el instrumento retirado
                return inst;
            }
        }    
        //Si no encuentra instrumento con ese nombre, devuelve null
        return null;
   }

   /*
   subirFama realiza
   - Incrementa el nivel en 1
   - Incrementa la energía en 20 (sin superar MAXIMA)
   - Añade 1000 seguidores
   */
  public void subirFama(){
    this.setNivel(this.nivel + 1);
    this.setEnergia(this.energia + 20);
    this.setSeguidores(this.seguidores + 1000);
  }

  /*
  darConcierto realiza:
  - Por cada 10 asistentes, gana un seguidor
  - Resta 30 energía
  - Si los seguidores >= 10000, llama a subirFama()
  */
  public void darConcierto(int asistentes){
    //Como asistentes es int, la división da un resultado entero
    //omitiendo los decimales
    int seguidoresGanados = asistentes / 10;
    //Se resta 30 de energía
    this.setEnergia(this.energia - 30);
    //Se suman lo seguidores ganados
    this.setSeguidores(this.seguidores + seguidoresGanados);
    //Se sube la fama si llega o supera los 10000 seguidores
    if(this.seguidores >= 10000){
        //Llamamos un a un método de la misma clase (this)
        this.subirFama();
    }
  }
  //Devolver una lista con instrumentos de rareza ENCONTRADO_EN_MARTE
  //Si no existen, se devuelve una lista vacía.
  public ArrayList<Instrumento> obtenerInstrumentosMarcianos() {
    //Creamos un stream a partir de la lista de instrumentos del artista.
    //Un stream nos permite recorrer la colección de forma funcional.
    return new ArrayList<>(instrumentos.stream()
    //filter recorre internamente todos los instrumentos de la lista.
    //La variable 'inst' representa CADA instrumento de la lista,
    //uno por uno, en cada iteración del stream.
    .filter(inst -> inst.getRareza() == Instrumento.ENCONTRADO_EN_MARTE)
    //collect convierte el resultado del stream en una lista.
    //Collectors.toList() devuelve un List, no un ArrayList.
    .collect(Collectors.toList()));
  }

  //Usando streams, sumar el volumen de todos los instrumentos
  //Se devuelve: (volumen total) + (nivel * 50) + (energia * 2)
  public int calcularPoderEscenico(){
    int volumenTotal = instrumentos.stream()
    //Convertimos cada instrumento en su volumen y lo sumamos
    .mapToInt(inst -> inst.getVolumen()).sum();
    //Se aplica la fórmula del poder escénico
    return volumenTotal + (this.getNivel() * 50) + (getEnergia()*2);
  }

  //Método auxiliar para convertir el género a texto
  private String generoATexto(){
    switch (generoMusical) {
        case DEATH_METAL_COSMICO:
            return "Death Metal Cósmico";
        case REGGAETON_MARCIANO:
            return "Reggaeton Marciano";
        case JAZZ_CUANTICO: 
            return "Jazz Cuántico";
        case POLKA_INTERGALACTICA: 
            return "Polka Intergaláctica";
        case TRAP_ESPACIAL:
            return "Trap Espacial";
        default:
            return "Desconocido";
    }
  }


  @Override
  public String toString(){
    return "====================ARTISTA====================\n"
    + "Nombre Artístico: " + this.nombreArtistico + "\n"
    + "Género musical: " + generoATexto() + "\n"
    + "Nivel: " + nivel + "\n"
    + "Energía: " + energia + "\n"
    + "Seguidores: " + seguidores + "\n"
    + "En gira: " + (enGira ? "Sí" : "No") + "\n"
    + "Número de instrumentos: " + instrumentos.size();

  }


}
