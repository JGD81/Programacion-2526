package UNIDAD3.Exercism.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        //Al ser un método estático, el método se integrad dentro de la clase,
        //Sin necesidad de crear un nuevo objeto con "new"
        System.out.println(LogLevels.message("[ERROR]: Invalid operation"));
        System.out.println(LogLevels.message("[WARNING]: Disk almost full\r\n"));
        System.out.println(LogLevels.logLevel("[ERROR]: Invalid operation"));
        System.out.println(LogLevels.reformat("[INFO]: Operation completed"));
    }
}
