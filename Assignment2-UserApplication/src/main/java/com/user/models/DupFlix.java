/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Niya
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DupFlix {
    
     private String categoryType;
    private String director;
    private Integer dupflixId;
    private String istrending;
    private String movieDescription;
    private String movieName;
    private String movieSubtitle;
    private String producer;
    private String thumbnail;
    private String video;

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDupflixId() {
        return dupflixId;
    }

    public void setDupflixId(Integer dupflixId) {
        this.dupflixId = dupflixId;
    }

    public String getIstrending() {
        return istrending;
    }

    public void setIstrending(String istrending) {
        this.istrending = istrending;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
