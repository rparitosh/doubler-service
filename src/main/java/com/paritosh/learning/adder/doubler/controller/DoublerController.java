package com.paritosh.learning.adder.doubler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class DoublerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/twice")
    public int twice(@RequestParam int a){
       // return restTemplate.getForObject ("http://localhost:9001/add?a=" +a + "&b=" +a , Integer.class);
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        return restTemplate.getForObject ("http://adder-service/add?a=" +a + "&b=" +a , Integer.class);
    }
}
