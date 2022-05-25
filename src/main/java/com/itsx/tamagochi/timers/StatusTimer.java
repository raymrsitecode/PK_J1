/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsx.tamagochi.utils;


import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author softtek
 */
public class StatusTimer extends TimerTask{

    private JProgressBar jProgressBar;
    private int progress = 0;
    
    public StatusTimer(JProgressBar jProgressBar,int progress){
        this.jProgressBar = jProgressBar;
        this.progress = progress;
    }
    @Override
    public void run() {
       modifyStatusProgress(jProgressBar);
    }
    
    private void modifyStatusProgress(JProgressBar jProgressBar1){
        
        int value = jProgressBar1.getValue(); 
           value =  value - 10;
           if( value == 10 ){
               JOptionPane.showMessageDialog(null, "La energia se esta por terminar");
           }else{
                jProgressBar1.setValue(value);
                 System.out.println("com.itsx.tamagochi.EstadosAnimoPantall.jButton1ActionPerformed()"+ value);
           }
    }
}
