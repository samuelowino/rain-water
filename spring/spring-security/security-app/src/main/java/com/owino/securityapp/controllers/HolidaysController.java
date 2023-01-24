package com.owino.securityapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidaysController {

    @GetMapping("/")
    public String root(){
        return "Hello, welcome to Holidays!";
    }

    @GetMapping("/home")
    public String home(){
        return "Hello, welcome to Holidays!";
    }

    @GetMapping("/user")
    public String user(Authentication authentication){
        return "Hello " + authentication.getName() + ".\nWelcome to holidays API";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello Admin";
    }

    @GetMapping("/holidays")
    public List<String> listHolidays(){
        return Arrays.asList("Akshaya Tritiya","Bhogi","Diwali","Durga Puja","Ekadasi","Ganesh Chaturthi","Gokul Ashtami");
    }
}
