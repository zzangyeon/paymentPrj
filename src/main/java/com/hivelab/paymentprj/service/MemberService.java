package com.hivelab.paymentprj.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.hivelab.paymentprj.entity.Member;
import com.hivelab.paymentprj.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	//회원 자동 생성
	public Member autoRegister() {
		Member member = Member.builder()
				.username(UUID.randomUUID().toString())
				.email("test@test.com")
				.address("경기도 성남시 대왕판교로")
				.build();

		return memberRepository.save(member);
	}
}
