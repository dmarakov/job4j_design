package ru.job4j.ood.srp;

public class Order {
    private int orderId;
    private double totalAmount;
    private Employee employee;

    /*
    Для начала я бы выделил два интерфейса: Order processor и Email notifier, с методами.
    Интерфейсы имплементировал бы в соответствующих классах
     */


    public void processOrder(int order, double totalAmount, Employee employee) {
        System.out.println("Ваш заказ, номен " + order + " на сумму " + totalAmount + " будет выполнен нашим сотрудникм " + employee);

    }

    public void sendEmailConfirmation() {
        System.out.println("Письмо отправлено на ваш email");
    }
}