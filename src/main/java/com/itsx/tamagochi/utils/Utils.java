/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itsx.tamagochi.utils;


import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

/**
 *
 * @author Raymundo
 */
public class Utils {


 public static void fill(JProgressBar  b)
    {
        int i = 0;
        try {
            while (i <= 100) {
                // fill the menu bar
                b.setValue(i + 10);
 
                // delay the thread
                Thread.sleep(1000);
                i += 20;
            }
        }
        catch (Exception e) {
        }
    }
    
public ImageIcon createImageIcon(String path,String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

public static JRadioButton getSelection(ButtonGroup group)
{
        for (Enumeration e=group.getElements(); e.hasMoreElements(); )
        {
            JRadioButton b = (JRadioButton)e.nextElement();
            if (b.getModel() == group.getSelection())
            {
                return b;
            }
        }

        return null;
}

  public static String getSelectedButtonText(ButtonGroup buttonGroup) { 
          for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); 
                          buttons.hasMoreElements();) 
                  { 
              AbstractButton button = buttons.nextElement(); 
              if (button.isSelected()) { 
                      return button.getText(); 
               } 
              } 
                return null; 
           }


 public static void isSelectedMascota(String seleccionado, ButtonGroup group, JLabel jLabel){
         jLabel.setIcon(null);
   if( seleccionado.contentEquals("Perro") && Utils.getSelectedButtonText(group).contentEquals("rojo")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-red-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
           if( seleccionado.contentEquals("Perro") && Utils.getSelectedButtonText(group).contentEquals("azul")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-blue-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
          if( seleccionado.contentEquals("Perro") && Utils.getSelectedButtonText(group).contentEquals("verde")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-green-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
          if( seleccionado.contentEquals("Perro") && Utils.getSelectedButtonText(group).contentEquals("violeta")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-violet-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
} 


public static void selectActualMascotaImage(String type, String  color, JLabel jLabel){
         jLabel.setIcon(null);
   if( type.contentEquals("Perro") && color.contentEquals("rojo")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-red-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
           if( type.contentEquals("Perro") && color.contentEquals("azul")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-blue-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
          if( type.contentEquals("Perro") && color.contentEquals("verde")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-green-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
          if( type.contentEquals("Perro") && color.contentEquals("violeta")){
                Utils util = new Utils();
                ImageIcon imageIcon = util.createImageIcon("/c1-violet-happy.png", "");
                jLabel.setIcon(  imageIcon );
            }
} 


            public static void fillJProgressBar(JProgressBar jProgressBar1, int stateActual)
               {
                   int i = 0;
                   try {
                       while (i <= stateActual) {
                           // fill the menu bar
                           jProgressBar1.setValue(i + 10);
                           i += 20;
                       }
                   }
                   catch (Exception e) {

                   }
               }

            public static void comer(JProgressBar jProgressBar1,JProgressBar jProgressBar2)
                           {
                                    int vida = jProgressBar1.getValue();
                                         vida = vida + 5;
                                       jProgressBar1.setValue(vida);

                                    int hambre = jProgressBar2.getValue();
                                         hambre = hambre + 20;
                                       jProgressBar2.setValue(hambre);
                                   
                                   
                              
                           }
            public static void tomarAgua(JProgressBar jProgressBar1,JProgressBar jProgressBar3)
                           {
                                    int vida = jProgressBar1.getValue();
                                         vida = vida + 2;
                                       jProgressBar1.setValue(vida);

                                    int sed = jProgressBar3.getValue();
                                         sed = sed + 20;
                                       jProgressBar3.setValue(sed);
                                   
                                   
                              
                           }
}
