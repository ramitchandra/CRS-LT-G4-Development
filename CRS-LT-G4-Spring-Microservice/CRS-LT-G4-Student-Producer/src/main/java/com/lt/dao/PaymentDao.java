/**
 * 
 */
package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Payment;

/**
 * 
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 * Interface for paymentdao operations
 */
@Repository
public interface PaymentDao extends CrudRepository<Payment, Integer> {

	public Payment save(Payment payment);

}
