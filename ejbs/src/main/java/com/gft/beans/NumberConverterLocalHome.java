/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.beans;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author MMikolaychuk
 */
public interface NumberConverterLocalHome extends EJBLocalHome {
     public NumberConverterLocal create() throws CreateException;
}
