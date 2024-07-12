package com.hivelab.paymentprj.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.hivelab.paymentprj.consts.PaymentStatus;
import com.hivelab.paymentprj.entity.Member;
import com.hivelab.paymentprj.entity.Order;
import com.hivelab.paymentprj.entity.Payment;
import com.hivelab.paymentprj.repository.OrderRepository;
import com.hivelab.paymentprj.repository.PaymentRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final PaymentRepository paymentRepository;

	public Order autoOrder(Member member) {

		// 임시 결제내역 생성
		Payment payment = Payment.builder()
				.price(100L)
				.status(PaymentStatus.READY)
				.build();

		paymentRepository.save(payment);

		// 주문 생성
		Order order = Order.builder()
				.member(member)
				.price(100L)
				.itemName("100원샵 상품")
				.orderUid(UUID.randomUUID().toString())
				.payment(payment)
				.build();

		return orderRepository.save(order);
	}

}
