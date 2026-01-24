package UNIDAD3.EjercicioEntrega;

public class Main {
    public static void main(String[] args) {
        
        /*
        ====================
        CLASE INSTRUMENTO
        ====================
        */

        //Creación de instrumento mediante constructor vacío
        Instrumento inst1 = new Instrumento();
        System.out.println(inst1);
        //Creación de instrumento mediante constructor con parámetros
        Instrumento inst2 = new Instrumento("Yamaha", Instrumento.GUITARRA_LASER, 100, 3, Instrumento.PRESTADO, true);
        System.out.println(inst2);
        Instrumento inst3 = new Instrumento("Ibanez", Instrumento.GUITARRA_LASER, 100, 3, Instrumento.ENCONTRADO_EN_MARTE, false);
        System.out.println(inst3);
        
        //MÉTODO: Comprobar si el instrumento es hackeable
        System.out.println("***Pruebas instrumento hackeable***");
        //inst2 es hackeable
        System.out.println("Es hackeable?: " + inst2.hackear());
        //Sube el volumen un 25%, añadimos nivel a rareza y mostramos true como hackeable 
        System.out.println(inst2);
        //inst3 no es hackeable (ENCONTRADO_EN_MARTE)
        System.out.println("Es hackeable?: " + inst3.hackear());
        System.out.println(inst3);
        
        //MÉTODO: Comprobar compatibilidad
        System.out.println("***Pruebas compatibilidad***");
        System.out.println("Es compatible?: " + inst2.esCompatible(Artista.DEATH_METAL_COSMICO));
        System.out.println("Es compatible?: " + inst2.esCompatible(Artista.REGGAETON_MARCIANO));
        
        /*
        ====================
        CLASE ARTISTA
        ====================
        */
       //Creación artista mediante constructor vacío
       Artista art1 = new Artista();
       System.out.println(art1);
       //Creación artista mediante constructor con parámetros
       Artista art2 = new Artista("El Fary", Artista.DEATH_METAL_COSMICO, 1, 50);
       System.out.println(art2);
       Artista art3 = new Artista("Gold Maiden", Artista.DEATH_METAL_COSMICO, 1, 50);
       System.out.println(art3);
       Artista art4 = new Artista("Metadeth", Artista.TRAP_ESPACIAL, 1, 50);
       System.out.println(art4);
       
       //MÉTODO: Tocar instrumento. No se pueden añadir instrumentos al artista
       //si no se cumplen las condiciones definidas en este método:
       //- El artista tiene energía superior o igual a 20
       //- El instrumento es compatible con su género
       //- El instrumento NO está en uso
       //Cuando el artista toca el instrumento:
       //- Se añade a la lista
       //- Se marca como enUso
       //- Se resta energía al artista
       System.out.println("***Pruebas tocar instrumento***");
       System.out.println("Podemos añadir el instrumento? " + art2.tocarInstrumento(inst2));
       System.out.println("Podemos añadir el instrumento? "+ art2.tocarInstrumento(inst3));
       //Comprobamos que se haya añadido el instrumento compatible (inst2)
       System.out.println(art2);
       
       //MÉTODO: Dejar instrumento
       System.out.println("***Pruebas dejar instrumento***"); 
       System.out.println(art2.dejarInstrumento("Ibanez"));
       //Comprobamos si ha dejado el instrumento
       System.out.println(art2);
       
       //METODO: Subir fama
       System.out.println("***Pruebas subir fama***");
       art2.subirFama();
       //Comprobamos si se ha aplicado correctamente el método
       // - Incrementa el nivel en 1, incrementa la energía en 20 (sin superar MAXIMA), añade 1000 seguidores
       System.out.println(art2);
       
       //MÉTODO: Dar concierto
       /*
        darConcierto realiza:
        - Por cada 10 asistentes, gana un seguidor
        - Resta 30 energía
        - Si los seguidores >= 10000, llama a subirFama()
        */
       System.out.println("***Pruebas dar concierto***");
       art2.darConcierto(1000);
       System.out.println(art2);
       
       //MÉTODO: Obtener instrumentos marcianos
       //Devolver una lista con instrumentos de rareza ENCONTRADO_EN_MARTE
        //Si no existen, se devuelve una lista vacía.
        //Volvemos a añadir el instrumento al artista
        System.out.println("***Pruebas obtener instrumentos marcianos***");
        art2.tocarInstrumento(inst3);
        System.out.println(art2);
        //Comprobamos que aparece en la lista
        System.out.println(art2.obtenerInstrumentosMarcianos());
        
        //MÉTODO: Calcular poder escénico
        //- Se suma el volumen de todos los instrumentos (volumen total) + (nivel * 50) + (energía + 2)
        System.out.println("***Pruebas calcular poder escénico***");
        System.out.println("El poder escénico es: " + art2.calcularPoderEscenico());
        
        /*
        ====================
        CLASE ESCENARIO
        ====================
        */
        //Creamos escenario con constructor vacío
        Escenario esc1 = new Escenario();
        System.out.println("===Escenario 1:===\n" + esc1);
        //Creamos escenario con constructor con parámetros
        Escenario esc2 = new Escenario("Ressurrection", Escenario.PRINCIPAL, 1);
        System.out.println("===Escenario 2:===\n" + esc2);
        Escenario esc3 = new Escenario("Paradise scenario", Escenario.SECUNDARIO, 4);
        System.out.println("===Escenario 3:===\n" + esc3);
        
        //MÉTODO: Subir al escenario
        /*
        El método subierAlEscenario realiza:
        - Si el artista ya está en el escenario, devuelve false
        - Si el número de artistas >= aforoMaximo, devuelve false
        - En caso contrario, lo añade y devuelve true
        */
       System.out.println("***Pruebas subir al esenario***");
        System.out.println("El artista puede subir al escenario?: " + esc2.subirAlEscenario(art2));
        //Comprobamos si el artista está en el escenario
        System.out.println("===Escenario 2:===\n" + esc2);
        //Intentamos agregar otro
        System.out.println("El artista puede subir al escenario?: " + esc2.subirAlEscenario(art1));
        //Comprobamos que no ha subido(supera el aforo del escenario)
        System.out.println("===Escenario 2:===\n" + esc2);
        
        //MÉTODO: Bajar del escenario por el nombre del artista
        System.out.println("***Pruebas bajar del escenario***");
        System.out.println("Puede subir al escenario?: " + esc2.bajarDelEscenario("el fary"));
        ;
        //Comprobamos el estado del escenario
        System.out.println("===Escenario 2:===\n" + esc2);

        //MÉTODO: Obtener artistas por género
        /*
        Comprueba los artistas que están en el escenario con el género introducido
        */
       //Volvemos a subir al escenario al art2
       System.out.println("***Pruebas obtener artistas por género***");
       esc2.subirAlEscenario(art2);
       //Comprobamos los géneros de los artistas en el escenario por el género introducido
       System.out.println(esc2.obtenerArtistaPorGenero(Artista.DEATH_METAL_COSMICO)); 

       //MÉTODO: obtener géneros en el escenario
       /*
        El método obtenerGenerosEnEscenario:
        - Recorre todos los artistas del escenario
         - Devuelve un HashSet con los géneros musicales presentes (sin repetir)
        - Usar HashSet para evitar duplicados
        */
       System.out.println("***Pruebas obtener géneros en el escenario***");
       //Subimos artistas al escenario
       esc3.subirAlEscenario(art2);
       System.out.println(esc3.obtenerGenerosEnEscenario());
       //Añadimos artista con mismo género 
       esc3.subirAlEscenario(art3);
       //Comprobamos que no se repite el género
       System.out.println(esc3.obtenerGenerosEnEscenario());
       //Añadimos artista con diferente género
       esc3.subirAlEscenario(art4);
       System.out.println(esc3.obtenerGenerosEnEscenario());
       
       //MÉTODO: Calcular espectacularidad
       //Suma el poder escénico de los artistas
       System.out.println("***Pruebas calcular espectacularidad***");
       System.out.println(esc3.calcularEspectacularidad());

       //MÉTODO: obtener artistas agotados
       //Devuelve los artistas con energía menor a 30 y los ordena de menor a mayor
       System.out.println("***Pruebas obtener artistas agotados***");
       //Bajamos 2 artistas del escenario (aforo 4)
       esc3.bajarDelEscenario("Metadeth");
       esc3.bajarDelEscenario("Gold Maiden");
       //Creamos artistas agotados
       Artista art5 = new Artista("Chiquetete", Artista.POLKA_INTERGALACTICA , 1, 20);
       Artista art6 = new Artista("Antonio Escobar", Artista.REGGAETON_MARCIANO, 1, 15);
       //Los subimos al escenario
       esc3.subirAlEscenario(art5);
       esc3.subirAlEscenario(art6);
       //Aplicamos el método
       System.out.println(esc3.obtenerArtistasAgotados());
       

    



       
       




    }
}
