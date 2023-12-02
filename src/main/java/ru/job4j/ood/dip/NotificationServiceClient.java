package ru.job4j.ood.dip;

/*
В данном случае нарушение происходит когда мы из метода sendNotification напрямую вызываем метод, в конкретной реализации
EmailNotificationService и зависим от его реализации.
Это можно исправить, если передавать абстракцию в конструктор, а в методе вызывать через интерфейс
 */
class NotificationServiceClient {
    private EmailNotificationService emailNotificationService;

    public NotificationServiceClient(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    public void sendNotification(String message) {
        emailNotificationService.sendNotification(message);
    }
}
