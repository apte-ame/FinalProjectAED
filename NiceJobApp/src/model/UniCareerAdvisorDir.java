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
}
