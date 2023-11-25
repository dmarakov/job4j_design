package ru.job4j.ood.isp;

/*
Класс Fish вынужден реализовывать методы sleep() и makeSound(), которые для рыбы могут быть неактуальными.
 */
class Fish implements Animal {
    @Override
    public void eat() {
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException("Fish don't sleep!");
    }

    @Override
    public void makeSound() {
        throw new UnsupportedOperationException("Fish don't make sounds!");
    }
}
