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
public class RentalAppsDir {
    
    ArrayList<RentalApps> rentalsList;

    public RentalAppsDir() {
        rentalsList = new ArrayList<>();
    }

    public ArrayList<RentalApps> getRentalAppsList() {
        return rentalsList;
    }

    public void setRentalAppsList(ArrayList<RentalApps> rentalsList) {
        this.rentalsList = rentalsList;
    }
    
    public void clearAll(){
        rentalsList.clear();
    }
    
    public RentalApps addRentalApps(){
        RentalApps newRentalApps = new RentalApps();
        rentalsList.add(newRentalApps);
        return newRentalApps;
    }
    
    public void deleteRentalApps(RentalApps delRentalApps){
        rentalsList.remove(delRentalApps);
    }
    
    public RentalApps searchRentalApps(RentalApps searchRentalApps){
        for(RentalApps rentalApps : rentalsList){
            if(rentalApps.equals(searchRentalApps)){
                return rentalApps;
            }
        }
        return null;
    }
    
    public ArrayList<RentalApps> updateRentalApps(RentalApps oldRentalApps,RentalApps updateRentalApps){
        Integer ind = rentalsList.indexOf(oldRentalApps);
        rentalsList.set(ind, updateRentalApps);
        return rentalsList;
    }
    
    public ArrayList<RentalApps> searchByLocation(String location){
        ArrayList<RentalApps> newRentalApps = new ArrayList<RentalApps>();
        for(RentalApps rentalApps : rentalsList){
            if(rentalApps.getLocation().equals(location)){
                newRentalApps.add(rentalApps);
            }
        }
        return newRentalApps;
    }
    
    public ArrayList<RentalApps> searchByStatus(String status){
        ArrayList<RentalApps> newRentalApps = new ArrayList<RentalApps>();
        for(RentalApps rentalApps : rentalsList){
            if(rentalApps.getStatus().equals(status)){
                newRentalApps.add(rentalApps);
            }
        }
        return newRentalApps;
    }
}
