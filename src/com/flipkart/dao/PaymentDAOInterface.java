/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;

/**
 * @author rahul.kumarsingh
 *
 */
public interface PaymentDAOInterface {
	
	public boolean storePayment( Payment payment);

}
