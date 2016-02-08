/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import com.health.main.frmParent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Ajeet
 */
public class HealthCare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//         TODO code application logic here
        MetalLookAndFeel lf=new MetalLookAndFeel();
        lf.setCurrentTheme(new CMOSTheme());                
        try {
            UIManager.setLookAndFeel(lf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HealthCare.class.getName()).log(Level.SEVERE, null, ex);
        }
        new frmParent().setVisible(true);
    }
    
}
