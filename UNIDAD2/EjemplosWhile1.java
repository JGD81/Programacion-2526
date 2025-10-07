package UNIDAD2;

public class EjemplosWhile1 {

    public static void main(String[] args) {

        int dado = 10;

        while (dado < 25) {
            System.out.println("Has sacado " + dado + ". Una tirada pasable, voy a regalarte un punto");
            dado = dado + 1;
        }
    }
}
