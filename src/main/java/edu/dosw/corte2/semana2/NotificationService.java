package edu.dosw.corte2.semana2;

public class NotificationService {

    private static NotificationService instance;

    private NotificationStrategy strategy;

    private NotificationService() {
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(String message) {
        if (strategy == null) {
            throw new IllegalStateException("No notification strategy selected");
        }
        strategy.sendNotification(message);
    }
}
