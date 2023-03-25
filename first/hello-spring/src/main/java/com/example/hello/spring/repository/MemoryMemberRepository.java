package com.example.hello.spring.repository;

import com.example.hello.spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id)); // null을 가능하게 함
    }

    @Override
    public Optional<Member> findByName(String name) {
        // map에서 name값이 파라미터의 name과 같은지 확인하고 없으면 반복. 찾으면 반환 끝까지 없으면 Optional에 null 들어가서 반환
       return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // store.values는 member들임
        return new ArrayList<>(store.values());
    }
}
