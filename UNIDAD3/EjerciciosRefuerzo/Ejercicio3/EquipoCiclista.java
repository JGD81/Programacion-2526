package UNIDAD3.EjerciciosRefuerzo.Ejercicio3;

import java.util.ArrayList;

public class EquipoCiclista {
    private String idEquipoCiclista;
    public String nombreEquipo;
    private int numeroCiclistas;
    private ArrayList<Ciclista> ciclistas;
    private String pais;

    public EquipoCiclista(){
        this.idEquipoCiclista = "";
        this.nombreEquipo = "";
        this.ciclistas = new ArrayList<>();
        this.numeroCiclistas = this.ciclistas.size();
        this.pais = "";
    }

    public EquipoCiclista(String idEquipoCiclista, String nombreEquipo, int numeroCiclistas, ArrayList<Ciclista> ciclistas, String pais){
        this.idEquipoCiclista = idEquipoCiclista;
        this.nombreEquipo = nombreEquipo;
        this.ciclistas = (ciclistas != null) ? new ArrayList<>(ciclistas) : new ArrayList<>();
        this.numeroCiclistas = this.ciclistas.size();
        this.pais = pais;
    }

    public String getIdEquipoCiclista() {
        return idEquipoCiclista;
    }

    public void setIdEquipoCiclista(String idEquipoCiclista) {
        this.idEquipoCiclista = idEquipoCiclista;
    }
    //Los getters y setters del nombre no son necesarios, pero lo pide el enunciado
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNumeroCiclistas() {
        return numeroCiclistas;
    }

    public void setNumeroCiclistas(int numeroCiclistas) {
        if(numeroCiclistas == this.ciclistas.size()){
            this.numeroCiclistas = this.ciclistas.size();
        } 
    }

    public ArrayList<Ciclista> getCiclistas() {
        return new ArrayList(ciclistas);
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = (ciclistas != null) ? new ArrayList<>(ciclistas) : new ArrayList<>();
        this.numeroCiclistas = this.ciclistas.size();
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    float calcularEdadPromedio(){
        if(ciclistas.size() == 0){
            return  0;
        }
        float sumaEdad = 0;
        for(int i = 0; i < ciclistas.size(); i++){
            sumaEdad += ciclistas.get(i).getEdad();
        }

        return sumaEdad / ciclistas.size();
    }

    int ciclistasPaisPorDebajoPeso(float pesoMaximo, String pais){
        int contador = 0;
        for (int i = 0; i < ciclistas.size(); i++){
            if(this.pais.equalsIgnoreCase(pais) && pesoMaximo >= ciclistas.get(i).getPeso()){
                contador ++;
            }
        }
        return contador;
    }

    ArrayList<Ciclista> ciclistasEspecialidadYRangoEdad(int especialidad, int edadMin, int edadMax){
        ArrayList<Ciclista> resultado = new ArrayList<>();
        if((edadMin < 0 || edadMin > 150) || (edadMax < 0 || edadMax > 150) || (edadMax < edadMin)){
            return new ArrayList<>();
        }

        if (especialidad < 1 || especialidad > 3){
            return new ArrayList<>();
        }

        for(int i = 0; i < ciclistas.size(); i++){
            if ((especialidad == ciclistas.get(i).getEspecialidad())
            && (ciclistas.get(i).getEdad() >= edadMin && ciclistas.get(i).getEdad() <= edadMax )){
                resultado.add(ciclistas.get(i));
            }   
        }
        return resultado;
    }

    int eliminarCiclista(int id){
        //Crear una variable para guardar el índice del ciclista
        //que coincida con el id introducido
        int indice = -1;
        //Recorremos el array ciclistas
        for(int i = 0; i < ciclistas.size();i++){
            //Buscamos que coindida con el id
            if (id == ciclistas.get(i).getIdCiclista()){
                //Si no hay coincidencias, se queda a -1, 
                //si hay coincidencia, se guarda el índice
                indice = i;
                //Solo puede haber un ciclista con un mismo id,
                //para evitar que siga recorriendo si lo encuentra,
                //rompemos el bucle
                break; 
            }
        }
        //Se retorna -1 si el índice no ha variado de valor
        if (indice == -1){
            return -1;
        }
        //Se crea un nuevo Arraylist con ciclistas, para hacer la copia
        //al Array principal
        ArrayList<Ciclista> nuevo = new ArrayList<>();
        //Recorremos el Array ciclistas y añadimos al array nuevo los 
        //ciclistas que no coinciden con el id del ciclista encontrado
        for(int i = 0; i < ciclistas.size();i++){
            if(i != indice){
                //Añadimos al ciclista a la nueva lista
                nuevo.add(ciclistas.get(i));
            }
        }
        //Actualizamos la lista de ciclistas a partir de la lista nueva
        this.ciclistas = nuevo;
        //Actualizamos el número de ciclistas con la nueva cantidad
        this.numeroCiclistas = ciclistas.size();
        //Devolvemos 0 porque se ha encontrado el ciclista y se ha eliminado
        return 0;
    }

    String determinarModeloDominante(String especialidad){
        //Se convierte el String de especialidad a todo en minúsucla
        //para poder realizar las comparaciones en el switch
        especialidad = especialidad.toLowerCase();
        // Variable donde guardaremos la especialidad en formato int
        //(las constantes definidas en la clase Ciclista)
        int especialidadBuscada = 0;
        // Guardará el modelo que más se repite (de momento aún no se asigna)
        String modeloDominante = null;
        // Guardará el mayor número de repeticiones encontradas
        int repeticiones = 0;
        // Convertimos la especialidad recibida como String
        // a su equivalente numérico (int)
        switch (especialidad) {
            case "montaña":
                especialidadBuscada = Ciclista.MONTANIA;
                break;
            case "contrareloj":
                especialidadBuscada = Ciclista.CONTRARELOJ;
                break;
            case "todoterreno":
                especialidadBuscada = Ciclista.TODOTERRENO;
                break;
            default: 
                return null;
            }

        for(int i = 0; i < ciclistas.size();i++){
            // Primer filtro:
            // Solo trabajamos con ciclistas cuya especialidad
            // coincide con la buscada
            if(especialidadBuscada == ciclistas.get(i).getEspecialidad()){
                // Contador de cuántas veces aparece un modelo concreto
                int contador = 0;
                // Guardamos el modelo de bici del ciclista actual
                String modeloActual = ciclistas.get(i).getModeloBici();
                // Segundo recorrido:
                // Volvemos a recorrer todos los ciclistas para contar
                // cuántos tienen ese mismo modelo
                for(int j = 0; j < ciclistas.size(); j++){
                    // Contamos solo si:
                    // 1. El modelo coincide con el modelo actual
                    // 2. La especialidad también coincide
                    if(ciclistas.get(j).getModeloBici().equals(modeloActual) && especialidadBuscada == ciclistas.get(j).getEspecialidad()){
                        contador++;
                    }
                }
                if(contador > repeticiones){
                    repeticiones = contador;
                    modeloDominante = modeloActual;
                }            
            }
        }
        return modeloDominante;
    }
    
}
