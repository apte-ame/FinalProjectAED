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
public class RHScheduleDir {
    
    ArrayList<RHSchedule> rhScheduleList;

    public RHScheduleDir() {
        rhScheduleList = new ArrayList<>();
    }
    
    public RHSchedule addRHSchedule(){
        RHSchedule newRHSchedule = new RHSchedule();
        rhScheduleList.add(newRHSchedule);
        return newRHSchedule;
    }
    
    public void deleteRHSchedule(RHSchedule delRHSchedule){
        rhScheduleList.remove(delRHSchedule);
    }
    
    public RHSchedule searchRHSchedule(RHSchedule searchRHSchedule){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.equals(searchRHSchedule)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public ArrayList<RHSchedule> updateRHSchedule(RHSchedule oldRHSchedule,RHSchedule updateRHSchedule){
        Integer ind = rhScheduleList.indexOf(oldRHSchedule);
        rhScheduleList.set(ind, updateRHSchedule);
        return rhScheduleList;
    }
}
