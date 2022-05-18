package com.project.neonaduri;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class NeonaduriApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeonaduriApplication.class, args);
    }

}


