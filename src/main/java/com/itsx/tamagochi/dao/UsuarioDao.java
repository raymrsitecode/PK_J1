/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsx.tamagochi.dao;

import com.itsx.tamagochi.dto.UsuarioDto;
import com.itsx.tamagochi.utils.UtilDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymundo
 */
public class UsuarioDao {


    public static void inserUsuario(UsuarioDto usuario){
             Connection con = UtilDao.getConnection();
         String sql = " insert into t_usuarios (user, password, token_security) values (?, ?, ? )";
               PreparedStatement preparedStmt;
        try {
                preparedStmt = con.prepareStatement(sql);

                preparedStmt.setString (1, usuario.getUser());
                preparedStmt.setString (2, usuario.getPassword());
                preparedStmt.setString( 3, usuario.getToken_security());

                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente");
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                
}

 public static UsuarioDto getUsuario(UsuarioDto usuario){
               Connection con = UtilDao.getConnection();
        try {
           Statement stmt = con.createStatement();
           ResultSet rs=stmt.executeQuery("SELECT * FROM t_usuarios where user = '"+usuario.getUser()+"' and password = '"+usuario.getPassword()+"'");  
                    
                    UsuarioDto user = new UsuarioDto();
                   while(rs.next()){
                            user.setId( rs.getInt("id"));
                            user.setUser(rs.getString("user"));
                            user.setPassword(rs.getString("password"));
                            user.setToken_security(rs.getString("token_security"));
                         }    
                       
                       con.close();
                       return user;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
              
}
 
 
}
