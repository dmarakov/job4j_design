package ru.job4j.ood.ocp;

class Order {
    private final double totalPrice;

    /*
    В данном примере нарушается ocp принцип, т.к каждый новый метод оплаты, приводит к тому, что
    изменяется наш основной метод, по расчету скидки.
    Т.е если мы ввдем оплату наличными, нам придется расширять if-else конструкцию еще одним условием.
    Что бы устранить это, согластно паттерну стратегия необходимо сделать следующие вещи:
    1. Выделить интерфейс. Назовем его PaymentStrategy
    2. Создаем два класса: CreditCardPayment и PayPalPayment, в которых имплементируем интерфейс и реализуем метод
    по расчету скидки, который объявиди в интерфейсе
    3. Переписываем класс Order, где в конструкторе инициализируем PaymentMethod. И в методе расчета скидки
    вызываем у объекта именно его метод
     */

    public Order(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double calculateTotalPrice(String paymentMethod) {
        double totalPriceWithDiscount = totalPrice;

        if ("creditCard".equals(paymentMethod)) {
            totalPriceWithDiscount *= 0.95;
        } else if ("paypal".equals(paymentMethod)) {
            totalPriceWithDiscount *= 0.98;
        }
        return totalPriceWithDiscount;
    }
}

