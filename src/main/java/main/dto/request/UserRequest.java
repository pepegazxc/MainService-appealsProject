package main.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Valid
public class UserRequest {

    @NotNull(message = "You must write an appeal")
    private String appeal;
}
