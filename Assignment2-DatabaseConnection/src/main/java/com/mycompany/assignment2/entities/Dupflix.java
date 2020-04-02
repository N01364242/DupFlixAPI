/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Niya
 */
@Entity
@Table(name = "DUPFLIX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dupflix.findAll", query = "SELECT d FROM Dupflix d"),
    @NamedQuery(name = "Dupflix.findByDupflixId", query = "SELECT d FROM Dupflix d WHERE d.dupflixId = :dupflixId"),
    @NamedQuery(name = "Dupflix.findByMovieName", query = "SELECT d FROM Dupflix d WHERE d.movieName = :movieName"),
    @NamedQuery(name = "Dupflix.findByMovieSubtitle", query = "SELECT d FROM Dupflix d WHERE d.movieSubtitle = :movieSubtitle"),
    @NamedQuery(name = "Dupflix.findByMovieDescription", query = "SELECT d FROM Dupflix d WHERE d.movieDescription = :movieDescription"),
    @NamedQuery(name = "Dupflix.findByCategoryType", query = "SELECT d FROM Dupflix d WHERE d.categoryType = :categoryType")})
public class Dupflix implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Size(max = 255)
    @Column(name = "MOVIE_SUBTITLE")
    private String movieSubtitle;
    @Size(max = 800)
    @Column(name = "MOVIE_DESCRIPTION")
    private String movieDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CATEGORY_TYPE")
    private String categoryType;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "DIRECTOR")
    private String director;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRODUCER")
    private String producer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ISTRENDING")
    private String istrending;
    

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUPFLIX_ID")
    private Integer dupflixId;

    public Dupflix() {
    }

    public Dupflix(Integer dupflixId) {
        this.dupflixId = dupflixId;
    }

    public Dupflix(Integer dupflixId, String movieName, String categoryType) {
        this.dupflixId = dupflixId;
        this.movieName = movieName;
        this.categoryType = categoryType;
    }

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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dupflixId != null ? dupflixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dupflix)) {
            return false;
        }
        Dupflix other = (Dupflix) object;
        if ((this.dupflixId == null && other.dupflixId != null) || (this.dupflixId != null && !this.dupflixId.equals(other.dupflixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.assignment2.entities.Dupflix[ dupflixId=" + dupflixId + " ]";
    }

    
   
    

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
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
