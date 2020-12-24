/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.beans;

import java.net.MalformedURLException;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author MMikolaychuk
 */
public interface NumberConverterLocal extends EJBLocalObject{
    String getString(int num) throws MalformedURLException;    
}
