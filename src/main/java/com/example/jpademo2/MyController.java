package com.example.jpademo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao scemo22221!";
    }
}
