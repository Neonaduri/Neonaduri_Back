package com.project.neonaduri.utils;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Health {


    @GetMapping("/health")
    public String healthCheck(){
        System.out.println("여기 타니?");
        return "good";
    }
}
