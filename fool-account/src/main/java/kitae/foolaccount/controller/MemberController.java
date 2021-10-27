package kitae.foolaccount.controller;

import kitae.foolaccount.domain.Member;
import kitae.foolaccount.repository.MemberRepository;
import kitae.foolaccount.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String create(MemberForm form){        // 회원가입을 하고 회원정보를 DB에 저장완료
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setPassword_confirm_question(form.getPassword_confirm_question());
        member.setPassword_confirm_question_answer(form.getPassword_confirm_question_answer());
        member.setName(form.getName());
        member.setPhone(form.getPhone());
        memberService.join(member);

//        System.out.println(form.getId());
//        System.out.println(form.getPassword());
//        System.out.println(form.getPassword_confirm_question());
//        System.out.println(form.getPassword_confirm_question_answer());
//        System.out.println(form.getName());
//        System.out.println(form.getPhone());
        return "redirect:/";
    }


}
