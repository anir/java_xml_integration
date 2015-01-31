/**
 * Shakespeare.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmlme.WebServices;

public interface Shakespeare extends javax.xml.rpc.Service {

/**
 * This Web Service takes a phrase from the plays of William Shakespeare
 * and returns the associated speech, speaker, and play. The Shakespeare
 * texts used in this Web Service are the XML versions developed by Jon
 * Bosak.  Go to http://www.oasis-open.org/cover/bosakShakespeare200.html
 * for more information on the texts. See http://www.xmlme.com for a
 * sample client and additional details about the Shakespeare Web Service.
 */
    public java.lang.String getShakespeareSoapAddress();

    public com.xmlme.WebServices.ShakespeareSoap getShakespeareSoap() throws javax.xml.rpc.ServiceException;

    public com.xmlme.WebServices.ShakespeareSoap getShakespeareSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
