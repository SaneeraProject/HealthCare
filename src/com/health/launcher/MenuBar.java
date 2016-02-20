/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.border.Border;

/**
 *
 * @author Ajeet
 */
enum POSITION {
    
    LEFT, RIGHT;
}

public class MenuBar extends JMenuBar {
    
    ArrayList<Component> allItems = new ArrayList<Component>();
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(32, 80, 129));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    public Insets getInsets() {
        return new Insets(0, 1, 0, 1); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Border getBorder() {
        return BorderFactory.createEmptyBorder(0, 0, 0, 0); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void add(Component c, POSITION p) {
        allItems.add(c);
    }
    
}
