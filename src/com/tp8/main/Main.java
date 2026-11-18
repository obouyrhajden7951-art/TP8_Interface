package com.tp8.main;

// L'étoile * importe toutes les classes du package
import com.tp8.payment.*;
import com.tp8.notification.*;

public class Main {
    public static void main(String[] args) {

        // ===== TESTS PAIEMENT =====

        // Variable de type interface, objet de type CreditCardProcessor : c'est le polymorphisme
        PaymentProcessor cardProcessor = new CreditCardProcessor("4111-1111-1111-1111");
        // On injecte le processeur dans le service
        PaymentService cardService = new PaymentService(cardProcessor);
        cardService.pay(50.0);

        // "=".repeat(40) affiche une ligne de 40 signes "=" (séparateur)
        System.out.println("\n" + "=".repeat(40) + "\n");

        // Même service, autre processeur : le code de PaymentService n'a pas changé
        PaymentProcessor transferProcessor = new BankTransferProcessor("FR76-3000-6000-0112-3456");
        PaymentService transferService = new PaymentService(transferProcessor);
        transferService.pay(150.0);

        // ===== TESTS NOTIFICATIONS =====

        System.out.println("\n" + "=".repeat(40) + "\n");
        System.out.println("TESTS NOTIFICATIONS\n");

        NotificationSender emailSender = new EmailNotificationSender();
        NotificationService emailService = new NotificationService(emailSender);
        emailService.sendWelcomeMessage("user@example.com");

        System.out.println("\n");

        NotificationSender smsSender = new SmsNotificationSender();
        NotificationService smsService = new NotificationService(smsSender);
        smsService.sendWelcomeMessage("+33612345678");
    }
}