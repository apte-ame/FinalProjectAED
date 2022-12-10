/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_highgui;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;
import model.CompDepartment;
import model.CompDepartmentDir;
import model.Company;
import model.CompanyDir;
import model.JobAppointments;
import model.JobAppointmentsDir;
import model.NgoRentals;
import model.NgoRentalsDir;
import model.RentalApps;
import model.RentalAppsDir;
import model.UniStudent;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.EventWaypoint;
import waypoint.MyWaypoint;
import waypoint.WaypointRender;

/**
 *
 * @author naini
 */
public class UniStudentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Uni_ExamCell_JPanel
     */
    JSplitPane splitPane;
    Connection conn = null;
    UniStudent student = new UniStudent();
    CanvasFrame frame = null;
    CompDepartmentDir compDeptDir = new CompDepartmentDir();
    CompDepartmentDir compDeptDirStudent = new CompDepartmentDir();
    CompanyDir compDir = new CompanyDir();
    JobAppointmentsDir jobAppDir = new JobAppointmentsDir();
    
    Integer selectedRow = -1;
    Integer selectedRowApps = -1;
    
    NgoRentalsDir ngoRents = new NgoRentalsDir();
    RentalAppsDir rentals = new RentalAppsDir();
    RentalApps selectedRental = new RentalApps();
    GeoPosition geo;
    
    private final Set<MyWaypoint> waypoints = new HashSet<>();
    private EventWaypoint event;
    
    Double latitude;
    Double longitude;
    
    String selectedCityMap = "";
    Integer selectedRowMap = -1;
    
    MouseInputListener mm;
    
    private RentalApps rentalApp;
    
    public UniStudentJPanel(JSplitPane splitPane, Connection conn, UniStudent student) {
        initComponents();
        
        this.splitPane = splitPane;
        this.conn = conn;
        this.student = student;
        
        if(student.getJdWatchAccess()){
            studentTabbedPane.setEnabledAt(1, true);
            btnWithdraw.setEnabled(true);
        }else{
            studentTabbedPane.setEnabledAt(1, false);
            btnWithdraw.setEnabled(false);
        }
        
        populateAllFields(student);
        ImageIcon myImg = retrieveImage(student);
        lblImage.setText("");
        lblImage.setIcon(myImg);
        getAllListings();
        findAllJobAppsOfStudent(student);
        
        removeJobAppFromListings();
        populateJobListingsTable(compDeptDir);
        populateJobListingsAppsTable(compDeptDirStudent);
        
        tblJobListings.getTableHeader().setFont( new Font( "Trebuchet MS" , Font.PLAIN, 18 ));
        tblJobListingsApps.getTableHeader().setFont( new Font( "Trebuchet MS" , Font.PLAIN, 18 ));
        btnApply.setEnabled(false);
        btnWithdraw.setEnabled(false);
        
        mm = new PanMouseInputListener(jXMapViewer);
        latitude = 42.3145186;
        longitude = -71.1103689;
        init(42.3145186,-71.1103689);
        
        clearAllFieldsMap();
        disableAllFieldsMap();
        loadAllRentals();
        getAllNgoRentals();
        populateTableMap(rentals);
        
        tblListings.getTableHeader().setFont( new Font( "Trebuchet MS" , Font.PLAIN, 18 ));
        
    }

    private void addWaypoint(MyWaypoint waypoint) {
        for (MyWaypoint d : waypoints) {
            jXMapViewer.remove(d.getButton());
        }
        waypoints.clear();
        waypoints.add(waypoint);
        initWaypoint();
    }
    
    private void initWaypoint() {
        WaypointPainter<MyWaypoint> wp = new WaypointRender();
        wp.setWaypoints(waypoints);
        jXMapViewer.setOverlayPainter(wp);
        for (MyWaypoint d : waypoints) {
            jXMapViewer.add(d.getButton());
        }
    }
    
    private void init(Double mainLat,Double mainLong) {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapViewer.setTileFactory(tileFactory);
//        geo = new GeoPosition(42.342428194183036, -71.10145032405853);
        geo = new GeoPosition(mainLat, mainLong);
        jXMapViewer.setAddressLocation(geo);
        jXMapViewer.setZoom(0);

        //  Create event mouse move
        addMouseListener();
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
        back_btn = new button.Button();
        studentTabbedPane = new javax.swing.JTabbedPane();
        panelStudentProfile = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txtUniversity = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        lblCollege = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEmailId = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblContactNo = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        cmbNationality = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGPA = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        nxtSavebtn = new button.Button();
        lblUniversity = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtCollege = new javax.swing.JTextField();
        txtDepartment = new javax.swing.JTextField();
        lblCourse = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        lblExpGradDate = new javax.swing.JLabel();
        txtExpGradDate = new javax.swing.JTextField();
        txtGPA = new javax.swing.JTextField();
        lblImage = new javax.swing.JLabel();
        btnTakePic = new javax.swing.JButton();
        btnClkAndUpload = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblAcadSummary = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaAcadSummary = new javax.swing.JTextArea();
        panelJDWatch = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        lblLevel = new javax.swing.JLabel();
        lblRoleFilter = new javax.swing.JLabel();
        lblSkills = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnApply = new button.Button();
        btnResetFilter = new button.Button();
        cmbRole = new javax.swing.JComboBox<>();
        cmbLevel = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        btnSearch = new button.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblJobListings = new javax.swing.JTable();
        txtSkills = new javax.swing.JTextField();
        txtCompanyName = new javax.swing.JTextField();
        lblCompany = new javax.swing.JLabel();
        txtSalaryOffered = new javax.swing.JTextField();
        lblSalaryOffered = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblJobDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaJobDescription = new javax.swing.JTextArea();
        txtStartDate = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        lblPosition = new javax.swing.JLabel();
        lblJobId = new javax.swing.JLabel();
        txtJobId = new javax.swing.JTextField();
        lblJobTitle = new javax.swing.JLabel();
        txtJobTitle = new javax.swing.JTextField();
        lblResults = new javax.swing.JLabel();
        panelMyApplications = new javax.swing.JPanel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblJobListingsApps = new javax.swing.JTable();
        btnSearch1 = new button.Button();
        btnRefreshTable = new button.Button();
        btnClear = new button.Button();
        btnViewSelected = new button.Button();
        lblJobProfile = new javax.swing.JLabel();
        lblJobDescription1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaJobDescriptionMyApp = new javax.swing.JTextArea();
        lblCompanyMyApp = new javax.swing.JLabel();
        txtCompanyMyApp = new javax.swing.JTextField();
        lblAppStatus = new javax.swing.JLabel();
        lblDateApplied = new javax.swing.JLabel();
        txtDateApplied = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        btnWithdraw = new button.Button();
        txtJobAppId = new javax.swing.JTextField();
        lblJobAppId = new javax.swing.JLabel();
        panelRentals = new javax.swing.JPanel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblListings = new javax.swing.JTable();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbLocation = new javax.swing.JComboBox<>();
        txtCoords = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMoveDate = new javax.swing.JTextField();
        cmbAvailability = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtAreaComments = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtLeasee = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        btnSearchMap = new button.Button();
        btnRefreshTableMap = new button.Button();
        btnClearMap = new button.Button();
        btnViewSelectedMap = new button.Button();
        lblWelcome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 51, 51));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 102, 153));

        back_btn.setBackground(new java.awt.Color(204, 204, 255));
        back_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_3.png"))); // NOI18N
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        studentTabbedPane.setBackground(new java.awt.Color(204, 255, 204));
        studentTabbedPane.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N

        panelStudentProfile.setPreferredSize(new java.awt.Dimension(900, 500));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 255, 204));

        txtUniversity.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtUniversity.setEnabled(false);

        txtEmailId.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtEmailId.setEnabled(false);

        txtContactNo.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtContactNo.setEnabled(false);

        lblCollege.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblCollege.setText("College");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel2.setText("Personal Details");

        lblEmailId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblEmailId.setText("Email ID");

        lblNationality.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblNationality.setText("Nationality");

        lblGender.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblGender.setText("Gender");

        lblContactNo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblContactNo.setText("Contact No.");

        cmbGender.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Prefer not to say" }));

        cmbNationality.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USA", "India", "China", "Canada", "Others" }));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel8.setText("Academic Details");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setText("Student Name");

        lblGPA.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblGPA.setText("GPA ");

        lblDepartment.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblDepartment.setText("Department");

        lblAge.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblAge.setText("Age");

        nxtSavebtn.setText("Update");
        nxtSavebtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        nxtSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxtSavebtnActionPerformed(evt);
            }
        });

        lblUniversity.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblUniversity.setText("University");

        txtStudentName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtStudentName.setEnabled(false);

        txtCollege.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtCollege.setEnabled(false);

        txtDepartment.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtDepartment.setEnabled(false);

        lblCourse.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblCourse.setText("Course");

        txtCourse.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtCourse.setEnabled(false);

        lblExpGradDate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblExpGradDate.setText("Expected Grad. Date");

        txtExpGradDate.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtExpGradDate.setEnabled(false);

        txtGPA.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtGPA.setEnabled(false);

        lblImage.setBackground(new java.awt.Color(150, 150, 150));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("No Image");
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTakePic.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        btnTakePic.setText("Take Pic");
        btnTakePic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTakePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakePicActionPerformed(evt);
            }
        });

        btnClkAndUpload.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        btnClkAndUpload.setText("Click and Upload");
        btnClkAndUpload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClkAndUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClkAndUploadActionPerformed(evt);
            }
        });

        lblPhoto.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblPhoto.setText("Photo");

        lblAcadSummary.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblAcadSummary.setText("Summary");

        txtAreaAcadSummary.setColumns(20);
        txtAreaAcadSummary.setRows(5);
        jScrollPane2.setViewportView(txtAreaAcadSummary);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmailId)
                            .addComponent(lblContactNo)
                            .addComponent(lblNationality)
                            .addComponent(lblGender)
                            .addComponent(lblAge)
                            .addComponent(lblPhoto)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContactNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(cmbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTakePic, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClkAndUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2)))
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(185, 185, 185))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCollege, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDepartment, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUniversity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCourse, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblExpGradDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGPA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAcadSummary, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGPA)
                            .addComponent(txtExpGradDate)
                            .addComponent(txtCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(txtUniversity)
                            .addComponent(txtCollege, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addGap(0, 51, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nxtSavebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        kGradientPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAge, txtCollege, txtContactNo, txtCourse, txtDepartment, txtEmailId, txtExpGradDate, txtGPA, txtStudentName, txtUniversity});

        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmailId))
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContactNo)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNationality))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGender))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAge))
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhoto)
                                    .addComponent(btnTakePic))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClkAndUpload)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(116, Short.MAX_VALUE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUniversity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCollege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCollege))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDepartment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCourse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtExpGradDate)
                            .addComponent(lblExpGradDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGPA))
                        .addGap(5, 5, 5)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAcadSummary))
                        .addGap(18, 18, 18)
                        .addComponent(nxtSavebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        kGradientPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCourse, txtAge, txtCollege, txtContactNo, txtCourse, txtDepartment, txtEmailId, txtExpGradDate, txtGPA, txtStudentName, txtUniversity});

        javax.swing.GroupLayout panelStudentProfileLayout = new javax.swing.GroupLayout(panelStudentProfile);
        panelStudentProfile.setLayout(panelStudentProfileLayout);
        panelStudentProfileLayout.setHorizontalGroup(
            panelStudentProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelStudentProfileLayout.setVerticalGroup(
            panelStudentProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentTabbedPane.addTab("STUDENT PROFILE", panelStudentProfile);

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(204, 255, 204));

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(204, 255, 204));
        kGradientPanel5.setPreferredSize(new java.awt.Dimension(850, 531));

        lblLevel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLevel.setText("Level");

        lblRoleFilter.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblRoleFilter.setText("Role");

        lblSkills.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblSkills.setText("Necessary Skills");

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Job Profile");

        btnApply.setText("Apply");
        btnApply.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnResetFilter.setText("Reset Filter");
        btnResetFilter.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        btnResetFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFilterActionPerformed(evt);
            }
        });

        cmbRole.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Software Developer", "Web Designer", "Data Analyst", "Business Analyst", "Data Scientist", "Data Engineer", "Project Manager" }));

        cmbLevel.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Specialist", "Associate", "Senior Associate", "Manager", "Analyst" }));

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Filters");

        btnSearch.setText("Search");
        btnSearch.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblJobListings.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        tblJobListings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Id", "Company", "Location", "Role", "Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblJobListings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJobListingsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblJobListings);

        txtSkills.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N

        txtCompanyName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtCompanyName.setEnabled(false);
        txtCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyNameActionPerformed(evt);
            }
        });

        lblCompany.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblCompany.setText("Company");

        txtSalaryOffered.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtSalaryOffered.setEnabled(false);
        txtSalaryOffered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryOfferedActionPerformed(evt);
            }
        });

        lblSalaryOffered.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblSalaryOffered.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSalaryOffered.setText("Salary Offered");

        lblStartDate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblStartDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStartDate.setText("Start Date");

        lblJobDescription.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJobDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJobDescription.setText("Job Description");

        txtAreaJobDescription.setColumns(20);
        txtAreaJobDescription.setRows(5);
        txtAreaJobDescription.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaJobDescription);

        txtStartDate.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtStartDate.setEnabled(false);
        txtStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartDateActionPerformed(evt);
            }
        });

        txtPosition.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtPosition.setEnabled(false);
        txtPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPositionActionPerformed(evt);
            }
        });

        lblPosition.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPosition.setText("Position");

        lblJobId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJobId.setText("Job Id");

        txtJobId.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtJobId.setEnabled(false);
        txtJobId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobIdActionPerformed(evt);
            }
        });

        lblJobTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJobTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJobTitle.setText("Job Title");

        txtJobTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtJobTitle.setEnabled(false);
        txtJobTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobTitleActionPerformed(evt);
            }
        });

        lblResults.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        lblResults.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResults.setText("Results");

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblRoleFilter)
                                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSkills))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                .addComponent(btnResetFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResults, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                .addComponent(lblJobDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                    .addComponent(lblSalaryOffered, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSalaryOffered, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                    .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                    .addComponent(lblJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(lblJobId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtJobId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                        .addComponent(lblCompany)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))))
        );

        kGradientPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbLevel, cmbRole});

        kGradientPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCompanyName, txtSalaryOffered, txtStartDate});

        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJobId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJobTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJobDescription)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSalaryOffered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblSalaryOffered, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRoleFilter)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResetFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114))
        );

        kGradientPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCompanyName, txtSalaryOffered});

        kGradientPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbLevel, cmbRole});

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelJDWatchLayout = new javax.swing.GroupLayout(panelJDWatch);
        panelJDWatch.setLayout(panelJDWatchLayout);
        panelJDWatchLayout.setHorizontalGroup(
            panelJDWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJDWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelJDWatchLayout.setVerticalGroup(
            panelJDWatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJDWatchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("JD WATCH", panelJDWatch);

        kGradientPanel6.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel6.setkStartColor(new java.awt.Color(204, 255, 204));

        kGradientPanel7.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(204, 255, 204));
        kGradientPanel7.setPreferredSize(new java.awt.Dimension(850, 531));

        tblJobListingsApps.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        tblJobListingsApps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Job ID", "Job Title", "Location", "Role", "Level", "Position", "Start Date", "Salary per Hr"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblJobListingsApps);

        btnSearch1.setBackground(new java.awt.Color(204, 255, 204));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_7.png"))); // NOI18N
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        btnRefreshTable.setBackground(new java.awt.Color(204, 255, 204));
        btnRefreshTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_4.png"))); // NOI18N
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(204, 255, 204));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_8.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnViewSelected.setBackground(new java.awt.Color(204, 255, 204));
        btnViewSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_9.png"))); // NOI18N
        btnViewSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSelectedActionPerformed(evt);
            }
        });

        lblJobProfile.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        lblJobProfile.setText("Job Profile");

        lblJobDescription1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJobDescription1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJobDescription1.setText("Job Description");

        txtAreaJobDescriptionMyApp.setColumns(20);
        txtAreaJobDescriptionMyApp.setRows(5);
        txtAreaJobDescriptionMyApp.setEnabled(false);
        jScrollPane5.setViewportView(txtAreaJobDescriptionMyApp);

        lblCompanyMyApp.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblCompanyMyApp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCompanyMyApp.setText("Company");

        txtCompanyMyApp.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtCompanyMyApp.setEnabled(false);
        txtCompanyMyApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompanyMyAppActionPerformed(evt);
            }
        });

        lblAppStatus.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        lblAppStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppStatus.setText("Application Status");

        lblDateApplied.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblDateApplied.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateApplied.setText("Date Applied");

        txtDateApplied.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtDateApplied.setEnabled(false);
        txtDateApplied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateAppliedActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setText("Status");

        txtStatus.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtStatus.setEnabled(false);
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        btnWithdraw.setForeground(new java.awt.Color(0, 0, 0));
        btnWithdraw.setText("Withdraw Application");
        btnWithdraw.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawActionPerformed(evt);
            }
        });

        txtJobAppId.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtJobAppId.setEnabled(false);
        txtJobAppId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobAppIdActionPerformed(evt);
            }
        });

        lblJobAppId.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblJobAppId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJobAppId.setText("Application Id");

        javax.swing.GroupLayout kGradientPanel7Layout = new javax.swing.GroupLayout(kGradientPanel7);
        kGradientPanel7.setLayout(kGradientPanel7Layout);
        kGradientPanel7Layout.setHorizontalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(lblJobProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAppStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblJobDescription1)
                    .addComponent(lblCompanyMyApp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompanyMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                        .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel7Layout.createSequentialGroup()
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                                .addComponent(lblJobAppId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtJobAppId, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblStatus)
                                    .addComponent(lblDateApplied))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDateApplied, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(110, 110, 110))))
        );

        kGradientPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClear, btnRefreshTable, btnSearch1, btnViewSelected});

        kGradientPanel7Layout.setVerticalGroup(
            kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnViewSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAppStatus)
                    .addComponent(lblJobProfile))
                .addGap(7, 7, 7)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompanyMyApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompanyMyApp)
                    .addComponent(txtJobAppId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJobAppId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJobDescription1)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 53, Short.MAX_VALUE))
                    .addGroup(kGradientPanel7Layout.createSequentialGroup()
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateApplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDateApplied))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        kGradientPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClear, btnRefreshTable, btnSearch1, btnViewSelected});

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMyApplicationsLayout = new javax.swing.GroupLayout(panelMyApplications);
        panelMyApplications.setLayout(panelMyApplicationsLayout);
        panelMyApplicationsLayout.setHorizontalGroup(
            panelMyApplicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMyApplicationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMyApplicationsLayout.setVerticalGroup(
            panelMyApplicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMyApplicationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("MY APPLICATIONS", panelMyApplications);

        kGradientPanel8.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(204, 255, 204));

        kGradientPanel9.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel9.setkStartColor(new java.awt.Color(204, 255, 204));
        kGradientPanel9.setPreferredSize(new java.awt.Dimension(850, 531));

        tblListings.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        tblListings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Listing Id", "Listed By", "Title", "Location", "Rent", "Availability", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblListings);

        txtTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel3.setText("Title");

        cmbLocation.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston", "New York", "Chicago", "San Francisco", "Los Angeles", "Seattle" }));
        cmbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocationActionPerformed(evt);
            }
        });

        txtCoords.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtCoords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoordsActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel10.setText("Coordinates");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel5.setText("Location");

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtAreaDescription.setRows(5);
        jScrollPane6.setViewportView(txtAreaDescription);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel1.setText("Description");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel7.setText("Rent");

        txtRent.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRentActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Availability");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel11.setText("Move-in Date");

        txtMoveDate.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtMoveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoveDateActionPerformed(evt);
            }
        });

        cmbAvailability.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbAvailability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Deal in progress", "Deal offered", "Rented" }));

        txtAreaComments.setColumns(20);
        txtAreaComments.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtAreaComments.setRows(5);
        txtAreaComments.setEnabled(false);
        jScrollPane9.setViewportView(txtAreaComments);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel12.setText("Comments");

        txtLeasee.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtLeasee.setEnabled(false);

        cmbStatus.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No activities", "Finalize deal", "Negotiate Rent", "Highlight issues" }));
        cmbStatus.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel6.setText("Status");

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel13.setText("Name of Leasee");

        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnUpdate.setText("Request");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapViewerLayout = new javax.swing.GroupLayout(jXMapViewer);
        jXMapViewer.setLayout(jXMapViewerLayout);
        jXMapViewerLayout.setHorizontalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jXMapViewerLayout.setVerticalGroup(
            jXMapViewerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        btnSearchMap.setBackground(new java.awt.Color(204, 255, 204));
        btnSearchMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_7.png"))); // NOI18N
        btnSearchMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMapActionPerformed(evt);
            }
        });

        btnRefreshTableMap.setBackground(new java.awt.Color(204, 255, 204));
        btnRefreshTableMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_4.png"))); // NOI18N
        btnRefreshTableMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableMapActionPerformed(evt);
            }
        });

        btnClearMap.setBackground(new java.awt.Color(204, 255, 204));
        btnClearMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_8.png"))); // NOI18N
        btnClearMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMapActionPerformed(evt);
            }
        });

        btnViewSelectedMap.setBackground(new java.awt.Color(204, 255, 204));
        btnViewSelectedMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_9.png"))); // NOI18N
        btnViewSelectedMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSelectedMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                        .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLeasee, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRent, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbAvailability, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMoveDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCoords, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbLocation, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                                .addComponent(btnSearchMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefreshTableMap, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClearMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnViewSelectedMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXMapViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(btnUpdate)))))
                .addContainerGap())
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                        .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchMap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefreshTableMap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearMap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewSelectedMap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(54, 54, 54))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel9Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRent, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(35, 35, 35)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLeasee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbLocation))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCoords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMoveDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cmbAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(9, 9, 9))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(kGradientPanel9Layout.createSequentialGroup()
                        .addComponent(jXMapViewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel8Layout = new javax.swing.GroupLayout(kGradientPanel8);
        kGradientPanel8.setLayout(kGradientPanel8Layout);
        kGradientPanel8Layout.setHorizontalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel8Layout.setVerticalGroup(
            kGradientPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRentalsLayout = new javax.swing.GroupLayout(panelRentals);
        panelRentals.setLayout(panelRentalsLayout);
        panelRentalsLayout.setHorizontalGroup(
            panelRentalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRentalsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRentalsLayout.setVerticalGroup(
            panelRentalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRentalsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTabbedPane.addTab("HOUSE RENTALS", panelRentals);

        lblWelcome.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        lblWelcome.setText("Welcome, XYZ!");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studentTabbedPane)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(res == 0) {
            ChoiceJPanel choicePanel = new ChoiceJPanel(splitPane, conn);
            splitPane.setRightComponent(choicePanel);
        }
        else{
            //Pressed No
        }
    }//GEN-LAST:event_back_btnActionPerformed

    private void btnClkAndUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClkAndUploadActionPerformed
        // TODO add your handling code here:
        
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try{
            grabber.start();
            opencv_core.IplImage img = grabber.grab();
//            String path = "C:/Users/AMEYA A/Desktop/pics/capture"+Math.random()+".png";
            String path = "capture"+".png";
            if(img != null)
            {
                cvSaveImage(path,img);
                grabber.release();
                frame.setVisible(false);
                //test
                File input = new File(path);
                BufferedImage image = ImageIO.read(input);
                String outputPath = "captureComp"+".png";
              
                File compressedImageFile = new File(outputPath);
                OutputStream os = new FileOutputStream(compressedImageFile);

                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
                ImageWriter writer = (ImageWriter) writers.next();

                ImageOutputStream ios = ImageIO.createImageOutputStream(os);
                writer.setOutput(ios);

                ImageWriteParam param = writer.getDefaultWriteParam();

                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(0.05f);  // Change the quality value you prefer
                writer.write(null, new IIOImage(image, null, null), param);

                os.close();
                ios.close();
                writer.dispose();
                //
                
                
                File inpFile = new File(outputPath);
                  
                ImageIcon uploadedImage;
                uploadedImage = new ImageIcon(outputPath);
                Image image1 = uploadedImage.getImage();
                Image scaledImage = image1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                lblImage.setText("");
                lblImage.setIcon(scaledImageIcon);
                sql(inpFile);
                
            }
            
        }catch(Exception e){
        e.printStackTrace();
        }
    }//GEN-LAST:event_btnClkAndUploadActionPerformed

    private void btnTakePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakePicActionPerformed
        // TODO add your handling code here:
        Thread webcam = new Thread(){
        public void run(){
        opencv_highgui.CvCapture capture =opencv_highgui.cvCreateCameraCapture(0);
        opencv_highgui.cvSetCaptureProperty(capture,opencv_highgui.CV_CAP_PROP_FRAME_HEIGHT,600);
        opencv_highgui.cvSetCaptureProperty(capture,opencv_highgui.CV_CAP_PROP_FRAME_WIDTH,600);
        opencv_core.IplImage grabbedImage = opencv_highgui.cvQueryFrame(capture);
        frame = new CanvasFrame("Webcam");
        while(frame.isVisible()&&(grabbedImage = opencv_highgui.cvQueryFrame(capture))!=null)
        {
            frame.showImage(grabbedImage);
            
        }
       
      }
       
    };  
       webcam.start();
    }//GEN-LAST:event_btnTakePicActionPerformed

    private void txtSalaryOfferedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryOfferedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryOfferedActionPerformed

    private void txtCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyNameActionPerformed

    private void txtStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartDateActionPerformed

    private void nxtSavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxtSavebtnActionPerformed
        // TODO add your handling code here:
        updateDetails(student);
    }//GEN-LAST:event_nxtSavebtnActionPerformed

    private void txtPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionActionPerformed

    private void txtJobIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobIdActionPerformed

    private void txtJobTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobTitleActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Please select a field:"));
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Role");
        model.addElement("Level");
        model.addElement("Salary");
       
        JComboBox comboBox = new JComboBox(model);
        panel.add(comboBox);

        int resultField = JOptionPane.showConfirmDialog(null, panel, "Search by Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resultField == JOptionPane.OK_OPTION){
            String fieldSelected = comboBox.getSelectedItem().toString();
            DefaultComboBoxModel role = new DefaultComboBoxModel();
            
            role.addElement("Software Developer");
            role.addElement("Web Designer");
            role.addElement("Data Analyst");
            role.addElement("Business Analyst");
            role.addElement("Data Scientist");
            role.addElement("Data Engineer");
            role.addElement("Project Manager");
            
            JComboBox comboBoxRole = new JComboBox(role);

            DefaultComboBoxModel level = new DefaultComboBoxModel();
            level.addElement("Specialist");
            level.addElement("Associate");
            level.addElement("Senior Associate");
            level.addElement("Manager");
            level.addElement("Analyst");
            
            JComboBox comboBoxLevel = new JComboBox(level);
            
            JTextField txtField = new JTextField("");
            
            panel.add(new JLabel("Value:"));
            
            if(fieldSelected.equalsIgnoreCase("Role")){
                comboBox.setEnabled(false);
                panel.add(comboBoxRole);
            }else if(fieldSelected.equalsIgnoreCase("Level")){
                comboBox.setEnabled(false);
                panel.add(comboBoxLevel);
            }else{
                comboBox.setEnabled(false);
                panel.add(txtField);
            }

            int resultValue = JOptionPane.showConfirmDialog(null, panel, "Search by Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resultValue == JOptionPane.OK_OPTION) {

                String fieldValue;
                if(fieldSelected.equalsIgnoreCase("Role")){
                    fieldValue = comboBoxRole.getSelectedItem().toString();
                } else if(fieldSelected.equalsIgnoreCase("Level")){
                    fieldValue = comboBoxLevel.getSelectedItem().toString();
                } else {
                    fieldValue = txtField.getText();
                }

                if(fieldValue.equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(this, "Please enter a value");
                }else{
                    CompDepartmentDir resultCompDeptDir = new CompDepartmentDir();
                    ArrayList<CompDepartment> resultDepartments = new ArrayList<CompDepartment>();
                    
                    if(fieldSelected.equalsIgnoreCase("Salary")){
                        resultDepartments = compDeptDirStudent.searchBySalary(Double.valueOf(fieldValue));
                    }else if(fieldSelected.equalsIgnoreCase("Role")){
                        resultDepartments = compDeptDirStudent.searchByRole(fieldValue);
                    }else if(fieldSelected.equalsIgnoreCase("Position")){
                        resultDepartments = compDeptDirStudent.searchByPosition(fieldValue);
                    }else{
                        resultDepartments = null;
                    }

                    if(resultDepartments.isEmpty()){
                        JOptionPane.showMessageDialog(this, "No Results Found");
                        populateJobListingsAppsTable(compDeptDirStudent);
                    }else{
                        JOptionPane.showMessageDialog(this, "Entries found");
                        resultCompDeptDir.setCompDepartmentList(resultDepartments);
                        populateJobListingsAppsTable(resultCompDeptDir);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Search Cancelled");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Search Cancelled");
        }
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        // TODO add your handling code here:
        populateJobListingsAppsTable(compDeptDirStudent);
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearAllFieldsMyApp();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSelectedActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        selectedRowApps = tblJobListingsApps.getSelectedRow();
        if(selectedRowApps < 0){
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }else{
            DefaultTableModel tableModel = (DefaultTableModel) tblJobListingsApps.getModel();
            CompDepartment dept = (CompDepartment) tableModel.getValueAt(selectedRowApps, 0);
             viewApplicationDetails(dept);
        }
    }//GEN-LAST:event_btnViewSelectedActionPerformed

    private void txtCompanyMyAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompanyMyAppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyMyAppActionPerformed

    private void txtDateAppliedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateAppliedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateAppliedActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void tblJobListingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJobListingsMouseClicked
        // TODO add your handling code here:
        selectedRow = tblJobListings.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) tblJobListings.getModel();
        CompDepartment dept = (CompDepartment) tableModel.getValueAt(selectedRow, 0);
        displayDepartment(dept);
        btnApply.setEnabled(true);
    }//GEN-LAST:event_tblJobListingsMouseClicked

    private void btnResetFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFilterActionPerformed
        // TODO add your handling code here:
        populateJobListingsTable(compDeptDir);
    }//GEN-LAST:event_btnResetFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        populateJobListingsFiltered(compDeptDir);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        selectedRow = tblJobListings.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }else{
            DefaultTableModel tableModel = (DefaultTableModel) tblJobListings.getModel();
            CompDepartment dept = (CompDepartment) tableModel.getValueAt(selectedRow, 0);
            applyToJob(dept);
            clearAllFieldsJobListing();
        }
        
        
    }//GEN-LAST:event_btnApplyActionPerformed

    private void txtJobAppIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobAppIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobAppIdActionPerformed

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawActionPerformed
        // TODO add your handling code here:
        selectedRowApps = tblJobListingsApps.getSelectedRow();
        if(selectedRowApps < 0){
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }else{
            DefaultTableModel tableModel = (DefaultTableModel) tblJobListingsApps.getModel();
            CompDepartment dept = (CompDepartment) tableModel.getValueAt(selectedRowApps, 0);
            deleteJobApp(dept);
            clearAllFieldsMyApp();;
        }
    }//GEN-LAST:event_btnWithdrawActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void cmbLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocationActionPerformed
        // TODO add your handling code here:
        selectedCityMap =  cmbLocation.getItemAt(cmbLocation.getSelectedIndex());
        updateMap(selectedCityMap);
    }//GEN-LAST:event_cmbLocationActionPerformed

    private void txtCoordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoordsActionPerformed

    private void txtRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRentActionPerformed

    private void txtMoveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoveDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoveDateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(cmbStatus.getSelectedItem().toString().equalsIgnoreCase("No activities")){
            JOptionPane.showMessageDialog(this, "Please select an activity");
        }else{
            updateDetailsMap();
            clearAllFieldsMap();
            disableAllFieldsMap();
            rentals.clearAll();
            loadAllRentals();
            populateTableMap(rentals);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMapActionPerformed
        // TODO add your handling code here:
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Please select a field:"));
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Location");
        model.addElement("Status");
        JComboBox comboBox = new JComboBox(model);
        panel.add(comboBox);

        int resultField = JOptionPane.showConfirmDialog(null, panel, "Search by Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resultField == JOptionPane.OK_OPTION){
            String fieldSelected = comboBox.getSelectedItem().toString();

            DefaultComboBoxModel locs = new DefaultComboBoxModel();
            locs.addElement("Boston");
            locs.addElement("New York");
            locs.addElement("Chicago");
            locs.addElement("San Francisco");
            locs.addElement("Los Angeles");
            locs.addElement("Seattle");

            JComboBox comboBoxLocs = new JComboBox(locs);

            DefaultComboBoxModel status = new DefaultComboBoxModel();
            status.addElement("No activities");
            status.addElement("Finalize deal");
            status.addElement("Negotiate Rent");
            status.addElement("Highlight issues");

            JComboBox comboBoxStatus = new JComboBox(status);

            panel.add(new JLabel("Value:"));

            if(fieldSelected.equalsIgnoreCase("Location")){
                comboBox.setEnabled(false);
                panel.add(comboBoxLocs);
            }else{
                comboBox.setEnabled(false);
                panel.add(comboBoxStatus);
            }

            int resultValue = JOptionPane.showConfirmDialog(null, panel, "Search by Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resultValue == JOptionPane.OK_OPTION) {

                String fieldValue;
                if(fieldSelected.equalsIgnoreCase("Location")){
                    fieldValue = comboBoxLocs.getSelectedItem().toString();
                } else {
                    fieldValue = comboBoxStatus.getSelectedItem().toString();
                }

                RentalAppsDir resultRentalAppsDir = new RentalAppsDir();
                ArrayList<RentalApps> resultRentalApps = new ArrayList<RentalApps>();

                if(fieldSelected.equalsIgnoreCase("Location")){
                    resultRentalApps = rentals.searchByLocation(fieldValue);
                }else if(fieldSelected.equalsIgnoreCase("Status")){
                    resultRentalApps = rentals.searchByStatus(fieldValue);
                }else{
                    resultRentalApps = null;
                }

                if(resultRentalApps.isEmpty()){
                    JOptionPane.showMessageDialog(this, "No Results Found");
                    populateTableMap(rentals);
                }else{
                    JOptionPane.showMessageDialog(this, "Entries found");
                    resultRentalAppsDir.setRentalAppsList(resultRentalApps);
                    populateTableMap(resultRentalAppsDir);
                }

            }else{
                JOptionPane.showMessageDialog(this, "Search Cancelled");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Search Cancelled");
        }
    }//GEN-LAST:event_btnSearchMapActionPerformed

    private void btnRefreshTableMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableMapActionPerformed
        // TODO add your handling code here:
        clearAllFieldsMap();
        disableAllFieldsMap();
        populateTableMap(rentals);
    }//GEN-LAST:event_btnRefreshTableMapActionPerformed

    private void btnClearMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMapActionPerformed
        // TODO add your handling code here:
        clearAllFieldsMap();
        disableAllFieldsMap();
    }//GEN-LAST:event_btnClearMapActionPerformed

    private void btnViewSelectedMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSelectedMapActionPerformed
        clearAllFieldsMap();
        disableAllFieldsMap();

        txtLeasee.setEnabled(true);
        cmbStatus.setEnabled(true);
        txtAreaComments.setEnabled(true);
        btnUpdate.setEnabled(true);

        selectedRow = tblListings.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }else{
            DefaultTableModel tableModel = (DefaultTableModel) tblListings.getModel();
            RentalApps rental = (RentalApps) tableModel.getValueAt(selectedRow, 0);
            displayRentalApp(rental);
            selectedRental = rental;
            if(rental.getAvailability().equalsIgnoreCase("Rented")){
                txtLeasee.setEnabled(false);
                cmbStatus.setEnabled(false);
                txtAreaComments.setEnabled(false);
                btnUpdate.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnViewSelectedMapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button back_btn;
    private button.Button btnApply;
    private button.Button btnClear;
    private button.Button btnClearMap;
    private javax.swing.JButton btnClkAndUpload;
    private button.Button btnRefreshTable;
    private button.Button btnRefreshTableMap;
    private button.Button btnResetFilter;
    private button.Button btnSearch;
    private button.Button btnSearch1;
    private button.Button btnSearchMap;
    private javax.swing.JButton btnTakePic;
    private javax.swing.JButton btnUpdate;
    private button.Button btnViewSelected;
    private button.Button btnViewSelectedMap;
    private button.Button btnWithdraw;
    private javax.swing.JComboBox<String> cmbAvailability;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbLevel;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JComboBox<String> cmbNationality;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JLabel lblAcadSummary;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAppStatus;
    private javax.swing.JLabel lblCollege;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCompanyMyApp;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblDateApplied;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblEmailId;
    private javax.swing.JLabel lblExpGradDate;
    private javax.swing.JLabel lblGPA;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblJobAppId;
    private javax.swing.JLabel lblJobDescription;
    private javax.swing.JLabel lblJobDescription1;
    private javax.swing.JLabel lblJobId;
    private javax.swing.JLabel lblJobProfile;
    private javax.swing.JLabel lblJobTitle;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblResults;
    private javax.swing.JLabel lblRoleFilter;
    private javax.swing.JLabel lblSalaryOffered;
    private javax.swing.JLabel lblSkills;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUniversity;
    private javax.swing.JLabel lblWelcome;
    private button.Button nxtSavebtn;
    private javax.swing.JPanel panelJDWatch;
    private javax.swing.JPanel panelMyApplications;
    private javax.swing.JPanel panelRentals;
    private javax.swing.JPanel panelStudentProfile;
    private javax.swing.JTabbedPane studentTabbedPane;
    private javax.swing.JTable tblJobListings;
    private javax.swing.JTable tblJobListingsApps;
    private javax.swing.JTable tblListings;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextArea txtAreaAcadSummary;
    private javax.swing.JTextArea txtAreaComments;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextArea txtAreaJobDescription;
    private javax.swing.JTextArea txtAreaJobDescriptionMyApp;
    private javax.swing.JTextField txtCollege;
    private javax.swing.JTextField txtCompanyMyApp;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtCoords;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtDateApplied;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtExpGradDate;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtJobAppId;
    private javax.swing.JTextField txtJobId;
    private javax.swing.JTextField txtJobTitle;
    private javax.swing.JTextField txtLeasee;
    private javax.swing.JTextField txtMoveDate;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtRent;
    private javax.swing.JTextField txtSalaryOffered;
    private javax.swing.JTextField txtSkills;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtUniversity;
    // End of variables declaration//GEN-END:variables

    public void populateAllFields(UniStudent student){
        txtStudentName.setText(student.getName());
        txtEmailId.setText(student.getEmailId());
        txtContactNo.setText(student.getContactNo().toString());
        if(student.getAge().equals(0)){
            txtAge.setText("18");
        }else{
            txtAge.setText(student.getAge().toString());
        }
        
        txtUniversity.setText(student.getDepartment().getCollege().getUniversity().getName());
        txtCollege.setText(student.getDepartment().getCollege().getName());
        txtDepartment.setText(student.getDepartment().getName());
        txtCourse.setText(student.getCourse());
        txtGPA.setText(student.getGpa().toString());
        
        txtExpGradDate.setText(getExpectedEndDate(student).toString());
        txtAreaAcadSummary.setText(student.getAcademicSummary());
        
        if(student.getGender()!=null){
            cmbGender.setSelectedItem(student.getGender());
        }else{
            cmbGender.setSelectedIndex(0);
        }
        
        if(student.getCountryOfOrigin()!=null){
            cmbNationality.setSelectedItem(student.getCountryOfOrigin());
        }else{
            cmbNationality.setSelectedIndex(0);
        }
        
        lblWelcome.setText("Welcome, "+ student.getName() + "!");
    }
    
    public void updateDetails(UniStudent student){
        if(!isAgeValid(txtAge.getText())){
                JOptionPane.showMessageDialog(this, "Age should be a number and between 18 and 100,\nboth inclusive");
        }else{
            student.setCountryOfOrigin(cmbNationality.getSelectedItem().toString());
            student.setGender(cmbGender.getSelectedItem().toString());
            student.setAge(Integer.valueOf(txtAge.getText()));
            student.setAcademicSummary(txtAreaAcadSummary.getText());

            updateStudentToDb(student);
            populateAllFields(student);
        }
    }
    
    public void updateStudentToDb(UniStudent student){
        try {
            String queryStudent = "UPDATE uni_student SET country_of_origin = '" + student.getCountryOfOrigin() + "' , gender = '" + student.getGender() + "'"
                    + ", age = '" + student.getAge().toString() + "', academic_summary = '" + student.getAcademicSummary() + "' WHERE "
                    + "student_gov_id = '" + student.getSevisId() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(queryStudent);   
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isAgeValid(String str) { 
        try {  
          Long.valueOf(str);
          if(Long.valueOf(str)<18 || Long.valueOf(str)>100){
            return false;
          }else{
            return true;
          }
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public void getAllListings(){
        try {
            String queryDepartments = "SELECT * FROM job_listings";
            if(student.getSemester() == 1 ||  student.getSemester() == 2){
                queryDepartments = queryDepartments + " WHERE position = 'Intern'"; 
            }else{
                queryDepartments = queryDepartments + " WHERE position = 'Full-Time'";
            }
            String queryCompanies = "SELECT * FROM companies";
            Statement st = conn.createStatement();
            Statement stCompany = conn.createStatement();
            ResultSet rs = st.executeQuery(queryDepartments); 
            ResultSet rsCompany = stCompany.executeQuery(queryCompanies);
                while(rsCompany.next())
                {
                    Company comp = compDir.addCompany();
                    comp.setId(rsCompany.getInt("id"));
                    comp.setName(rsCompany.getString("company_name"));
                    comp.setCountry(rsCompany.getString("country"));
                    comp.setState(rsCompany.getString("state"));
                    comp.setDistrict(rsCompany.getString("district"));
                    comp.setPincode(rsCompany.getString("pincode"));
                    
                }
                while (rs.next())
                {
                    CompDepartment dept = compDeptDir.addCompDepartment();
                    
                    dept.setJobId(rs.getInt("id"));
                    Company requiredCompany = compDir.searchByName(rs.getString("company_name"));
                    dept.setCompany(requiredCompany);                 
                    dept.setJobDescription(rs.getString("job_description"));
                    dept.setLevel(rs.getString("level"));
                    dept.setLocation(rs.getString("location"));
                    dept.setPosition(rs.getString("position"));
                    dept.setRole(rs.getString("role"));
                    dept.setSalaryPerHr(rs.getDouble("salary_offered"));
                    dept.setStartDate(LocalDate.parse(rs.getString("start_date")));
                    dept.setTitle(rs.getString("job_title"));
                    dept.setVisible(rs.getBoolean("visible"));
                    
                    
                }
                st.close();
                stCompany.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateJobListingsTable(CompDepartmentDir compDepartmentDir){
        DefaultTableModel tableModel = (DefaultTableModel) tblJobListings.getModel();
        tableModel.setRowCount(0);
        
        for(CompDepartment dept : compDepartmentDir.getCompDepartmentList()){
            Object row[] = new Object[5];
            if(dept.getVisible()){
                row[0] = dept;
                row[1] = dept.getCompany().getName();
                row[2] = dept.getLocation();
                row[3] = dept.getRole();
                row[4] = dept.getLevel();
                tableModel.addRow(row);
            }
        }
    }
    
    public void populateJobListingsAppsTable(CompDepartmentDir compDepartmentDir){
        DefaultTableModel tableModel = (DefaultTableModel) tblJobListingsApps.getModel();
        tableModel.setRowCount(0);
        
        for(CompDepartment dept : compDepartmentDir.getCompDepartmentList()){
            Object row[] = new Object[8];
            row[0] = dept;
            System.out.println(dept.getTitle());
            row[1] = dept.getTitle();
            row[2] = dept.getLocation();
            row[3] = dept.getRole();
            row[4] = dept.getLevel();
            row[5] = dept.getPosition();
            row[6] = dept.getStartDate().toString();
            row[7] = dept.getSalaryPerHr().toString();
            tableModel.addRow(row);
            
            
        }
    }
    
    public void displayDepartment(CompDepartment dept){
        txtJobId.setText(dept.getJobId().toString());
        txtCompanyName.setText(dept.getCompany().getName());
        txtPosition.setText(dept.getPosition());
        txtJobTitle.setText(dept.getTitle());
        txtAreaJobDescription.setText(dept.getJobDescription());
        txtStartDate.setText(dept.getStartDate().toString());
        txtSalaryOffered.setText(dept.getSalaryPerHr().toString());
    }

    public void clearAllFieldsJobListing(){
        txtJobId.setText("");
        txtCompanyName.setText("");
        txtPosition.setText("");
        txtJobTitle.setText("");
        txtAreaJobDescription.setText("");
        txtStartDate.setText("");
        txtSalaryOffered.setText("");
    }
    
    public void populateJobListingsFiltered(CompDepartmentDir compDeptDirOriginal){
        ArrayList<CompDepartment> newJobListings = new ArrayList<CompDepartment>();
        CompDepartmentDir newCompDeptDir = new CompDepartmentDir();
        
        if(!cmbLevel.getSelectedItem().toString().equalsIgnoreCase("All")){
            newJobListings = compDeptDirOriginal.searchByLevel(cmbLevel.getSelectedItem().toString());
            newCompDeptDir.setCompDepartmentList(newJobListings);
        }else{
            newJobListings = compDeptDirOriginal.getCompDepartmentList();
            newCompDeptDir.setCompDepartmentList(newJobListings);
        }
        
        if(!cmbRole.getSelectedItem().toString().equalsIgnoreCase("All")){
            newJobListings = newCompDeptDir.searchByRole(cmbRole.getSelectedItem().toString());
            newCompDeptDir.setCompDepartmentList(newJobListings);
        }else{
            newJobListings = newCompDeptDir.getCompDepartmentList();
            newCompDeptDir.setCompDepartmentList(newJobListings);
        }
        
        if(!txtSkills.getText().equalsIgnoreCase("")){
            newJobListings = newCompDeptDir.searchByJobDesc(txtSkills.getText());
            newCompDeptDir.setCompDepartmentList(newJobListings);
            System.out.println("not all");
        }else{
            newJobListings = newCompDeptDir.getCompDepartmentList();
            newCompDeptDir.setCompDepartmentList(newJobListings);
        }
        
        populateJobListingsTable(newCompDeptDir);
    }
    
    public void applyToJob(CompDepartment dept){
        compDeptDir.deleteCompDepartment(dept);
        compDeptDirStudent.addCompDepartmentFromAnother(dept);
        saveJobAppToDb(dept, student);
        
        populateJobListingsTable(compDeptDir);  
        populateJobListingsAppsTable(compDeptDirStudent);
        
    }
    
    public void deleteJobApp(CompDepartment dept){
        compDeptDirStudent.deleteCompDepartment(dept);
        compDeptDir.addCompDepartmentFromAnother(dept);
        
        deleteJobAppFromDb(dept, student);
        
        populateJobListingsTable(compDeptDir);  
        populateJobListingsAppsTable(compDeptDirStudent);
        
    }
    
    public void saveJobAppToDb(CompDepartment dept, UniStudent student){
        try {
            String queryNewStudent = "INSERT into appointments (student_gov_id, company_id, job_listings_id, date_applied, status) VALUES "
                    + "('" + student.getSevisId().toString() + "', '" + dept.getCompany().getId().toString() + "' , '" + dept.getJobId().toString() + "', "
                    + "'" + LocalDate.now().toString() + "' , 'Applied')";
            Statement st = conn.createStatement();
            st.executeUpdate(queryNewStudent); 
            st.close();
            
            jobAppDir.clearAllJobApps();
            findAllJobAppsOfStudent(student);
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteJobAppFromDb(CompDepartment dept, UniStudent student){
        try {
            ArrayList<JobAppointments> job = jobAppDir.searchByJobListingId(dept.getJobId());
            String queryDelApp = "DELETE from appointments WHERE application_id = '"
                    + job.get(0).getApplicationId().toString() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(queryDelApp);   
            st.close();
            
            jobAppDir.clearAllJobApps();
            findAllJobAppsOfStudent(student);
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void findAllJobAppsOfStudent(UniStudent student){
        try {
            String queryStudents = "SELECT * FROM appointments WHERE student_gov_id = '" + student.getSevisId() + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(queryStudents);                
                while (rs.next())
                {
                    JobAppointments jobApp = jobAppDir.addJobAppointment();
                    
                    jobApp.setApplicationId(rs.getInt("application_id"));
                    jobApp.setSevisId(rs.getString("student_gov_id"));
                    jobApp.setCompanyId(rs.getInt("company_id"));
                    jobApp.setJobListingsId(rs.getInt("job_listings_id"));
                    jobApp.setDateApplied(LocalDate.parse(rs.getString("date_applied")));
                    if(rs.getString("status")!=null){
                        jobApp.setStatus(rs.getString("status"));
                    }
                    if(rs.getString("comments")!=null){
                        jobApp.setComments(rs.getString("comments"));
                    }
                }
                st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeJobAppFromListings(){
        for(JobAppointments jobApp : jobAppDir.getJobAppointmentsList()){
            CompDepartment newDept = compDeptDir.searchByJobId(jobApp.getJobListingsId());
            compDeptDir.deleteCompDepartment(newDept);
            compDeptDirStudent.addCompDepartmentFromAnother(newDept);
        }
    }
    
    public void viewApplicationDetails(CompDepartment dept){
        txtCompanyMyApp.setText(dept.getCompany().getName());
        txtAreaJobDescriptionMyApp.setText(dept.getJobDescription());
        ArrayList<JobAppointments> jobApps = jobAppDir.searchByJobListingId(dept.getJobId());
        txtJobAppId.setText(jobApps.get(0).getApplicationId().toString());
        txtDateApplied.setText(jobApps.get(0).getDateApplied().toString());
        if(jobApps.get(0).getStatus()!=null){
            txtStatus.setText(jobApps.get(0).getStatus());
        }else{
            txtStatus.setText("");
        }
        if(student.getJdWatchAccess()){
            btnWithdraw.setEnabled(true);
        }else{
            btnWithdraw.setEnabled(false);
        }
        
    }
    
    public void clearAllFieldsMyApp(){
        txtCompanyMyApp.setText("");
        txtAreaJobDescriptionMyApp.setText("");
        txtJobAppId.setText("");
        txtDateApplied.setText("");
        txtStatus.setText("");
        btnWithdraw.setEnabled(false);
    }
    
    public LocalDate getExpectedEndDate(UniStudent student){
        LocalDate today = LocalDate.now();
        Integer month = today.getMonthValue();
        Integer year = today.getYear();
        
        LocalDate expectedStart = LocalDate.now();
        if(student.getSemester()==1){
            Integer monthsAdv = ((month + 9) % 12) / 4;
            Integer yearAdv = year;
            if(month >= 9){
                yearAdv+=1;
            }
            if(monthsAdv == 0){
                String expectedStartStr = yearAdv.toString() + "-04-30";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else if(monthsAdv == 1){
                String expectedStartStr = yearAdv.toString() + "-08-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else{
                String expectedStartStr = yearAdv.toString() + "-12-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }
        }else if(student.getSemester()==2){
            Integer monthsAdv = ((month + 6) % 12) / 4;
            Integer yearAdv = year;
            if(month >= 9){
                yearAdv+=1;
            }
            if(monthsAdv == 0){
                String expectedStartStr = yearAdv.toString() + "-04-30";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else if(monthsAdv == 1){
                String expectedStartStr = yearAdv.toString() + "-08-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else{
                String expectedStartStr = yearAdv.toString() + "-12-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }
        }else if(student.getSemester()==3){
            Integer monthsAdv = ((month + 3) % 12) / 4;
            Integer yearAdv = year;
            if(month >= 9){
                yearAdv+=1;
            }
            if(monthsAdv == 0){
                String expectedStartStr = yearAdv.toString() + "-04-30";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else if(monthsAdv == 1){
                String expectedStartStr = yearAdv.toString() + "-08-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else{
                String expectedStartStr = yearAdv.toString() + "-12-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }
        }else{
            Integer monthsAdv = ((month - 1) % 12) / 4;
            Integer yearAdv = year;
            
            if(monthsAdv == 0){
                String expectedStartStr = yearAdv.toString() + "-04-30";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else if(monthsAdv == 1){
                String expectedStartStr = yearAdv.toString() + "-08-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }else{
                String expectedStartStr = yearAdv.toString() + "-12-31";
                expectedStart = LocalDate.parse(expectedStartStr);
            }
        }
        return expectedStart;
    }
    
    public void sql(File inpFile){
            
            
        try {
                
                

                  String query = "SELECT * FROM photos"; // retrieve photo
                  
                  File myFile = inpFile;

                  try(FileInputStream fin = new FileInputStream(myFile)){
                        PreparedStatement pst = conn.prepareStatement("INSERT INTO photos (photos,student_id)VALUES(?,?)");

                        pst.setBlob(1, fin);
                        pst.setInt(2, student.getId());
                        pst.executeUpdate();
                  }catch(IOException ex){
                      Logger lgr =Logger.getLogger(UniStudentJPanel.class.getName());
                      lgr.log(Level.SEVERE,ex.getMessage(),ex);
                  }
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery(query); // retrieve photo
//                int count=0;
//                
//                System.out.println(count);
//                
//                while (rs.next()) // retrieve photo
//                {
//                    count++;
//                  int id = rs.getInt("id");
//                    String filename = "D:/Ameya data/NEU/AED Lab Sem 1/photos/image"+count+".png";
//                  try(FileOutputStream fos = new FileOutputStream(filename)){
//                      Blob blob = rs.getBlob("photos");
//                      int len = (int) blob.length();
//                      byte[] buf = blob.getBytes(1, len);
//                      fos.write(buf,0,len);
//                  }catch(IOException ex){
//                      Logger lgr =Logger.getLogger(UniStudentJPanel.class.getName());
//                      lgr.log(Level.SEVERE,ex.getMessage(),ex);
//                  }
//                  
//                  
//                }
//                st.close();

                if (conn != null) {
                    System.out.println("Connected to the database test1");

                    
                }

            } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
            
        }
    
    public ImageIcon retrieveImage(UniStudent myStudent){
        ImageIcon uploadedImage=null;
        ImageIcon scaledImageIcon=null;
        try{ Statement st = conn.createStatement();
                String query = "SELECT photos FROM photos WHERE student_id="+myStudent.getId();
                ResultSet rs = st.executeQuery(query); // retrieve photo
                int count=0;
                
//                System.out.println(count);
                
                while (rs.next()) // retrieve photo
                {
                    count++;
//                  int id = rs.getInt("id");
                    String filename = "retCapture"+".png";
                  try(FileOutputStream fos = new FileOutputStream(filename)){
                      Blob blob = rs.getBlob("photos");
                      int len = (int) blob.length();
                      byte[] buf = blob.getBytes(1, len);
                      fos.write(buf,0,len);
                      
                uploadedImage = new ImageIcon(filename);
                Image image1 = uploadedImage.getImage();
                Image scaledImage = image1.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
                scaledImageIcon = new ImageIcon(scaledImage);
                  }catch(IOException ex){
                      Logger lgr =Logger.getLogger(UniStudentJPanel.class.getName());
                      lgr.log(Level.SEVERE,ex.getMessage(),ex);
                  }
                  
                  
                }
                st.close();

                if (conn != null) {
                    System.out.println("Connected to the database test1");

                    
                }
                
            } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return scaledImageIcon;
    }
    
    public void addMouseListener(){   
        jXMapViewer.addMouseListener(mm);
        jXMapViewer.addMouseMotionListener(mm);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
    }
    
    public void removeMouseListener(){
        jXMapViewer.removeMouseListener(mm);
        jXMapViewer.removeMouseMotionListener(mm);
        jXMapViewer.removeMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));
    }
    
    public void updateMap(String selectedCity){
        if(selectedCity.equalsIgnoreCase("Boston")){
            latitude = 42.3145186;
            longitude = -71.1103689;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(latitude, longitude)));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }else if(selectedCity.equalsIgnoreCase("New York")){
//            init(40.6976701,-74.2598698);
            latitude = 40.6976701;
            longitude = -74.2598698;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(latitude, longitude)));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }else if(selectedCity.equalsIgnoreCase("Chicago")){
//            init(41.8339042,-88.0121521);
            latitude = 41.8339042;
            longitude = -88.0121521;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(latitude, longitude)));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }else if(selectedCity.equalsIgnoreCase("San Francisco")){
//            init(37.771713, -122.431704);
            latitude = 37.771713;
            longitude = -122.431704;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(latitude, longitude)));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }else if(selectedCity.equalsIgnoreCase("Los Angeles")){
//            init(34.034957,-118.257965);
            latitude = 34.034957;
            longitude = -118.257965;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(latitude, longitude)));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }else{
//            init(47.606756,-122.322473);
            latitude = 47.606756;
            longitude = -122.322473;
            init(latitude,longitude);
            addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(geo.getLatitude(), geo.getLongitude())));
            initWaypoint();
            txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
        }
        txtCoords.setText("");
    }
    
    private void disableAllFieldsMap(){
        txtTitle.setEnabled(false);
        txtAreaDescription.setEnabled(false);
        txtRent.setEnabled(false);
        
        cmbLocation.setEnabled(false);
        txtCoords.setEnabled(false);
        txtMoveDate.setEnabled(false);
        cmbAvailability.setEnabled(false);
        
        txtLeasee.setEnabled(false);
        cmbStatus.setEnabled(false);
        txtAreaComments.setEnabled(false);
        
        jXMapViewer.setEnabled(false);
        
        btnUpdate.setEnabled(false);
    }
    
    private void enableAllFieldsMap(){
        txtTitle.setEnabled(true);
        txtAreaDescription.setEnabled(true);
        txtRent.setEnabled(true);
        
        cmbLocation.setEnabled(true);
        txtCoords.setEnabled(true);
        txtMoveDate.setEnabled(true);
        cmbAvailability.setEnabled(true);
        
        txtLeasee.setEnabled(true);
        cmbStatus.setEnabled(true);
        txtAreaComments.setEnabled(true);
        
        jXMapViewer.setEnabled(true);
      
        btnUpdate.setEnabled(true);
    }
    
    public void populateTableMap(RentalAppsDir rentals){
        DefaultTableModel tableModel = (DefaultTableModel) tblListings.getModel();
        tableModel.setRowCount(0);
        
        for(RentalApps rental : rentals.getRentalAppsList()){
            Object row[] = new Object[7];
            row[0] = rental;
            row[1] = ngoRents.searchById(rental.getNgoRentalId()).getName();
            row[2] = rental.getTitle();
            row[3] = rental.getLocation();
            row[4] = rental.getRent().toString();
            row[5] = rental.getAvailability();
            row[6] = rental.getStatus();
            
            tableModel.addRow(row);
        }
    }
    
    public void loadAllRentals(){
        try {
            String queryRentals = "SELECT * FROM rentals WHERE availability = 'Available' OR leasee_id = '"+student.getId().toString()+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(queryRentals);                
                while (rs.next())
                {
                    RentalApps rental = rentals.addRentalApps();
                    
                    rental.setId(rs.getInt("id"));
                    rental.setTitle(rs.getString("title"));
                    rental.setDescription(rs.getString("description"));
                    rental.setRent(Integer.valueOf(rs.getString("rent")));
                    rental.setAvailability(rs.getString("availability"));
                    rental.setLatitude(Double.valueOf(rs.getString("latitude")));
                    rental.setLongitude(Double.valueOf(rs.getString("longitude")));
                    rental.setLocation(rs.getString("location"));
                    rental.setStatus(rs.getString("status"));
                    rental.setNgoRentalId(Integer.valueOf(rs.getString("ngo_rental_id")));
                    rental.setStartDate(LocalDate.parse(rs.getString("start_date")));
                    
                    if(rs.getString("name_of_leasee")!=null){
                        rental.setNameOfLeasee(rs.getString("name_of_leasee"));
                    }else{
                        rental.setNameOfLeasee("");
                    }
                    
                    if(rs.getString("comments")!=null){
                        rental.setComments(rs.getString("comments"));
                    }else{
                        rental.setComments("");
                    }
                    
                    if(rs.getInt("leasee_id")!=0){
                        rental.setLeaseeId(rs.getInt("leasee_id"));
                    }else{
                        rental.setLeaseeId(0);
                    }
                    
                    
                }
                st.close();
                
                Boolean rent = false;
                for(RentalApps rental: rentals.getRentalAppsList()){
                    if(rental.getAvailability().equalsIgnoreCase("Rented")){
                        rent = true;
                    }
                }
                
                if(rent){
                    rentals.deleteAllNonRented();
                }
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearAllFieldsMap(){
        txtTitle.setText("");
        txtAreaDescription.setText("");
        txtRent.setText("");
        
        cmbLocation.setSelectedIndex(0);
        txtCoords.setText("");
        txtMoveDate.setText("");
        cmbAvailability.setSelectedIndex(0);
        
        txtLeasee.setText("");
        cmbStatus.setSelectedIndex(0);
        txtAreaComments.setText("");
        
        jXMapViewer.setEnabled(false);
        removeMouseListener();
    }
    
    public void displayRentalApp(RentalApps rental){
        txtTitle.setText(rental.getTitle());
        txtAreaDescription.setText(rental.getDescription());
        txtRent.setText(rental.getRent().toString());
        
        cmbLocation.setSelectedItem(rental.getLocation());
        txtCoords.setText(rental.getLatitude().toString()+","+rental.getLongitude().toString());
        txtMoveDate.setText(rental.getStartDate().toString());
        cmbAvailability.setSelectedItem(rental.getAvailability());
        
        txtLeasee.setText(student.getName());
        cmbStatus.setSelectedItem(rental.getStatus());
        txtAreaComments.setText(rental.getComments());
        
        latitude = rental.getLatitude();
        longitude = rental.getLongitude();
        init(latitude,longitude);
        addWaypoint(new MyWaypoint("Test 001", event, new GeoPosition(geo.getLatitude(), geo.getLongitude())));
        initWaypoint();
        txtCoords.setText(String.valueOf(latitude) +"," + String.valueOf(longitude));
    }
    
    public void updateDetailsMap(){
        try {
            String queryNewStudent = "UPDATE rentals SET availability = 'Deal in progress', name_of_leasee = '"+ txtLeasee.getText() +"' , status = '"+cmbStatus.getSelectedItem().toString()+"', comments = '"+txtAreaComments.getText()+"', leasee_id = '"+student.getId().toString()+"' WHERE id = '"+ selectedRental.getId().toString() +"'";
            Statement st = conn.createStatement();
            st.executeUpdate(queryNewStudent); 
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getAllNgoRentals(){
        try {
            
            String queryNgoRentals = "SELECT * FROM ngo_rentals";
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(queryNgoRentals);
                while(rs.next())
                {
                    NgoRentals rental = ngoRents.addNgoRentals();
                    rental.setId(rs.getInt("id"));
                    rental.setUsername(rs.getString("username"));
                    rental.setPassword(rs.getString("password"));
                    rental.setName(rs.getString("name"));
                    rental.setCountry(rs.getString("country"));
                    rental.setLocation(rs.getString("location"));
                    
                }
            
                st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UniExamCellJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
