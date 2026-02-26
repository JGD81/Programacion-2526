package com.ejercicioud4;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.ejercicioud4.dao.GnomoAncianoDAO;
import com.ejercicioud4.utils.ConexionBD;

public class Main {
    public static void main(String[] args) {
        /*Connection con = ConexionBD.conectar();

         if (con != null) {
            System.out.println("La conexión funciona correctamente.");
        } else {
            System.out.println("No se pudo conectar.");
        }*/

        /*
        =====================================================
        PRUEBAS GNOMOANCIANODAO
        =====================================================
        */
        
        //Creamos un nuevo objeto DAO de GnomoAnciano
        GnomoAncianoDAO daoGnomo = new GnomoAncianoDAO();

        //Contar registros count()
        System.out.println("Total registros: " + daoGnomo.count());

        //findAll()
        System.out.println(daoGnomo.findAll());

        /* 
        //Método insert()
        //Creamos un nuevo HashMap con un nuevo Gnomo
        Map<String,Object> nuevo = new HashMap<>();
        nuevo.put("nombre", "prueba");
        nuevo.put("apodoGuerra", "Destructor");
        nuevo.put("edad", 150);
        nuevo.put("alturaBarba", 60.5);
        nuevo.put("nivelCascarrabias", 9);
        nuevo.put("energiaRefunfuño", 95);
        
        //Insertamos en la tabla el nuevo gnomo mediante insert()
        long id = daoGnomo.insert(nuevo);

        //Mostramos el id del nuevo gnomo creado
        System.out.println("Nuevo ID: " + id);
        //Y volvemos a contar las filas de la tabla gnomoAnciano
        System.out.println("Nuevo total: " + daoGnomo.count());
        

        //Método findById. Buscamos el nuevo gnomo creado en la tabla
        System.out.println(daoGnomo.findById(9));

        //Método update()
        Map<String,Object> cambiosGnomo = new HashMap<>();
        cambiosGnomo.put("edad", 200);
        cambiosGnomo.put("nivelCascarrabias", 1);

        //Comprobamos si los datos han sido actualizados
        boolean gnomoActualizado = daoGnomo.update(9, cambiosGnomo);

        //Mostramos los datos del gnomo actualizado
        System.out.println("Actualizado: " + gnomoActualizado);
        System.out.println("Después del update: " + daoGnomo.findById(9));
        

        //Método delete()
        boolean gnomoEliminado = daoGnomo.delete(9);

        //Imprimir resultados
        System.out.println("Eliminado: " + gnomoEliminado);
        System.out.println("Nuevo total: " + daoGnomo.count());
        System.out.println("Buscar eliminado: " + daoGnomo.findById(9));
        

        //Método paginación 
        System.out.println("Página 1:");
        System.out.println(daoGnomo.findAll(1, 3));
        */
        //Métodos abstractos
        //filtrar
        System.out.println(daoGnomo.filtrar("edad", 64));
        //buscar
        System.out.println(daoGnomo.buscar("edad", ">=", "43"));

    }
}