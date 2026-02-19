package com.unidad4.model;

import java.util.Arrays;

public class ActorDAO extends CrudDAO {
    public ActorDAO(){
        //Llama al constructor de la clase padre
        //para conectarse a la base de datos y guardar
        //la conexión en this.con
        super();
        //Asigna el nombre de la tabla del DAO
        this.nombreTabla = "actor";
        //Se define la lista de columnas de la tabla actor
        this.campos = Arrays.asList("id", "nombre", "nacionalidad", "fec_nac");
    }
}
