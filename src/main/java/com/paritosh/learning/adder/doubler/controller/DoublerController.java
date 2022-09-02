package com.paritosh.learning.adder.doubler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DoublerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/twice")
    public int twice(@RequestParam int value){
        return restTemplate.getForObject ("adder-service.default.svc.cluster.local:9001/add?a=" +value + "&b=" +value , Integer.class);
    }
}
