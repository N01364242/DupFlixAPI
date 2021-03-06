
package com.mycompany.assignment2.userbackend.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AdminDatabaseService", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AdminDatabaseService {


    /**
     * 
     * @return
     *     returns java.util.List<com.mycompany.assignment2.userbackend.soap.Dupflix>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllDupFlixData", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.GetAllDupFlixData")
    @ResponseWrapper(localName = "getAllDupFlixDataResponse", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.GetAllDupFlixDataResponse")
    @Action(input = "http://service/AdminDatabaseService/getAllDupFlixDataRequest", output = "http://service/AdminDatabaseService/getAllDupFlixDataResponse")
    public List<Dupflix> getAllDupFlixData();

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteDupFlixData", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.DeleteDupFlixData")
    @ResponseWrapper(localName = "deleteDupFlixDataResponse", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.DeleteDupFlixDataResponse")
    @Action(input = "http://service/AdminDatabaseService/deleteDupFlixDataRequest", output = "http://service/AdminDatabaseService/deleteDupFlixDataResponse")
    public int deleteDupFlixData(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "upload", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.UploadResponse")
    @Action(input = "http://service/AdminDatabaseService/uploadRequest", output = "http://service/AdminDatabaseService/uploadResponse")
    public int upload(
        @WebParam(name = "arg0", targetNamespace = "")
        Dupflix arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editDupFlixData", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.EditDupFlixData")
    @ResponseWrapper(localName = "editDupFlixDataResponse", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.EditDupFlixDataResponse")
    @Action(input = "http://service/AdminDatabaseService/editDupFlixDataRequest", output = "http://service/AdminDatabaseService/editDupFlixDataResponse")
    public int editDupFlixData(
        @WebParam(name = "arg0", targetNamespace = "")
        Dupflix arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.mycompany.assignment2.userbackend.soap.Dupflix
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDupFlixData", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.GetDupFlixData")
    @ResponseWrapper(localName = "getDupFlixDataResponse", targetNamespace = "http://service/", className = "com.mycompany.assignment2.userbackend.soap.GetDupFlixDataResponse")
    @Action(input = "http://service/AdminDatabaseService/getDupFlixDataRequest", output = "http://service/AdminDatabaseService/getDupFlixDataResponse")
    public Dupflix getDupFlixData(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
