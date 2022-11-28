/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
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
    
    public RHSchedule searchById(Integer id){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getId().equals(id)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public RHSchedule searchByStudent(UniStudent student){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getStudent().equals(student)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public RHSchedule searchByRecruitingTeam(CompRecruitingTeam recruitingTeam){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getRecruitingTeam().equals(recruitingTeam)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public RHSchedule searchByJobPosting(RHJobPosting jobPosting){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getJobPosting().equals(jobPosting)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public RHSchedule searchByDate(LocalDate date){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getDate().equals(date)){
                return rhSchedule;
            }
        }
        return null;
    }
    
    public RHSchedule searchByTime(LocalTime time){
        for(RHSchedule rhSchedule : rhScheduleList){
            if(rhSchedule.getTime().equals(time)){
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
