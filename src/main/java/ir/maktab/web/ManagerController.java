package ir.maktab.web;

import ir.maktab.dto.ManagerDto;
import ir.maktab.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/managerPage")
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/login")
    public String getSignIn(@ModelAttribute("manager")ManagerDto managerDto, Model model){
        ManagerDto dto=managerService.findByUserName(managerDto.getUserName());
        if (dto==null){
            model.addAttribute("notFoundManager","Manager Not Found");
            return "loginManagerPage";
        }else{
            System.out.println("yes");
            if (!dto.getPassword().equals(managerDto.getPassword())){
                model.addAttribute("invalidPassword","Password Is Incorrect");
                return "loginManagerPage";
            }else {
               return "managerHomePage";
            }
        }

    }
}
