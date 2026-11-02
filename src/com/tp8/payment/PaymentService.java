package com.tp8.payment;

// Le service ne connaît QUE l'interface PaymentProcessor.
// Il ne sait pas si c'est une carte ou un virement : c'est ça le découplage.
public class PaymentService {

    // Le type est l'interface, pas une classe concrète
    private final PaymentProcessor processor;

    // Injection de dépendance : on donne le processeur par le constructeur
    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public boolean pay(double amount) {
        System.out.println("--- Traitement du paiement via : " + processor.getPaymentMethod() + " ---");

        // Polymorphisme : Java appelle la bonne version de processPayment
        // selon l'objet réellement passé (carte ou virement)
        boolean success = processor.processPayment(amount);

        if (success) {
            System.out.println("Transaction terminée avec succès.");
        } else {
            System.out.println("Transaction échouée.");
        }
        return success;
    }
}