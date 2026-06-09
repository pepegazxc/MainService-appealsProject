package main.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import main.dto.enums.Status;

@Data
public class MayorAnswerRequest {
    @NotBlank
    private String userEmail;
    @NotBlank
    private String answer;
    @NotBlank
    @NotNull
    private Status status;
}
