package com.examenc.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlaylistStreaming {
    
    private int idPlaylist;
    public String nombrePlaylist;
    private ArrayList<CancionDigital> listaCanciones;
    private String creador;
    private int seguidores;
    private boolean esColaborativa;
    private int duracionTotalSegundos;

    public PlaylistStreaming(){

        this.idPlaylist = (int) (Math.random()*900)+100;
        this.nombrePlaylist = "";
        this.listaCanciones = new ArrayList<>();
        this.creador = "";
        this.seguidores = (int) (Math.random()*50001);
        this.esColaborativa = false;
        this.duracionTotalSegundos = 0;
    }

    public PlaylistStreaming(int idPlaylist, String nombrePlaylist, ArrayList<CancionDigital> listaCanciones, String creador, boolean esColaborativa, int duracionTotalSegundos){
        
        this.idPlaylist = idPlaylist;
        this.nombrePlaylist = nombrePlaylist;
        this.listaCanciones = (listaCanciones != null) ? listaCanciones : new ArrayList<>();
        this.creador = creador;
        this.seguidores = listaCanciones.size() * 100;
        this.esColaborativa = esColaborativa;
        this.duracionTotalSegundos = duracionTotalSegundos;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public ArrayList<CancionDigital> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<CancionDigital> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public boolean isEsColaborativa() {
        return esColaborativa;
    }

    public void setEsColaborativa(boolean esColaborativa) {
        this.esColaborativa = esColaborativa;
    }

    public int getDuracionTotalSegundos() {
        return duracionTotalSegundos;
    }

    public void setDuracionTotalSegundos(int duracionTotalSegundos) {
        this.duracionTotalSegundos = duracionTotalSegundos;
    }

    //Calcula la duración media en segundos de las canciones de la playlist
    //Si no hay canciones, devuelve 0.0

    public double calcularDuracionPromedioCanciones(){

        /*//Por bucle  
        //Comprobamos si hay canciones en la lista
        if (listaCanciones.size() == 0){
            return 0.0;
        }
        
        //Variable para acumular los segundos
        int totalSegundos = 0;

        //For para sumar los segundos de cada canción de la lista de canciones
        for (CancionDigital cancionDigital : listaCanciones) {
            totalSegundos += cancionDigital.getDuracionSegundos();
        }

        //Sacar la media de la duración
        return (double) totalSegundos / listaCanciones.size();*/
        
        //Stream
        return listaCanciones.stream().mapToInt(p -> p.getDuracionSegundos()).average().orElse(0.0);
        
    }

    public ArrayList<CancionDigital> buscarCancionesPorGeneroYPopularidad(int genero, double min, double max){
        /*
        ArrayList<CancionDigital> cancionesPorGeneroyPopularidad = new ArrayList<>();

        if(min < 0 || max > 10 || min > max){

            return cancionesPorGeneroyPopularidad;
        }
         
        for (CancionDigital cancionDigital : listaCanciones) {
        
            if(cancionDigital.getGeneroMusical() == genero && (cancionDigital.getPopularidad() >= min && cancionDigital.getPopularidad() <= max)){
                cancionesPorGeneroyPopularidad.add(cancionDigital);
            }
        }

        return cancionesPorGeneroyPopularidad;
        */

        //Stream
        if(min < 0 || max > 10 || min > max){

            return new ArrayList<>();
        }

        return new ArrayList<>(listaCanciones.stream().filter(p -> p.getGeneroMusical() == genero)
        .filter(j -> j.getPopularidad() >= min && j.getPopularidad() <= max)
        .toList());
    }

    //Contar canciones explícitas
    public long contarCancionesExplicit(){
        /* 
        //Con bucles
        int contador = 0;

        for (CancionDigital cancionDigital : listaCanciones) {
            if (cancionDigital.isEsExplicit()){
                contador ++;
            }
        }

        return contador;
        */
        return listaCanciones.stream().filter(p -> p.isEsExplicit()).count();
    }

    //Eliminar canciones de la lista que sea menor que el minimoReproducciones
    int eliminarCancionesConPocasReproducciones(int minimoReproducciones){

        /*int contador = 0;

        //Con for clásico
        for (int i = 0; i<listaCanciones.size();i++){
            if(listaCanciones.get(i).getNumeroReproducciones() < minimoReproducciones){
                listaCanciones.remove(i);
                i--;//retrocede porque se elimina una canción y se cambian de posición
            }
        }
        return contador;*/

        //Con removeIF
        int tamañoInicial = listaCanciones.size();

        listaCanciones.removeIf(c -> c.getNumeroReproducciones() < minimoReproducciones);

        return tamañoInicial - listaCanciones.size();
    }

    //Canción digital con más popularidad
    public CancionDigital obtenerCancionMasPopular(){

        return listaCanciones.stream()
        .max(Comparator.comparingDouble(CancionDigital::getPopularidad)
        .thenComparingInt(CancionDigital::getNumeroReproducciones))
        .orElse(null);
    }







}
