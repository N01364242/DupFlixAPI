/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.userbackend;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Niya
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
   response.getHeaders().add("Access-Control-Allow-Origin", "");
      response.getHeaders().add("Access-Control-Allow-Headers", "origin,content-type,accept,authorization");
      response.getHeaders().add("Access-Control-Allow-Methods","GET");
      response.getHeaders().add("Access-Control-max-Age", "1209600");
    }
    
}
