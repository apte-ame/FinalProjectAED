/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
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
    
    public GovStudentRecord searchById(Integer id){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getId().equals(id)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByStudent(UniStudent student){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getStudent().equals(student)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByI20Status(Boolean i20Status){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getI20Status().equals(i20Status)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByVisaIssued(String visaIssued){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getVisaIssued().equals(visaIssued)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByVisaValidTill(LocalDate visaValidTill){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getVisaValidTill().equals(visaValidTill)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByVisaValidFrom(LocalDate visaValidFrom){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getVisaValidFrom().equals(visaValidFrom)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByPassportCountry(String passportCountry){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getPassportCountry().equals(passportCountry)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByPassportNumber(Long passportNumber){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getPassportNumber().equals(passportNumber)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByPassportValidFrom(LocalDate passportValidFrom){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getPassportValidFrom().equals(passportValidFrom)){
                return govStudentRecord;
            }
        }
        return null;
    }
    
    public GovStudentRecord searchByPassportValidTill(LocalDate passportValidTill){
        for(GovStudentRecord govStudentRecord : govStudentRecordList){
            if(govStudentRecord.getPassportValidTill().equals(passportValidTill)){
                return govStudentRecord;
            }
        }
        return null;
    }
}
