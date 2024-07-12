package com.hivelab.paymentprj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivelab.paymentprj.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
