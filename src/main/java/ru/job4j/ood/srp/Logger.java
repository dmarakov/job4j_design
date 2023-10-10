package ru.job4j.ood.srp;

/*
В данном случае необходимо создать два интерфейса: Logger и EmailNotifier.
На основании этих двух интерфейсов создать два класса: LoggerService и EmailNotifierService.
В этих классах имплементировать интерфейсы и реализовать методы
 */
public class Logger {

    public void logMessage(String message) {
        System.out.println("Log: " + message);
    }

    public void sendEmailNotification(String errorMessage) {
        System.out.println("Email sent: " + errorMessage);
    }
}
