package com.anthony.loginuser.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anthony.loginuser.models.Planet;
import com.anthony.loginuser.models.User;
import com.anthony.loginuser.service.PlanetService;
import com.anthony.loginuser.service.UserService;
import com.anthony.loginuser.validator.UserValidator;

@Controller
public class UsersController {
    private UserService userService;
    
    private UserValidator userValidator;
    
    private PlanetService planetService;
    
    public UsersController(UserService userService, UserValidator userValidator, PlanetService planetService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.planetService = planetService;
    }
    
//    @RequestMapping("/")
//    public String registerForm(@Valid @ModelAttribute("user") User user) {
//        return "logRegPage.jsp";
//    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "logRegPage.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "logRegPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/dashboard"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        // retrieve all planets
        List<Planet> allPlanets = planetService.getAllPlanets();
        model.addAttribute("planets", allPlanets);
        return "dashboard.jsp";
    }
}
