package com.askie01.springsecuritytutorial;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringSecurityTutorialApplication {

    static void main(String[] args) {
        SpringApplication.run(SpringSecurityTutorialApplication.class, args);
    }
}
