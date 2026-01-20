package UNIDAD3.EjerciciosRefuerzo.Ejercicio1;

import java.util.ArrayList;

public class AgenciaViajes {
    private String codigo;
    public String nombre;
    private int numeroDestinos;
    private ArrayList<Destino> destinos;
    private String pais;
    private int anioFundacion;
    private boolean tieneWebReservas;
    // Constructor vacío
    // Inicializa la lista de destinos vacía
    // El número de destinos se genera aleatoriamente (aunque la lista esté vacía)
    public AgenciaViajes(){
        this.codigo = "";
        this.nombre = "";
        this.numeroDestinos = (int) (Math.random()*11);
        this.destinos = new ArrayList<>();
        this.pais = "";
        this.anioFundacion = 2000;
        this.tieneWebReservas = false;
    }
    // Constructor completo
    // Recibe una lista de destinos ya creada
    // Se hace una copia de la lista para evitar que se modifique desde fuera
    public AgenciaViajes(String codigo, String nombre, ArrayList<Destino> destinos, String pais, int anioFundacion, boolean tieneWebReservas){
        this.codigo = codigo;
        this.nombre = nombre;
        // Se crea una copia para proteger la lista interna de la agencia
        this.destinos = new ArrayList<>(destinos);
        this.numeroDestinos = destinos.size();
        this.pais = pais;
        this.anioFundacion = anioFundacion;
        this.tieneWebReservas = tieneWebReservas;
    }
    //Setters y getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDestinos() {
        return numeroDestinos;
    }

    public ArrayList<Destino> getDestinos() {
        return destinos;
    }
    
    public void setDestinos(ArrayList<Destino> destinos) {
        this.destinos = destinos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public boolean isTieneWebReservas() {
        return tieneWebReservas;
    }

    public void setTieneWebReservas(boolean tieneWebReservas) {
        this.tieneWebReservas = tieneWebReservas;
    }
    // Calcula el precio medio de todos los destinos de la agencia
    // Devuelve 0.0 si no hay destinos
    public float calcularPrecioMedioTotal(){
        //Inicializamos la variable para guardar la suma de precios
        float suma = 0;
        //Si no hay destinos, directamente se devuelve 0.0
        if(destinos.size() == 0){
            return 0.0f;
        }
        //Si hay destinos, se recorre el Array y se van guardando los precios
        for (int i = 0; i < destinos.size();i++){
                suma = suma + destinos.get(i).getPrecioMedio();
        }
        //Se retorna el precio medio
        return suma / destinos.size();
    }
    /*
    Cuenta cuántos destinos cumplen simultáneamente:
    - un tipo de destino concreto (por ejemplo "Playa" o "Ciudad")
    - un requisito de visado determinado (true o false)
    */
    public int contarDestinosPorTipoYVisado(String tipoBuscado, boolean necesitaVisado){
        //Inicializamos una variable que cuente los destinos
        int contador = 0;
        //Recorremos la lista de destinos
        for (int i = 0; i < destinos.size();i++){
            //Se coprueba:
            //- Si el tipo coincide con el tipo buscado (ignorando mayúsculas y minúsculas)
            //- Si el destino requiere visado (se comparan booleanos)
            //- Se suman los destinos que cumplan las condiciones
            if(destinos.get(i).getTipoDestino().equalsIgnoreCase(tipoBuscado) && destinos.get(i).isRequiereVisado() == necesitaVisado){
                contador ++;
            }      
        }
        //Se devuelve cuantos destinos cumplen las condiciones
        return contador;
    }
    //Filtra los destinos que cumplen:
    //- Una temporada ideal concreta
    //- Un precio medio dentro de un rango
    public ArrayList<Destino>filtrarDestinosPorTemporadaYPrecio(int temporadaFiltro, float minPrecio, float maxPrecio){
        //Se crea un ArrayList para guardar los destinos válidos
        ArrayList<Destino> filtro = new ArrayList<>();
       //Se recorre la lista de destinos de la agencia
        for (int i = 0; i < destinos.size();i++){
            //Se comprueba:
            //- Si la temporada ideal coincida con la temporada filtro
            //- El rango de precios
            if(destinos.get(i).getTemporadaIdeal() == temporadaFiltro && (destinos.get(i).getPrecioMedio() >= minPrecio && destinos.get(i).getPrecioMedio()<= maxPrecio)){
                //Se añade al Array los destinos que coinciden
                filtro.add(destinos.get(i));
            }      
        }
        //Se devuelve la lista resultante
        return filtro;
    }
    //Elimina un destino de la agencia a partir de su identificador
    int eliminarDestino(int idDestinoEliminar){
        //Se recorre la lista de destinos
        for (int i = 0; i <destinos.size();i++){
            //Se compara el id de cade destino con el id recibido
            if(destinos.get(i).getIdDestino() == idDestinoEliminar){
                //Si coincide, se elimina
                destinos.remove(i);
                //Se actualiza el número de destinos
                this.numeroDestinos = destinos.size();
                //Si se borra, se retorna 0
                return 0;
            }
        }
        //Si no se borra ninguno, se retorna -1
        return -1;
    }
    //Busca el destino más barato que contenga una atracción concreta
    String destinoMasBaratoConAtraccion(String atraccionBuscada){
        //Se inicia variable booleana para controlar si se encuentra algún destino
        boolean encontrado = false;
        //Se inicia variable para añadir el destino y poder devolverlo
        String nombreResultado = "";
        //Se añade un precio exagerado, para que guarde siempre uno más barato
        float precioMasBajo = 999999999;
        //Recorremos la lista de destinos
        for (int i = 0; i < destinos.size();i++){
            //Se buscan destinos que contengan atracciones turísticas (todas se pasan a minúsculas)
            if (destinos.get(i).getAtraccionesTuristicas().toLowerCase().contains(atraccionBuscada.toLowerCase())){
                //Se controla para condicional final
                encontrado = true;
                //Se compara el precioMedio con la variable precioMasBajo para ir guardando los precios más bajos
                if(destinos.get(i).getPrecioMedio() < precioMasBajo){
                    //Si es más bajo, se guarda el precio encontrado y el nombre del destino
                    precioMasBajo = destinos.get(i).getPrecioMedio();
                    nombreResultado = destinos.get(i).getNombre();
                }    
            }
        }
        //Condicional controlado por el booleano, para devolver un caso u otro
        if (encontrado){
            return nombreResultado;
        }else{
            return "No encontrado";
        }   
    }





}
