package main.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import main.dto.request.UserRequest;

@Getter
@AllArgsConstructor
public enum Cities {
    BELGRADE(1L), MOSCOW(2L), WARSAW(3L);

    private Long id;
}
