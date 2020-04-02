/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.databaseconnection.handler;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author Niya
 */
public class DupFlixMovieNameHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
        SOAPMessage msg = messageContext.getMessage();
        String content = null;
        try {
            content = msg.getSOAPBody().getTextContent();
             Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
          if(!outbound){
                if(content.contains("disney")||content.contains("Disney")){
                 generateSOAPErrMessage(msg, "Cannot enter word Disney"); 
                }
            }
        
        } catch (SOAPException ex) {
            Logger.getLogger(DupFlixMovieNameHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       
        return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        System.out.println("Server : handleFault()......");
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
    private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
       try {
           QName faultname =new QName(SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE,"clients");
          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
          SOAPFault soapFault = soapBody.addFault();
          Detail detail = soapFault.addDetail();
          soapFault.setFaultString(reason);
          throw new SOAPFaultException(soapFault);
       }
       catch(SOAPException e) { }
    }
    
}
