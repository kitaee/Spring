package kitae.foolaccount.repository;

import kitae.foolaccount.domain.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setCount(++sequence);
        store.put(member.getCount(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {   // 로그인 기능을 위한 아이디찾기
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<Member> findByPassword(String password) {  // 로그인 기능을 위한 비밀번호 찾기
        return store.values().stream()
                .filter(member -> member.getPassword().equals(password))
                .findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> findByPhone(String phone) {
        return store.values().stream()
                .filter(member -> member.getPhone().equals(phone))
                .findAny();
    }

    @Override
    public Optional<Member> findByPassword_confirm_question(String password_confirm_question) {
        return store.values().stream()
                .filter(member -> member.getPassword_confirm_question().equals(password_confirm_question))
                .findAny();
    }

    @Override
    public Optional<Member> findByPassword_confirm_question_answer(String password_confirm_question_answer) {
        return store.values().stream()
                .filter(member -> member.getPassword_confirm_question_answer().equals(password_confirm_question_answer))
                .findAny();
    }
}