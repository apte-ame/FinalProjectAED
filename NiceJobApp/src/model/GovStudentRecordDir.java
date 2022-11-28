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
public class GovStudentRecordDir {
    
    ArrayList<GovStudentRecord> govStudentRecordList;

    public GovStudentRecordDir() {
        govStudentRecordList = new ArrayList<>();
    }
    
    public GovStudentRecord addGovStudentRecord(){
        GovStudentRecord newGovStudentRecord = new GovStudentRecord();
        govStudentRecordList.add(newGovStudentRecord);
        return newGovStudentRecord;
    }
    
    public void deleteGovStudentRecord(GovStudentRecord delGovStudentRecord){
        govStudentRecordList.remove(delGovStudentRecord);
    }
    
    public GovStudentRecord searchGovStudentRecord(GovStudentRecord searchGovStudentRecord){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.equals(searchGovStudentRecord)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public ArrayList<GovStudentRecord> updateGovStudentRecord(GovStudentRecord oldGovStudentRecord,GovStudentRecord updateGovStudentRecord){
        Integer ind = govStudentRecordList.indexOf(oldGovStudentRecord);
        govStudentRecordList.set(ind, updateGovStudentRecord);
        return govStudentRecordList;
    }
    
}
