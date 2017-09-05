/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Timestamp;

/**
 *
 * @author Ada
 */
public class getTime {
      public static String getTimestamp(){
	 java.util.Date date= new java.util.Date();
	 return new Timestamp(date.getTime()).toString();
    }
}
