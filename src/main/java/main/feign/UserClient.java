package main.feign;

import main.configuration.FeignConfig;
import main.dto.feign.InternalUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "registration-service", url = "${service.url}", configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/internal/users/{userIdentifier}")
    InternalUserDto getEmail(@PathVariable String userIdentifier);
}
