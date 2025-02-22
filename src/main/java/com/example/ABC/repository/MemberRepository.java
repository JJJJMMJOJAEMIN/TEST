package com.example.ABC.repository;

import com.example.ABC.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member,Long> {


    Optional<Member> findByUserId(String userId);
}
