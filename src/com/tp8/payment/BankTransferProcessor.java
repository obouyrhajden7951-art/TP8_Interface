package com.tp8.payment;

// Deuxième implémentation : virement bancaire.
// Même contrat que la carte, mais comportement différent (il y a un délai).
public class BankTransferProcessor implements PaymentProcessor {

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

        // On simule un délai de traitement d'1 seconde.
        // (c'est juste pour la simulation, dans la vraie vie on ne bloque pas comme ça)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Si le thread est interrompu, on remet le signal d'interruption
            // et on considère que le paiement a échoué
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