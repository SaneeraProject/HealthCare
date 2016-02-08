/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author Ajeet
 */
public class CustomHeader extends JPanel{
    public CustomHeader(){
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setPaint(new GradientPaint(new Point2D.Double(0,0),Color.WHITE, new Point2D.Double(getWidth(),getHeight()), Color.decode("#ff9900")));
        g2d.fill(getBounds());
    }
}
