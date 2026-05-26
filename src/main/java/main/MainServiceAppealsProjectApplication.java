package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MainServiceAppealsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainServiceAppealsProjectApplication.class, args);
    }

}
