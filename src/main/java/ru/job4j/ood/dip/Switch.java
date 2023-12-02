package ru.job4j.ood.dip;

/*
В данном случае у нас есть передача конкретной реализации в конструктор, вместо его абстракции.
Так же мы вызываем метод напрямую в класса. Надо и то и другое заменить на интерфейс
 */

class Switch {
    private LightBulb lightBulb;

    public Switch() {
        this.lightBulb = new LightBulb();
    }

    public void operate() {
        lightBulb.turnOn();
    }
}

