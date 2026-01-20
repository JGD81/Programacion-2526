package UNIDAD3.EjerciciosRefuerzo.Ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Computadora {
    private String identificador;
    public String nombre;
    private int numeroComponentes;
    private ArrayList<Componente> componentes;
    private String tipo;

    public Computadora(){
        this.identificador = "";
        this.nombre = "";
        this.componentes = new ArrayList<>();
        this.numeroComponentes = this.componentes.size();
        this.tipo = "";
    }

    public Computadora(String identificador, String nombre, ArrayList<Componente> componentes, String tipo){
        this.identificador = identificador;
        this.nombre = nombre;
        this.componentes = (componentes != null) ? new ArrayList<>(componentes) : new ArrayList<>();
        this.numeroComponentes = this.componentes.size();
        this.tipo = tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroComponentes() {
        return numeroComponentes;
    }
    //No se utiliza porque se asigna según tamaño del ArrayList
    /*public void setNumeroComponentes(int numeroComponentes) {
        this.numeroComponentes = this.componentes.size();
    }*/

    public ArrayList<Componente> getComponentes() {
        return new ArrayList<>(componentes);
    }
    
    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = (componentes != null) ? new ArrayList<>(componentes) : new ArrayList<>();
    } 

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*float calcularPotenciaTotal(){
        float sumaPotencias = 0;
        for(int i = 0; i < componentes.size(); i++){
            sumaPotencias += componentes.get(i).getPotenciaWatts();
        }
        return sumaPotencias;
    }*/

    //Version stream
    float calcularPotenciaTotal(){
        double resultado = 0;
        //stream recorre el array, 
        // - mapToDouble: transforma cada elemento del stream en un double, no el ArrayList entero.
        //      - c: Cada elemento del Stream
        //      - ->: Se transforma en...
        //      - c.getPotenciaWatts() el valor numérico que extraes
        //      - sum(): suma de los elementos que extraes
        resultado = componentes.stream().mapToDouble(c -> c.getPotenciaWatts()).sum();
        return (float) resultado;
    }

    /*int componentesMarcaPorDebajoPotencia(String marca, float potenciaMax){
        int contador = 0;
        for (int i = 0; i < componentes.size(); i++){
            if (componentes.get(i).getPotenciaWatts() <= potenciaMax && componentes.get(i).getMarca().equalsIgnoreCase(marca)){
                contador ++;
            }
        }
        return contador;
    }*/

    //Version Stream
    int componentesMarcaPorDebajoPotencia(String marca, float potenciaMax){
        // Recorre el ArrayList con stream, filtra por condiciones,
        // y cuenta los true de la condición. Count devuelve long, por eso se
        // castea a int
        return (int) componentes.stream()
        .filter(c -> c.getPotenciaWatts() <= potenciaMax 
                && c.getMarca().equalsIgnoreCase(marca))
        .count();
    }
    /* 
    ArrayList<Componente> filtrarComponentesPorTipoYRango(String tipo, float minPotencia, float maxPotencia){
        //Creamos ArrayList que vamos a devolver en el método
        ArrayList<Componente> resultado = new ArrayList<>();
        //Variable para guardar el tipo (string) convertido a int
        int tipoBuscado = -1;
        //Hacemos validaciones de potencias, si no pasa las validaciones
        //devolvemos arraylist vacío
        if (minPotencia < 0
             || maxPotencia > 1000 
             || minPotencia >= maxPotencia){
                return resultado;
            }
        //Convertimos el tipo String a tipo int
        switch (tipo.toUpperCase()) {
            case "PROCESADOR":
                tipoBuscado = Componente.PROCESADOR;
                break;
            case "MEMORIA":
                tipoBuscado = Componente.MEMORIA;
                break;
            case "CPU":
                tipoBuscado = Componente.CPU;
                break;
            case "GRAFICA":
                tipoBuscado = Componente.GRAFICA;
                break;
            default:
                return resultado;
        }
        //Recorremos la lista y añadimos condicional con los requerimientos del filtro
        for (int i = 0; i < componentes.size(); i++){
            if((componentes.get(i).getTipo() == tipoBuscado) && (componentes.get(i).getPotenciaWatts() >= minPotencia && componentes.get(i).getPotenciaWatts() <= maxPotencia)){
                //Añadimos el componente (objeto) a la lista
                resultado.add(componentes.get(i));
            }
        }
        //Devolvemos arraylist de componentes que cumplen el filtro
        return resultado;
    }
    */
   ArrayList<Componente> filtrarComponentesPorTipoYRango(String tipo, float minPotencia, float maxPotencia){
        //Creamos ArrayList que vamos a devolver en el método
        ArrayList<Componente> resultado = new ArrayList<>();
        //Variable para guardar el tipo (string) convertido a int
        int tipoBuscado = -1;
        //Hacemos validaciones de potencias, si no pasa las validaciones
        //devolvemos arraylist vacío
        if (minPotencia < 0
             || maxPotencia > 1000 
             || minPotencia >= maxPotencia){
                return resultado;
            }
        //Convertimos el tipo String a tipo int
        switch (tipo.toUpperCase()) {
            case "PROCESADOR":
                tipoBuscado = Componente.PROCESADOR;
                break;
            case "MEMORIA":
                tipoBuscado = Componente.MEMORIA;
                break;
            case "CPU":
                tipoBuscado = Componente.CPU;
                break;
            case "GRAFICA":
                tipoBuscado = Componente.GRAFICA;
                break;
            default:
                return resultado;
        }
        //Guardamos en una variable local final, sino el lambda no puede usarla
        final int tipoFinal = tipoBuscado; 
        resultado = componentes.stream()
        .filter(c -> c.getTipo() == tipoFinal
        && c.getPotenciaWatts() >= minPotencia
        //Añadimos a ArrayList (devuelve lista) 
        && c.getPotenciaWatts() <= maxPotencia).collect(Collectors.toCollection(ArrayList::new));

        return resultado;
   }
   
   int eliminarComponente(int id) {
    // Recorremos el ArrayList
    for (int i = 0; i < componentes.size(); i++) {
        // Si encontramos el id
        if (componentes.get(i).getId() == id) {
            // Eliminamos el componente
            componentes.remove(i);
            // Actualizamos el número de componentes
            numeroComponentes = componentes.size();
            return 0; // eliminado correctamente
        }
    }
    // Si no se ha encontrado el componente
    return -1;
    }

    //Versión stream no recomendable para eliminar

    String modeloMasComunPorTipo(String tipo) {
    int tipoBuscado;

    // Convertimos el tipo String a constante
    switch (tipo.toUpperCase()) {
        case "PROCESADOR":
            tipoBuscado = Componente.PROCESADOR;
            break;
        case "MEMORIA":
            tipoBuscado = Componente.MEMORIA;
            break;
        case "CPU":
            tipoBuscado = Componente.CPU;
            break;
        case "GRAFICA":
            tipoBuscado = Componente.GRAFICA;
            break;
        default:
            return null;
    }

    // Mapa para contar modelos
    HashMap<String, Integer> contador = new HashMap<>();

    // Recorremos los componentes
    for (Componente c : componentes) {
        if (c.getTipo() == tipoBuscado) {
            String modelo = c.getModelo();
            contador.put(modelo, contador.getOrDefault(modelo, 0) + 1);
        }
    }

    // Si no hay modelos
    if (contador.isEmpty()) {
        return null;
    }

    // Buscamos el modelo con mayor frecuencia
    String modeloMasComun = null;
    int max = 0;

    for (String modelo : contador.keySet()) {
        int repeticiones = contador.get(modelo);
        if (repeticiones > max) {
            max = repeticiones;
            modeloMasComun = modelo;
        }
    }

    return modeloMasComun;
}

/*
//Versión stream
String modeloMasComunPorTipoStream(String tipo) {
    int tipoBuscado;

    // Convertimos el tipo String a constante
    switch (tipo.toUpperCase()) {
        case "PROCESADOR":
            tipoBuscado = Componente.PROCESADOR;
            break;
        case "MEMORIA":
            tipoBuscado = Componente.MEMORIA;
            break;
        case "CPU":
            tipoBuscado = Componente.CPU;
            break;
        case "GRAFICA":
            tipoBuscado = Componente.GRAFICA;
            break;
        default:
            return null;
    }

    // Filtramos por tipo, agrupamos por modelo y contamos
    return componentes.stream()
        .filter(c -> c.getTipo() == tipoBuscado)
        .collect(
            Collectors.groupingBy(
                Componente::getModelo,
                Collectors.counting()
            )
        )
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
}
*/


}
