package com.ejercicioud4;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ejercicioud4.dao.DuendeCombateDAO;
import com.ejercicioud4.dao.GnomoAncianoDAO;
import com.ejercicioud4.dao.HadaMadrinaDAO;
import com.ejercicioud4.dao.TopoCombateDAO;
import com.ejercicioud4.model.DuendeCombateDO;
import com.ejercicioud4.model.GnomoAncianoDO;
import com.ejercicioud4.model.HadaMadrinaDO;
import com.ejercicioud4.model.TopoCombateDO;
import com.ejercicioud4.utils.ConexionBD;

public class Main {
    public static void main(String[] args) {

        // Creación de la conexión
        Connection con = ConexionBD.conectar();

        if (con != null) {
            System.out.println("La conexión funciona correctamente.");
        } else {
            System.out.println("No se pudo conectar.");
        }

        //Instanciar DAOs

        GnomoAncianoDAO gnomoDAO = new GnomoAncianoDAO();
        HadaMadrinaDAO hadaDAO = new HadaMadrinaDAO();

        //Método calcularEnergiaRefunfunioTotal
        int energiaTotal = gnomoDAO.calcularEnergiaRefunfunioTotal();
        System.out.println("=====Energía refunfuño=====");
        System.out.println("Energia total de refunfuño (nivel > 5): " + energiaTotal);

        //Método CargarDuendes
        System.out.println("=====CargarDuendes=====");
        ArrayList<DuendeCombateDO> duendes = hadaDAO.cargarDuendes(1);
        for (DuendeCombateDO d : duendes){
            System.out.println(d);
        }

        //Método cargarHadasConAlasPequenias
        System.out.println("=====Hadas pequeñas=====");
        ArrayList<HadaMadrinaDO> hadasPequenias = hadaDAO.cargarHadasConAlasPequenias(100);

        for(HadaMadrinaDO h : hadasPequenias){
            System.out.println(h);
        }

        //Método update()
        Map<String,Object> cambiosGnomo = new HashMap<>();
        cambiosGnomo.put("edad", 200);
        cambiosGnomo.put("nivelCascarrabias", 1);
         
         //Comprobamos si los datos han sido actualizados
         boolean gnomoActualizado = gnomoDAO.update(9, cambiosGnomo);
         
         //Mostramos los datos del gnomo actualizado
         System.out.println("Actualizado: " + gnomoActualizado);
         System.out.println("Después del update: " + gnomoDAO.findById(9));


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
         * 
         * // Método StringBuilder
         * GnomoAncianoDAO dao = new GnomoAncianoDAO();
         * 
         * String informe = dao.generarInformeGnomos();
         * 
         * System.out.println(informe);
         * 
         * 
         * // Pruebas métodos de TopoCombate
         * TopoCombateDAO topoDAO = new TopoCombateDAO();
         * 
         * System.out.println("---- Topos con tierra en los ojos ----");
         * ArrayList<TopoCombateDO> tierra = topoDAO.cargarToposConTierraEnOjos(1);
         * for (TopoCombateDO t : tierra) {
         * System.out.println(t);
         * }
         * 
         * System.out.println("\n---- Topos descansados ----");
         * ArrayList<TopoCombateDO> descansados = topoDAO.cargarToposDescansados();
         * for (TopoCombateDO t : descansados) {
         * System.out.println(t);
         * }
         * 
         * System.out.println("\n---- Promedio fuerza excavación ----");
         * double promedio = topoDAO.calcularPromedioFuerzaExcavacion(1);
         * System.out.println("Promedio: " + promedio);
         * 
         * System.out.println("\n---- Paginación (3 elementos, página 1) ----");
         * ArrayList<TopoCombateDO> paginado = topoDAO.cargarToposPaginado(3, 1);
         * for (TopoCombateDO t : paginado) {
         * System.out.println(t);
         * }
         * 
         * 
         * 
         * // Pruebas métodos HadaMadrinaDAO
         * 
         * HadaMadrinaDAO hadaDAO = new HadaMadrinaDAO();
         * 
         * // Cargar duendes de un hada concreta
         * System.out.println("----- DUENDES DEL HADA 1 -----");
         * ArrayList<DuendeCombateDO> duendes = hadaDAO.cargarDuendes(1);
         * 
         * for (DuendeCombateDO d : duendes) {
         * System.out.println(d);
         * }
         * 
         * // Calcular polvo total (nivelPasivoAgresividad > 3)
         * System.out.println("\n----- POLVO PURPURINA TOTAL -----");
         * double totalPolvo = hadaDAO.calcularPolvoPurpurinaTotal();
         * System.out.println("Total polvo: " + totalPolvo);
         * 
         * 
         * // Obtener hada más veterana
         * System.out.println("\n----- HADA MÁS VETERANA -----");
         * HadaMadrinaDO veterana = hadaDAO.obtenerHadaMasVeterana();
         * System.out.println(veterana);
         * 
         * 
         * // Cargar hadas con alas pequeñas
         * System.out.println("\n----- HADAS CON ALAS < 50 -----");
         * ArrayList<HadaMadrinaDO> hadasPequenas =
         * hadaDAO.cargarHadasConAlasPequenias(50);
         * 
         * for (HadaMadrinaDO h : hadasPequenas) {
         * System.out.println(h);
         * }
         */

    }

}