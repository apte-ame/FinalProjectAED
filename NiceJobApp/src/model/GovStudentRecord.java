/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class GovStudentRecord {
    
    private Integer id;
    private UniStudent student;
    private Boolean i20Status;
    private String visaIssued;
    private LocalDate visaValidFrom;
    private LocalDate visaValidTill;
    private String passportCountry;
    private Long passportNumber;
    private LocalDate passportValidFrom;
    private LocalDate passportValidTill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UniStudent getStudent() {
        return student;
    }

    public void setStudent(UniStudent student) {
        this.student = student;
    }

    public Boolean getI20Status() {
        return i20Status;
    }

    public void setI20Status(Boolean i20Status) {
        this.i20Status = i20Status;
    }

    public String getVisaIssued() {
        return visaIssued;
    }

    public void setVisaIssued(String visaIssued) {
        this.visaIssued = visaIssued;
    }

    public LocalDate getVisaValidFrom() {
        return visaValidFrom;
    }

    public void setVisaValidFrom(LocalDate visaValidFrom) {
        this.visaValidFrom = visaValidFrom;
    }

    public LocalDate getVisaValidTill() {
        return visaValidTill;
    }

    public void setVisaValidTill(LocalDate visaValidTill) {
        this.visaValidTill = visaValidTill;
    }

    public String getPassportCountry() {
        return passportCountry;
    }

    public void setPassportCountry(String passportCountry) {
        this.passportCountry = passportCountry;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportValidFrom() {
        return passportValidFrom;
    }

    public void setPassportValidFrom(LocalDate passportValidFrom) {
        this.passportValidFrom = passportValidFrom;
    }

    public LocalDate getPassportValidTill() {
        return passportValidTill;
    }

    public void setPassportValidTill(LocalDate passportValidTill) {
        this.passportValidTill = passportValidTill;
    }
    
    
    
}
