package com.tp8.payment;

public class BankTransferProcessor implements PaymentProcessor {

    // Ici on stocke un numéro de compte, et non un numéro de carte
    private final String accountNumber;

    public BankTransferProcessor(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur : Montant invalide pour le virement.");
            return false;
        }
        System.out.println("Virement de " + amount + "€ vers le compte " + accountNumber + " initié.");

        // Simulation d'un délai de traitement : un virement n'est pas instantané
        try {
            Thread.sleep(1000); // pause de 1000 ms = 1 seconde
        } catch (InterruptedException e) {
            // Si le thread est interrompu, on remet l'indicateur d'interruption
            // (bonne pratique) puis on signale l'échec du paiement
            Thread.currentThread().interrupt();
            return false;
        }
        System.out.println("Virement confirmé.");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Virement Bancaire";
    }
}