/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package chart;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Form_1 extends javax.swing.JPanel {

   
    public Form_1() {
       initComponents();
        initData();
    }

        private void initData() {
        List<ModelChartPie> list1 = new ArrayList<>();
        list1.add(new ModelChartPie("China", 10, new Color(4, 174, 243)));
        list1.add(new ModelChartPie("India", 150, new Color(215, 39, 250)));
        list1.add(new ModelChartPie("USA", 80, new Color(44, 88, 236)));
        list1.add(new ModelChartPie("Others", 100, new Color(21, 202, 87)));
         chartPie.setModel(list1);
        //  Test data chart line
        List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("China", 10));
        list.add(new ModelChartLine("India", 150));
        list.add(new ModelChartLine("USA", 80));
        list.add(new ModelChartLine("Others", 100));
       
        chartLine1.setModel(list);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPie = new chart.ChartPie();
        chartLine1 = new chart.ChartLine();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.ChartLine chartLine1;
    private chart.ChartPie chartPie;
    // End of variables declaration//GEN-END:variables
}
