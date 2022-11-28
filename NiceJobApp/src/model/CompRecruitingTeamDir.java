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
public class CompRecruitingTeamDir {
    
    ArrayList<CompRecruitingTeam> compRecruitingTeamList;

    public CompRecruitingTeamDir() {
        compRecruitingTeamList = new ArrayList<>();
    }
    
    public CompRecruitingTeam addCompRecruitingTeam(){
        CompRecruitingTeam newCompRecruitingTeam = new CompRecruitingTeam();
        compRecruitingTeamList.add(newCompRecruitingTeam);
        return newCompRecruitingTeam;
    }
    
    public void deleteCompRecruitingTeam(CompRecruitingTeam delCompRecruitingTeam){
        compRecruitingTeamList.remove(delCompRecruitingTeam);
    }
    
    public CompRecruitingTeam searchCompRecruitingTeam(CompRecruitingTeam searchCompRecruitingTeam){
        for(CompRecruitingTeam compRecruitingTeam : compRecruitingTeamList){
            if(compRecruitingTeam.equals(searchCompRecruitingTeam)){
                return compRecruitingTeam;
            }
        }
        return null;
    }
    
    public ArrayList<CompRecruitingTeam> updateCompRecruitingTeam(CompRecruitingTeam oldCompRecruitingTeam,CompRecruitingTeam updateCompRecruitingTeam){
        Integer ind = compRecruitingTeamList.indexOf(oldCompRecruitingTeam);
        compRecruitingTeamList.set(ind, updateCompRecruitingTeam);
        return compRecruitingTeamList;
    }
}
