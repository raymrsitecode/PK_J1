/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsx.tamagochi.dao;

import com.itsx.tamagochi.dto.Mascota;
import com.itsx.tamagochi.dto.UsuarioDto;
import com.itsx.tamagochi.utils.UtilDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymundo
 */
public class MascotaDao {
    

 public static void inserUsuario(Mascota mascota, int usuario_id){
             Connection con = UtilDao.getConnection();
         String sql = " insert into t_mascota (name, type, color, t_usuarios_id) values (?, ?, ?, ? ) ";
               PreparedStatement preparedStmt;
        try {
                preparedStmt = con.prepareStatement(sql);

                preparedStmt.setString (1, mascota.getName());
                preparedStmt.setString (2, mascota.getClase());
                preparedStmt.setString( 3, mascota.getColor());
                preparedStmt.setInt(4, usuario_id);

                preparedStmt.execute(); 
                JOptionPane.showMessageDialog(null, "La mascota se ha creado correctamente");
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                
}

    public static List<Mascota> getMascota(int userId){
               Connection con = UtilDao.getConnection();
        try {
           Statement stmt = con.createStatement();
           ResultSet rs=stmt.executeQuery("SELECT * FROM t_mascota where t_usuarios_id = '"+userId+"'");  

                    
                    List<Mascota> mascotas = new ArrayList<>();
                   
                   while(rs.next()){
                            Mascota mascota = new Mascota();
                            mascota.setName(rs.getString("name"));
                            mascota.setClase(rs.getString("type"));
                            mascota.setColor(rs.getString("color"));
                            mascotas.add(mascota);
                         }    
                       
                       con.close();
                       return mascotas;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
              
}


 public static Mascota getMascotaById(String name){
               Connection con = UtilDao.getConnection();
        try {
           Statement stmt = con.createStatement();
           ResultSet rs=stmt.executeQuery("SELECT * FROM t_mascota where name = '"+name+"'");  
                    
                   Mascota mascota = new Mascota();
                   
                   while(rs.next()){

                            mascota.setName(rs.getString("name"));
                            mascota.setClase(rs.getString("type"));
                            mascota.setColor(rs.getString("color"));
                    
                         }    
                           
                       con.close();
                          return mascota;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
              
}
}
