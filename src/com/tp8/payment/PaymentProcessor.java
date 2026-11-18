package com.tp8.payment;

// Une interface définit CE QUE les classes doivent faire, sans dire COMMENT.
// Toute classe qui "implements PaymentProcessor" devra fournir ces deux méthodes.
public interface PaymentProcessor {

    /**
     * Traite une transaction de paiement.
     * @param amount Le montant à payer en euros.
     * @return true si le paiement est réussi, false sinon.
     */
    // Signature seule, sans corps { } : c'est une méthode abstraite
    boolean processPayment(double amount);

    /**
     * Retourne le nom du moyen de paiement.
     * @return Le nom du processeur.
     */
    String getPaymentMethod();
}