package com.tp8.notification;

// Envoi de notifications par SMS
public class SmsNotificationSender implements NotificationSender {

    // Un SMS standard fait 160 caractères maximum.
    // static final = constante, la même pour tous les objets
    private static final int MAX_SMS_LENGTH = 160;

    @Override
    public void sendNotification(String recipient, String message) {
        // Vérification du format du numéro : il doit commencer par "+"
        if (!recipient.startsWith("+")) {
            System.out.println("[SMS] Erreur : numéro invalide : " + recipient);
            return;
        }

        // On utilise une variable locale au lieu de modifier le paramètre
        String finalMessage = message;

        // Si le message est trop long, on le coupe
        if (finalMessage.length() > MAX_SMS_LENGTH) {
            System.out.println("[SMS] Message trop long, tronqué à " + MAX_SMS_LENGTH + " caractères.");
            finalMessage = finalMessage.substring(0, MAX_SMS_LENGTH);
        }

        System.out.println("[SMS] Envoi au " + recipient + " : " + finalMessage);
    }

    @Override
    public String getChannelType() {
        return "SMS";
    }
}