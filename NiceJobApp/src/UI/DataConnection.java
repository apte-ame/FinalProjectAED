/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnection {
    Connection conn = null;
    public DataConnection(Connection conn) {
        this.conn = conn;
    
    }
       
//    public static void main(String[] args)throws Exception{
    public HashMap<String,Integer> dataConn(){
       
           HashMap<String,Integer> myMap = new HashMap<>();
        try {
//                conn = DriverManager.getConnection(url1, user, password);
                String queryNewStudent = "SET SESSION wait_timeout=31536000;";
                Statement st = conn.createStatement();
                st.executeUpdate(queryNewStudent);   
                st.close();
//                String query = "SELECT * from test_nation ";
                String query = "SELECT * from uni_student";
                ArrayList<String> myArray= new ArrayList<>();
                
                Statement stStudent = conn.createStatement();
                ResultSet rs = stStudent.executeQuery(query); 
                ArrayList<String> nationality = new ArrayList<>();
                
                while(rs.next()){
                   // int id = rs.getInt("id");y
//                   nationality.add(rs.getString("Nationality"));
                     nationality.add(rs.getString("country_of_origin"));
                }
                stStudent.close();
                Collections.sort(nationality);
                for(String nat:nationality){
                    myMap.put(nat, Collections.frequency(nationality, nat));
                   
                }
                for (String name: myMap.keySet()) {
                    String key = name;
                    String value = myMap.get(name).toString();
                    System.out.println(key + " " + value);              
}
            
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return myMap;
    }      

}
