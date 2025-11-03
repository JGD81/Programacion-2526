package UNIDAD2;

public class SumaPosNegArray {

    public static void main(String[] args) {
        
        //Inicializamos sumas y contadores 
    
        int sumaNegativos = 0;
        int i = 0;
        int j = 0;
        //Creamos array para guardar resultados(Suma y resta)
        int[] sumasTotales = new int[2];
        //Array que contiene los valores a sumar
        int[] arrayPrincipal = {4, 0, -5, 9, -7, 3};
        for (i = 0; i < arrayPrincipal.length;i++){
            if (arrayPrincipal[i] > 0 ){
                j++;
            } else if (arrayPrincipal[i] < 0){
            sumaNegativos = sumaNegativos + arrayPrincipal[i];
        }
        }
        sumasTotales[0] = j;
        sumasTotales[1] = sumaNegativos;

        System.out.println("[" + sumasTotales[0] + "]" + "[" + sumasTotales[1] + "]");

    }
}
