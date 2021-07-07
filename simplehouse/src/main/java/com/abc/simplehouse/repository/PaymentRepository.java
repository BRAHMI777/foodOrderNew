/**
 * @author gowthami
 * @date 2021-07-07
 *
 */

package com.abc.simplehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abc.simplehouse.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}