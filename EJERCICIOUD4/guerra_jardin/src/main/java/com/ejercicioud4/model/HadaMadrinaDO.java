package com.ejercicioud4.model;

public class HadaMadrinaDO {

    private int idHadaMadrina;
    private String nombre;
    private String apodoGuerra;
    private int edad;
    private int envergaduraAlas;
    private int nivelPasivoAgresividad;
    private int polvoPurpurina;

    public HadaMadrinaDO(int idHadaMadrina, String nombre, String apodoGuerra, int edad, int envergaduraAlas,
            int nivelPasivoAgresividad, int polvoPurpurina) {

        this.idHadaMadrina = idHadaMadrina;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.edad = edad;
        this.envergaduraAlas = envergaduraAlas;
        this.nivelPasivoAgresividad = nivelPasivoAgresividad;
        this.polvoPurpurina = polvoPurpurina;
    }

    public int getIdHadaMadrina() {
        return idHadaMadrina;
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

    public int getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    public int getNivelPasivoAgresividad() {
        return nivelPasivoAgresividad;
    }

    public int getPolvoPurpurina() {
        return polvoPurpurina;
    }

    @Override
    public String toString() {

        return "HadaMadrinaDO{" +
                "id=" + idHadaMadrina +
                ", nombre='" + nombre + '\'' +
                ", apodoGuerra=" + apodoGuerra +
                ", edad=" + edad +
                ", envergaduraAlas=" + envergaduraAlas +
                ", nivelPasivoAgresividad=" + nivelPasivoAgresividad +
                ", polvoPurpurina=" + polvoPurpurina +
                '}';
    }

}
