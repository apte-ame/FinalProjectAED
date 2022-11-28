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
public class GovernmentDir {
    
    ArrayList<Government> governmentList;

    public GovernmentDir() {
        governmentList = new ArrayList<>();
    }
    
    public Government addGovernment(){
        Government newGovernment = new Government();
        governmentList.add(newGovernment);
        return newGovernment;
    }
    
    public void deleteGovernment(Government delGovernment){
        governmentList.remove(delGovernment);
    }
    
    public Government searchGovernment(Government searchGovernment){
        for(Government government : governmentList){
            if(government.equals(searchGovernment)){
                return government;
            }
        }
        return null;
    }
    
    public ArrayList<Government> updateGovernment(Government oldGovernment,Government updateGovernment){
        Integer ind = governmentList.indexOf(oldGovernment);
        governmentList.set(ind, updateGovernment);
        return governmentList;
    }
}
