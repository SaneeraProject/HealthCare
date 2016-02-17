/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.main;

import com.database.User;
import com.health.chat.ChatForm;
import com.health.clinic.ClinicList;
import com.health.clinic.ClinicScreen;
import com.health.doctor.frmPhysician;
import com.health.patient.PatientScreen;
import com.health.payment.PaymentScreen;
import com.health.pharmacy.PharmacyScreen;
import com.health.token.TokenScreen;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Ajeet
 */
public class frmParent extends javax.swing.JFrame {

    /**
     * Creates new form frmParent
     */
    public static User user = null;
    private ChatForm chatForm1;

    public frmParent(User user) {
        this.user = user;
        initComponents();
        btnPatient.setVisible(false);
        btnClinic.setVisible(false);
        btnApointment.setVisible(false);
        btnFarmacy.setVisible(false);
        btnPhyision.setVisible(false);
        btnSetting.setVisible(false);
        btnToken.setVisible(false);
        btnPayment.setVisible(false);
        lblUser.setText(user.getUserName());
        setMinimumSize(new Dimension(600, 600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        chatForm1=new ChatForm();
        jPanel3.add(chatForm1,BorderLayout.EAST);
        loadbuttons();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new CustomHeader();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnPatient = new javax.swing.JButton();
        btnClinic = new javax.swing.JButton();
        btnApointment = new javax.swing.JButton();
        btnFarmacy = new javax.swing.JButton();
        btnPhyision = new javax.swing.JButton();
        btnToken = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSetting = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        jMenuItem16.setText("jMenuItem16");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Health Care");

        jToolBar2.setOpaque(false);

        jLabel1.setText("Status : ");
        jToolBar2.add(jLabel1);

        jProgressBar1.setMaximumSize(new java.awt.Dimension(146, 14));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(146, 14));
        jToolBar2.add(jProgressBar1);
        jToolBar2.add(jSeparator2);

        jLabel2.setText("Tax Rate : ");
        jToolBar2.add(jLabel2);

        jTextField1.setText("0.0");
        jTextField1.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(100, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 20));
        jToolBar2.add(jTextField1);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        jLabel3.setText("Health Care");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jLabel3, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Picture12.png"))); // NOI18N
        jButton2.setToolTipText("Home");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Picture10.png"))); // NOI18N
        jButton3.setToolTipText("Chat");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        jPanel1.add(jButton3, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Picture11.png"))); // NOI18N
        jButton4.setToolTipText("My Profile");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setMargin(new java.awt.Insets(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 10);
        jPanel1.add(jButton4, gridBagConstraints);

        lblUser.setBackground(new java.awt.Color(51, 51, 51));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Not logged in");
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(lblUser, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(102, 102, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Logout");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setFocusable(false);
        jButton5.setMaximumSize(new java.awt.Dimension(100, 23));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jButton5, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));

        btnPatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture2.png"))); // NOI18N
        btnPatient.setToolTipText("Patients");
        btnPatient.setBorderPainted(false);
        btnPatient.setContentAreaFilled(false);
        btnPatient.setFocusable(false);
        btnPatient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPatient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPatient);

        btnClinic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture3.png"))); // NOI18N
        btnClinic.setToolTipText("Clinics");
        btnClinic.setBorderPainted(false);
        btnClinic.setContentAreaFilled(false);
        btnClinic.setFocusable(false);
        btnClinic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClinic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClinicActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClinic);

        btnApointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture4.png"))); // NOI18N
        btnApointment.setToolTipText("Appointments");
        btnApointment.setBorderPainted(false);
        btnApointment.setContentAreaFilled(false);
        btnApointment.setFocusable(false);
        btnApointment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnApointment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnApointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApointmentActionPerformed(evt);
            }
        });
        jToolBar1.add(btnApointment);

        btnFarmacy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture5.png"))); // NOI18N
        btnFarmacy.setToolTipText("Pharmacy");
        btnFarmacy.setBorderPainted(false);
        btnFarmacy.setContentAreaFilled(false);
        btnFarmacy.setFocusable(false);
        btnFarmacy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFarmacy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFarmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFarmacyActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFarmacy);

        btnPhyision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture6.png"))); // NOI18N
        btnPhyision.setToolTipText("Physicians");
        btnPhyision.setBorderPainted(false);
        btnPhyision.setContentAreaFilled(false);
        btnPhyision.setFocusable(false);
        btnPhyision.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPhyision.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPhyision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhyisionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPhyision);

        btnToken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture7.png"))); // NOI18N
        btnToken.setToolTipText("Token Manager ");
        btnToken.setBorderPainted(false);
        btnToken.setContentAreaFilled(false);
        btnToken.setFocusable(false);
        btnToken.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnToken.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnToken);

        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture8.png"))); // NOI18N
        btnPayment.setToolTipText("Payments");
        btnPayment.setBorderPainted(false);
        btnPayment.setContentAreaFilled(false);
        btnPayment.setFocusable(false);
        btnPayment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPayment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPayment);
        jToolBar1.add(jSeparator1);

        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small/Picture9.png"))); // NOI18N
        btnSetting.setToolTipText("Settings");
        btnSetting.setBorderPainted(false);
        btnSetting.setContentAreaFilled(false);
        btnSetting.setFocusable(false);
        btnSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSetting);

        jPanel3.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        new frmLogin(null, true).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnApointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApointmentActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new ClinicList(this, true));        // TODO add your handling code here:
    }//GEN-LAST:event_btnApointmentActionPerformed

    private void btnPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new PatientScreen(this));
    }//GEN-LAST:event_btnPatientActionPerformed

    private void btnClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClinicActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new ClinicScreen(this));
    }//GEN-LAST:event_btnClinicActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new PaymentScreen(this));
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnPhyisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhyisionActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new frmPhysician(this, true));
    }//GEN-LAST:event_btnPhyisionActionPerformed

    private void btnFarmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFarmacyActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new PharmacyScreen(this));
    }//GEN-LAST:event_btnFarmacyActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }
        jDesktopPane1.add(new SettingScreen(this));
    }//GEN-LAST:event_btnSettingActionPerformed

    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
        new TokenScreen(getIconImage()).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnTokenActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        chatForm1.setVisible(!chatForm1.isVisible());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        for (JInternalFrame frame : jDesktopPane1.getAllFrames()) {
            frame.dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApointment;
    private javax.swing.JButton btnClinic;
    private javax.swing.JButton btnFarmacy;
    private javax.swing.JButton btnPatient;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnPhyision;
    private javax.swing.JButton btnSetting;
    private javax.swing.JButton btnToken;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables

    private void loadbuttons() {
        if (user.getType().equals("Admin")) {
            btnPatient.setVisible(true);
            btnClinic.setVisible(true);
            btnApointment.setVisible(true);
            btnFarmacy.setVisible(false);
            btnPhyision.setVisible(true);
            btnSetting.setVisible(true);
            btnToken.setVisible(false);
            btnPayment.setVisible(true);
        }else if(user.getType().equals("Receptionist")) {
            btnPatient.setVisible(true);
            btnClinic.setVisible(false);
            btnApointment.setVisible(true);
            btnFarmacy.setVisible(false);
            btnPhyision.setVisible(false);
            btnSetting.setVisible(true);
            btnToken.setVisible(false);
            btnPayment.setVisible(false);
        }else if(user.getType().equals("Physician")) {
            btnPatient.setVisible(true);
            btnClinic.setVisible(false);
            btnApointment.setVisible(true);
            btnFarmacy.setVisible(false);
            btnPhyision.setVisible(false);
            btnSetting.setVisible(true);
            btnToken.setVisible(false);
            btnPayment.setVisible(false);
        }else if(user.getType().equals("Cashier")) {
            btnPatient.setVisible(false);
            btnClinic.setVisible(false);
            btnApointment.setVisible(false);
            btnFarmacy.setVisible(false);
            btnPhyision.setVisible(false);
            btnSetting.setVisible(true);
            btnToken.setVisible(false);
            btnPayment.setVisible(true);
        }else if(user.getType().equals("Pharmacist")) {
            btnPatient.setVisible(false);
            btnClinic.setVisible(false);
            btnApointment.setVisible(false);
            btnFarmacy.setVisible(true);
            btnPhyision.setVisible(false);
            btnSetting.setVisible(true);
            btnToken.setVisible(false);
            btnPayment.setVisible(false);
        }else if(user.getType().equals("Super User") || user.getType().equals("Accountant")) {
            btnPatient.setVisible(true);
            btnClinic.setVisible(true);
            btnApointment.setVisible(true);
            btnFarmacy.setVisible(true);
            btnPhyision.setVisible(true);
            btnSetting.setVisible(true);
            btnToken.setVisible(true);
            btnPayment.setVisible(true);
        }else if(user.getType().equals("Token manager")) {
            btnPatient.setVisible(false);
            btnClinic.setVisible(false);
            btnApointment.setVisible(false);
            btnFarmacy.setVisible(false);
            btnPhyision.setVisible(false);
            btnSetting.setVisible(true);
            btnToken.setVisible(true);
            btnPayment.setVisible(false);
        }

    }
}
