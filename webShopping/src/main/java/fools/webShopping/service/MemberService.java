package fools.webShopping.service;

import fools.webShopping.domain.Member;
import fools.webShopping.repository.MemberRepository;
import fools.webShopping.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }





    //회원가입
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getCount();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberCount){
        return memberRepository.findByCount(memberCount);
    }
}
