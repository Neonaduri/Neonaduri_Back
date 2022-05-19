package com.project.neonaduri;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableEncryptableProperties
@EnableJpaAuditing
@SpringBootApplication
public class NeonaduriApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeonaduriApplication.class, args);
    }

}


