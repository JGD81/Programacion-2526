package com.ejerciciorefuerzo.model;

public class Pais {
    // Atributos
    private int id;
    private String nombre;
    private String continente;
    private long poblacion;

    // Constructor vacío
    public Pais() {

    }

    // Constructor con atributos
    public Pais(int id, String nombre, String continente, long poblacion) {

        this.id = id;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;

    }

    // Getters y setters
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

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {

        return "Pais{id=" + id +
                ", nombre='" + nombre +
                "', continente='" + continente +
                "', poblacion=" + poblacion + "}";
    }
   
}
