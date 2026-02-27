package com.ejercicioud4;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ejercicioud4.dao.DuendeCombateDAO;
import com.ejercicioud4.dao.GnomoAncianoDAO;
import com.ejercicioud4.dao.HadaMadrinaDAO;
import com.ejercicioud4.dao.TopoCombateDAO;
import com.ejercicioud4.model.GnomoAncianoDO;
import com.ejercicioud4.model.TopoCombateDO;
import com.ejercicioud4.utils.ConexionBD;

public class Main {
    public static void main(String[] args) {
        /*
         * Connection con = ConexionBD.conectar();
         * 
         * if (con != null) {
         * System.out.println("La conexión funciona correctamente.");
         * } else {
         * System.out.println("No se pudo conectar.");
         * }
         */

        /*
         * =====================================================
         * PRUEBAS GNOMOANCIANODAO
         * =====================================================
         */
        /*
         * //Creamos un nuevo objeto DAO de GnomoAnciano
         * GnomoAncianoDAO daoGnomo = new GnomoAncianoDAO();
         * 
         * //Contar registros count()
         * System.out.println("Total registros: " + daoGnomo.count());
         * 
         * //findAll()
         * System.out.println(daoGnomo.findAll());
         * 
         * 
         * //Método insert()
         * //Creamos un nuevo HashMap con un nuevo Gnomo
         * Map<String,Object> nuevo = new HashMap<>();
         * nuevo.put("nombre", "prueba");
         * nuevo.put("apodoGuerra", "Destructor");
         * nuevo.put("edad", 150);
         * nuevo.put("alturaBarba", 60.5);
         * nuevo.put("nivelCascarrabias", 9);
         * nuevo.put("energiaRefunfuño", 95);
         * 
         * //Insertamos en la tabla el nuevo gnomo mediante insert()
         * long id = daoGnomo.insert(nuevo);
         * 
         * //Mostramos el id del nuevo gnomo creado
         * System.out.println("Nuevo ID: " + id);
         * //Y volvemos a contar las filas de la tabla gnomoAnciano
         * System.out.println("Nuevo total: " + daoGnomo.count());
         * 
         * 
         * //Método findById. Buscamos el nuevo gnomo creado en la tabla
         * System.out.println(daoGnomo.findById(9));
         * 
         * //Método update()
         * Map<String,Object> cambiosGnomo = new HashMap<>();
         * cambiosGnomo.put("edad", 200);
         * cambiosGnomo.put("nivelCascarrabias", 1);
         * 
         * //Comprobamos si los datos han sido actualizados
         * boolean gnomoActualizado = daoGnomo.update(9, cambiosGnomo);
         * 
         * //Mostramos los datos del gnomo actualizado
         * System.out.println("Actualizado: " + gnomoActualizado);
         * System.out.println("Después del update: " + daoGnomo.findById(9));
         * 
         * 
         * //Método delete()
         * boolean gnomoEliminado = daoGnomo.delete(9);
         * 
         * //Imprimir resultados
         * System.out.println("Eliminado: " + gnomoEliminado);
         * System.out.println("Nuevo total: " + daoGnomo.count());
         * System.out.println("Buscar eliminado: " + daoGnomo.findById(9));
         * 
         * 
         * //Método paginación
         * System.out.println("Página 1:");
         * System.out.println(daoGnomo.findAll(1, 3));
         * 
         * //Métodos abstractos
         * //filtrar
         * System.out.println(daoGnomo.filtrar("edad", 64));
         * //buscar
         * System.out.println(daoGnomo.buscar("edad", ">=", "43"));
         */

        /*
         * =====================================================
         * PRUEBAS TOPOCOMBATEDAO
         * =====================================================
         * 
         * 
         * TopoCombateDAO daoTopo = new TopoCombateDAO();
         * 
         * 
         * //Contar registros count()
         * System.out.println("Total registros: " + daoTopo.count());
         * 
         * System.out.println(daoTopo.filtrar("horasSueño",5));
         * System.out.println(daoTopo.findById(9));
         * 
         * HadaMadrinaDAO daoHada = new HadaMadrinaDAO();
         * 
         * System.out.println("Total registros: " + daoHada.count());
         * 
         * System.out.println(daoHada.filtrar("edad",38));
         * System.out.println(daoHada.findById(6));
         * 
         * DuendeCombateDAO daoDuende = new DuendeCombateDAO();
         * 
         * System.out.println("Total registros: " + daoDuende.count());
         * 
         * System.out.println(daoDuende.filtrar("nivelSarcasmo",72));
         * System.out.println(daoDuende.findById(6));
         * 
         * // Prueba del ´metodo calcularEnergíaRefunfunioTotal
         * 
         * // Método cargar topos
         * GnomoAncianoDAO gnomoDAO = new GnomoAncianoDAO();
         * 
         * int idGnomo = 1; // ID que quieres probar
         * 
         * ArrayList<TopoCombateDO> topos = gnomoDAO.cargarTopos(idGnomo);
         * 
         * if (topos.isEmpty()) {
         * System.out.println("El gnomo no tiene topos asignados.");
         * } else {
         * System.out.println("Topos del gnomo " + idGnomo + ":");
         * 
         * for (TopoCombateDO topo : topos) {
         * System.out.println("ID: " + topo.getIdTopoCombate());
         * System.out.println("Nombre: " + topo.getNombre());
         * System.out.println("Modelo: " + topo.getModelo());
         * System.out.println("-----------------------");
         * }
         * }
         * 
         * // Método Gnomo con mayor nivel cascarrabias
         * GnomoAncianoDAO gnomoDAO = new GnomoAncianoDAO();
         * 
         * GnomoAncianoDO gnomo = gnomoDAO.obtenerGnomoMasCascarrabias();
         * 
         * if (gnomo != null) {
         * System.out.println("Gnomo más cascarrabias:");
         * System.out.println("ID: " + gnomo.getIdGnomoAnciano());
         * System.out.println("Nombre: " + gnomo.getNombre());
         * System.out.println("Nivel: " + gnomo.getNivelCascarrabias());
         * } else {
         * System.out.println("No hay gnomos en la base de datos.");
         * }
         */
        // Método StringBuilder
        GnomoAncianoDAO dao = new GnomoAncianoDAO();

        String informe = dao.generarInformeGnomos();

        System.out.println(informe);

    }

}