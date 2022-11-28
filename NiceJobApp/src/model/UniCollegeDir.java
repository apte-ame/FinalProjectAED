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
public class UniCollegeDir {
    
    ArrayList<UniCollege> uniCollegeList;

    public UniCollegeDir() {
        uniCollegeList = new ArrayList<>();
    }
    
    public UniCollege addUniCollege(){
        UniCollege newUniCollege = new UniCollege();
        uniCollegeList.add(newUniCollege);
        return newUniCollege;
    }
    
    public void deleteUniCollege(UniCollege delUniCollege){
        uniCollegeList.remove(delUniCollege);
    }
    
    public UniCollege searchUniCollege(UniCollege searchUniCollege){
        for(UniCollege uniCollege : uniCollegeList){
            if(uniCollege.equals(searchUniCollege)){
                return uniCollege;
            }
        }
        return null;
    }
    
    public ArrayList<UniCollege> updateUniCollege(UniCollege oldUniCollege,UniCollege updateUniCollege){
        Integer ind = uniCollegeList.indexOf(oldUniCollege);
        uniCollegeList.set(ind, updateUniCollege);
        return uniCollegeList;
    }
    
    public UniCollege searchById(Integer id){
        for(UniCollege uniCollege : uniCollegeList){
            if(uniCollege.getId().equals(id)){
                return uniCollege;
            }
        }
        return null;
    }
    
    public UniCollege searchByName(String name){
        for(UniCollege uniCollege : uniCollegeList){
            if(uniCollege.getName().equals(name)){
                return uniCollege;
            }
        }
        return null;
    }
    
    public UniCollege searchByUniversity(University university){
        for(UniCollege uniCollege : uniCollegeList){
            if(uniCollege.getUniversity().equals(university)){
                return uniCollege;
            }
        }
        return null;
    }
}
