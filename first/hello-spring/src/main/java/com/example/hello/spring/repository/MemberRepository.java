package com.example.hello.spring.repository;

import com.example.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id); // Null을 반환하지 않기 위해 Optional을 이용해 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
