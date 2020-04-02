
package com.mycompany.assignment2.userbackend.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dupflix complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dupflix">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dupflixId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="istrending" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movieDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movieName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movieSubtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="producer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thumbnail" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dupflix", propOrder = {
    "categoryType",
    "director",
    "dupflixId",
    "istrending",
    "movieDescription",
    "movieName",
    "movieSubtitle",
    "producer",
    "thumbnail"
})
public class Dupflix {

    protected String categoryType;
    protected String director;
    protected Integer dupflixId;
    protected String istrending;
    protected String movieDescription;
    protected String movieName;
    protected String movieSubtitle;
    protected String producer;
    protected byte[] thumbnail;

    /**
     * Gets the value of the categoryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * Sets the value of the categoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryType(String value) {
        this.categoryType = value;
    }

    /**
     * Gets the value of the director property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the value of the director property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirector(String value) {
        this.director = value;
    }

    /**
     * Gets the value of the dupflixId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDupflixId() {
        return dupflixId;
    }

    /**
     * Sets the value of the dupflixId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDupflixId(Integer value) {
        this.dupflixId = value;
    }

    /**
     * Gets the value of the istrending property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIstrending() {
        return istrending;
    }

    /**
     * Sets the value of the istrending property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIstrending(String value) {
        this.istrending = value;
    }

    /**
     * Gets the value of the movieDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieDescription() {
        return movieDescription;
    }

    /**
     * Sets the value of the movieDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieDescription(String value) {
        this.movieDescription = value;
    }

    /**
     * Gets the value of the movieName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Sets the value of the movieName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieName(String value) {
        this.movieName = value;
    }

    /**
     * Gets the value of the movieSubtitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieSubtitle() {
        return movieSubtitle;
    }

    /**
     * Sets the value of the movieSubtitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieSubtitle(String value) {
        this.movieSubtitle = value;
    }

    /**
     * Gets the value of the producer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Sets the value of the producer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducer(String value) {
        this.producer = value;
    }

    /**
     * Gets the value of the thumbnail property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setThumbnail(byte[] value) {
        this.thumbnail = value;
    }

}
