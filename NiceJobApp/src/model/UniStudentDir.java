/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UniStudentDir {
    
    ArrayList<UniStudent> uniStudentList;

    public UniStudentDir() {
        uniStudentList = new ArrayList<>();
    }
    
    public UniStudent addUniStudent(){
        UniStudent newUniStudent = new UniStudent();
        uniStudentList.add(newUniStudent);
        return newUniStudent;
    }
    
    public void deleteUniStudent(UniStudent delUniStudent){
        uniStudentList.remove(delUniStudent);
    }
    
    public UniStudent searchUniStudent(UniStudent searchUniStudent){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.equals(searchUniStudent)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public ArrayList<UniStudent> updateUniStudent(UniStudent oldUniStudent,UniStudent updateUniStudent){
        Integer ind = uniStudentList.indexOf(oldUniStudent);
        uniStudentList.set(ind, updateUniStudent);
        return uniStudentList;
    }
}
