/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.userbackend.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niya
 */
@XmlRootElement
public class DupFlix {

    
    
 
    private String movieName;
  
    private String movieSubtitle;
  
    private String movieDescription;

    private String categoryType;


    private String thumbnail;


    private String director;

  
    private String producer;

    private String istrending;
    
     private Integer dupflixId;

    public Integer getDupflixId() {
        return dupflixId;
    }

    public void setDupflixId(Integer dupflixId) {
        this.dupflixId = dupflixId;
    }
    
   
    
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieSubtitle() {
        return movieSubtitle;
    }

    public void setMovieSubtitle(String movieSubtitle) {
        this.movieSubtitle = movieSubtitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getIstrending() {
        return istrending;
    }

    public void setIstrending(String istrending) {
        this.istrending = istrending;
    }
  

}
