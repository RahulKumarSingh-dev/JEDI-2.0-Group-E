/**
 * 
 */
package com.flipkart.services;

import com.flipkart.bean.Payment;

/**
 * @author rahul.kumarsingh
 *
 */
public interface PaymentServiceInterface {
	public void processPayment(Payment payment);

	public void sendPaymentNotification(Payment payment);
	

}
