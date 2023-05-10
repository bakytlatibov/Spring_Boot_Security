package peaksoft.peaksoft.spring_boot_security.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

//    @GetMapping()
//    public String getMainPage() {
//        return "main_page";
//    }
 @GetMapping()
    public String getMainPage2() {
        return "main";
    }

}
