/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.sql.Connection;
import javax.swing.JSplitPane;

/**
 *
 * @author Aditya, Ameya, Nainil
 */
public class CompanyChoiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Choice_JPanel
     */
    JSplitPane splitPane;
    String choice = "";
    Connection conn = null;
    
    public CompanyChoiceJPanel(JSplitPane splitPane, Connection conn) {
        initComponents();
        
        this.splitPane = splitPane;
        this.conn = conn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        btnStudent = new button.Button();
        btnAdvisor = new button.Button();
        btnSystemAdmin = new button.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHR = new button.Button();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 630));

        kGradientPanel1.setkEndColor(new java.awt.Color(189, 188, 240));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(217, 247, 228));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 630));

        btnStudent.setBackground(new java.awt.Color(82, 159, 252));
        btnStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnStudent.setText("RECRUITEMENT DEPARTMENT");
        btnStudent.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        btnAdvisor.setBackground(new java.awt.Color(82, 159, 252));
        btnAdvisor.setForeground(new java.awt.Color(255, 255, 255));
        btnAdvisor.setText("DEPARTMENT REQUEST");
        btnAdvisor.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnAdvisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdvisorActionPerformed(evt);
            }
        });

        btnSystemAdmin.setBackground(new java.awt.Color(82, 159, 252));
        btnSystemAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnSystemAdmin.setText("SYSTEM ADMIN");
        btnSystemAdmin.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnSystemAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSystemAdminActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Seamless Industry Logo only.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Title_Company.png"))); // NOI18N

        btnHR.setBackground(new java.awt.Color(82, 159, 252));
        btnHR.setForeground(new java.awt.Color(255, 255, 255));
        btnHR.setText("HUMAN RESOURCE ");
        btnHR.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnHR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHRActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Industry Logo.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnSystemAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHR, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHR, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdvisor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSystemAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
        choice = "student";
        CompanyLoginJPanel loginPanel = new CompanyLoginJPanel(splitPane, conn);
        splitPane.setRightComponent(loginPanel);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnAdvisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdvisorActionPerformed
        // TODO add your handling code here:
        choice = "advisor";
        LoginJPanel loginPanel = new LoginJPanel(splitPane, choice, conn);
        splitPane.setRightComponent(loginPanel);
    }//GEN-LAST:event_btnAdvisorActionPerformed

    private void btnSystemAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSystemAdminActionPerformed
        // TODO add your handling code here:
        choice = "admin";
        LoginJPanel loginPanel = new LoginJPanel(splitPane, choice, conn);
        splitPane.setRightComponent(loginPanel);
    }//GEN-LAST:event_btnSystemAdminActionPerformed

    private void btnHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHRActionPerformed
//        // TODO add your handling code here:
//         CompanyHRJPanel companyHRPanel = new CompanyHRJPanel(splitPane, conn, selectedComp);
//        splitPane.setRightComponent(companyHRPanel);

        
    }//GEN-LAST:event_btnHRActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAdvisor;
    private button.Button btnHR;
    private button.Button btnStudent;
    private button.Button btnSystemAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
