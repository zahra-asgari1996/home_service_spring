package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.LoginExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.OrderService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundSubServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/expert")
public class ExpertController {
    private final ExpertService expertService;
    private final SubServiceService subServiceService;
    private final OrderService orderService;

    public ExpertController(ExpertService expertService, SubServiceService subServiceService, OrderService orderService) {
        this.expertService = expertService;
        this.subServiceService = subServiceService;
        this.orderService = orderService;
    }
    @PostMapping(value = "/registerExpertPage/register")
    public String save(@ModelAttribute("expert")ExpertDto expertDto){
        expertService.saveNewExpert(expertDto);
        return "expertHomePage";
    }
    @GetMapping("/registerExpertPage")
    public ModelAndView goToExpertRegisterPage(){
        return new ModelAndView("registerExpertPage","expert",new ExpertDto());
    }
    @GetMapping("/loginExpertPage")
    public ModelAndView goToLoginExpertPage(){
        return new ModelAndView("loginExpertPage","loginExpert",new LoginExpertDto());
    }

    @PostMapping("/loginExpertPage/login")
    public String loginExpert(@ModelAttribute("loginExpert") LoginExpertDto dto, Model model,
                              HttpServletRequest request) throws NotFoundExpertException {
        ExpertDto expertDto = expertService.findByEmail(dto.getEmail());
        if (expertDto!=null){
            if (expertDto.getPassword().equals(dto.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("expert",expertDto);
                //model.addAttribute("email",expertDto.getEmail());
                return "expertHomePage";
            }else {
                return "loginExpertPage";
            }
        }else{
            return "loginExpertPage";
        }
    }

    @GetMapping("/selectField")
    public String selectField(Model model,  @SessionAttribute ("expert") ExpertDto expertDto

                              ){
        model.addAttribute("selectFieldForExpert",new SelectFieldForExpertDto());
        //HttpSession session = request.getSession(false);
        return "selectFieldForExpert";
    }

    @PostMapping("/selectField")
    public String selectField(@ModelAttribute("selectFieldForExpert") SelectFieldForExpertDto dto,
                              //@ModelAttribute ("email") String email,
                              @SessionAttribute("expert")ExpertDto expert
                              ) throws NotFoundExpertException, NotFoundSubServiceException {
//        ExpertDto expertDto= expertService.findByEmail(expert.getEmail());
//        SubServiceDto subServiceDto=subServiceService.findByName(dto.getSubServiceDto().getName());
//        String email = (String) model.getAttribute("email");
        dto.setExpertDto(expert);
        expertService.addExpertToSubService(dto);
        //subServiceService.addExpertToSubService(subServiceDto,expertDto);
        return "expertHomePage";
    }

    @GetMapping("/showOrders")
    public ModelAndView showOrders(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Object expert = session.getAttribute("expert");
        //model.addAttribute("showOrdersForm",orderService.findOrdersBaseOnExpertSubServices((ExpertDto) expert));
        return new ModelAndView("showOrdersPage",
                "ordersList",orderService.findOrdersBaseOnExpertSubServices((ExpertDto) expert));
    }
}
