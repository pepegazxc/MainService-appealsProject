package main.event;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MayorEvent extends EventClass{
    private List<String> mayorsEmails;
    private String userIdentifier;
    private String userEmail;
    private String appeal;
    private Long appealId;
}
