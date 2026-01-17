package UNIDAD3.EjerciciosRefuerzo.Ejercicio2;

import java.util.ArrayList;

public class Competicion {
    private String codigoCompeticion;
    public String nombreEvento;
    private int numeroParticipantes;
    private ArrayList<MotoAcuatica> participantes;
    private String ubicacion;
    private double premioTotal;
    private boolean esInternacional;

    public Competicion(){
        this.codigoCompeticion = "";
        this.nombreEvento = "";
        this.numeroParticipantes = (int) (Math.random()*51);
        this.participantes = new ArrayList<>();
        this.ubicacion = "";
        this.premioTotal = 0.0;
        this.esInternacional = false;
    }

    public Competicion(String codigoCompeticion, String nombreEvento, ArrayList<MotoAcuatica> participantes, String ubicacion, double premioTotal, boolean esInternacional){
        this.codigoCompeticion = codigoCompeticion;
        this.nombreEvento = nombreEvento;
        this.participantes = (participantes != null) ? new ArrayList<>(participantes) : new ArrayList<>();
        //Importante: Se está utilizando el tamaño del atributo, no del parámetro
        this.numeroParticipantes = this.participantes.size();
        this.ubicacion = ubicacion;
        this.premioTotal = premioTotal;
        this.esInternacional = esInternacional;
    }

    public String getCodigoCompeticion() {
        return codigoCompeticion;
    }

    public void setCodigoCompeticion(String codigoCompeticion) {
        this.codigoCompeticion = codigoCompeticion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    //No se crea el set porque depende del tamaño del array participantes
    /*public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }*/

    public ArrayList<MotoAcuatica> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    public void setParticipantes(ArrayList<MotoAcuatica> participantes) {
        this.participantes = (participantes != null) ? new ArrayList<>(participantes) : new ArrayList<>();
        //numero de participantes depende del tamaño del Array, es por ello que hay que actualizarlo una vez creado
        this.numeroParticipantes = this.participantes.size();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(double premioTotal) {
        this.premioTotal = premioTotal;
    }

    public boolean isEsInternacional() {
        return esInternacional;
    }
    
    public void setEsInternacional(boolean esInternacional) {
        this.esInternacional = esInternacional;
    }

    public float calcularPotenciaMediaCategoria(int categoriaFiltro){
        float suma = 0;
        int totalMotos = 0;
        for(int i = 0; i < participantes.size(); i++){
            if(categoriaFiltro == participantes.get(i).getTipoCategoria()){
                suma = suma + participantes.get(i).getPotenciaCV();
                totalMotos ++; 
            }
        }
        if (totalMotos > 0){
            return suma / totalMotos;
        }
        return 0.0f;
    }

    


}


