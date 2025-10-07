package UNIDAD2;

public class EdadMedia {
    public static void main(String[] args) {
        /*
         * Ejerciciov2: leer las edades de 10 personas, que deben de estar entre 18 y 65
         * años
         * se debe sacar por pantalla la edad de cada persona y al final la edad media
         * del grupo
         */
        int sumaEdad = 0;
        int i = 1;
        int edad = 0;
        int cantidadPersonas = 0;
        String mensaje = "";

        // Quiero que se repita 10 veces
        while (i <= 10) {
            // Borramos el mensaje
            mensaje = "";
            // Genero la edad entre 1 y 100
            edad = (int) (Math.random() * 100) + 1;
            if (edad < 18) {
                mensaje = "La persona es menor de edad";
            } else if (edad > 65) {
                mensaje = "Esá jubilado";
            } else {

                // Pasamos a la siguiente persona
                sumaEdad = sumaEdad + edad;
                cantidadPersonas = cantidadPersonas + 1;
            }
            // Mostramos la edad del personaje
            mensaje = "La edad de la persona " + i + " es " + edad + ". " + mensaje;
            i++;
        }
        // Calculamos la media
        if (cantidadPersonas != 0) {
            sumaEdad = sumaEdad / cantidadPersonas;
            System.out.println("La media de edad es: " + sumaEdad);
        }
    }
}
