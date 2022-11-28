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
public class UniStudent {
    
    private Integer id;
    private String name;
    private Integer age;
    private UniDepartment department;
    private LocalDate startDate;
    private LocalDate endDate;
    private String course;
    private UniCareerAdvisor careerAdvisor;
    private String emailId;
    private Long contactNo;
    private Boolean workEligibilityFlag;
    private Integer studentGovId;
    private String countryOfOrigin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UniDepartment getDepartment() {
        return department;
    }

    public void setDepartment(UniDepartment department) {
        this.department = department;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public UniCareerAdvisor getCareerAdvisor() {
        return careerAdvisor;
    }

    public void setCareerAdvisor(UniCareerAdvisor careerAdvisor) {
        this.careerAdvisor = careerAdvisor;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Boolean getWorkEligibilityFlag() {
        return workEligibilityFlag;
    }

    public void setWorkEligibilityFlag(Boolean workEligibilityFlag) {
        this.workEligibilityFlag = workEligibilityFlag;
    }

    public Integer getStudentGovId() {
        return studentGovId;
    }

    public void setStudentGovId(Integer studentGovId) {
        this.studentGovId = studentGovId;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    
    
    
}
