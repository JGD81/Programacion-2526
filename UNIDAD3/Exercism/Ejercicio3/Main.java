package UNIDAD3.Exercism.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        //El parámetro que se le pasa a la función, es si el caballero está despierto o no
        System.out.println("Puede Annalyn atacar, si el caballero está despierto?: " + AnnalynsInfiltration.canFastAttack(true));
        //Cada booleano representa si uno de los 3 personajes está despierto
        System.out.println("Se puede espiar, si al menos uno de los personajes está despierto: " + AnnalynsInfiltration.canSpy(true, false, false));
        //Se puede enviar la señal si el prisionero está despierto y el arquero dormido
        System.out.println("Se puede enviar la señal al prisionero?: " + AnnalynsInfiltration.canSignalPrisoner(false, true));
        //se puede liberar al prisionero (tiene el perro y el arquero duerme ó no tiene el perro pero
        //todos duermen menos el prisionero)
        System.out.println("Se puede liberar el prisionero?: " + AnnalynsInfiltration.canFreePrisoner(false, false, false, true));
    }
}
