package ru.job4j.ood.srp;

public class Employee {
    private String name;
    private double salary;

    /*
    В данном примере, для класса Employee мы в одном классе и расчитываем ЗП и выводим ее.
    Верным ходом было бы разделить эти вещи на два разных класса, каждый из которых выполнял бы свою функцию и реализовать там свои, необходимые методы
     */
    public double calculateSalary(double salary) {
        return salary;
    }

    public void printSalary(String name, double salary) {
        System.out.println("Salary for" + name + "=" + calculateSalary(salary));
    }
}
