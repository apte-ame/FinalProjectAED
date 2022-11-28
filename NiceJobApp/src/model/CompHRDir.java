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
public class CompHRDir {
    
    ArrayList<CompHR> compHRList;

    public CompHRDir() {
        compHRList = new ArrayList<>();
    }
    
    public CompHR addCompHR(){
        CompHR newCompHR = new CompHR();
        compHRList.add(newCompHR);
        return newCompHR;
    }
    
    public void deleteCompHR(CompHR delCompHR){
        compHRList.remove(delCompHR);
    }
    
    public CompHR searchCompHR(CompHR searchCompHR){
        for(CompHR compHR : compHRList){
            if(compHR.equals(searchCompHR)){
                return compHR;
            }
        }
        return null;
    }
    
    public CompHR searchById(Integer id){
        for(CompHR compHR : compHRList){
            if(compHR.getId().equals(id)){
                return compHR;
            }
        }
        return null;
    }
    
    public CompHR searchByName(String name){
        for(CompHR compHR : compHRList){
            if(compHR.getName().equals(name)){
                return compHR;
            }
        }
        return null;
    }
    
    public CompHR searchByCompany(Company company){
        for(CompHR compHR : compHRList){
            if(compHR.getCompany().equals(company)){
                return compHR;
            }
        }
        return null;
    }
    
    public CompHR searchByDepartment(CompDepartment department){
        for(CompHR compHR : compHRList){
            if(compHR.getDepartment().equals(department)){
                return compHR;
            }
        }
        return null;
    }
    
    public ArrayList<CompHR> updateCompHR(CompHR oldCompHR,CompHR updateCompHR){
        Integer ind = compHRList.indexOf(oldCompHR);
        compHRList.set(ind, updateCompHR);
        return compHRList;
    }
}
