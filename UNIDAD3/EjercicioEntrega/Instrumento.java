package UNIDAD3.EjercicioEntrega;

public class Instrumento {
    
    //Variables miembro
    private String nombre;
    private int tipo;
    private int volumen;
    private double nivelDistorsion;
    private int rareza;
    public boolean enUso;
    //Constantes estáticas
    //Tipos
    public static final int GUITARRA_LASER = 1;
    public static final int BATERIA_CUANTICA = 2;
    public static final int SINTETIZADOR_ESPACIAL = 3;
    public static final int KAZOO_LEGENDARIO = 4;
    public static final int THEREMIN_ATOMICO = 5;
    //Rarezas
    public static final int PRESTADO = 1;
    public static final int COMPRADO = 2;
    public static final int ROBADO = 3;
    public static final int ENCONTRADO_EN_MARTE = 4;

    //Constructor vacío
    public Instrumento (){
        //Aleatorio entre 1 y 5 (según constantes estáticas)
        this.tipo = (int) (Math.random()*5) + 1;
        //Aleatorio entre 1 y 4 (según constantes estáticas)
        this.rareza = (int) (Math.random()*4) + 1;
        //Aleatorio entre 20 y 150
        this.volumen = (int) (Math.random()*130)+20;
        //Aleatorio entre 0.0 y 10.0
        this.nivelDistorsion = Math.random()*10;
        this.enUso = false;
    }
    
    //Constructor con todos los parámetros
    public Instrumento (String nombre, int tipo, int volumen, double nivelDistorsion, int rareza, boolean enUso){
        this.nombre = nombre;
        this.tipo = tipo;
        //Para reutilizar la validación de los setters y evitar duplicar el código, llamamos directamente al setter
        this.setVolumen(volumen);
        this.setNivelDistorsion(nivelDistorsion);
        this.rareza = rareza;
        this.enUso = enUso;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        if (volumen >= 0 && volumen <= 150){
            this.volumen = volumen;
        }
    }

    public double getNivelDistorsion() {
        return nivelDistorsion;
    }

    public void setNivelDistorsion(double nivelDistorsion) {
        if (nivelDistorsion >= 0 && nivelDistorsion <= 10){
            this.nivelDistorsion = nivelDistorsion;
        }
    }

    public int getRareza() {
        return rareza;
    }
    
    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public boolean getEnUso(){
        return enUso;
    }
    
    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    //Métodos
    //Comprueba si el instrumento se puede hackear
    public boolean hackear(){
        //En el caso de que rareza sea ENCONTRADO_EN_MARTE, no es hackeable
        if (rareza == ENCONTRADO_EN_MARTE){
            return false;
        }else{
            //Si es hackeable, el volumen aumenta un 25%
            double nuevoVolumen = volumen + (volumen * 0.25);
            //Validamos que el volumen no pase de 150
            if (nuevoVolumen <= 150){
                setVolumen((int) nuevoVolumen); 
            }else{
                setVolumen(150);
            }
            //Y además, añadimos un nivel a rareza
            setRareza(this.rareza + 1);
            //Devolvemos que el instrumento es hackeable
            return true;
        }
    }

    //Comprobar compatibilidad
    public boolean esCompatible(int generoMusical){
        switch (generoMusical) {
            case Artista.DEATH_METAL_COSMICO:
                if(tipo == GUITARRA_LASER || tipo ==BATERIA_CUANTICA){
                    return true;
                }else{
                    return false;
                }
            case Artista.REGGAETON_MARCIANO:
                if (tipo == SINTETIZADOR_ESPACIAL || tipo == BATERIA_CUANTICA){
                    return true;   
                }else{
                    return false;
                }
            case Artista.JAZZ_CUANTICO:
                if (tipo == THEREMIN_ATOMICO || tipo == SINTETIZADOR_ESPACIAL){
                    return true;   
                }else{
                    return false;
                }
            case Artista.POLKA_INTERGALACTICA:
                if (tipo == KAZOO_LEGENDARIO || tipo == THEREMIN_ATOMICO){
                    return true;   
                }else{
                    return false;
                }
            case Artista.TRAP_ESPACIAL:
                if (tipo == SINTETIZADOR_ESPACIAL || tipo == BATERIA_CUANTICA){
                    return true;   
                }else{
                    return false;
                }
            default:
                return false;
        }
    }

    //toString
    @Override
    public String toString(){
        return "====================INSTRUMENTO====================\n"
        + "Nombre: " + nombre + "\n"
        + "Tipo: " + tipo + "\n" 
        + "Volumen: " + volumen + "\n"
        + "Nivel de distorsión: " + nivelDistorsion + "\n"
        + "Rareza: " + rareza + "\n"
        + "En uso (true:si/false:no): " + enUso + "\n";
    }
}
