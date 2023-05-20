/**

 * 
 */
package com.flipkart.services;
import java.util.*;

import com.flipkart.bean.Payment;

/**
 * @author rahul.kumarsingh
 *
 */
public class PaymentOperationService implements PaymentServiceInterface{
	
	
	public void processPayment(Payment payment) {
		
        // Perform payment processing logic based on the payment mode
        switch (payment.getPaymentMode()) {
            case "online":
                // Handle online payment logic
            	
                System.out.println("Processing online payment...");
               
                
                break;
            case "offline":
                // Handle offline payment logic
                System.out.println("Processing offline payment...");
                break;
            case "scholarship":
                // Handle scholarship payment logic
                System.out.println("Processing scholarship payment...");
                break;
            default:
                // Handle unsupported payment mode or throw an exception
                throw new IllegalArgumentException("Invalid payment mode: " + payment.getPaymentMode());
        }

        // Additional logic for payment processing can be added here.

        // Send payment notification
        sendPaymentNotification(payment);
    }

    public void sendPaymentNotification(Payment payment) {
        // Logic for sending payment notification
        String message = "Payment of " + payment.getAmount() + " received for payment ID: " + payment.getPaymentId();
        String recipient = payment.getStudentName();
        
        // Example: Print payment notification details
        System.out.println("Sending payment notification...");
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + message);

        // Additional logic for sending notifications, such as using email or SMS APIs, can be added here.
    }
	
	
	
}
