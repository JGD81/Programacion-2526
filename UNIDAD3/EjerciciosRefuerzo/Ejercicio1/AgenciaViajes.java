package UNIDAD3.EjerciciosRefuerzo.Ejercicio1;

import java.util.ArrayList;

public class AgenciaViajes {
    private String codigo;
    public String nombre;
    private int numeroDestinos;
    private ArrayList<Destino> destinos;
    private String pais;
    private int anioFundacion;
    private boolean tieneWebReservas;

    public AgenciaViajes(){
        this.codigo = "";
        this.nombre = "";
        this.numeroDestinos = (int) (Math.random()*11);
        this.destinos = new ArrayList<>();
        this.pais = "";
        this.anioFundacion = 2000;
        this.tieneWebReservas = false;
    }

    public AgenciaViajes(String codigo, String nombre, ArrayList<Destino> destinos, String pais, int anioFundacion, boolean tieneWebReservas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.destinos = new ArrayList<>(destinos);
        this.numeroDestinos = destinos.size();
        this.pais = pais;
        this.anioFundacion = anioFundacion;
        this.tieneWebReservas = tieneWebReservas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDestinos() {
        return numeroDestinos;
    }

    public ArrayList<Destino> getDestinos() {
        return destinos;
    }
    
    public void setDestinos(ArrayList<Destino> destinos) {
        this.destinos = destinos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public boolean isTieneWebReservas() {
        return tieneWebReservas;
    }

    public void setTieneWebReservas(boolean tieneWebReservas) {
        this.tieneWebReservas = tieneWebReservas;
    }

    public float calcularPrecioMedioTotal(){
        float suma = 0;
        if(destinos.size() == 0){
            return 0.0f;
        }
        for (int i = 0; i < destinos.size();i++){
                suma = suma + destinos.get(i).getPrecioMedio();
        }
        return suma / destinos.size();
    }

    public int contarDestinosPorTipoYVisado(String tipoBuscado, boolean necesitaVisado){
        
        int contador = 0;

        for (int i = 0; i < destinos.size();i++){
            if(destinos.get(i).getTipoDestino().equalsIgnoreCase(tipoBuscado) && destinos.get(i).isRequiereVisado() == necesitaVisado){
                contador ++;
            }      
        }

        return contador;
    }

    public ArrayList<Destino>filtrarDestinosPorTemporadaYPrecio(int temporadaFiltro, float minPrecio, float maxPrecio){
        ArrayList<Destino> filtro = new ArrayList<>();
        for (int i = 0; i < destinos.size();i++){
            if(destinos.get(i).getTemporadaIdeal() == temporadaFiltro && (destinos.get(i).getPrecioMedio() >= minPrecio && destinos.get(i).getPrecioMedio()<= maxPrecio)){
                filtro.add(destinos.get(i));
            }      
        }
        return filtro;
    }





}
