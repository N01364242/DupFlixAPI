/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Niya
 */
@Service
public class HomeService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
   // Do any additional configuration here
   return builder.build();
}
    
    public Object parse(String url){
       Object o=  restTemplate.getForObject(url, Object.class);
         return o;
    }
    
}
