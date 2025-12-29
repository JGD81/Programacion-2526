package UNIDAD3.Exercism.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        //Creamos nuevo objeto
        SalaryCalculator empleado = new SalaryCalculator();
        //Calculamos el el multiplicador del salario dependiendo de los 
        //días que el empleado falta
        System.out.println(empleado.salaryMultiplier(6));
        //Calculamos el multiplicador según los productos vendidos
        System.out.println(empleado.bonusMultiplier(21));
        //Calculamos el bonus de salario según los productos vendidos
        System.out.println(empleado.bonusForProductsSold(21));
        //Calculamos el salario total del empleado, dependiendo de la
        //asistencia y del bonues por venta de productos
        System.out.println(empleado.finalSalary(5, 100));
    }  
}
