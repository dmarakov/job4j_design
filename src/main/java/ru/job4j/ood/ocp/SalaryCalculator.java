package ru.job4j.ood.ocp;

class SalaryCalculator {

    /*
    В данном примере нарушается ocp принцип, т.к каждый новый метод расчета зарплаты, приводит к тому, что
    изменяется наш основной метод, по расчету зарплаты.
    Что бы устранить это, согластно паттерну стратегия необходимо сделать следующие вещи:
    1. Выделить интерфейс. Назовем его Employee
    2. Создаем два класса: FullTimeEmployee и ContractEmployee, в которых имплементируем интерфейс и реализуем метод
    по расчету скидки, который объявиди в интерфейсе
    3. Переписываем класс SalaryCalculator, где в конструкторе инициализируем Employee. И в методе расчета зарплаты
    вызываем у объекта именно его метод
     */
    public double calculateSalary(Object employee) {
        if (employee instanceof FullTimeEmployee) {
            System.out.println("Расчет для FullTimeEmployee");
        } else if (employee instanceof ContractEmployee) {
            System.out.println("Расчет для ContractEmployee");
        }
        return 0;
    }
}

class FullTimeEmployee {
}

class ContractEmployee {
}

