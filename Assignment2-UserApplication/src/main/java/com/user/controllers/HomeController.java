/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controllers;


import com.google.gson.Gson;
import com.user.models.DupFlix;
import com.user.services.HomeService;
import java.awt.PageAttributes;
import java.util.ArrayList;

import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Niya
 */
@RestController
public class HomeController {
    
    private static final String HOME_PAGE ="userApp";
    private static final String JSON_COUNTRY_URL="http://localhost:8080/Assignment2-UserBackend/resources/home/all";
    
    @Autowired
    private  HomeService homeService;
    
    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/")  
    public ModelAndView getDashboard( ){  
         ModelAndView  mv = new ModelAndView();
         Client client = ClientBuilder.newClient();
         List<DupFlix> dupFlixList = new ArrayList<>();
        WebTarget resource = client.target("http://localhost:8080/Assignment2-UserBackend/resources/home/all");
                Invocation.Builder request = resource.request();
                Response response = request.get();
                
                if(response.getStatus()== 200){
                    String output = response.readEntity(String.class);
                    
                    Gson gson = new Gson();
        dupFlixList = gson.fromJson(output, ArrayList.class);
                }
         mv.addObject("dupFlixList", dupFlixList);
         mv.setViewName(HOME_PAGE);
     return mv;
    }
}
