package com.hivelab.paymentprj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.hivelab.paymentprj.dto.PaymentCallbackRequest;
import com.hivelab.paymentprj.dto.RequestPayDto;
import com.hivelab.paymentprj.service.PaymentService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService paymentService;

	@GetMapping("/payment/{id}")
	public String paymentPage(@PathVariable(name = "id", required = false) String id,
			Model model) {

		model.addAttribute("requestDto", paymentService.findRequestDto(id));
		return "payment";
	}

	@ResponseBody
	@PostMapping("/payment")
	public ResponseEntity<IamportResponse<Payment>> validationPayment(@RequestBody PaymentCallbackRequest request) {
		IamportResponse<Payment> iamportResponse = paymentService.paymentByCallback(request);

		log.info("결제 응답={}", iamportResponse.getResponse().toString());

		return new ResponseEntity<>(iamportResponse, HttpStatus.OK);
	}

	@GetMapping("/success-payment")
	public String successPaymentPage() {
		return "success-payment";
	}

	@GetMapping("/fail-payment")
	public String failPaymentPage() {
		return "fail-payment";
	}
}
