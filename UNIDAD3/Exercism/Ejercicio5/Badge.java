package UNIDAD3.Exercism.Ejercicio5;
/**
 * En este ejercicio, escribirás código para imprimir credenciales para los empleados de la fábrica.
 */

/**
 * Los empleados tienen una identificación, nombre y nombre de departamento. 
 * Las etiquetas de identificación de los empleados tienen el siguiente formato: "[id] - name - DEPARTMENT"
 */
public class Badge {
    public String print(Integer id, String name, String department){
        //Java convierte automáticamente a String cuando se concatena con +, si
        //al menos uno de ellos es String. En el ejercicio 2, se añade la posibilidad
        //de que el empleado no tenga id. OJO: Se usa Integer y no int, porque con int
        //no se pueden tener valores nulos. En el ejercicio 3, se añade la posibilidad
        //de añadir al propietario, en el que el departamento sería OWNER. También puede
        //ser un empleado nuevo (sin id)
        String deparmentLabel;

        if(department == null){
            deparmentLabel = "OWNER";
        }else{
            deparmentLabel = department.toUpperCase();
        }

        if(id==null){
            return name + " - " + deparmentLabel;
        }else{
        return "[" + id + "] - " + name + " - " + deparmentLabel;
        }
    }
}
