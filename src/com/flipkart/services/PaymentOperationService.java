/**

 * 
 */
package com.flipkart.services;
import java.util.*;

import com.flipkart.bean.Payment;
import com.flipkart.dao.*;
/**
 * @author rahul.kumarsingh
 *
 */
public class PaymentOperationService implements PaymentServiceInterface{
	
	static int paymentId = 0;
	public void processPayment(Payment payment) {

        paymentId = paymentId + 1;
        payment.setPaymentId("P" + Integer.toString(paymentId) );
        payment.setReferenceId("R" + Integer.toString(paymentId) );

        PaymentDAOInterface paymentDao = new PaymentDAOImplementation();
        paymentDao.storePayment(payment);
        // Send payment notification
        sendPaymentNotification(payment);
    }

    public void sendPaymentNotification(Payment payment) {
        // Logic for sending payment notification
        String message = "Payment of " + payment.getAmount() + " received for payment ID: " + payment.getPaymentId();
        String recipient = payment.getStudentName();
        
        // Example: Print payment notification details
        System.out.println("<--------------------------Sending payment notification--------------------->");
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("<--------------------------------------------------------------------------->");

        // Additional logic for sending notifications, such as using email or SMS APIs, can be added here.
    }
	
	
	
}
