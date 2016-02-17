/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import com.health.main.frmLogin;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Ajeet
 */
public class HealthCare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        MetalLookAndFeel lf=new MetalLookAndFeel();
//        lf.setCurrentTheme(new CMOSTheme());
//        lf.initialize();
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (Exception ex) {
        }

        new frmLogin(null, true).setVisible(true);
    }

}
