package com.tp8.main;

//Les imports doivent être en haut du fichier, sous le package
import com.tp8.notification.*;
import com.tp8.payment.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

 public static void main(String[] args) {

     // ===== PARTIE 1 : PAIEMENTS =====
     System.out.println("TESTS PAIEMENTS\n");

     // Le type de la variable est l'interface, l'objet est une classe concrète
     PaymentProcessor cardProcessor = new CreditCardProcessor("4111-1111-1111-1111");
     PaymentService cardService = new PaymentService(cardProcessor);
     cardService.pay(50.0);

     System.out.println("\n" + "=".repeat(40) + "\n");

     PaymentProcessor transferProcessor = new BankTransferProcessor("FR76-3000-6000-0112-3456");
     PaymentService transferService = new PaymentService(transferProcessor);
     transferService.pay(150.0);

     System.out.println("\n" + "=".repeat(40) + "\n");

     // Test d'un cas d'erreur : montant négatif
     cardService.pay(-20.0);

     System.out.println("\n" + "=".repeat(40) + "\n");

     // Démonstration du polymorphisme avec une liste
     // Une seule boucle gère tous les types de paiement
     List<PaymentProcessor> processors = new ArrayList<>();
     processors.add(cardProcessor);
     processors.add(transferProcessor);

     for (PaymentProcessor p : processors) {
         System.out.println("Méthode disponible : " + p.getPaymentMethod());
     }

     // ===== PARTIE 2 : NOTIFICATIONS =====
     System.out.println("\n" + "=".repeat(40) + "\n");
     System.out.println("TESTS NOTIFICATIONS\n");

     NotificationSender emailSender = new EmailNotificationSender();
     NotificationService emailService = new NotificationService(emailSender);
     emailService.sendWelcomeMessage("user@example.com");

     System.out.println("\n");

     NotificationSender smsSender = new SmsNotificationSender();
     NotificationService smsService = new NotificationService(smsSender);
     smsService.sendWelcomeMessage("+33612345678");

     System.out.println("\n");

     // Test d'un cas d'erreur : email invalide
     emailService.sendWelcomeMessage("pas-un-email");
 }
}