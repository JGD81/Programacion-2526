package com.ejercicioud4.dao;

public class GnomoAnciano {
        //Atributos
    private int idGnomoAnciano;
    private String nombre;
    private String apodoGuerra;
    private int edad;
    private double alturaBarba;
    private int nivelCascarrabias;
    private int energiaRefunfunio;

    //Constructor vacío
    public GnomoAnciano(){

    }

    //Constructor completo
    public GnomoAnciano(int idGnomoAnciano, String nombre, String apodoGuerra, 
        int edad, double alturaBarba, int nivelCascarrabias, int energiaRefunfunio){
            this.idGnomoAnciano = idGnomoAnciano;
            this.nombre = nombre;
            this.apodoGuerra = apodoGuerra;
            this.edad = edad;
            this.alturaBarba = alturaBarba;
            this.nivelCascarrabias = nivelCascarrabias;
            this.energiaRefunfunio = energiaRefunfunio;
        }
    
    //Getters y setters
    public int getIdGnomoAnciano() {
        return idGnomoAnciano;
    }

    public void setIdGnomoAnciano(int idGnomoAnciano) {
        this.idGnomoAnciano = idGnomoAnciano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodoGuerra() {
        return apodoGuerra;
    }

    public void setApodoGuerra(String apodoGuerra) {
        this.apodoGuerra = apodoGuerra;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAlturaBarba() {
        return alturaBarba;
    }

    public void setAlturaBarba(double alturaBarba) {
        this.alturaBarba = alturaBarba;
    }

    public int getNivelCascarrabias() {
        return nivelCascarrabias;
    }

    public void setNivelCascarrabias(int nivelCascarrabias) {
        this.nivelCascarrabias = nivelCascarrabias;
    }

    public int getEnergiaRefunfunio() {
        return energiaRefunfunio;
    }

    public void setEnergiaRefunfunio(int energiaRefunfunio) {
        this.energiaRefunfunio = energiaRefunfunio;
    }

    //Mostrar resultados (también válido para debug)
    @Override
    public String toString(){
        return "GnomoAnciano{" +
                "idGnomoAnciano=" + idGnomoAnciano +
                ", nombre='" + nombre + '\'' +
                ", apodoGuerra='" + apodoGuerra + '\'' +
                ", edad=" + edad +
                ", alturaBarba=" + alturaBarba +
                ", nivelCascarrabias=" + nivelCascarrabias +
                ", energiaRefunfunio=" + energiaRefunfunio +
                '}';
    }
}
