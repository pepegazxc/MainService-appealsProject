package main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealsController {

    @PostMapping("/write")
    public String writeAnAppeal(){
        return null;
    }
}