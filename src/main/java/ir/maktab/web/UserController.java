package ir.maktab.web;

import ir.maktab.dto.FilterUsersDto;
import ir.maktab.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void allowEmptyDateBinding(WebDataBinder binder) {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @PostMapping(value = "/searchUser")
    public ModelAndView searchUsers(@ModelAttribute("users") FilterUsersDto dto) {
        return new ModelAndView("searchUsersPage", "usersList", userService.filterUsers(dto));

    }

    @GetMapping(value = "/searchUser")
    public String searchUsers(Model model) {
        model.addAttribute("users", new FilterUsersDto());
        return "searchUsersPage";
    }
}
