package kitae.foolaccount.service;

import kitae.foolaccount.domain.Member;
import kitae.foolaccount.repository.MemberRepository;
import kitae.foolaccount.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        memberRepository.save(member);
        return member.getCount();
    }

} 