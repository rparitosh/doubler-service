package com.paritosh.learning.adder.doubler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class DoublerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/twice")
    public int twice(@RequestParam int a){

        String url = "http://adder-service:9003/add?a="+a+"&b="+a;

        return restTemplate.getForObject (url, Integer.class);
    }
}
