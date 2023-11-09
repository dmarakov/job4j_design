package ru.job4j.ood.lsp;

/*
У нас есть два класса: птица и страус. В родительском классе мы определяем метод fly.
В классе наследнике переопределяем его, но т.к страус летать не умеет, то кидаем исключение.
Следовательно при замене базовоно класса, классом наследником, у нас возникнет незапланированное поведение в программе
и она звершится с исключением.
 */
class Bird {
    public void fly() {
        System.out.println("This bird can fly.");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly.");
    }

    public void run() {
        System.out.println("This ostrich can run.");
    }

    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Ostrich();
        makeBirdFly(bird);
    }
}

