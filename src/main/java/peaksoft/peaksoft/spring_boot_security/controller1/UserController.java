
package peaksoft.peaksoft.spring_boot_security.controller1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.spring_boot_security.entities.User;
import peaksoft.peaksoft.spring_boot_security.repository.UserRepository;
import peaksoft.peaksoft.spring_boot_security.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println("User password: " + user.getPassword());
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/userUpdate/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("updateUser", user);
        return "user/updateUser";
    }

    @RequestMapping(value = "{id}", method = {RequestMethod.PATCH, RequestMethod.GET})
    public String saveUserUpdate(@PathVariable("id") Long id, @ModelAttribute("updateUser") User user) {
        userService.updateUser(id, user,user.getRoleName());
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }
}