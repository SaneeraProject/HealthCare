/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

/**
 *
 * @author Ajeet
 */
public class Menu extends JMenu {

    private static final Icon ARROW_ICON = new MenuArrowIcon();

    
    public Menu(String pappu) {
        super(pappu);
        setFocusPainted(false);
        setRolloverEnabled(false);
        setFont(new Font("Arial", 0, 14));
    }

    @Override
    public JMenuItem add(JMenuItem menuItem) {
        menuItem.setMargin(new Insets(2, 50, 2, 50));
        menuItem.setPreferredSize(new Dimension(150, 25));
        return super.add(menuItem); 
    }

    
    
    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 15); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Border getBorder() {
        return BorderFactory.createEmptyBorder(0, 0, 0, 0); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (isSelected()) {
            g2.setColor(new Color(32,80,129).brighter());
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
        g2.setColor(Color.WHITE);
//        g2.setFont();
//        g2.drawString(getText(), 15, 14 + g.getFontMetrics().getHeight() / 2);
        Dimension dim = getSize();
        Insets ins = getInsets();
        int x = dim.width - ins.right;
        int y = ins.top + (dim.height - ins.top - ins.bottom - ARROW_ICON.getIconHeight()) / 2;
        g.setColor(Color.WHITE);
        ARROW_ICON.paintIcon(this, g2, x, y);
        
        g2.drawString(getText(), 15, 14 + g.getFontMetrics().getHeight() / 2);
    }

}
