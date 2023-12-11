package com.example.projets5baovola.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @GetMapping("/test")
    public String hello(@RequestParam(value = "name", defaultValue = "World", required = true) String name,  Model model, HttpSession session) {
        model.addAttribute("message", name);
        return "test";
    }
    @GetMapping("/home")
    public String home(){
        return "test";
    }
}
