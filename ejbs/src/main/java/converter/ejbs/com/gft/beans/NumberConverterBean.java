/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.beans;

import com.gft.beans.generated.NumberConversionSoapType;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author MMikolaychuk
 */
public class NumberConverterBean {
    private static final String SERVICE = "NumberConversion";
    private static final String URL_STR = "http://www.dataaccess.com/webservicesserver/";
    private static final String EXT = ".wso?WSDL";
    
    public void ejbCreate() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext(javax.ejb.SessionContext ctx) {}
    public void unsetSessionContext() {}
    public void ejbRemove() {}
        
    public String getString(int num) throws MalformedURLException {
        String url = String.format("%s%s%s", URL_STR, SERVICE, EXT);
        URL wsdContractURL = new URL(url);
        QName serviceName = new QName(URL_STR, SERVICE);
        Service service = Service.create(wsdContractURL, serviceName);
        NumberConversionSoapType client = service.getPort(NumberConversionSoapType.class);                
        return client.numberToWords(BigInteger.valueOf(num));                          
    }
}
