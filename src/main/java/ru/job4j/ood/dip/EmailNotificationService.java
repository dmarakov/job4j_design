package ru.job4j.ood.dip;

class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification sent: " + message);
    }
}
