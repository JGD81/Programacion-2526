package UNIDAD2;

public class EjercicioEntrega1 {
    public static void main(String[] args) {
        int contador = 1; 
        do {
            if (contador % 3 == 0 && contador % 5 == 0){
                System.out.println("FizzBuzz");
            }else if (contador % 3 == 0){
                System.out.println("Fizz");
            }else if (contador % 5 == 0) {
                System.out.println("Buzz");
            }else{
                System.out.println(contador);    
            }
            contador++;       
        } while (contador <= 15); 

    }
}
