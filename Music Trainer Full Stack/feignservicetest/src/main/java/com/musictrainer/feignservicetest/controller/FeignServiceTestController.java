package com.musictrainer.feignservicetest.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true", allowedHeaders = "*")
public class FeignServiceTestController {


    @GetMapping("/feignclienttest")
    public String testEndpoint(){

        return "Success! Feign client reached!";
    }
}
