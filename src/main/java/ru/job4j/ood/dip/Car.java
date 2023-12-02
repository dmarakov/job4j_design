package ru.job4j.ood.dip;

/*
В этом классе нарушается DIP принцип, т.к в конструкторе для высокоуровнего класса Car мы зависим от
реализации низкоуровнего класса Engine.
Для того, что бы исправить это:
- класс Engine делаем интерфейсом
- создаем класс CarEngine и имплементируем интерфейс Engine
- в контсруктор передаем объект класса Engine
 */
class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
        System.out.println("Car started");
    }
}
