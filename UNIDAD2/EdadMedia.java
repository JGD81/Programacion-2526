package UNIDAD2;

public class EdadMedia {
    public static void main(String[] args) {

        int sumaEdad = 0;
        int i = 1;
        int edad = 0;

        // Quiero que se repita 10 veces
        while (i <= 10) {
            // Genero la edad aleaotriamente
            edad = 18 + (int) (Math.random() * 48);
            // Mostramos la edad de la persona
            System.out.println("La edad de la persona " + i + "es: " + edad);
            // Pasamos a la siguiente persona
            i++;
            sumaEdad = sumaEdad + edad;
        }
        // Calculamos la media
        sumaEdad = sumaEdad / 10;
        System.out.println("La media de edad es: " + sumaEdad);

    }
}
