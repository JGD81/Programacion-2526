package UNIDAD3.EjerciciosRefuerzo.Ejercicio1;

public class Destino {
    private int idDestino;
    private String nombre;
    private float precioMedio;
    private String tipoDestino;
    private boolean requiereVisado;
    private int temporadaIdeal;
    private String atraccionesTuristicas;
    // Constantes para evitar usar números mágicos
    public static final int TEMPORADA_BAJA = 1;
    public static final int TEMPORADA_MEDIA = 2;
    public static final int TEMPORADA_ALTA = 3;
    // Constructor vacío
    // Genera valores aleatorios para idDestino, precioMedio y temporadaIdeal
    // El resto de campos se inicializan con valores por defecto
    public Destino(){
        this.idDestino = (int) (Math.random()*1000) + 1;
        this.nombre = "";
        this.precioMedio = (float) (Math.random()*270) + 30;
        this.tipoDestino = "";
        this.requiereVisado = false;
        this.temporadaIdeal = (int) (Math.random()*3) +1;
        this.atraccionesTuristicas = "";
    }
    // Constructor completo
    // El idDestino se genera automáticamente
    // La temporadaIdeal se asigna usando el setter para reutilizar la validación
    public Destino(String nombre, float precioMedio, String tipoDestino, boolean requiereVisado, int temporadaIdeal, String atraccionesTuristicas){
        this.idDestino = (int) (Math.random()*1000) + 1;
        this.nombre = nombre;
        this.precioMedio = precioMedio;
        this.tipoDestino = tipoDestino;
        this.requiereVisado = requiereVisado;
        // Se usa el setter para asegurar que la temporada esté dentro de los valores válidos
        this.setTemporadaIdeal(temporadaIdeal);
        this.atraccionesTuristicas = atraccionesTuristicas;
    }
    //Setters y getters
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioMedio() {
        return precioMedio;
    }

    public void setPrecioMedio(float precioMedio) {
        this.precioMedio = precioMedio;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public boolean isRequiereVisado() {
        return requiereVisado;
    }

    public void setRequiereVisado(boolean requiereVisado) {
        this.requiereVisado = requiereVisado;
    }
    public int getTemporadaIdeal() {
        return temporadaIdeal;
    }
    // Setter con validación para evitar valores incorrectos de temporada
    public void setTemporadaIdeal(int temporadaIdeal) {
        if(temporadaIdeal >=1 && temporadaIdeal <=3){
            this.temporadaIdeal = temporadaIdeal;
        }else{
            this.temporadaIdeal = 1;
        } 
    }

    public String getAtraccionesTuristicas() {
        return atraccionesTuristicas;
    }

    public void setAtraccionesTuristicas(String atraccionesTuristicas) {
        this.atraccionesTuristicas = atraccionesTuristicas;
    }

    public String temporadaIdealTexto(){
        switch (temporadaIdeal) {
            case TEMPORADA_BAJA:
                return "Temporada baja";
            case TEMPORADA_MEDIA:
                return "Temporada media";
            case TEMPORADA_ALTA:
                return "Temporada alta";
            default:
                return "Temporada desconocida";
        }
    }

    @Override
    public String toString() {
        return "====================DESTINO====================\n"
        + "ID destino: " + idDestino + "\n" 
        + "Nombre: " + nombre + "\n"
        + "Precio medio por día: " + precioMedio + "\n"
        + "Tipo de destino: " + tipoDestino + "\n"
        + "Requiere visado?: " + (requiereVisado ? "Si" : "No") + "\n"
        + "Temporada ideal: " + temporadaIdealTexto() + "\n"
        + "Atracciones turísticas: " + atraccionesTuristicas; 
    }
}
