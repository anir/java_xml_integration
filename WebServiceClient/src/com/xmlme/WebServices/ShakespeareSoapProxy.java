package com.xmlme.WebServices;

public class ShakespeareSoapProxy implements com.xmlme.WebServices.ShakespeareSoap {
  private String _endpoint = null;
  private com.xmlme.WebServices.ShakespeareSoap shakespeareSoap = null;
  
  public ShakespeareSoapProxy() {
    _initShakespeareSoapProxy();
  }
  
  public ShakespeareSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initShakespeareSoapProxy();
  }
  
  private void _initShakespeareSoapProxy() {
    try {
      shakespeareSoap = (new com.xmlme.WebServices.ShakespeareLocator()).getShakespeareSoap();
      if (shakespeareSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shakespeareSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shakespeareSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shakespeareSoap != null)
      ((javax.xml.rpc.Stub)shakespeareSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.xmlme.WebServices.ShakespeareSoap getShakespeareSoap() {
    if (shakespeareSoap == null)
      _initShakespeareSoapProxy();
    return shakespeareSoap;
  }
  
  public java.lang.String getSpeech(java.lang.String request) throws java.rmi.RemoteException{
    if (shakespeareSoap == null)
      _initShakespeareSoapProxy();
    return shakespeareSoap.getSpeech(request);
  }
  
  
}