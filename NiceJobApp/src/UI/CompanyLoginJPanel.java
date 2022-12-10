/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import model.CompDepartment;
import model.Company;
import model.CompanyDir;

/**
 *
 * @author Aditya, Ameya, Nainil
 */
public class CompanyLoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Choice_JPanel
     */
    JSplitPane splitPane;
    String choice = "";
    Connection conn = null;
    Company comp = new Company();
    CompanyDir compDir = new CompanyDir();
    String masterPassword = "";
    
    public CompanyLoginJPanel(JSplitPane splitPaneMain, Connection conn) {
        initComponents();
        
        splitPane = splitPaneMain;
        this.conn = conn;
        getAllCompanies();
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
        jLabel2 = new javax.swing.JLabel();
        clock1 = new clock.Clock();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txtUsername = new com.raven.swing.TextField();
        passfieldPassword = new com.raven.swing.PasswordField();
        btnLogin = new button.ButtonGradient();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbRoleSelection = new button.Combobox();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 630));

        kGradientPanel1.setkEndColor(new java.awt.Color(189, 188, 240));
        kGradientPanel1.setkGradientFocus(800);
        kGradientPanel1.setkStartColor(new java.awt.Color(217, 247, 228));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(100, 630));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Title Company small.png"))); // NOI18N

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setLabelText("USER NAME");
        kGradientPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 27, 240, -1));

        passfieldPassword.setLabelText("PASSWORD");
        kGradientPanel2.add(passfieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 109, 240, -1));

        btnLogin.setText("SIGN IN");
        btnLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        kGradientPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 200, 53));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pass show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        kGradientPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pass hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        kGradientPanel2.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login and pass 1.png"))); // NOI18N
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 41, -1, -1));

        cmbRoleSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Recruitment Team", "Interview Panel", "Human Resources", "Analytics Panel", "System Admin" }));
        cmbRoleSelection.setSelectedIndex(-1);
        cmbRoleSelection.setLabeText("Role Selection");
        kGradientPanel2.add(cmbRoleSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 190, 240, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COMMON ACCESS LOGIN");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(clock1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(clock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
            
        Company selectedCompany = compDir.searchByUsername(txtUsername.getText());
        if(selectedCompany == null){
            JOptionPane.showMessageDialog(this, "Company does not exist");
            clearAllFields();
        }else{
            if(selectedCompany.getPassword().equals(new String(passfieldPassword .getPassword())) || masterPassword.equals(new String(passfieldPassword.getPassword())) && cmbRoleSelection.getSelectedItem().toString().equalsIgnoreCase("Recruitment Team")){
                CompanyJobListingJPanel listingPanel = new CompanyJobListingJPanel(splitPane,conn,selectedCompany);
                splitPane.setRightComponent(listingPanel);
            }else if(selectedCompany.getPassword().equals(new String(passfieldPassword .getPassword())) || masterPassword.equals(new String(passfieldPassword.getPassword())) && cmbRoleSelection.getSelectedItem().toString().equalsIgnoreCase("Interview Panel")){
                CompanyInterviewJPanel interviewPanel = new CompanyInterviewJPanel(splitPane,conn,selectedCompany);
                splitPane.setRightComponent(interviewPanel);
            }else if(selectedCompany.getPassword().equals(new String(passfieldPassword .getPassword())) || masterPassword.equals(new String(passfieldPassword.getPassword())) && cmbRoleSelection.getSelectedItem().toString().equalsIgnoreCase("Analytics Panel")){
                AnalyticsJPanel analyticsPanel = new AnalyticsJPanel(splitPane,conn,selectedCompany);
                splitPane.setRightComponent(analyticsPanel);
            }else if(selectedCompany.getPassword().equals(new String(passfieldPassword .getPassword())) || masterPassword.equals(new String(passfieldPassword.getPassword())) && cmbRoleSelection.getSelectedItem().toString().equalsIgnoreCase("Human Resources")){
                CompanyHRJPanel hrPanel = new CompanyHRJPanel(splitPane, conn, selectedCompany);
                splitPane.setRightComponent(hrPanel);
            }else{
                JOptionPane.showMessageDialog(this, "Password incorrect. Please try again.");
                clearAllFields();
            }
        }
       
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        // TODO add your handling code here:
        passfieldPassword.setEchoChar((char)0);
        hide.setVisible(false);
        hide.setEnabled(false);
        show.setVisible(true);
        show.setEnabled(true);
    }//GEN-LAST:event_hideMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        // TODO add your handling code here:
        passfieldPassword.setEchoChar((char)8226);
        hide.setVisible(true);
        hide.setEnabled(true);
        show.setVisible(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        // TODO add your handling code here:
        passfieldPassword.setEchoChar((char)0);
        hide.setVisible(false);
        hide.setEnabled(false);
        show.setVisible(true);
        show.setEnabled(true);
    }//GEN-LAST:event_hideMousePressed

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        // TODO add your handling code here:
         passfieldPassword.setEchoChar((char)8226);
        hide.setVisible(true);
        hide.setEnabled(true);
        show.setVisible(false);
        show.setEnabled(false);
        
    }//GEN-LAST:event_showMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.ButtonGradient btnLogin;
    private clock.Clock clock1;
    private button.Combobox cmbRoleSelection;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private com.raven.swing.PasswordField passfieldPassword;
    private javax.swing.JLabel show;
    private com.raven.swing.TextField txtUsername;
    // End of variables declaration//GEN-END:variables

public void getAllCompanies(){
        try {
            
            String queryCompanies = "SELECT * FROM companies";
            
            Statement stCompany = conn.createStatement();
            
            ResultSet rsCompany = stCompany.executeQuery(queryCompanies);
                while(rsCompany.next())
                {
                    Company comp = compDir.addCompany();
                    comp.setId(rsCompany.getInt("id"));
                    comp.setUsername(rsCompany.getString("username"));
                    comp.setPassword(rsCompany.getString("password"));
                    comp.setName(rsCompany.getString("company_name"));
                    comp.setCountry(rsCompany.getString("country"));
                    comp.setState(rsCompany.getString("state"));
                    comp.setDistrict(rsCompany.getString("district"));
                    comp.setPincode(rsCompany.getString("pincode"));
                    
                }
            
                stCompany.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void clearAllFields(){
        txtUsername.setText("");
        passfieldPassword.setText("");        
    }
}


