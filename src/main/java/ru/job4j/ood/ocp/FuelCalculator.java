package ru.job4j.ood.ocp;

class FuelCalculator {

    /*
В данном примере нарушается ocp принцип, т.к каждый новый вид трансорта, приводит к тому, что
изменяется наш основной метод, по расчету расхода топлива.
Т.е если мы ввдем еще один трансорт, нам придется расширять if-else конструкцию еще одним условием.
Что бы устранить это, согластно паттерну стратегия необходимо сделать следующие вещи:
1. Выделить интерфейс. Назовем его Vehicle
2. Создаем два класса: Car и Motorcycle, в которых имплементируем интерфейс и реализуем метод
по расчету затрат топлива, который объявили в интерфейсе
3. Переписываем класс FuelCalculator, где в конструкторе инициализируем Vehicle. И в методе расчета затрат топлива
вызываем у объекта именно его метод
 */
    public double calculateFuelConsumption(Object vehicle, double distance) {
        if (vehicle instanceof Car) {
            System.out.println("Расчет для Car");
        } else if (vehicle instanceof Motorcycle) {
            System.out.println("Расчет для Motorcycle");
        }
        return 0;
    }
}

class Car {
}

class Motorcycle {
}

