package main.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import main.dto.enums.Cities;


@Data
@Valid
public class UserRequest {

    @NotBlank(message = "You must write an appeal")
    @NotNull(message = "You must write an appeal")
    private String appeal;

    @NotNull(message = "You must write city name")
    private Cities cityName;
}
