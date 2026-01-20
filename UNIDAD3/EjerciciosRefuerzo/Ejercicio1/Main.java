package UNIDAD3.EjerciciosRefuerzo.Ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Creación objeto
        AgenciaViajes ag1 = new AgenciaViajes();
        // Se crea la lista de destinos antes de crear la agencia
        // para que el constructor pueda copiarla correctamente
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        // Creación de destinos con datos variados
        Destino dest1 = new Destino("Mallorca", 200, "Playa", false, 1, "Playas cristalinas, bares");
        Destino dest2 = new Destino();
        Destino dest3 = new Destino("Cádiz", 100, "Playa", false, 2, "Carnaval, playas");
        Destino dest4 = new Destino("Londres", 250, "Ciudad", true, 3, "Noria, cerveza");
        // Se añaden los destinos a la lista
        listaDestinos.add(dest1);
        listaDestinos.add(dest2);
        listaDestinos.add(dest3);
        listaDestinos.add(dest4);
        //Se crea la agencia usando el constructor completo.
        //La lista ya contiene los destinos
        AgenciaViajes ag2 = new AgenciaViajes("A01", "Ágila viajes", listaDestinos, "España", 2020, false);

        System.out.println(ag2.calcularPrecioMedioTotal());
        System.out.println(ag2.contarDestinosPorTipoYVisado("Ciudad", true));
        System.out.println(ag2.filtrarDestinosPorTemporadaYPrecio(1, 100, 200));
        System.out.println(dest2.getIdDestino());
        System.out.println(ag2.eliminarDestino(868));
        System.out.println(ag2.destinoMasBaratoConAtraccion("noria"));

    }
}
