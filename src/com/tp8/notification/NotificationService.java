package com.tp8.notification;

// Service de notification : il dépend de l'interface, pas d'Email ou de SMS.
public class NotificationService {

    private final NotificationSender sender;

    // Pour changer de canal, il suffit de passer un autre sender ici
    public NotificationService(NotificationSender sender) {
        this.sender = sender;
    }

    public void sendWelcomeMessage(String recipient) {
        String message = "Bienvenue ! Votre compte a été créé avec succès.";
        System.out.println("Envoi via canal : " + sender.getChannelType());
        sender.sendNotification(recipient, message);
    }
}