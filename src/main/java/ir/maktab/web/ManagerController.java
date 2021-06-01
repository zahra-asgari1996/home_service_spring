package ir.maktab.web;

import ir.maktab.dto.ManagerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

    @PostMapping("/signIn")
    public void getSignIn(){

    }
}
