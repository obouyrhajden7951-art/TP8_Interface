package com.tp8.notification;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String recipient, String message) {
        // Validation propre à l'email : une adresse doit contenir un "@"
        // (validation très simple, suffisante pour ce TP)
        if (!recipient.contains("@")) {
            System.out.println("[EMAIL] Erreur : Adresse invalide : " + recipient);
            return; // on quitte la méthode sans envoyer
        }
        System.out.println("[EMAIL] Envoi du message à " + recipient + " : " + message);
    }

    @Override
    public String getChannelType() {
        return "Email";
    }
}