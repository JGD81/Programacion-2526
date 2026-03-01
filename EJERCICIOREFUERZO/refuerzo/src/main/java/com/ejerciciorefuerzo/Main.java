package com.ejerciciorefuerzo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import com.ejerciciorefuerzo.model.Pais;

public class Main {
    public static void main(String[] args) {

        // Creación de objetos
        Pais espania = new Pais(1, "España", "Europa", 47000000);
        Pais francia = new Pais(2, "Francia", "Europa", 67000000);
        Pais alemania = new Pais(3, "Alemania", "Europa", 83000000);

        // Creamos nuevo arraylist vacío
        ArrayList<Pais> paises = new ArrayList<>();

        // Añadimos los países
        paises.add(espania);
        paises.add(francia);
        paises.add(alemania);

        // Recorrer Arraylist
        for (int i = 0; i < paises.size(); i++) {
            System.out.println("Pais: " + paises.get(i));
        }

        for (Pais pais : paises) {
            System.out.println(pais);
        }

        // Llamada al método 1
        System.out.println(poblacionTotal(paises));

        // Llamada al método 2
        System.out.println(paisMasPoblado(paises));

        // Llamada al método 3
        ArrayList<Pais> europeos = filtrarPorContinente(paises, "Europa");

        for (Pais p : europeos) {
            System.out.println(p);
        }

        // Llamada al método 4
        Pais resultado = buscarPorNombre(paises, "Francia");

        if (resultado != null) {
            System.out.println("Encontrado: " + resultado);
        } else {
            System.out.println("No existe ese país.");
        }

        //Llamada al método 4
        
        ordenarPorPoblacion(paises);
        System.out.println(paises);

    }

    // Método suma la población total de todos los países
    public static long poblacionTotal(ArrayList<Pais> lista) {

        long total = 0;

        for (Pais pais : lista) {
            total += pais.getPoblacion();
        }

        return total;
    }

    // Método que obtiene el país más poblado
    public static Pais paisMasPoblado(ArrayList<Pais> lista) {

        if (lista.isEmpty()) {
            return null;
        }

        Pais mayor = lista.get(0);

        for (Pais pais : lista) {

            if (pais.getPoblacion() > mayor.getPoblacion()) {

                mayor = pais;
            }
        }

        return mayor;
    }

    //Método que busca por continente
    public static ArrayList<Pais> filtrarPorContinente(ArrayList<Pais> lista, String continente) {

        ArrayList<Pais> filtroContinente = new ArrayList<>();

        for (Pais pais : lista) {

            if (pais.getContinente().equalsIgnoreCase(continente)) {

                filtroContinente.add(pais);
            }

        }

        return filtroContinente;
    }

    //Método que busca por nombre del país
    public static Pais buscarPorNombre(ArrayList<Pais> lista, String nombre) {

        for (Pais pais : lista) {

            if (pais.getNombre().equalsIgnoreCase(nombre)) {
                return pais;
            }
        }

        return null;
    }

    public static ArrayList<Pais> paisesConMasDe(ArrayList<Pais> lista, long poblacionMinima){

        ArrayList<Pais> resultado = new ArrayList<>();

        for (Pais pais : lista) {

            if (pais.getPoblacion() > poblacionMinima){
                resultado.add(pais);
            }
            
        }

        return resultado;
    }

    //Método que ordena los paises por población
    public static void ordenarPorPoblacion(ArrayList<Pais> lista){
        //Método predefinido para comparar valores
        lista.sort(Comparator.comparingLong(Pais::getPoblacion).reversed());
    }

    //Cuenta cuántos países hay de un continente determinado
    public static Map<String, Integer> contarPorContinente(ArrayList<Pais> lista){

    }
}