package com.tp8.notification;

// Envoi de notifications par email
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String recipient, String message) {
        // Validation simple : une adresse email doit contenir un "@"
        // (c'est une vérification très basique, juste pour le TP)
        if (!recipient.contains("@")) {
            System.out.println("[EMAIL] Erreur : Adresse invalide : " + recipient);
            return; // on arrête ici, on n'envoie rien
        }
        System.out.println("[EMAIL] Envoi du message à " + recipient + " : " + message);
    }

    @Override
    public String getChannelType() {
        return "Email";
    }
}