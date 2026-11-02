package com.tp8.payment;

// Première implémentation : paiement par carte bancaire.
// "implements" = la classe s'engage à respecter le contrat de l'interface.
public class CreditCardProcessor implements PaymentProcessor {

    // final car le numéro de carte ne change plus après la création
    private final String cardNumber;

    // Constructeur : on reçoit le numéro de carte à la création de l'objet
    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        // Un montant négatif ou nul n'a pas de sens, on refuse
        if (amount <= 0) {
            System.out.println("Erreur : Montant invalide pour la carte " + maskCardNumber());
            return false;
        }
        // Ici on simule juste un paiement accepté (pas de vraie banque !)
        System.out.println("Paiement de " + amount + "€ par carte " + maskCardNumber() + " accepté.");
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Carte Bancaire";
    }

    // Méthode privée : on cache le numéro pour ne pas l'afficher en entier
    // (on garde seulement les 4 derniers caractères)
    private String maskCardNumber() {
        if (cardNumber.length() < 4) {
            return "****";
        }
        return "**** " + cardNumber.substring(cardNumber.length() - 4);
    }
}