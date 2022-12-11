/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
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
    
    public RHJobPosting searchById(Integer id){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getId().equals(id)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchByPostName(String postName){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getPostName().equals(postName)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchByDepartment(CompDepartment companyDepartment){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getCompanyDepartment().equals(companyDepartment)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchByPostingValidFrom(LocalDate postingValidFrom){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getPostingValidFrom().equals(postingValidFrom)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchByPostingValidTill(LocalDate postingValidTill){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getPostingValidFrom().equals(postingValidTill)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchByDescription(String description){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getDescription().equals(description)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public RHJobPosting searchBySalaryRange(String salaryRange){
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getSalaryRange().equals(salaryRange)){
                return rhJobPosting;
            }
        }
        return null;
    }
    
    public ArrayList<RHJobPosting> searchByCompanyName(String companyName){
        ArrayList<RHJobPosting> newRHJobPostings = new ArrayList<>();
        for(RHJobPosting rhJobPosting : rhJobPostingList){
            if(rhJobPosting.getCompName().equals(companyName)){
                newRHJobPostings.add(rhJobPosting);
            }
        }
        return newRHJobPostings;
    }
    
    public ArrayList<RHJobPosting> updateRHJobPosting(RHJobPosting oldRHJobPosting,RHJobPosting updateRHJobPosting){
        Integer ind = rhJobPostingList.indexOf(oldRHJobPosting);
        rhJobPostingList.set(ind, updateRHJobPosting);
        return rhJobPostingList;
    }
}
