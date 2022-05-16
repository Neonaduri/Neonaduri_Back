package com.project.neonaduri.utils;


import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Health {

//    private final Environment env;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        System.out.println("여기 타니?");
        return ResponseEntity.ok("200");
    }
}
