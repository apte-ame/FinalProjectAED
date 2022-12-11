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
public class AcceptedJobsDir {
    ArrayList<AcceptedJobs> acceptedJobsList;

    public void setAcceptedJobsList(ArrayList<AcceptedJobs> acceptedJobsList) {
        this.acceptedJobsList = acceptedJobsList;
    }

    public ArrayList<AcceptedJobs> getAcceptedJobsList() {
        return acceptedJobsList;
    }
    
    public AcceptedJobsDir() {
        acceptedJobsList = new ArrayList<>();
    }
    
    public AcceptedJobs addAcceptedJobs(){
        AcceptedJobs newAcceptedJobs = new AcceptedJobs();
        acceptedJobsList.add(newAcceptedJobs);
        return newAcceptedJobs;
    }
    
    public void deleteAcceptedJobs(AcceptedJobs delAcceptedJobs){
        acceptedJobsList.remove(delAcceptedJobs);
    }
    
    public void removeAllAcceptedJobs(){
        acceptedJobsList.clear();
    }
    
    public ArrayList<AcceptedJobs> updateAcceptedJobs(AcceptedJobs oldAcceptedJobs,AcceptedJobs updateAcceptedJobs){
        Integer ind = acceptedJobsList.indexOf(oldAcceptedJobs);
        acceptedJobsList.set(ind, updateAcceptedJobs);
        return acceptedJobsList;
    }
    
    public ArrayList<AcceptedJobs> searchBySalary(Double salary){
        ArrayList<AcceptedJobs> newAcceptedJobs = new ArrayList<AcceptedJobs>();
        for(AcceptedJobs acceptedJobs : acceptedJobsList){
            if(acceptedJobs.getSalary().equals(salary)){
                newAcceptedJobs.add(acceptedJobs);
            }
        }
        return newAcceptedJobs;
    }
    
    public ArrayList<AcceptedJobs> searchByPosition(String position){
        ArrayList<AcceptedJobs> newAcceptedJobs = new ArrayList<AcceptedJobs>();
        for(AcceptedJobs acceptedJobs : acceptedJobsList){
            if(acceptedJobs.getPosition().equals(position)){
                newAcceptedJobs.add(acceptedJobs);
            }
        }
        return newAcceptedJobs;
    }
    
    public ArrayList<AcceptedJobs> searchByRole(String role){
        ArrayList<AcceptedJobs> newAcceptedJobs = new ArrayList<AcceptedJobs>();
        for(AcceptedJobs acceptedJobs : acceptedJobsList){
            if(acceptedJobs.getRole().equals(role)){
                newAcceptedJobs.add(acceptedJobs);
            }
        }
        return newAcceptedJobs;
    }
    
    public ArrayList<AcceptedJobs> searchByLevel(String level){
        ArrayList<AcceptedJobs> newAcceptedJobs = new ArrayList<AcceptedJobs>();
        for(AcceptedJobs acceptedJobs : acceptedJobsList){
            if(acceptedJobs.getLevel().equals(level)){
                newAcceptedJobs.add(acceptedJobs);
            }
        }
        return newAcceptedJobs;
    }
    
    public ArrayList<AcceptedJobs> searchByCompanyId(Integer compId){
        ArrayList<AcceptedJobs> newAcceptedJobs = new ArrayList<AcceptedJobs>();
        for(AcceptedJobs acceptedJobs : acceptedJobsList){
            if(acceptedJobs.getCompanyId().equals(compId)){
                newAcceptedJobs.add(acceptedJobs);
            }
        }
        return newAcceptedJobs;
    }
    
}
