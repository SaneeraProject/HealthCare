/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import com.health.main.frmLogin;
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
        MetalLookAndFeel lf=new MetalLookAndFeel();
        lf.setCurrentTheme(new CMOSTheme());
        lf.initialize();
        
        new frmLogin(null, true).setVisible(true);
    }

}
