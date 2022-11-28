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
public class RHJobPosting {
    
    private Integer id;
    private String postName;
    private CompDepartment companyDepartment;
    private LocalDate postingValidFrom;
    private LocalDate postingValidTill;
    private String description;
    private String salaryRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public CompDepartment getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(CompDepartment companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public LocalDate getPostingValidFrom() {
        return postingValidFrom;
    }

    public void setPostingValidFrom(LocalDate postingValidFrom) {
        this.postingValidFrom = postingValidFrom;
    }

    public LocalDate getPostingValidTill() {
        return postingValidTill;
    }

    public void setPostingValidTill(LocalDate postingValidTill) {
        this.postingValidTill = postingValidTill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
   
}
