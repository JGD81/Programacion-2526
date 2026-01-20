package UNIDAD3.EjerciciosRefuerzo.Ejercicio2;

import java.util.ArrayList;

public class Competicion {
    private String codigoCompeticion;
    public String nombreEvento;
    private int numeroParticipantes;
    private ArrayList<MotoAcuatica> participantes;
    private String ubicacion;
    private double premioTotal;
    private boolean esInternacional;

    public Competicion(){
        this.codigoCompeticion = "";
        this.nombreEvento = "";
        this.numeroParticipantes = (int) (Math.random()*51);
        this.participantes = new ArrayList<>();
        this.ubicacion = "";
        this.premioTotal = 0.0;
        this.esInternacional = false;
    }

    public Competicion(String codigoCompeticion, String nombreEvento, ArrayList<MotoAcuatica> participantes, String ubicacion, double premioTotal, boolean esInternacional){
        this.codigoCompeticion = codigoCompeticion;
        this.nombreEvento = nombreEvento;
        this.participantes = (participantes != null) ? new ArrayList<>(participantes) : new ArrayList<>();
        //Importante: Se está utilizando el tamaño del atributo, no del parámetro
        this.numeroParticipantes = this.participantes.size();
        this.ubicacion = ubicacion;
        this.premioTotal = premioTotal;
        this.esInternacional = esInternacional;
    }

    public String getCodigoCompeticion() {
        return codigoCompeticion;
    }

    public void setCodigoCompeticion(String codigoCompeticion) {
        this.codigoCompeticion = codigoCompeticion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    //No se crea el set porque depende del tamaño del array participantes
    /*public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }*/

    public ArrayList<MotoAcuatica> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    public void setParticipantes(ArrayList<MotoAcuatica> participantes) {
        this.participantes = (participantes != null) ? new ArrayList<>(participantes) : new ArrayList<>();
        //numero de participantes depende del tamaño del Array, es por ello que hay que actualizarlo una vez creado
        this.numeroParticipantes = this.participantes.size();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(double premioTotal) {
        this.premioTotal = premioTotal;
    }

    public boolean isEsInternacional() {
        return esInternacional;
    }
    
    public void setEsInternacional(boolean esInternacional) {
        this.esInternacional = esInternacional;
    }

    public float calcularPotenciaMediaCategoria(int categoriaFiltro){
        float suma = 0;
        int totalMotos = 0;
        for(int i = 0; i < participantes.size(); i++){
            if(categoriaFiltro == participantes.get(i).getTipoCategoria()){
                suma = suma + participantes.get(i).getPotenciaCV();
                totalMotos ++; 
            }
        }
        if (totalMotos > 0){
            return suma / totalMotos;
        }
        return 0.0f;
    }

    public int contarMotosElectricasPorRangoPotencia(float minPotencia, float maxPotencia){
        if(minPotencia > maxPotencia){
            return 0;
        }
        int contador = 0;
        for(int i = 0; i < participantes.size(); i++){
            if (participantes.get(i).isEsElectrica() && (participantes.get(i).getPotenciaCV() >= minPotencia && participantes.get(i).getPotenciaCV() <= maxPotencia)) {
                contador++;
            }
        }
        
        return contador;
    }

    public ArrayList<MotoAcuatica> filtrarMotosPorCilindradaYModificacion(int minCilindrada, int maxCilindrada, String modificacionBuscada){
        // Validaciones según el enunciado:
        // - minCilindrada no puede ser negativa
        // - maxCilindrada no puede superar 3000
        // - maxCilindrada debe ser mayor o igual que minCilindrada
        if (minCilindrada < 0 || maxCilindrada > 3000 || maxCilindrada < minCilindrada){
            // Si alguna validación falla, se devuelve un ArrayList vacío
            return new ArrayList<MotoAcuatica>();
        }
        // ArrayList donde se guardarán las motos que cumplen las condiciones
        ArrayList<MotoAcuatica> resultado = new ArrayList<>();
         // Recorremos el ArrayList de participantes de la competición
        for(int i = 0; i < participantes.size(); i++){
            // Comprobamos que la cilindrada de la moto esté dentro del rango indicado
            if(minCilindrada <= participantes.get(i).getCilindrada() && maxCilindrada >= participantes.get(i).getCilindrada()){
                // Recorremos las modificaciones de la moto actual
                for(int j = 0; j < participantes.get(i).getModificaciones().size(); j++){
                    // Obtenemos la modificación actual y la pasamos a minúsculas
                    // para hacer la comparación insensible a mayúsculas/minúsculas
                    String modificacionActual = participantes.get(i).getModificaciones().get(j).toLowerCase();
                    // Comprobamos si la modificación contiene el texto buscado
                    if(modificacionActual.contains(modificacionBuscada.toLowerCase())){
                        // Si cumple todas las condiciones, añadimos la moto al resultado
                        resultado.add(participantes.get(i));
                        // Salimos del bucle de modificaciones para evitar duplicados
                        break;
                    }
                }
            }
        }
        // Devolvemos el ArrayList con las motos filtradas
        return resultado;
    }

    public int eliminarMoto(int idMotoEliminar){
        //Recorremos la lista de participantes
        for(int i = 0; i < participantes.size(); i++){
            //Obtenemos la id de la moto actual
            int idMoto = participantes.get(i).getIdMoto();
            //Comprobamos si el id de la moto coincide con el que queremos eliminar
            if(idMoto == idMotoEliminar){
                //Eliminamos la moto del ArrayList usando su índice
                participantes.remove(i);
                //Actualizamos el número de participantes tras la eliminación
                this.numeroParticipantes = participantes.size();
                //Devolvemos 0 indicando que la moto se ha eliminado correctamente
                return 0;
            }
        }
        //Si no se ha eliminado ninguna, devuelve -1
        return -1;
    }

    public String marcaMotoMasPotenteSinModificacion(String modificacionExcluida){
        //Si no hay participantes, no se puede encontrar ninguna moto
        if(participantes.size() == 0){
            return "No encontrada";
        }
        //Variable para almacenar la mayor potencia encontrada hasta el momento
        float potenciaMaxima = 0;
        //Variable para guardar la marca de la moto más potente que cumpla con la condición
        String marcaMasPotente = "";
        //Recorremos la lista de participantes (motos)
        for(int i = 0; i < participantes.size(); i++){
            //Indicador para saber si la moto actual tiene la modificación excluída
            boolean tieneModificacionExcluida= false;
            //Recorremos la lista de modificaciones de la moto actual
            for(int j = 0; j < participantes.get(i).getModificaciones().size(); j++){
                //Obtenemos la modificación actual en minúsculas
                String modificacionActual = participantes.get(i).getModificaciones().get(j).toLowerCase();
                //Comprobamos si la modificación contiene la excluída (sin distinguir mayus/minús)
                if(modificacionActual.contains(modificacionExcluida.toLowerCase())){
                    //Marcamos que la moto tiene la modificación excluída
                    tieneModificacionExcluida= true;
                    //Salimos del bucle de modificaciones porque ya no nos interesa esta moto
                    break;
                }
                
            }
            //Si la moto NO tiene la modificación excluída y su potencia es mayor a la máxima registrada
            if(!tieneModificacionExcluida && participantes.get(i).getPotenciaCV() > potenciaMaxima){
                //Actualizamos la marca de la moto más potente
                marcaMasPotente = participantes.get(i).getMarca();
                //Actualizamos la potencia máxima
                potenciaMaxima = participantes.get(i).getPotenciaCV();
            }
        }
        //Si no se ha encontrado ninguna moto válida
        if(marcaMasPotente.equals("")){
            return "No encontrada";
        }else{
            //Devolvemos la marca de la moto más potente sin la modificación excluída
            return marcaMasPotente;
        }
    }
}


