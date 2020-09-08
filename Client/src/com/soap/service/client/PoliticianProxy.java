package com.soap.service.client;

public class PoliticianProxy implements com.soap.service.client.Politician {
  private String _endpoint = null;
  private com.soap.service.client.Politician politician = null;
  
  public PoliticianProxy() {
    _initPoliticianProxy();
  }
  
  public PoliticianProxy(String endpoint) {
    _endpoint = endpoint;
    _initPoliticianProxy();
  }
  
  private void _initPoliticianProxy() {
    try {
      politician = (new com.soap.service.client.PoliticianServiceLocator()).getPoliticianPort();
      if (politician != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)politician)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)politician)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (politician != null)
      ((javax.xml.rpc.Stub)politician)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.soap.service.client.Politician getPolitician() {
    if (politician == null)
      _initPoliticianProxy();
    return politician;
  }
  
  
}