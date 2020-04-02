/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import com.mycompany.assignment2.DupFlixJpaController.DupFlixJPAController.DupflixJpaController;
import com.mycompany.assignment2.DupFlixJpaController.DupFlixJPAController.exceptions.NonexistentEntityException;
import com.mycompany.assignment2.entities.Dupflix;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.soap.SOAPException;

/**
 *
 * @author Niya
 */
@WebService(serviceName = "AdminDatabaseService")
@HandlerChain(file = "AdminDatabaseService_handler.xml")
public class AdminDatabaseService {

    
     @WebMethod
   public int upload(Dupflix dupflix) 
           
   {
       int success =1;
      
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            
            DupflixJpaController dupFlixRepo = new DupflixJpaController(emf);
            
            Dupflix dpf = new Dupflix();
            
            dpf.setMovieName(dupflix.getMovieName());
            dpf.setMovieSubtitle(dupflix.getMovieSubtitle());
            dpf.setMovieDescription(dupflix.getMovieDescription());
            dpf.setCategoryType(dupflix.getCategoryType());
         
            dpf.setDupflixId(dupFlixRepo.getDupflixCount() + 1);
            dpf.setDirector(dupflix.getDirector());
            dpf.setProducer(dupflix.getProducer());
            dpf.setThumbnail(dupflix.getThumbnail());
            dpf.setIstrending(dupflix.getIstrending());
            dupFlixRepo.create(dpf);
            
            
        } catch(SOAPException ex){
            success =2;
           return success;
            
        }catch (Exception ex) {

            success =0;
           return success;
        }
               
         return success;      
   }
   
    @WebMethod
   public List<Dupflix> getAllDupFlixData(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            
            DupflixJpaController dupFlixRepo = new DupflixJpaController(emf);
            
            List<Dupflix> list = dupFlixRepo.findDupflixEntities();
            
            return list;
       
   }
   
    @WebMethod
   public int editDupFlixData(Dupflix dupFlix){
       int success = 1;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            
            DupflixJpaController dupFlixRepo = new DupflixJpaController(emf);
            dupFlixRepo.edit(dupFlix);
        } catch (Exception ex) {
           success = 0;
           return success;
        }
        return success;
   }
   
    @WebMethod
   public int deleteDupFlixData(int id){
       int success = 1;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            
            DupflixJpaController dupFlixRepo = new DupflixJpaController(emf);
            dupFlixRepo.destroy(id);
        } catch (NonexistentEntityException ex) {
            success = 0;
            return success;
        }
         
        return success;
            
   }
   
   @WebMethod
   public Dupflix getDupFlixData(int id){
      
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            
            DupflixJpaController dupFlixRepo = new DupflixJpaController(emf);
            Dupflix flix = dupFlixRepo.findDupflix(id);
            return flix;
       
   }
   

}
