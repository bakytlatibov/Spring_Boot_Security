
package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entity.User;
import peaksoft.peaksoft.spring_boot_security.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user/users";
    }
    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "user/addUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user")User user){
        userRepository.save(user);
        return "redirect:/user/users";
    }
    @GetMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable("id")Long id,Model model){
        User user = userRepository.getById(id);
        model.addAttribute("updateUser",user);
        return "user/updateUser";
    }
    @PatchMapping("/{id}")
    public String saveUserUpdate(@PathVariable("id")Long id,@ModelAttribute("updateUser")User user){
      userRepository.save(user);
        return "redirect:/user/users";
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return "redirect:/user/users";
    }
}