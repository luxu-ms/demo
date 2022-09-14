package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping("hello")
    public String hello(){
        return "Hello VS Code !!!";
    }

    @GetMapping("hellodb")
    public String hellodb(){
        long startTime = System.currentTimeMillis();
        String userName = userRepository.findById(1).get().getName();
        long endTime = System.currentTimeMillis();

        return String.format("Hello %s, %d ms", userName, endTime-startTime);
    }
}