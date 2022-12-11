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
public class NgoRentalsDir {
    
    ArrayList<NgoRentals> ngoRentalsList;

    public NgoRentalsDir(){
        ngoRentalsList = new ArrayList<>();
    }

    public ArrayList<NgoRentals> getCompanyList() {
        return ngoRentalsList;
    }

    public void setNgoRentalsList(ArrayList<NgoRentals> ngoRentalsList) {
        this.ngoRentalsList = ngoRentalsList;
    }
    
    public void clearAll(){
        ngoRentalsList.clear();
    }
    
    public NgoRentals addNgoRentals(){
        NgoRentals newNgoRentals = new NgoRentals();
        ngoRentalsList.add(newNgoRentals);
        return newNgoRentals;
    }
    
    public void deleteNgoRentals(NgoRentals delNgoRentals){
        ngoRentalsList.remove(delNgoRentals);
    }
    
    public NgoRentals searchNgoRentals(NgoRentals searchNgoRentals){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.equals(searchNgoRentals)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchById(Integer id){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getId().equals(id)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchByName(String name){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getName().equals(name)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public ArrayList<NgoRentals> searchByNgoName(String name){
        ArrayList<NgoRentals> newNgo = new ArrayList<>();
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getName().equals(name)){
               newNgo.add(ngoRentals);
            }
        }
        return newNgo;
    }
    
    public NgoRentals searchByUsername(String username){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getUsername().equals(username)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchByDistrict(String district){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getDistrict().equals(district)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchByState(String state){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getState().equals(state)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchByCountry(String country){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getCountry().equals(country)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public NgoRentals searchByPincode(String pincode){
        for(NgoRentals ngoRentals : ngoRentalsList){
            if(ngoRentals.getPincode().equals(pincode)){
                return ngoRentals;
            }
        }
        return null;
    }
    
    public ArrayList<NgoRentals> updateNgoRentals(NgoRentals oldNgoRentals,NgoRentals updateNgoRentals){
        Integer ind = ngoRentalsList.indexOf(oldNgoRentals);
        ngoRentalsList.set(ind, updateNgoRentals);
        return ngoRentalsList;
    }
    
}
