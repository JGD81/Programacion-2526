package UNIDAD3.EjerciciosRefuerzo.Ejercicio3;

public class Ciclista {
    private int idCiclista;
    private String nombreCiclista;
    private int edad;
    private String modeloBici;
    private float peso;
    private int posicion;
    private int especialidad;
    public static final int MONTANIA = 1;
    public static final int CONTRARELOJ = 2;
    public static final int TODOTERRENO = 3;

    public Ciclista(){
        this.idCiclista = (int) (Math.random()*50)+1;
        this.nombreCiclista = "";
        this.edad = (int) (Math.random()*30)+18;
        this.modeloBici = "";
        this.peso = (float) (Math.random()*40)+40;
        this.posicion = (int) (Math.random()*100)+1;
        this.especialidad = (int) (Math.random()*3)+1;
    }

    public Ciclista(int idCiclista, String nombreCiclista, int edad, String modeloBici, float peso, int posicion, int especialidad){
        this.idCiclista = idCiclista;
        this.nombreCiclista = nombreCiclista;
        this.edad = edad;
        this.modeloBici = modeloBici;
        this.peso = peso;
        this.posicion = posicion;
        this.especialidad = especialidad;
    }

    public int getIdCiclista() {
        return idCiclista;
    }

    public void setIdCiclista(int idCiclista) {
        this.idCiclista = idCiclista;
    }

    public String getNombreCiclista() {
        return nombreCiclista;
    }

    public void setNombreCiclista(String nombreCiclista) {
        this.nombreCiclista = nombreCiclista;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getModeloBici() {
        return modeloBici;
    }

    public void setModeloBici(String modeloBici) {
        this.modeloBici = modeloBici;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        if(especialidad > 0 && especialidad < 4){
            this.especialidad = especialidad;
        }  
    }

    public String especialidadATexto(){
        switch (especialidad) {
            case MONTANIA:
                return "Montaña";
            case CONTRARELOJ:
                return "Contrareloj";
            case TODOTERRENO:
                return "Todoterreno";
            default:
                return "Especialidad desconocida";
        }
    }

    @Override
    public String toString() {
        return "Ciclista: \n"
        + "*************************************************************\n"
        + "Nombre: " + nombreCiclista + "\n"
        + "Edad: " + edad + "\n"
        + "Modelo Bici: " + modeloBici + "\n"
        + "Peso: " + peso + "\n"
        + "Posición: " + posicion + "\n"
        + "Especialidad: " + especialidadATexto() + "\n"
        + "*************************************************************";
    }
}
