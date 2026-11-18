package com.tp8.payment;

public class PaymentService {

    // Le type est l'INTERFACE, pas une classe concrète.
    // Le service accepte donc n'importe quel moyen de paiement (polymorphisme).
    private final PaymentProcessor processor;

    // Injection de dépendance par le constructeur :
    // le moyen de paiement est fourni de l'extérieur, le service ne le crée pas lui-même.
    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public boolean pay(double amount) {
        // Appelle la bonne version de getPaymentMethod() selon l'objet reçu
        System.out.println("--- Traitement du paiement via : " + processor.getPaymentMethod() + " ---");
        boolean success = processor.processPayment(amount);
        if (success) {
            System.out.println("Transaction terminée avec succès.");
        } else {
            System.out.println("Transaction échouée.");
        }
        return success;
    }
}