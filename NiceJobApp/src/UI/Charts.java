/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Charts extends javax.swing.JPanel {

    Connection conn = null;
    public Charts() {
        initComponents();
//        showLineChart();
//        showBarChart();
//        getData();
    }

//    public void showBarChart(){
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(200, "Rate", "Intern");
//        dataset.setValue(150, "Rate", "Analyst");
//        dataset.setValue(18, "Rate", "Associate");
//        dataset.setValue(100, "Rate", "Manager");
//      
//        
//        JFreeChart chart = ChartFactory.createBarChart("Rate VS Level","Level","Rate", 
//                dataset, PlotOrientation.VERTICAL, false,true,false);
//        
//        CategoryPlot categoryPlot = chart.getCategoryPlot();
//        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
//        categoryPlot.setBackgroundPaint(Color.WHITE);
//        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
//        Color clr3 = new Color(204,0,51);
//        renderer.setSeriesPaint(0, clr3);
//        
//        ChartPanel barpChartPanel = new ChartPanel(chart);
//        panelBarChart.removeAll();
//        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
//        panelBarChart.validate();
//        
//        
//    }
//    
//     public void showLineChart(){
//        //create dataset for the graph
//         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.setValue(20, "Rate", "BA");
//        dataset.setValue(15, "Rate", "DS");
//        dataset.setValue(18, "Rate", "DA");
//        dataset.setValue(10, "Rate", "PM");
//        dataset.setValue(8, "Rate", "M");
//        dataset.setValue(25, "Rate", "SWE");
//        
//        //create chart
//        JFreeChart linechart = ChartFactory.createLineChart("Rate VS Role","Role","Rate", 
//                dataset, PlotOrientation.VERTICAL, false,true,false);
//        
//        //create plot object
//         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
//       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
//        lineCategoryPlot.setBackgroundPaint(Color.white);
//        
//        //create render object to change the moficy the line properties like color
//        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
//        Color lineChartColor = new Color(204,0,51);
//        lineRenderer.setSeriesPaint(0, lineChartColor);
//        
//         //create chartPanel to display chart(graph)
//        ChartPanel lineChartPanel = new ChartPanel(linechart);
//        panelLineChart.removeAll();
//        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
//        panelLineChart.validate();
//    }
    
    
     public void showBarChart(ResultSet myRs) {
     
        Integer countNew = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            while(myRs.next()){
                try {
                    countNew++;
//                    dataset.setValue(myRs.getInt("Hour_rate"), "Rate", myRs.getString("Level"));
//                    System.out.println(myRs.getInt("Hour_rate")+" "+ myRs.getString("Level")+"\n");
                   dataset.setValue(myRs.getInt("avg_salary"), "Rate", myRs.getString("role"));
                    System.out.println(myRs.getString("role")+" "+ myRs.getInt("avg_salary")+"\n");
                } catch (SQLException ex) {
                    Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
        }

//        dataset.setValue(150, "Rate", "Analyst");
//        dataset.setValue(18, "Rate", "Associate");
//        dataset.setValue(100, "Rate", "Manager");

//        dataset.setValue(150, "Rate", "Analyst");
//        dataset.setValue(18, "Rate", "Associate");
//        dataset.setValue(100, "Rate", "Manager");
      
        
        JFreeChart chart = ChartFactory.createBarChart("Rate VS Level","Level","Rate", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        panelBarChart.removeAll();
        panelBarChart.add(barpChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
        
        
    }
    
     public void showLineChart(ResultSet myRs){
        //create dataset for the graph
        Integer count = 0;
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            while(myRs.next()){
                try {
                    count++;
//                    dataset.setValue(myRs.getInt("Hour_rate"), "Rate", myRs.getString("Role"));
//                    System.out.println(myRs.getInt("Hour_rate")+" "+ myRs.getString("Role")+"\n");
                      dataset.setValue(myRs.getInt("avg_salary"), "Rate", myRs.getString("level"));
                      System.out.println(myRs.getString("level")+" "+ myRs.getInt("avg_salary")+"\n");

                } catch (SQLException ex) {
                    Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//        dataset.setValue(20, "Rate", "BA");
//        dataset.setValue(15, "Rate", "DS");
//        dataset.setValue(18, "Rate", "DA");
//        dataset.setValue(10, "Rate", "PM");
//        dataset.setValue(8, "Rate", "M");
//        dataset.setValue(25, "Rate", "SWE");
        } catch (SQLException ex) {
            Logger.getLogger(Charts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Rate VS Role","Role","Rate", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }

    public void getData(Connection connect){
//      String url1 = "jdbc:mysql://remotemysql.com:3306/X3utimq6Oc?autoConnect=true";
//            String user = "X3utimq6Oc";
//            String password = "YhPSJWB1Qu";
//

        conn = connect;
        

        ResultSet rs = null;
        ResultSet rs1 =null;
        try {
                
//                String query = "SELECT * from test_nation ";
                String query = "SELECT level,AVG(salary_offered) as avg_salary FROM job_listings GROUP BY level";
                String queryNew = "SELECT role,AVG(salary_offered) as avg_salary FROM job_listings GROUP BY role";
                ArrayList<String> myArray= new ArrayList<>();
//                conn = DriverManager.getConnection(url1, user, password);
                Statement stStudent = conn.createStatement();
                Statement stStudent2 = conn.createStatement();
                rs = stStudent.executeQuery(queryNew); 
                rs1 = stStudent2.executeQuery(query); 
                showLineChart(rs1);
                showBarChart(rs);
                
                stStudent.close();
                stStudent2.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGPanel = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();
        panelLineChart = new javax.swing.JPanel();

        BGPanel.setBackground(new java.awt.Color(255, 255, 255));
        BGPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarChart.setPreferredSize(new java.awt.Dimension(350, 350));
        panelBarChart.setLayout(new java.awt.BorderLayout());
        BGPanel.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 350, 330));

        panelLineChart.setPreferredSize(new java.awt.Dimension(350, 350));
        panelLineChart.setLayout(new java.awt.BorderLayout());
        BGPanel.add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 350, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BGPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGPanel;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    // End of variables declaration//GEN-END:variables
}
