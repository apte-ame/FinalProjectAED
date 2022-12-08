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

    public ArrayList<Government> getGovernmentList() {
        return governmentList;
    }

    public void setGovernmentList(ArrayList<Government> governmentList) {
        this.governmentList = governmentList;
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
    
    public Government searchById(Integer id){
        for(Government government : governmentList){
            if(government.getId().equals(id)){
                return government;
            }
        }
        return null;
    }
    
    public Government searchByName(String name){
        for(Government government : governmentList){
            if(government.getName().equals(name)){
                return government;
            }
        }
        return null;
    }
    
    public Government searchByState(String state){
        for(Government government : governmentList){
            if(government.getState().equals(state)){
                return government;
            }
        }
        return null;
    }
    
    public Government searchByCountry(String country){
        for(Government government : governmentList){
            if(government.getCountry().equals(country)){
                return government;
            }
        }
        return null;
    }
    
    public Government searchByPincode(String pincode){
        for(Government government : governmentList){
            if(government.getPincode().equals(pincode)){
                return government;
            }
        }
        return null;
    }
    
    public Government searchByUsername(String username){
        for(Government government : governmentList){
            if(government.getUsername().equals(username)){
                return government;
            }
        }
        return null;
    }
}
