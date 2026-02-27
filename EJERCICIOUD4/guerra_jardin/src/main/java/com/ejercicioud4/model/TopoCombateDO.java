package com.ejercicioud4.model;

public class TopoCombateDO {
    private int idTopoCombate;
    private String nombre;
    private String apodoGuerra;
    private String modelo;
    private int fuerzaExcavacion;
    private int agudezaOlfativa;
    private int horasSuenio;
    private int tiempoTierraEnOjos;
    private int idGnomoAnciano;

    // Constructor completo (para SELECT)
    public TopoCombateDO(int idTopoCombate, String nombre,
            String apodoGuerra, String modelo, int fuerzaExcavacion,
            int agudezaOlfativa, int horasSuenio, int tiempoTierraEnOjos,
            int idGnomoAnciano) {

        this.idTopoCombate = idTopoCombate;
        this.nombre = nombre;
        this.apodoGuerra = apodoGuerra;
        this.modelo = modelo;
        this.fuerzaExcavacion = fuerzaExcavacion;
        this.agudezaOlfativa = agudezaOlfativa;
        this.horasSuenio = horasSuenio;
        this.tiempoTierraEnOjos = tiempoTierraEnOjos;
        this.idGnomoAnciano = idGnomoAnciano;
    }

    public int getIdTopoCombate() {
        return idTopoCombate;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApodoGuerra() {
        return apodoGuerra;
    }

    public String getModelo() {
        return modelo;
    }

    public int getFuerzaExcavacion() {
        return fuerzaExcavacion;
    }

    public int getAgudezaOlfativa() {
        return agudezaOlfativa;
    }

    public int getHorasSuenio() {
        return horasSuenio;
    }

    public int getTiempoTierraEnOjos() {
        return tiempoTierraEnOjos;
    }

    public int getIdGnomoAnciano() {
        return idGnomoAnciano;
    }
}
