package com.ejerciciorefuerzo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.ejerciciorefuerzo.model.Pais;

public class Main {
    public static void main(String[] args) {

        // Creación de objetos
        Pais espania = new Pais(1, "España", "Europa", 47000000);
        Pais francia = new Pais(2, "Francia", "Europa", 67000000);
        Pais alemania = new Pais(3, "Alemania", "Europa", 83000000);
        Pais japon = new Pais(4, "Japón", "Asia", 100000000);

        // Creamos nuevo arraylist vacío
        ArrayList<Pais> paises = new ArrayList<>();

        // Añadimos los países
        paises.add(espania);
        paises.add(francia);
        paises.add(alemania);
        paises.add(japon);
    

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

        //Llamada al método 5
        
        ordenarPorPoblacion(paises);
        System.out.println(paises);

        //Llama al método 6
        ejemploBasico();

        //LLamada al método 7
        System.out.println(contarPorContinente(paises));
        
        //Llamada al método 8
        System.out.println(agruparPorContinente(paises));

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

    public static void ejemploBasico(){

        //Crear HashMap (Clave, Valor)
        HashMap<String, Integer> ejemplo = new HashMap<>();

        //Añadir elementos
        ejemplo.put("España", 47000000);
        ejemplo.put("Francia", 67000000);
        ejemplo.put("Alemania", 83000000);

        //Obtener población Francia
        System.out.println("Población de Francia: " + ejemplo.get("Francia"));

        //Recorrer Map (foreach). Se recorre todo el Hashmap
        for (Map.Entry<String, Integer> entry : ejemplo.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    //Contar cuantas veces aparece cada continente en el Arraylist
    public static Map<String, Integer> contarPorContinente(ArrayList<Pais> lista){

        //Se crea HashMap vacío, que devolverá clave - valor (Continente - valor)
        Map<String, Integer> totalContinente = new HashMap<>();
        
        //Recorremos el Arraylist
        for(Pais pais : lista){
            //Buscamos el continente de cada país por iteración
            String continente = pais.getContinente();

            //Si el Hasmap no contiene la clave con el continente de la iteración
            //Se añade: continente (clave) = valor (1)
            if(!totalContinente.containsKey(continente)){
                totalContinente.put(continente, 1);
            }else{
                //Si lo tiene, se coje el valor actual, y se le suma 1
                int actual = totalContinente.get(continente);
                totalContinente.put(continente, actual + 1);
            }
        }

        return totalContinente;
    }

    //Devuelve un map con el Continente como clave, y con un ArrayList de paises como valor
    public static Map<String, ArrayList<Pais>> agruparPorContinente(ArrayList<Pais> lista){

        Map<String, ArrayList<Pais>> total = new HashMap<>();

        //Se recorre el Arraylist, y se obtiene el continente por iteración
        for (Pais pais : lista) {
            String continente = pais.getContinente();

            if(!total.containsKey(continente)){
                //Si no existe el continente, se añade el continente como clave
                //y se crea una nueva lista asociada como valor
                total.put(continente, new ArrayList<>());
            }
            
            //Obtiene la lista asociada a ese continente
            //y añade el país
            total.get(continente).add(pais);
        }

        return total;
    }
}