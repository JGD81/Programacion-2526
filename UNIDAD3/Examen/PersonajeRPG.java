package UNIDAD3.Examen;

import java.util.ArrayList;

//José García Díaz

/*Realizar las siguientes clases en java:
1. Clase PersonajeRPG.java (1,5 puntos)
Atributos:
idPersonaje: Identificador único del personaje.
nombrePersonaje: Nombre del personaje (Ej: "ThunderBlade", "MysticShadow").
clasePersonaje: Clase del personaje. Crear constantes estáticas:
CLASE_GUERRERO = 1
CLASE_MAGO = 2
CLASE_ARQUERO = 3
CLASE_ASESINO = 4
nivel: Nivel actual del personaje (entre 1 y 100).
puntosVida: Puntos de vida máximos.
puntosDanio: Daño base del personaje.
esLegendario: Indica si el personaje tiene estatus legendario.
habilidades: Cadena con las habilidades especiales separadas por comas (Ej: "Golpe crítico,Invisibilidad,Teletransporte"). Puede hacerse como un ArrayList o array de Strings a preferencia del alumno.
guildName: Nombre del gremio al que pertenece (puede estar vacío si no tiene gremio).
Requisitos:
Todos los atributos deben ser privados excepto nombrePersonaje que es público.
Métodos get/set para cada atributo privado.
Constructores:
Vacío: Genera idPersonaje aleatorio (entre 10000 y 99999), nivel aleatorio (entre 1 y 50), puntosVida aleatorio (entre 1000 y 5000), puntosDanio aleatorio (entre 50.0 y 250.0). nombrePersonaje y guildName como cadenas vacías, habilidades vacío. esLegendario a false. clasePersonaje aleatorio entre los valores de las constantes.
Completo: Recibe todos los parámetros (excepto el idPersonaje que se auto genera aleatoriamente como en el constructor vacío) y los asigna.
Método toString():
Devolverá una cadena formateada con los contenidos de los atributos de la clase de la siguiente manera:
=== PERSONAJE RPG ===
-> ID: <idPersonaje>
-> Nombre: <nombrePersonaje>
-> Clase: <Guerrero/Mago/Arquero/Asesino - según el valor numérico>
-> Nivel: <nivel>
-> Vida: <puntosVida> HP
-> Daño: <puntosDanio>
-> Legendario: <Sí/No>
-> Gremio: <guildName o "Sin gremio" si está vacío>
-> Habilidades: <habilidades>
=====================
2. Clase TorneoEsports.java (1,5 puntos)
Atributos:
codigoTorneo: Código único del torneo. Puede contener letras y números.
nombreTorneo: Nombre del torneo.
jugadoresRegistrados: Cantidad de personajes inscritos en el torneo.
listaJugadores (ArrayList o Array de PersonajeRPG): Colección de los personajes participantes.
servidorRegion: Servidor/región donde se celebra (Ej: "EU-West", "NA-East", "Asia-Pacific").
poolPremios: Bolsa de premios total en monedas del juego.
requiereNivelMinimo: Nivel mínimo requerido para participar.
esRanked: Indica si el torneo afecta al ranking competitivo.
Requisitos:
Todos los atributos privados excepto nombreTorneo.
Métodos get/set para cada atributo.
Constructores:
Vacío: Genera jugadoresRegistrados aleatorio (entre 0 y 100). codigoTorneo, servidorRegion como cadena vacía. poolPremios a 0, requiereNivelMinimo a 1 y esRanked a false. El ArrayList listaJugadores se inicializa vacío.
Completo: Recibe todos los parámetros menos jugadoresRegistrados (incluyendo un ArrayList<PersonajeRPG>). jugadoresRegistrados se debe calcular a partir del tamaño del ArrayList recibido.
Funciones en TorneoEsports.java:
a) double calcularDanioPromedioClase(int claseFiltro) (1 punto)
Calcula el daño promedio (puntosDanio) de todos los personajes que pertenecen a la clase especificada.
Devuelve 0.0 si no hay personajes de esa clase o si el torneo no tiene participantes.
b) int contarPersonajesLegendariosConHabilidad(String habilidadBuscada) [OBLIGATORIO USAR STREAMS](1 punto)
Cuenta cuántos personajes legendarios poseen la habilidad especificada en su lista de habilidades (búsqueda insensible a mayúsculas/minúsculas).
c) ArrayList<PersonajeRPG> obtenerTopPersonajesPorVida(int topN) (1,5 puntos) 
Devuelve un ArrayList con los topN personajes con más puntos de vida, ordenados de mayor a menor.
Si topN es mayor que el número de participantes, devuelve todos los participantes ordenados.
Si topN ≤ 0, devuelve un ArrayList vacío.
d) PersonajeRPG buscarPersonajeMasFuerteDeGremio(String nombreGremio) (1,5 puntos)
Busca y devuelve el personaje con mayor puntosDanio que pertenezca al gremio especificado.
La búsqueda del gremio debe ser exacta (sensible a mayúsculas).
Si no existe ningún personaje de ese gremio, devuelve null.
En caso de empate en daño, devuelve el de mayor nivel.


e) boolean actualizarNivelesYEliminarDebiles(int incrementoNivel, int nivelMinimoSupervivencia) (2 puntos)
Incrementa el nivel de todos los personajes en la cantidad especificada (sin superar el nivel 100).
Después del incremento, elimina del torneo todos los personajes cuyo nivel final sea menor que nivelMinimoSupervivencia.
Actualiza jugadoresRegistrados correctamente.
Devuelve true si se eliminó al menos un personaje, false en caso contrario.
3. Archivo de Pruebas PruebasTorneo.java (0,5 puntos)
Crear una clase PruebasTorneo con un método main.
Dentro del main:
Crear al menos 7 instancias de PersonajeRPG con datos variados (usar ambos constructores). Incluir personajes de diferentes clases, algunos legendarios, con diferentes gremios y habilidades.
Crear al menos 2 instancias de TorneoEsports y asignar los personajes creados.
Probar cada una de las funciones implementadas en TorneoEsports.java al menos una vez, mostrando los resultados por consola de forma clara y ordenada.
Mostrar el toString() de al menos dos personajes.
 */


public class PersonajeRPG {
    private int idPersonaje;
    public String nombrePersonaje;
    private int clasePersonaje;
    private int nivel;
    private int puntosVida;
    private float puntosDanio;
    private boolean esLegendario;
    private ArrayList<String> habilidades;
    private String guildName;
    public static final int CLASE_GUERRERO = 1;
    public static final int CLASE_MAGO = 2;
    public static final int CLASE_ARQUERO = 3;
    public static final int CLASE_ASESINO = 4;

    public PersonajeRPG(){
        this.idPersonaje = (int) (Math.random()*89990)+1000;
        this.nombrePersonaje = "";
        this.clasePersonaje = (int) (Math.random()*4)+1;
        this.nivel = (int) (Math.random()*50)+1;
        this.puntosVida = (int) (Math.random()*4000)+1000;
        this.puntosDanio = (float) (Math.random()*200) + 50;
        this.esLegendario = false;
        this.habilidades = new ArrayList<>();
        this.guildName = "";
    }

    public PersonajeRPG(String nombrePersonaje, int clasePersonaje, int nivel, int puntosVida,
        float puntosDanio, boolean esLegendario, ArrayList<String> habilidades, String guildName){
            this.idPersonaje = (int) (Math.random()*89990)+1000;
            this.nombrePersonaje = nombrePersonaje;
            this.clasePersonaje = clasePersonaje;
            this.nivel = nivel;
            this.puntosVida = puntosVida;
            this.puntosDanio = puntosDanio;
            this.esLegendario = esLegendario;
            this.habilidades = (habilidades != null) ? new ArrayList<>(habilidades) : new ArrayList<>();
            this.guildName = guildName;
        }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getClasePersonaje() {
        return clasePersonaje;
    }

    public void setClasePersonaje(int clasePersonaje) {
        if(clasePersonaje > 0 && clasePersonaje < 5){
            this.clasePersonaje = clasePersonaje;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public float getPuntosDanio() {
        return puntosDanio;
    }

    public void setPuntosDanio(float puntosDanio) {
        this.puntosDanio = puntosDanio;
    }

    public boolean isEsLegendario() {
        return esLegendario;
    }

    public void setEsLegendario(boolean esLegendario) {
        this.esLegendario = esLegendario;
    }

    public ArrayList<String> getHabilidades() {
        return new ArrayList<>(habilidades);
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = (habilidades != null) ? new ArrayList<>(habilidades) : new ArrayList<>();
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    @Override
    public String toString() {
        return "===PERSONAJE RPG===\n"
        + "-> ID: " + idPersonaje + "\n"
        + "-> Nombre: " + nombrePersonaje + "\n"
        + "-> Clase " + clasePersonaje + "\n"
        + "-> Nivel " + nivel + "\n"
        + "-> Vida: " + puntosVida + "HP\n"
        + "-> Daño: " + puntosDanio + "\n"
        + "-> Legendario: " + esLegendario + "\n"
        + "-> Gremio: " + guildName + "\n"
        + "-> Habilidades: " + habilidades + "\n"
        + "=====================\n";
     }


}
