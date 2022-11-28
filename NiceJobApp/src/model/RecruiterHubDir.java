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
    
    public ArrayList<RecruiterHub> updateRecruiterHub(RecruiterHub oldRecruiterHub,RecruiterHub updateRecruiterHub){
        Integer ind = recruiterHubList.indexOf(oldRecruiterHub);
        recruiterHubList.set(ind, updateRecruiterHub);
        return recruiterHubList;
    }
}
