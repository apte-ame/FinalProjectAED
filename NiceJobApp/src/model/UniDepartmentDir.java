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
public class UniDepartmentDir {
    
    ArrayList<UniDepartment> uniDepartmentList;

    public UniDepartmentDir() {
        uniDepartmentList = new ArrayList<>();
    }
    
    public UniDepartment addUniDepartment(){
        UniDepartment newUniDepartment = new UniDepartment();
        uniDepartmentList.add(newUniDepartment);
        return newUniDepartment;
    }
    
    public void deleteUniDepartment(UniDepartment delUniDepartment){
        uniDepartmentList.remove(delUniDepartment);
    }
    
    public UniDepartment searchUniDepartment(UniDepartment searchUniDepartment){
        for(UniDepartment uniDepartment : uniDepartmentList){
            if(uniDepartment.equals(searchUniDepartment)){
                return uniDepartment;
            }
        }
        return null;
    }
    
    public ArrayList<UniDepartment> updateUniDepartment(UniDepartment oldUniDepartment,UniDepartment updateUniDepartment){
        Integer ind = uniDepartmentList.indexOf(oldUniDepartment);
        uniDepartmentList.set(ind, updateUniDepartment);
        return uniDepartmentList;
    }
}
