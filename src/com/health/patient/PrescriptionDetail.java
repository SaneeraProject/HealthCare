/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.health.patient;

import com.database.DBConfig;
import com.database.MedicineStock;
import com.database.Prescription;
import com.database.PrescriptionData;
import com.health.preview.Preview;
import com.health.preview.PreviewData;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ajeet
 */
public class PrescriptionDetail extends javax.swing.JDialog {

    /**
     * Creates new form PrescriptionDetail
     */
    private Prescription p;

    public PrescriptionDetail(java.awt.Frame parent, boolean modal, Prescription p,boolean edit) {
        super(parent, modal);
        this.p = p;
        initComponents();
        setMinimumSize(new Dimension(900, 500));
        setLocationRelativeTo(parent);

        load();

        DefaultComboBoxModel<MedicineStock> model = new DefaultComboBoxModel<>();

        ArrayList<MedicineStock> stock = new DBConfig().getMedicineData();
        for (MedicineStock s : stock) {
            model.addElement(s);
        }

        JComboBox cmbMedicine = new JComboBox(model);
        TableColumn col = jTable1.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(cmbMedicine));
        col.setMinWidth(200);
        cmbMedicine.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    MedicineStock m = (MedicineStock) cmbMedicine.getSelectedItem();
                    int row = jTable1.getSelectedRow();
                    jTable1.setValueAt(m.getId(), row, 0);
                    jTable1.setValueAt(m.getRate(), row, 6);
                }
            }
        });

        JComboBox cmbFrequency = new JComboBox();
        cmbFrequency.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"After food", "At once", "Before food", "Every day", "Every morning", "Every night", "Four times a day", "If necessary", "Rx", "Three times a day", "To the desired amount", "Twice a day", "Whenever necessary", "With"}));
        TableColumn col1 = jTable1.getColumnModel().getColumn(4);
        col1.setMinWidth(200);
        col1.setCellEditor(new DefaultCellEditor(cmbFrequency));

//        if(edit){
            btnSave.setEnabled(edit);
//        }
    }

    public void load() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        tftDate.setText(fmt.format(p.getDated()));
        tftPhysician.setText(p.getPhysicianname());
        tftPrescriptionID.setText(p.getPrescriptionid() + "");
        btnSave.setEnabled(true);
        btnPrint.setEnabled(false);
        ArrayList<PrescriptionData> pList = new DBConfig().getPrescriptionData(p.getPrescriptionid());
        if (pList.size() > 0) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(0);
            for (PrescriptionData p : pList) {
                model.insertRow(model.getRowCount(), new Object[]{p.getMid(), p.getMedication(), p.getQuantity(), p.getTake(), p.getFrequency(), p.getDuration(), p.getRate(), p.getRate() * p.getQuantity()});
            }

            btnSave.setEnabled(true);
            btnPrint.setEnabled(true);
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tftDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tftPhysician = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftPrescriptionID = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prescription Detail");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add prescription detail"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Prescription Date and time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jLabel1, gridBagConstraints);

        tftDate.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(tftDate, gridBagConstraints);

        jLabel2.setText("Ordered by physician");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jLabel2, gridBagConstraints);

        tftPhysician.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(tftPhysician, gridBagConstraints);

        jLabel3.setText("Prescription Id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jLabel3, gridBagConstraints);

        tftPrescriptionID.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(tftPrescriptionID, gridBagConstraints);

        jButton5.setText("View");
        jButton5.setPreferredSize(new java.awt.Dimension(75, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(jButton5, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Medications", "Quantity", "Take", "Frequency", "Duration", "Rate", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(20);
        jTable1.setRowSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("-");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnPrint)
                    .addComponent(btnSave)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.insertRow(model.getRowCount(), new Object[]{});
        jTable1.setModel(model);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try {

            ArrayList<PrescriptionData> plist = new ArrayList<PrescriptionData>();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                int mid = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                double quantity = Double.parseDouble(jTable1.getValueAt(i, 2).toString());
                double rate = Double.parseDouble(jTable1.getValueAt(i, 6).toString());
                String take = jTable1.getValueAt(i, 3).toString();
                String frequency = jTable1.getValueAt(i, 4).toString();
                String duration = jTable1.getValueAt(i, 5).toString();
                PrescriptionData p = new PrescriptionData();
                p.setMid(mid);
                p.setQuantity(quantity);
                p.setRate(rate);
                p.setTake(take);
                p.setFrequency(frequency);
                p.setDuration(duration);
                plist.add(p);
            }

            if (plist.size() > 0) {
                int prescription = Integer.parseInt(tftPrescriptionID.getText());
                int i = new DBConfig().addPrescriptionData(prescription, plist);
//                if (i > 0) {
                JOptionPane.showMessageDialog(this, "Prescription data has been saved!");
                btnSave.setEnabled(false);
                btnPrint.setEnabled(true);
//                }
            }
        } catch (Exception ex) {

        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(jTable1.getSelectedRow());
        jTable1.setModel(model);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        int i = jTable1.getSelectedRow();
        try {
            double quantity = Double.parseDouble(jTable1.getValueAt(i, 2).toString());
            double rate = Double.parseDouble(jTable1.getValueAt(i, 6).toString());
            jTable1.setValueAt(quantity * rate, i, 7);

        } catch (Exception ex) {

        }


    }//GEN-LAST:event_jTable1KeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        PreviewData data = new PreviewData();
        data.setTitle("Prescription Invoice");
        LinkedHashMap<String, String> myMap = new LinkedHashMap<String, String>();
        myMap.put("Prescription ID", tftPrescriptionID.getText());
        myMap.put("Physician Name", tftPhysician.getText());
        myMap.put("Date and Time", tftDate.getText());
//        myMap.put("Tax Amount", t.getId()+"");

        double total = 0;
        try {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                total = total + Double.parseDouble(jTable1.getValueAt(i, 7).toString());
            }
        } catch (Exception ex) {
        }
        LinkedHashMap<String, String> footerMap = new LinkedHashMap<String, String>();
        footerMap.put("Total Amount", total + "");

        data.setHeaderMap(myMap);

        data.setModel((DefaultTableModel) jTable1.getModel());

        data.setFooterMap(footerMap);

        Preview p = new Preview(this, "Invoice", data);

// TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tftDate;
    private javax.swing.JTextField tftPhysician;
    private javax.swing.JTextField tftPrescriptionID;
    // End of variables declaration//GEN-END:variables
}
