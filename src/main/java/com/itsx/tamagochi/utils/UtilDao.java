/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsx.tamagochi.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raymundo
 */
public class UtilDao {
    

   public static Connection getConnection(){

        Properties props = getConnectionData();
            try{  
                  Class.forName(props.getProperty("db.driver"));  
                   return  DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.user"), props.getProperty("db.passwd"));  
              }catch(Exception e){ 
                                   System.out.println(e);
                         }  

          return null;
}
    
   private static Properties getConnectionData() {
        Properties props = new Properties();
        String fileName = "src/main/resources/db.properties";
        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(UtilDao.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return props;
    }

}
