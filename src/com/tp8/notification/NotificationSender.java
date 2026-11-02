package com.tp8.notification;

// Contrat pour tous les canaux de notification (email, SMS, ...)
public interface NotificationSender {

    // Envoie un message à un destinataire (email, numéro de téléphone...)
    void sendNotification(String recipient, String message);

    // Retourne le nom du canal (pour l'affichage)
    String getChannelType();
}