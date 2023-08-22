package fr.fixgia.roulemapoule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RouleMaPouleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouleMaPouleApplication.class, args);
    }

}
