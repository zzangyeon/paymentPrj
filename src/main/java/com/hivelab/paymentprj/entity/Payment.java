package com.hivelab.paymentprj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.hivelab.paymentprj.consts.PaymentStatus;

@Entity
@Getter
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long price;
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private String paymentUid; // 결제 고유 번호

	@Builder
	public Payment(Long price, PaymentStatus status) {
		this.price = price;
		this.status = status;
	}

	public void changePaymentBySuccess(PaymentStatus status, String paymentUid) {
		this.status = status;
		this.paymentUid = paymentUid;
	}
}
