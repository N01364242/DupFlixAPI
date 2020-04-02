/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.userbackend.service;

import com.google.gson.Gson;
import com.mycompany.assignment2.userbackend.models.DupFlix;
import com.mycompany.assignment2.userbackend.soap.AdminDatabaseService;
import com.mycompany.assignment2.userbackend.soap.AdminDatabaseService_Service;
import com.mycompany.assignment2.userbackend.soap.Dupflix;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * REST Web Service
 *
 * @author Niya
 */

@Path("home")
@Produces("text/json")
public class HomeService implements MessageBodyWriter {

  @Path("string")
    @GET
    public String getCommentString(){
        
        DupFlix flix = generateComment();
        
        Gson gson = new Gson();
        return gson.toJson(flix);
        
    }
    
    @Path("response")
    @GET
    @Produces("text/json")
    public Response getCommentResponse(){
       DupFlix flix = generateComment();
       return Response.ok(flix).build();
    }
    
    @GET
    public DupFlix getComment(){
        return generateComment();
    }
    
    private DupFlix generateComment(){
        DupFlix flix = new DupFlix();
        flix.setDupflixId(1);
        flix.setMovieName("Dog");
        flix.setProducer("Master");
        flix.setDirector("MasterDir");
        return flix;
    }

    @Override
    public boolean isWriteable(Class type, Type type1, Annotation[] antns, MediaType mt) {
        if (type.getClass().equals(Response.class)){
        return true;
        }
        return false;
    }

    @Override
    public void writeTo(Object t, Class type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap mm, OutputStream out) throws IOException, WebApplicationException {
        
     
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal((Response)t, out);
        } catch (JAXBException ex) {
            Logger.getLogger(HomeService.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    }
    @GET
    @Path("all")
    @Produces("text/json")
    public List<DupFlix> getAllDupFlixData(){
        
        return getData();
    }
    
    @GET
    @Path("all/{count}")
    @Produces("text/json")
    public List<DupFlix> getAllComments(@PathParam("count") int count){
        
        return getData().stream().limit(count).collect(Collectors.toList());
    }
    
    private ArrayList<DupFlix> getData(){
        
        AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
            ArrayList<Dupflix> dupFlixList = new ArrayList<Dupflix>();
            ArrayList<DupFlix> dupFlixLs = new ArrayList<DupFlix>();
            dupFlixList = (ArrayList<Dupflix>) port.getAllDupFlixData();
            for(Dupflix dp:dupFlixList){
            DupFlix flix = new DupFlix();
        flix.setDupflixId(dp.getDupflixId());
        flix.setMovieName(dp.getMovieName());
        flix.setMovieSubtitle(dp.getMovieSubtitle());
        flix.setThumbnail(Base64.getEncoder().encodeToString(dp.getThumbnail()));
        flix.setCategoryType(dp.getCategoryType());
        flix.setDirector(dp.getDirector());
        flix.setProducer(dp.getProducer());
        flix.setMovieDescription(dp.getMovieDescription());
        flix.setIstrending(dp.getIstrending());
        dupFlixLs.add(flix);
    }
            return dupFlixLs;
    }
  
}
