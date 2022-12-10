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
    public ArrayList<HashMap<String,Integer>> dataConn(){
       
           HashMap<String,Integer> myMap = new HashMap<>();
           HashMap<String,Integer> myMap1 = new HashMap<>();
           ArrayList<HashMap<String,Integer>> temp = new ArrayList<>();
        try {
//                conn = DriverManager.getConnection(url1, user, password);
                String queryNewStudent = "SET SESSION wait_timeout=31536000;";
                Statement st = conn.createStatement();
                st.executeUpdate(queryNewStudent);   
                st.close();
//                String query = "SELECT * from test_nation ";
                String query = "SELECT * from uni_student";
                String queryNew = "SELECT location,AVG(salary_offered) as avg_salary FROM job_listings GROUP BY location";
                ArrayList<String> myArray= new ArrayList<>();
                
                Statement stStudent = conn.createStatement();
                Statement stNew = conn.createStatement();
                ResultSet rs = stStudent.executeQuery(query); 
                ResultSet rsNew = stNew.executeQuery(queryNew);
                
                ArrayList<String> nationality = new ArrayList<>();
                ArrayList<String> location = new ArrayList<>();
                while(rs.next()){
                   // int id = rs.getInt("id");y
//                   nationality.add(rs.getString("Nationality"));
                     nationality.add(rs.getString("country_of_origin"));
                }
                
                while(rsNew.next()){
                   // int id = rs.getInt("id");y
//                   nationality.add(rs.getString("Nationality"));
//                     location.add(rsNew.getString("location"));
                     myMap1.put(rsNew.getString("location"), rsNew.getInt("avg_salary"));
                }
                
                stStudent.close();
                stNew.close();
                Collections.sort(nationality);
//                Collections.sort(location);
                for(String nat:nationality){
                    myMap.put(nat, Collections.frequency(nationality, nat));
                   
                }
                for (String name: myMap.keySet()) {
                    String key = name;
                    String value = myMap.get(name).toString();
                    System.out.println(key + " " + value);              
}
                
                 for (String name: myMap1.keySet()) {
                    String key = name;
                    String value = myMap1.get(name).toString();
                    System.out.println(key + " " + value);              
}
                
                
                temp.add(myMap);
                temp.add(myMap1);
//                for (String name: myMap.keySet()) {
//                    String key = name;
//                    String value = myMap.get(name).toString();
//                    System.out.println(key + " " + value);              
//}
//            
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return temp;
    }      

}
