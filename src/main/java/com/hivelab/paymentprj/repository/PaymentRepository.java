package com.hivelab.paymentprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivelab.paymentprj.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
