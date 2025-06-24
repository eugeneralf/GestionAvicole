package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.User;
import com.elevageavicole.gestion_elevage_avicole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listerUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users/liste";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("user", new User());
        return "users/formulaire";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());

            user.get().setPassword("");
            return "users/formulaire";
        }
        return "redirect:/users";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}