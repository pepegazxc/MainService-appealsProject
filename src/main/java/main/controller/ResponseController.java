package main.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import main.dto.request.MayorAnswerRequest;
import main.service.AppealsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResponseController {

    private final AppealsService service;

    @PostMapping("/appeal/{appealId}/answer")
    public String answerToAppeal(@Valid @RequestBody MayorAnswerRequest answer, @PathVariable Long appealId){
        service.appealResponse(appealId, answer);
        return "Changes have been made";
    }
}
