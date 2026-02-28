package com.ejercicioud4.model;

public class DuendeCombateDO {
    
    private int idDuendeCombate;
    private String nombre;
    private String apodoGuerra;
    private String modelo;
    private int agilidad;
    private int nivelSarcasmo;
    private int tiempoBrilloCegador;
    private int idHadaMadrina;

    public DuendeCombateDO(int idDuendeCombate, String nombre, String apodoGuerra, String modelo, 
        int agilidad, int nivelSarcasmo, int tiempoBrilloCegador, int idHadaMadrina){
        
        this.idDuendeCombate = idDuendeCombate;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.modelo = modelo;
        this.agilidad = agilidad;
        this.nivelSarcasmo = nivelSarcasmo;
        this.tiempoBrilloCegador = tiempoBrilloCegador;
        this.idHadaMadrina = idHadaMadrina;
    }

    public int getIdDuendeCombate() {
        return idDuendeCombate;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApodoGuerra() {
        return apodoGuerra;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getNivelSarcasmo() {
        return nivelSarcasmo;
    }

    public int getTiempoBrilloCegador() {
        return tiempoBrilloCegador;
    }

    public int getIdHadaMadrina() {
        return idHadaMadrina;
    }

    @Override
    public String toString() {
        
        return "DuendeCombateDO{" +
                "id=" + idDuendeCombate +
                ", nombre='" + nombre + '\'' +
                ", apodoGuerra=" + apodoGuerra +
                ", modelo" + modelo +
                ", agilidad=" + agilidad +
                ", nivelSarcasmo=" + nivelSarcasmo +
                ", tiempoBrilloCegador=" + tiempoBrilloCegador +
                ", idHadaMadrina=" + idHadaMadrina +
                '}';
    }
}
