package kitae.foolaccount.controller;

import kitae.foolaccount.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }


}
