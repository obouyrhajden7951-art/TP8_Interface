package com.tp8.payment;

// "implements" : la classe s'engage à respecter le contrat PaymentProcessor.
// Si une méthode de l'interface manque, le compilateur signale une erreur.
public class CreditCardProcessor implements PaymentProcessor {

    // Numéro de carte, donné une seule fois à la création (final = non modifiable)
    private final String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // @Override : indique qu'on implémente une méthode de l'interface
    @Override
    public boolean processPayment(double amount) {
        // Simulation d'une vérification : un montant négatif ou nul est refusé
        if (amount <= 0) {
            System.out.println("Erreur : Montant invalide pour la carte " + cardNumber);
            return false;
        }
        System.out.println("Paiement de " + amount + "€ par carte " + cardNumber + " accepté.");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Carte Bancaire";
    }
}