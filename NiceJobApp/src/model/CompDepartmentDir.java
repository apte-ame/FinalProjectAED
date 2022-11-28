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
public class CompDepartmentDir {
    
    ArrayList<CompDepartment> compDepartmentList;

    public CompDepartmentDir() {
        compDepartmentList = new ArrayList<>();
    }
    
    public CompDepartment addCompDepartment(){
        CompDepartment newCompDepartment = new CompDepartment();
        compDepartmentList.add(newCompDepartment);
        return newCompDepartment;
    }
    
    public void deleteCompDepartment(CompDepartment delCompDepartment){
        compDepartmentList.remove(delCompDepartment);
    }
    
    public CompDepartment searchCompDepartment(CompDepartment searchCompDepartment){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.equals(searchCompDepartment)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public ArrayList<CompDepartment> updateCompDepartment(CompDepartment oldCompDepartment,CompDepartment updateCompDepartment){
        Integer ind = compDepartmentList.indexOf(oldCompDepartment);
        compDepartmentList.set(ind, updateCompDepartment);
        return compDepartmentList;
    }
}
