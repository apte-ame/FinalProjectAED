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
public class RHJobPostingDir {
    
    ArrayList<RHJobPosting> rhJobPostingList;

    public RHJobPostingDir() {
        rhJobPostingList = new ArrayList<>();
    }
    
    public RHJobPosting addRHJobPosting(){
        RHJobPosting newRHJobPosting = new RHJobPosting();
        rhJobPostingList.add(newRHJobPosting);
        return newRHJobPosting;
    }
    
    public void deleteRHJobPosting(RHJobPosting delRHJobPosting){
        rhJobPostingList.remove(delRHJobPosting);
    }
    
    public RHJobPosting searchRHJobPosting(RHJobPosting searchRHJobPosting){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.equals(searchRHJobPosting)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public ArrayList<RHJobPosting> updateRHJobPosting(RHJobPosting oldRHJobPosting,RHJobPosting updateRHJobPosting){
        Integer ind = rhJobPostingList.indexOf(oldRHJobPosting);
        rhJobPostingList.set(ind, updateRHJobPosting);
        return rhJobPostingList;
    }
}
