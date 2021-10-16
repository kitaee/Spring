package fools.webShopping.repository;

import fools.webShopping.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByCount(Long count);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
