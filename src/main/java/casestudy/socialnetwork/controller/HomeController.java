package casestudy.socialnetwork.controller;

import casestudy.socialnetwork.model.User;
import casestudy.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage(){
        return "sign-in-page";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(User user) {
        ModelAndView mav = new ModelAndView("/sign-in-page");
        mav.addObject("user", user);
        String role = "ROLE_USER";
        user.setRoles(role);
        user.setActive(true);
        for (User user1 : userService.findAll()){
            if (user1.getUserName().equals(user.getUserName())) return mav.addObject("");
        }
        userService.save(user);
        return mav;
    }

    @GetMapping("/cut")
    public String accessDenied() {
        return "";
    }
}