package UNIDAD3.EjerciciosRefuerzo.Ejercicio2;

import java.util.ArrayList;

public class MotoAcuatica {
    private int idMoto;
    public String marca;
    private String modelo;
    private int cilindrada;
    private float potenciaCV;
    private int tipoCategoria;
    private boolean esElectrica;
    private ArrayList<String> modificaciones;
    public static final int CATEGORIA_PRINCIPIANTE = 1;
    public static final int CATEGORIA_AMATEUR =  2;
    public static final int CATEGORIA_PROFESIONAL = 3;

    public MotoAcuatica(){
        this.idMoto = (int) (Math.random()*8999) + 1000;
        this.marca = "";
        this.modelo = "";
        this.cilindrada = (int) (Math.random()*1100)+700;
        this.potenciaCV = (float) (Math.random()*220) + 90;
        this.tipoCategoria = (int) (Math.random()*3)+1;
        this.esElectrica = false;
        this.modificaciones = new ArrayList<>();
    }

    public MotoAcuatica(String marca, String modelo, int cilindrada, float potenciaCV, int tipoCategoria, boolean esElectrica, ArrayList<String>modificaciones){
        this.idMoto = (int) (Math.random()*8999) + 1000;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.potenciaCV = potenciaCV;
        this.tipoCategoria = tipoCategoria;
        this.esElectrica = esElectrica;
        //Evitamos error en el caso de que se pase null como modificadores (NullPointerException)
        this.modificaciones = (modificaciones !=null) ? new ArrayList<>(modificaciones) : new ArrayList<>();
    }

    public int getIdMoto() {
        return idMoto;
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

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(float potenciaCV) {
        this.potenciaCV = potenciaCV;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        if(tipoCategoria > 0 && tipoCategoria < 4){
            this.tipoCategoria = tipoCategoria;
        }   
    }

    public boolean isEsElectrica() {
        return esElectrica;
    }

    public void setEsElectrica(boolean esElectrica) {
        this.esElectrica = esElectrica;
    }

    public ArrayList<String> getModificaciones() {
        //Copia y crea un nuevo ArrayList para proteger el estado interno del objeto
        return new ArrayList<>(modificaciones);
    }

    public void setModificaciones(ArrayList<String> modificaciones) {
        //Evitamos error en el caso de que se pase null como modificadores (NullPointerException)
        this.modificaciones = (modificaciones !=null) ? new ArrayList<>(modificaciones) : new ArrayList<>();   
    }

    public String categoriaATexto(){
        switch (tipoCategoria) {
            case CATEGORIA_PRINCIPIANTE:
                return "Categoría Principiante";
            case CATEGORIA_AMATEUR:
                return "Categoría amateur";
            case CATEGORIA_PROFESIONAL:
                return "Categoría profesional";
            default:
                return "Categoría desconocida";
        }
    }

    @Override
    public String toString() {
        
        return "====================MOTO ACUÁTICA====================\n"
        + "ID Moto: " + idMoto + "\n"
        + "Marca: " + marca + " - " + "Modelo: " + modelo +"\n"
        + "Cilindrada: " + cilindrada + " CC\n"
        + "Potencia: " + potenciaCV + " CV\n"
        + "Categoría: " + categoriaATexto() + "\n"
        + "Eléctrica: " + (esElectrica ? "Sí" : "No") + "\n"
        + "Modificaciones: " + modificaciones; 
    }
}
