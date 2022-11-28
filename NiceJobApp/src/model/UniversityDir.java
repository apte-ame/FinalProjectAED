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
public class UniversityDir {
    
    ArrayList<University> universityList;

    public UniversityDir() {
        universityList = new ArrayList<>();
    }
    
    public University addUniversity(){
        University newUniversity = new University();
        universityList.add(newUniversity);
        return newUniversity;
    }
    
    public void deleteUniversity(University delUniversity){
        universityList.remove(delUniversity);
    }
    
    public University searchUniversity(University searchUniversity){
        for(University university : universityList){
            if(university.equals(searchUniversity)){
                return university;
            }
        }
        return null;
    }
    
    public ArrayList<University> updateUniversity(University oldUniversity,University updateUniversity){
        Integer ind = universityList.indexOf(oldUniversity);
        universityList.set(ind, updateUniversity);
        return universityList;
    }
    
    public University searchById(Integer id){
        for(University university : universityList){
            if(university.getId().equals(id)){
                return university;
            }
        }
        return null;
    }
    
    public University searchByName(String name){
        for(University university : universityList){
            if(university.getName().equals(name)){
                return university;
            }
        }
        return null;
    }
    
    public University searchByDistrict(String district){
        for(University university : universityList){
            if(university.getDistrict().equals(district)){
                return university;
            }
        }
        return null;
    }
    
    public University searchByState(String state){
        for(University university : universityList){
            if(university.getState().equals(state)){
                return university;
            }
        }
        return null;
    }
    
    public University searchByCountry(String country){
        for(University university : universityList){
            if(university.getCountry().equals(country)){
                return university;
            }
        }
        return null;
    }
    
    public University searchByPincode(Long pincode){
        for(University university : universityList){
            if(university.getPincode().equals(pincode)){
                return university;
            }
        }
        return null;
    }
}
