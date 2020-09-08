
package com.soap.service.client;

public interface PoliticianService extends javax.xml.rpc.Service {
    public java.lang.String getPoliticianPortAddress();

    public com.soap.service.client.Politician getPoliticianPort() throws javax.xml.rpc.ServiceException;

    public com.soap.service.client.Politician getPoliticianPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
