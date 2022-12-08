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
public class AcceptedJobs {
    private Integer jobListingsId;
    private String sevisId;
    private Integer companyId;
    private String companyName;
    private LocalDate expectedGradDate;
    private LocalDate startDate;
    private String position;
    private Double salary;
    private String course;
    private String jobTitle;
    private String govStatus;
    private String govComments;
    private String nationality;
    private String level;
    private String role;
    private String studentName;
    private String university;
    private String govIssues;
    private String govName;
    private String location;

    public String getGovName() {
        return govName;
    }

    public void setGovName(String govName) {
        this.govName = govName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    

    public String getGovIssues() {
        return govIssues;
    }

    public void setGovIssues(String govIssues) {
        this.govIssues = govIssues;
    }
    
    

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
    
    

    public Integer getJobListingsId() {
        return jobListingsId;
    }

    public void setJobListingsId(Integer jobListingsId) {
        this.jobListingsId = jobListingsId;
    }

    public String getSevisId() {
        return sevisId;
    }

    public void setSevisId(String sevisId) {
        this.sevisId = sevisId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getExpectedGradDate() {
        return expectedGradDate;
    }

    public void setExpectedGradDate(LocalDate expectedGradDate) {
        this.expectedGradDate = expectedGradDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGovStatus() {
        return govStatus;
    }

    public void setGovStatus(String govStatus) {
        this.govStatus = govStatus;
    }

    public String getGovComments() {
        return govComments;
    }

    public void setGovComments(String govComments) {
        this.govComments = govComments;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return sevisId.toString();
    }
    
    
}
