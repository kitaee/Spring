package fools.webShopping.controller;

import fools.webShopping.domain.Member;
import fools.webShopping.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());
        member.setPhone1(form.getPhone1());
        member.setPhone2(form.getPhone2());
        member.setPhone3(form.getPhone3());
        System.out.println("id = " + member.getId());
        System.out.println("pw = " + member.getPassword());
        System.out.println("email = " + member.getEmail());
        System.out.println("phone1 = " + member.getPhone1());
        System.out.println("phone2 = " + member.getPhone2());
        System.out.println("phone3 = " + member.getPhone3());
        memberService.join(member);

        return "redirect:/";
    }
}
