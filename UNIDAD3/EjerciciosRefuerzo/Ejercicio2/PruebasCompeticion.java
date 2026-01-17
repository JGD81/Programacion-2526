package UNIDAD3.EjerciciosRefuerzo.Ejercicio2;

import java.util.ArrayList;

public class PruebasCompeticion {
    public static void main(String[] args) {
        MotoAcuatica moto1 = new MotoAcuatica();
        ArrayList<String> mod1 = new ArrayList<>();
        mod1.add("Tubo de escape");
        mod1.add("Manetas"); 
        MotoAcuatica moto2 = new MotoAcuatica("Honda", "CBR", 600, 150, 1, false,mod1);
        MotoAcuatica moto3 = new MotoAcuatica("Yamaha", "HR", 1000, 200, 2, true, null);
        ArrayList<MotoAcuatica> participantes = new ArrayList<>();
        participantes.add(moto2);
        Competicion comp1 = new Competicion();
        Competicion comp2 = new Competicion("C01", "GP Jerez", participantes, "Jerez", 300000, true);
        System.out.println(comp2.calcularPotenciaMediaCategoria(1));
        System.out.println(comp2.contarMotosElectricasPorRangoPotencia(100, 300));
        System.out.println(comp2.filtrarMotosPorCilindradaYModificacion(100, 700, "Tubo de escape"));
        System.out.println(comp2.eliminarMoto(moto2.getIdMoto()));
        System.out.println(moto2);
    }
}
