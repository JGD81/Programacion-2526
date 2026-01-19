package UNIDAD3.EjerciciosRefuerzo.Ejercicio4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // =========================
        // 1️⃣ Crear componentes
        // =========================
        Componente c1 = new Componente(
                1,
                "Procesador i5",
                "Intel",
                "i5-12400",
                Componente.PROCESADOR,
                125,
                "LGA1700"
        );

        Componente c2 = new Componente(
                2,
                "Memoria RAM",
                "Corsair",
                "Vengeance 16GB",
                Componente.MEMORIA,
                40,
                "DDR4"
        );

        Componente c3 = new Componente(
                3,
                "Tarjeta Gráfica",
                "NVIDIA",
                "RTX 3060",
                Componente.GRAFICA,
                170,
                "PCIe"
        );

        Componente c4 = new Componente(
                4,
                "Procesador Ryzen",
                "AMD",
                "Ryzen 5 5600X",
                Componente.PROCESADOR,
                65,
                "AM4"
        );

        // =========================
        // 2️⃣ Crear ArrayList de componentes
        // =========================
        ArrayList<Componente> listaComponentes = new ArrayList<>();
        listaComponentes.add(c1);
        listaComponentes.add(c2);
        listaComponentes.add(c3);
        listaComponentes.add(c4);

        // =========================
        // 3️⃣ Crear Computadora
        // =========================
        Computadora pc = new Computadora(
                "PC-001",
                "Ordenador Gaming",
                listaComponentes,
                "Sobremesa"
        );

        // =========================
        // 4️⃣ Probar métodos
        // =========================

        // Potencia total (stream)
        float potenciaTotal = pc.calcularPotenciaTotal();
        System.out.println("Potencia total del PC: " + potenciaTotal + " W");

        // Contar componentes por marca y potencia
        int componentesIntel = pc.componentesMarcaPorDebajoPotencia("Intel", 150);
        System.out.println("Componentes Intel con potencia <= 150W: " + componentesIntel);

        // Filtrar componentes por tipo y rango
        ArrayList<Componente> procesadoresFiltrados =
                pc.filtrarComponentesPorTipoYRango("PROCESADOR", 50, 130);

        System.out.println("Procesadores entre 50W y 130W:");
        for (Componente c : procesadoresFiltrados) {
            System.out.println("- " + c.getNombre() + " (" + c.getPotenciaWatts() + " W)");
        }
    }
}