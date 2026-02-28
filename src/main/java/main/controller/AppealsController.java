package main.controller;

import main.dto.request.UserRequest;
import main.service.AppealsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealsController {

    private final AppealsService appealsService;

    public AppealsController(AppealsService appealsService) {
        this.appealsService = appealsService;
    }

    @PostMapping("/write")
    public String writeAnAppeal(UserRequest request){
        appealsService.saveAppeal(request);
        return "Your appeal has been submitted successfully!";
    }
}