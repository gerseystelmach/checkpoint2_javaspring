package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("userName", principal.getName());
        return "index";
    }
}
