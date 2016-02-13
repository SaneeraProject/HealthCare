/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Ajeet
 */
public class ButtonUI extends BasicButtonUI{

    @Override
    public void paint(Graphics g, JComponent c) {
        g.setColor(Color.blue);
//        g.fillRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
        super.paint(g, c);
//        super.paintIcon(g, c,null);
    }
    
    
    
}
