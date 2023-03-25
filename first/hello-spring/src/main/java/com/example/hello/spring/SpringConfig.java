package com.example.hello.spring;

import com.example.hello.spring.repository.JpaMemberRepository;
import com.example.hello.spring.repository.MemberRepository;
import com.example.hello.spring.repository.MemoryMemberRepository;
import com.example.hello.spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
//    private final DataSource dataSoure;
//    private final EntityManager em;

    // 그냥 JPA
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSoure = dataSource;
//        this.em = em;
//    }

    // 스프링 데이터 JPA
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);
//    }

}
