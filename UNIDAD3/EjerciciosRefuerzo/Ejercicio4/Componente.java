package UNIDAD3.EjerciciosRefuerzo.Ejercicio4;

public class Componente {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private int tipo;
    private float potenciaWatts;
    private String compatibilidad;
    public static final int PROCESADOR = 1;
    public static final int MEMORIA = 2;
    public static final int CPU = 3;
    public static final int GRAFICA = 4;

    public Componente(){
        this.id = (int) (Math.random()*1000)+1;
        this.nombre = "";
        this.marca = "";
        this.modelo = "";
        this.tipo = (int) (Math.random()*4)+1;
        this.potenciaWatts = (float) (Math.random()*490)+10;
        this.compatibilidad = "";
    }

    public Componente(int id, String nombre, String marca, String modelo, int tipo, float potenciaWatts, String compatibilidad){
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potenciaWatts = potenciaWatts;
        this.compatibilidad = compatibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo > 0 && tipo < 5){
            this.tipo = tipo;
        }       
    }

    public float getPotenciaWatts() {
        return potenciaWatts;
    }

    public void setPotenciaWatts(float potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    @Override
    public String toString() {
        return "Componente:\n"
        + "*************************************************************\n"
        + "Id: " + id + "\n"
        + "Nombre: " + nombre + "\n"
        + "Marca: " + marca + "\n"
        + "Modelo: " + modelo + "\n"
        + "Tipo: " + tipo + "\n"
        + "Potencia: " + potenciaWatts + "\n"
        + "Compatibilidad: " + compatibilidad + "\n"
        + "*************************************************************\n";
    }

}
