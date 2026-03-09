package com.examend.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {
    
    private int codigoBiblioteca;
    public String nombreBiblioteca;
    private String ciudad;
    private ArrayList<LibroBiblioteca> libros;
    private int numeroSocios;
    private boolean esPublica;

    public Biblioteca(){
        this.codigoBiblioteca = (int) (Math.random()*900)+100;
        this.nombreBiblioteca = "";
        this.ciudad = "";
        this.libros = new ArrayList<>();
        this.numeroSocios = 0;
        this.esPublica = false;
    }

    public Biblioteca(int codigoBiblioteca, String nombreBiblioteca, String ciudad, ArrayList<LibroBiblioteca> libros, boolean esPublica){
        this.codigoBiblioteca = codigoBiblioteca;
        this.nombreBiblioteca = nombreBiblioteca;
        this.ciudad = ciudad;
        this.libros = (libros != null ? libros :new ArrayList<>());
        this.numeroSocios = this.libros.size();
        this.esPublica = false;
    }

    public int getCodigoBiblioteca() {
        return codigoBiblioteca;
    }

    public void setCodigoBiblioteca(int codigoBiblioteca) {
        this.codigoBiblioteca = codigoBiblioteca;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<LibroBiblioteca> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<LibroBiblioteca> libros) {
        this.libros = libros;
    }

    public int getNumeroSocios() {
        return numeroSocios;
    }

    public boolean isEsPublica() {
        return esPublica;
    }

    public void setEsPublica(boolean esPublica) {
        this.esPublica = esPublica;
    }

    public double calcularPromedioPaginas(){

        /* 
        return libros.stream().mapToInt(p -> p.getNumeroPaginas()).average().orElse(0.0);
        */
        if(libros.size() == 0){
            return 0;
        }

        int suma = 0;

        for (LibroBiblioteca libroBiblioteca : libros) {
            suma += libroBiblioteca.getNumeroPaginas();
        }

        return (double) suma / libros.size(); 
    }

    public ArrayList<LibroBiblioteca> buscarLibrosPorAutor(String autor){

        /*ArrayList<LibroBiblioteca> resultado = new ArrayList<>();

        for (LibroBiblioteca libroBiblioteca : libros) {
            
            if(libroBiblioteca.getAutor().equalsIgnoreCase(autor)){
                resultado.add(libroBiblioteca);
            }  
        }

        return resultado;*/

        return new ArrayList<>(libros.stream().filter(p -> p.getAutor().equalsIgnoreCase(autor)).toList());
    }

    public int contarLibrosDigitales(){

        return (int) libros.stream().filter(p -> p.isEsDigital()).count();
    }

    public boolean eliminarLibrosPorTipo(int tipoEliminar){
        
        return libros.removeIf(p -> p.getTipoLibro() == tipoEliminar);
    }

    public String obtenerTitulosLibros(){
        
        if(libros.size() == 0){

            return "No hay libros";
        }


        return libros.stream().map(p -> p.getTitulo()).collect(Collectors.joining(", "));
    }

    public ArrayList<LibroBiblioteca> buscarLibrosPorTema(String tema){

    /*ArrayList<LibroBiblioteca> resultado = new ArrayList<>();

    for (LibroBiblioteca libro : libros) {

        for (String t : libro.getTemas()) {

            if(t.equalsIgnoreCase(tema)){
                resultado.add(libro);
                break;
            }

        }
    }

    return resultado;*/
        
    return new ArrayList<>(libros.stream().filter(p -> p.getTemas().stream().anyMatch(j -> j.equalsIgnoreCase(tema))).toList());
    }


}
