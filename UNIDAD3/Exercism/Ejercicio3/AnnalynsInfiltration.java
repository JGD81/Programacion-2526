package UNIDAD3.Exercism.Ejercicio3;

/**
 * En este ejercicio, implementarás la lógica de misiones para un nuevo juego de rol
que un amigo está desarrollando. La protagonista es Annalyn, una chica valiente con un perro feroz y leal. 
Desafortunadamente, ocurre un desastre: su mejor amiga fue secuestrada mientras buscaba bayas en el bosque. 
Annalyn intentará encontrarla y rescatarla, llevando opcionalmente a su perro en la misión.
Tras un tiempo siguiendo el rastro, Annalyn descubre el campamento donde su amiga está prisionera. 
Resulta que hay dos secuestradores: un poderoso caballero y un astuto arquero.
Tras encontrar a los secuestradores, Annalyn considera cuál de las siguientes acciones puede realizar:
- Ataque rápido: se puede realizar un ataque rápido si el caballero está dormido, ya que tarda en ponerse 
la armadura, lo que lo deja vulnerable.
- Espionaje: se puede espiar al grupo si al menos uno de ellos está despierto. De lo contrario, espiar es una pérdida 
de tiempo. 
- Señalar al prisionero: Se puede avisar al prisionero mediante sonidos de pájaros si está despierto y el 
arquero duerme. Los arqueros están entrenados en señales de pájaros y podrían interceptar el mensaje si están despiertos.
- Liberar al prisionero: Annalyn puede intentar colarse en el campamento para liberar al prisionero. Esto es arriesgado y 
solo puede tener éxito de dos maneras:
    - Si Annalyn tiene a su perro, puede rescatar al prisionero si el arquero duerme. El caballero le teme al perro y el arquero 
    no tendrá tiempo de prepararse antes de que Annalyn y el prisionero puedan escapar.
    - Si Annalyn no tiene a su perro, ¡ella y el prisionero deben ser muy escurridizos! Annalyn puede liberar al prisionero si 
    este está despierto y tanto el caballero como el arquero duermen. Sin embargo, si el prisionero duerme, no podrán rescatarlo, 
    ya que la repentina aparición de Annalyn lo sobresaltaría y despertaría al caballero y al arquero. 
Tienes cuatro tareas: implementar la lógica para determinar si las acciones anteriores están disponibles en función del 
estado de los tres personajes en el bosque y si el perro mascota de Annalyn está presente o no.
 * 
 */

public class AnnalynsInfiltration {
    //Hacer un ataque rápido si el caballero no está despierto
    public static boolean canFastAttack(boolean knightIsAwake){
        //Declaramos la variable fuera del condicional para que se pueda
        //usar fuera y devolver el resultado en el return. Sólo cambia a true
        //si el caballero no está despierto.
        boolean canFastAttack = false;
        if(!knightIsAwake){
            canFastAttack = true;
        }
        return canFastAttack;
    }
    //Se puede espiar si al menos uno de los personajes está despierto
    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake){ 
        boolean canSpy = false;
        if (knightIsAwake || archerIsAwake || prisonerIsAwake){
            canSpy = true;
        }
        return canSpy;
    }
    //Método que devuelve si se puede enviar una señal al prisionero (prisionero despierto, arquero dormido)
    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake){
        boolean canSignalPrisoner = false;
        if(!archerIsAwake && prisonerIsAwake){
            canSignalPrisoner = true;
        }
        return canSignalPrisoner;
    }
    //Método para saber si se puede liberar al prisionero (tiene el perro y el arquero duerme ó no tiene el perro pero
    //todos duermen menos el prisionero)
    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent){
        boolean canFreePrisoner = false;
        if(petDogIsPresent && !archerIsAwake){
            canFreePrisoner = true;
        }else if (!knightIsAwake && !archerIsAwake && prisonerIsAwake && !petDogIsPresent) {
            canFreePrisoner = true;
        }
        return canFreePrisoner; 
    }
}
