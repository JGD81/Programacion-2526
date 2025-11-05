package UNIDAD2;

/*
 *
3️⃣ Números con suma de dígitos par
Imprime los números del 1 al 100 cuya suma de dígitos sea par.
Ejemplo:
13 → 1+3=4 → par ✅

 */

public class EjerciciosRefuerzo3 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++){
            int n = i;
            if (n <= 9){
                if (n % 2 == 0){
                    System.out.print(n + " ");
                }
            }else if (n >= 10 && n < 100) {
                    int primerDigito = n % 10;
                    int segndoDigito = n / 10;
                    int suma = primerDigito + segndoDigito;
                    if (suma % 2 == 0){
                        System.out.println(n + " -> " + primerDigito + " + " + segndoDigito + " = " + suma);
                    }
            }else if (n == 100){
                
            }
        
        }

    }
}   

