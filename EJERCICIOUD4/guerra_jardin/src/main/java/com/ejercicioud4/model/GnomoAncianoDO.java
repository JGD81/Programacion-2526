package com.ejercicioud4.model;

public class GnomoAncianoDO {

    // Atributos
    private int idGnomoAnciano;
    private String nombre;
    private String apodoGuerra;
    private int edad;
    private double alturaBarba;
    private int nivelCascarrabias;
    private int energiaRefunfunio;

    public GnomoAncianoDO(int idGnomoAnciano, String nombre, String apodoGuerra, int edad,
            double alturaBarba, int nivelCascarrabias, int energiaRefunfunio) {

        this.idGnomoAnciano = idGnomoAnciano;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.edad = edad;
        this.alturaBarba = alturaBarba;
        this.nivelCascarrabias = nivelCascarrabias;
        this.energiaRefunfunio = energiaRefunfunio;
    }

    public int getIdGnomoAnciano() {
        return idGnomoAnciano;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApodoGuerra() {
        return apodoGuerra;
    }

    public int getEdad() {
        return edad;
    }

    public double getAlturaBarba() {
        return alturaBarba;
    }

    public int getNivelCascarrabias() {
        return nivelCascarrabias;
    }

    public int getEnergiaRefunfunio() {
        return energiaRefunfunio;
    }

    

}
