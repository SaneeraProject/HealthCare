package com.health.launcher;
//-*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
//http://ateraimemo.com/Swing/ToolButtonPopup.html

import java.awt.*;
import java.net.*;
import javax.swing.*;

public final class MainPanel extends JDesktopPane {

    private final JToolBar toolbar = new JToolBar("toolbar");
    private final JPopupMenu pop1 = new JPopupMenu();
    private final JPopupMenu pop2 = new JPopupMenu();
    private final URL url = getClass().getResource("ei0021-16.png");
    private final Component rigid = Box.createRigidArea(new Dimension(5, 5));

    public MainPanel() {
        setPreferredSize(new Dimension(700, 500));
    }

    
    public void createAndShowGUI() {
        JFrame frame = new JFrame("ToolButtonPopup");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MenuBar mb = new MenuBar();
        
        Menu dashboard=new Menu("Dashboards");
        dashboard.add(new JMenuItem("Go to dashboard"));
        mb.add(dashboard);
        Menu modules = new Menu("Modules");
        modules.add(new JMenuItem("Clinic Manager"));
        modules.add(new JMenuItem("Pharmacy Manager"));
        modules.add(new JMenuItem("Diagnosys Manager"));
        modules.addSeparator();
        modules.add(new JMenuItem("Payment Manager"));

        mb.add(modules);
        Menu utilities=new Menu("Utilities");
        utilities.add(new JMenuItem("Calculator"));
        utilities.add(new JMenuItem("Messanger"));
        utilities.addSeparator();
        utilities.add(new JMenuItem("Queue Window"));
        mb.add(utilities);
        Menu administration=new Menu("Administration");
        administration.add(new JMenuItem("Hospital Setting"));
        administration.add(new JMenuItem("Invoice Setting"));        
        mb.add(administration);
        mb.add(Box.createHorizontalGlue());
        JTextField textField01 = new JTextField(20) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque()) {
                    int w = getWidth();
                    int h = getHeight();
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(UIManager.getColor("TextField.background"));
                    g2.fillRoundRect(0, 0, w - 1, h - 1, h, h);
                    g2.setColor(Color.WHITE);
                    g2.drawRoundRect(0, 0, w - 1, h - 1, h, h);
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        textField01.setOpaque(false);
        textField01.setMaximumSize(new Dimension(100, 25));
        textField01.setBackground(new Color(0x0, true)); //Nimbus
        textField01.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        mb.add(textField01);
        Menu account = new Menu("User");
        account.add(new JMenuItem("Change Password"));
        account.addSeparator();
        account.add(new JMenuItem("Logout"));

        mb.add(account);
        frame.setJMenuBar(mb);
        JToolBar tb = new JToolBar();
        tb.setOpaque(false);
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/e.png"))));
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/l.png"))));
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/m.png"))));
        tb.addSeparator();
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/d.png"))));
        tb.addSeparator();
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/j.png"))));
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/f.png"))));
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/g.png"))));
        tb.addSeparator();
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/k.png"))));
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/i.png"))));
        tb.addSeparator();
        tb.add(new JButton(new ImageIcon(getClass().getResource("/com/health/launcher/susu/a.png"))));
        frame.getContentPane().add(tb, BorderLayout.NORTH);

        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
