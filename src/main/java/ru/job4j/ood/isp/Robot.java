package ru.job4j.ood.isp;


/*
Класс Robot вынужден реализовывать методы eat() и sleep(), которые для него не имеют смысла.
 */
public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat!");
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Robots don't sleep!");
    }
}
