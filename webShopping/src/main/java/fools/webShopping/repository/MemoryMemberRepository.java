package fools.webShopping.repository;

import fools.webShopping.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setCount(++sequence);
        store.put(member.getCount(),member);
        return member;
    }

    @Override
    public Optional<Member> findByCount(Long count) {
        return Optional.ofNullable(store.get(count));
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(member->member.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
