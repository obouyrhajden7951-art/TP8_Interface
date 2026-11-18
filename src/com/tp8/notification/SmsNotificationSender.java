package com.tp8.notification;

public class SmsNotificationSender implements NotificationSender {

    // Limite standard d'un SMS. static final = constante partagée, non modifiable
    private static final int MAX_SMS_LENGTH = 160;

    @Override
    public void sendNotification(String recipient, String message) {
        // Règle propre au SMS : on tronque les messages trop longs
        if (message.length() > MAX_SMS_LENGTH) {
            System.out.println("[SMS] Message trop long, tronqué à " + MAX_SMS_LENGTH + " caractères.");
            // substring(0, 160) garde les 160 premiers caractères
            message = message.substring(0, MAX_SMS_LENGTH);
        }
        System.out.println("[SMS] Envoi au " + recipient + " : " + message);
    }

    @Override
    public String getChannelType() {
        return "SMS";
    }
}