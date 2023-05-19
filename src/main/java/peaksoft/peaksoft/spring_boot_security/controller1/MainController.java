package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.peaksoft.spring_boot_security.entities.User;
import peaksoft.peaksoft.spring_boot_security.service.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")

public class MainController {
  private final   UserService userService;
@GetMapping("/login")
public String login(){
    return "/login";
}
    @GetMapping()
    public String getMain() {
        return "main";
    }


    @GetMapping("/profile")
    public String login(Model model, Principal principal) {
        User user=userService.getByName(principal.getName());
        model.addAttribute("user",user);
        return "profile";
    }
}
