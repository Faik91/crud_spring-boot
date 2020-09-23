package net.crudapp.controller;

import net.crudapp.model.User;
import net.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String ListUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.allUsers());
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.editUser(user);
        }

        return "redirect:/admin/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.deleteUser(id);

        return "redirect:/admin/users";
    }



    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.allUsers());

        return "/users";

    }

    @RequestMapping("/userData/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "/userData";
    }
}
