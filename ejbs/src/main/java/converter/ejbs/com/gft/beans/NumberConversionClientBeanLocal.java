/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gft.beans;

import javax.ejb.Local;
import java.math.BigInteger;
import java.net.MalformedURLException;

/**
 *
 * @author MMikolaychuk
 */
@Local
public interface NumberConversionClientBeanLocal  {
    String getString(int num)throws MalformedURLException;

}
