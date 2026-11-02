package com.tp8.payment;

// Interface = le contrat que tous les moyens de paiement doivent respecter.
// Elle dit CE QU'IL FAUT FAIRE, mais pas COMMENT le faire.
public interface PaymentProcessor {

    // Traite un paiement. Retourne true si ça a marché, false sinon.
    boolean processPayment(double amount);

    // Retourne le nom du moyen de paiement (pour l'affichage)
    String getPaymentMethod();
}
