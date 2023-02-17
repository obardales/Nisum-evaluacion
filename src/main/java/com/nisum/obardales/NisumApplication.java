package com.nisum.obardales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
public class NisumApplication {

    public static void main(String[] args) {
        SpringApplication.run(NisumApplication.class, args);
    }

}
