package UNIDAD3.EjerciciosRefuerzo.Ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Creamos los ciclistas con el constructor con parámetros
        Ciclista c1 = new Ciclista(1, "Juan García", 29, "Phanter", 60, 13, 2);
        Ciclista c2 = new Ciclista(2, "Antonio Fernández", 20, "BH", 56, 10, 1);
        Ciclista c3 = new Ciclista(3, "Jose Pérez", 23, "Trek", 60, 11, 3);
        Ciclista c4 = new Ciclista(4, "Lucas Boyé", 26, "BH", 55, 12, 1);
        //Creamos un arraylist para guardar los ciclistas y pasárselo al equipo
        ArrayList<Ciclista> ciclistas = new ArrayList<>();
        //Añadimos los ciclistas al arraylist
        ciclistas.add(c1);
        ciclistas.add(c2);
        ciclistas.add(c3);
        ciclistas.add(c4);
        //Creamos un equipo con el constructor vacío
        EquipoCiclista eq1 = new EquipoCiclista();
        //Creamos un equipo con el constructor con parámetros, y le pasamos el arraylist ciclistas
        EquipoCiclista eq2 = new EquipoCiclista("EQ01", "Banesto", 10, ciclistas, "España");
        //Probamos las distintas funcionalidades para que se pinten en pantalla
        System.out.println(eq2.calcularEdadPromedio());
        System.out.println(eq2.ciclistasEspecialidadYRangoEdad(1,20,26));
        System.out.println(eq2.ciclistasPaisPorDebajoPeso(56, "España"));
        System.out.println(eq2.eliminarCiclista(1));
        System.out.println(eq2.determinarModeloDominante("montaña"));
    }
}
