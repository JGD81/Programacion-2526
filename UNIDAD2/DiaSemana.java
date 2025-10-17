package UNIDAD2;

public class DiaSemana {
    public static void main(String[] args) {

        int numSemana = (int) (Math.random() * 7 + 1);

        String diaSemana = " ";

        switch (numSemana) {
            case 1:
                diaSemana = "Lunes";
                break;
            case 2:
                diaSemana = "Martes";
                break;
            case 3:
                diaSemana = "Miercoles";
                break;
            case 4:
                diaSemana = "Jueves";
                break;
            case 5:
                diaSemana = "Viernes";
                break;
            case 6, 7:
                diaSemana = "Fin de semana";
                break;
            default:
                diaSemana = "Ninguno";
                break;
        }

        System.out.println("El dia de la semana es: " + diaSemana);
    }
}
