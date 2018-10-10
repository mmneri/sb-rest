package org.france.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FrancePlayersServiceApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(FrancePlayersServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(FrancePlayersServiceApplication.class);
    }

}
