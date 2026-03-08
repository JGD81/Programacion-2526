package com.examenc.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
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
    public int eliminarCancionesConPocasReproducciones(int minimoReproducciones){

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

    //Devolver una lista con las topN canciones más reproducidas ordenadas e mayor a menor
    public ArrayList<CancionDigital> topCancionesMasReproducidas(int topNn){
        /*
        return new ArrayList<>(listaCanciones.stream()
        .sorted((p1, p2)->p2.getNumeroReproducciones() - p1.getNumeroReproducciones())
        .limit(topNn).toList());
        */
        return new ArrayList<>(listaCanciones.stream()
        .sorted(Comparator.comparingDouble(CancionDigital::getNumeroReproducciones)
        .reversed())
        .limit(topNn)
        .toList());

    }

    public ArrayList<CancionDigital> buscarCancionesPorArtista(String artista){
        /* 
        ArrayList<CancionDigital> cancionesDeArtista = new ArrayList<>();
        
        for (CancionDigital cancionDigital : listaCanciones) {
            
            if(cancionDigital.getArtista().equalsIgnoreCase(artista)){
                cancionesDeArtista.add(cancionDigital);
            }
        }
        
        return cancionesDeArtista;
        */
        return new ArrayList<>(listaCanciones.stream()
        .filter(p -> p.getArtista().equalsIgnoreCase(artista))
        .toList());
    }

    public ArrayList<String> obtenerTodasLasEtiquetas(){

        return new ArrayList<>(listaCanciones.stream()
        .flatMap(p -> p.getEtiquetas().stream())
        .distinct()
        .toList());
    }

    public long contarCancionesPorGenero(int genero){

        return (int) listaCanciones.stream()
        .filter(p -> p.getGeneroMusical() == genero)
        .count();
    }

    public CancionDigital obtenerCancionMasLarga(){

        return listaCanciones.stream()
        .max(Comparator.comparingInt(CancionDigital::getDuracionSegundos))
        .orElse(null);

    }

    public int obtenerDuracionTotalPlaylist(){

        return listaCanciones.stream()
        .mapToInt(p -> p.getDuracionSegundos())
        .sum();
    }
    
    public String obtenerTitulosCanciones(){

        return listaCanciones.stream().map(p -> p.getTitulo()).collect(Collectors.joining(", "));
    }
    

    public ArrayList<CancionDigital> obtenerCancionesExplicitOrdenadas(){

        return new ArrayList<>(listaCanciones.stream()
        .filter(p -> p.isEsExplicit())
        .sorted(Comparator.comparingDouble(CancionDigital::getPopularidad)
        .reversed())
        .toList());
    }

    public ArrayList<CancionDigital> topCancionesMasLargas(int n){

        return new ArrayList<>(listaCanciones.stream()
        .sorted(Comparator.comparingInt(CancionDigital::getDuracionSegundos).reversed())
        .limit(n)
        .toList());
    }

    
    public ArrayList<String> obtenerArtistas(){

        return new ArrayList<>(listaCanciones.stream()
        .map(CancionDigital::getArtista)
        .distinct()
        .toList());
    }


    public boolean hayCancionesExplicit(){

        return listaCanciones.stream()
        .anyMatch(p -> p.isEsExplicit());
    }

    public ArrayList<CancionDigital> buscarCancionesPorEtiqueta(String etiqueta){
        //OJO: FILTER CUANDO QUIERES FILTRAR CANCIONES SEGÚN ALGO DENTRO DE OTRA LISTA
        //FLATMAP: CUANDO QUIERES SACAR TODOS LOS ELEMENTOS DE UNA LISTA INTERNA
        return new ArrayList<>(listaCanciones.stream()
        .filter(p -> p.getEtiquetas().stream().anyMatch(j -> j.equalsIgnoreCase(etiqueta)))
        .toList());
    }
}
