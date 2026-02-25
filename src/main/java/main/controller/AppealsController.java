package main.controller;

import main.dto.request.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealsController {

    @PostMapping("/write")
    public String writeAnAppeal(UserRequest request){
        return "Your appeal has been submitted successfully!";
    }
}