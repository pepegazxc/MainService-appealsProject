package main.event;

import lombok.Data;
import main.dto.enums.Status;

@Data
public class AppealResponseEvent extends EventClass{
    private String userEmail;
    private String appealResponse;
    private Status status;
}
