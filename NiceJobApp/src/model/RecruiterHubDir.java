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
public class RecruiterHubDir {
    
    ArrayList<RecruiterHub> recruiterHubList;

    public RecruiterHubDir() {
        recruiterHubList = new ArrayList<>();
    }
    
    public RecruiterHub addRecruiterHub(){
        RecruiterHub newRecruiterHub = new RecruiterHub();
        recruiterHubList.add(newRecruiterHub);
        return newRecruiterHub;
    }
    
    public void deleteRecruiterHub(RecruiterHub delRecruiterHub){
        recruiterHubList.remove(delRecruiterHub);
    }
    
    public RecruiterHub searchRecruiterHub(RecruiterHub searchRecruiterHub){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.equals(searchRecruiterHub)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchById(Integer id){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getId().equals(id)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchByName(String name){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getName().equals(name)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchByDistrict(String district){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getDistrict().equals(district)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchByState(String state){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getState().equals(state)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchByCountry(String country){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getCountry().equals(country)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public RecruiterHub searchByPincode(String pincode){
        for(RecruiterHub recruiterHub : recruiterHubList){
            if(recruiterHub.getPincode().equals(pincode)){
                return recruiterHub;
            }
        }
        return null;
    }
    
    public ArrayList<RecruiterHub> updateRecruiterHub(RecruiterHub oldRecruiterHub,RecruiterHub updateRecruiterHub){
        Integer ind = recruiterHubList.indexOf(oldRecruiterHub);
        recruiterHubList.set(ind, updateRecruiterHub);
        return recruiterHubList;
    }
}
