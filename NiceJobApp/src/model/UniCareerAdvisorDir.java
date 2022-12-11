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
public class UniCareerAdvisorDir {
    
    ArrayList<UniCareerAdvisor> uniCareerAdvisorList;

    public UniCareerAdvisorDir() {
        uniCareerAdvisorList = new ArrayList<>();
    }

    public ArrayList<UniCareerAdvisor> getUniCareerAdvisorList() {
        return uniCareerAdvisorList;
    }

    public void setUniCareerAdvisorList(ArrayList<UniCareerAdvisor> uniCareerAdvisorList) {
        this.uniCareerAdvisorList = uniCareerAdvisorList;
    }
    
    public void clearAll(){
        uniCareerAdvisorList.clear();
    }
    
    public UniCareerAdvisor addUniCareerAdvisor(){
        UniCareerAdvisor newUniCareerAdvisor = new UniCareerAdvisor();
        uniCareerAdvisorList.add(newUniCareerAdvisor);
        return newUniCareerAdvisor;
    }
    
    public void deleteUniCareerAdvisor(UniCareerAdvisor delUniCareerAdvisor){
        uniCareerAdvisorList.remove(delUniCareerAdvisor);
    }
    
    public UniCareerAdvisor searchUniCareerAdvisor(UniCareerAdvisor searchUniCareerAdvisor){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.equals(searchUniCareerAdvisor)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
    public ArrayList<UniCareerAdvisor> updateUniCareerAdvisor(UniCareerAdvisor oldUniCareerAdvisor,UniCareerAdvisor updateUniCareerAdvisor){
        Integer ind = uniCareerAdvisorList.indexOf(oldUniCareerAdvisor);
        uniCareerAdvisorList.set(ind, updateUniCareerAdvisor);
        return uniCareerAdvisorList;
    }
    
    public UniCareerAdvisor searchById(Integer id){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.getId().equals(id)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
    public UniCareerAdvisor searchByName(String name){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.getName().equals(name)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
    public UniCareerAdvisor searchByUsername(String username){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.getUsername().equals(username)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
    public UniCareerAdvisor searchByDepartment(UniDepartment department){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.getDepartment().equals(department)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
    public UniCareerAdvisor searchByUniversityId(Integer uniId){
        for(UniCareerAdvisor uniCareerAdvisor : uniCareerAdvisorList){
            if(uniCareerAdvisor.getUniversityId().equals(uniId)){
                return uniCareerAdvisor;
            }
        }
        return null;
    }
    
}
