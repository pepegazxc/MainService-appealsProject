package main.controller;

import jakarta.validation.Valid;
import main.dto.request.MayorAnswerRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @PostMapping("/appeal/{appealId}/answer")
    public void answerToAppeal(@Valid @RequestBody MayorAnswerRequest answer, @PathVariable Long appealId){

    }
}
