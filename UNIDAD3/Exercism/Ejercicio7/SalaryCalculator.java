package UNIDAD3.Exercism.Ejercicio7;
/**
 * En este ejercicio, implementará reglas para calcular el salario total 
 * de un empleado en un mes. La Compañía Internacional de Siderurgia (ISC) 
 * necesita ayuda para calcular los salarios de sus empleados, considerando 
 * diversos factores que pueden afectar el salario final.
 */
public class SalaryCalculator {
    //Implemente el salaryMultipliermétodo que devuelve el multiplicador 
    // salarial según el número de días que el empleado faltó al trabajo. 
    // Se aplica una penalización del 15% a partir del 5 día.
    public double salaryMultiplier(int daysSkiped) {
        /*if(daysSkiped >= 5){
            multiplier = 0.85;
            return multiplier;
        }else{
            multiplier = 1;
            return multiplier;
        }*/
        double multiplier = daysSkiped >=5 ? 0.85 : 1.0;
        return multiplier;  
    }

    /**
     * Implementar los métodos bonusMultipliery bonusForProductsSold. El ISC paga 
     * diez unidades monetarias por cada producto vendido, y si un empleado vende 
     * veinte productos o más, el multiplicador aumenta a trece. bonusMultiplier 
     * Se debe determinar qué multiplicador aplicar y bonusForProductSoldse 
     * debe devolver la bonificación total en unidades monetarias.
     */
    public int bonusMultiplier(int productsSold){
        int multiplier = productsSold >= 20 ? 13 : 10;
        return multiplier;
    }

    public double bonusForProductsSold(int productsSold){
        return productsSold * bonusMultiplier(productsSold);
    }

    /**
     * Implemente el finalSalary. Debe multiplicar el salario base de 1000.00 
     * por el multiplicador salarial, sumar la bonificación y obtener el resultado. 
     * Sin embargo, los salarios deben tener un límite de 2000.00.
     */
    public double finalSalary(int daysSkiped, int productsSold){
        double baseSalary = 1000;
        double total = baseSalary * salaryMultiplier(daysSkiped) + bonusForProductsSold(productsSold);
        total = total >= 2000 ? 2000 : total;
        return total;
    }


}
