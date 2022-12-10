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
public class CompDepartmentDir {
    
    ArrayList<CompDepartment> compDepartmentList;

    public ArrayList<CompDepartment> getCompDepartmentList() {
        return compDepartmentList;
    }

    public void setCompDepartmentList(ArrayList<CompDepartment> compDepartmentList) {
        this.compDepartmentList = compDepartmentList;
    }

    public CompDepartmentDir() {
        compDepartmentList = new ArrayList<>();
    }
    
    public CompDepartment addCompDepartment(){
        CompDepartment newCompDepartment = new CompDepartment();
        compDepartmentList.add(newCompDepartment);
        return newCompDepartment;
    }
    
    public void addCompDepartmentFromAnother(CompDepartment addCompDepartment){
        compDepartmentList.add(addCompDepartment);
    }
    
    public void deleteCompDepartment(CompDepartment delCompDepartment){
        compDepartmentList.remove(delCompDepartment);
    }
    
    public CompDepartment searchCompDepartment(CompDepartment searchCompDepartment){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.equals(searchCompDepartment)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public CompDepartment searchByDepartmentId(Integer departmentId){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getDepartmentId().equals(departmentId)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public CompDepartment searchByDepartmentName(String departmentName){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getDepartmentName().equals(departmentName)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public CompDepartment searchByJobId(Integer jobId){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getJobId().equals(jobId)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public ArrayList<CompDepartment> searchByRole(String role){
        ArrayList<CompDepartment> newCompDept = new ArrayList<CompDepartment>();
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getRole().equals(role)){
                newCompDept.add(compDepartment);
            }
        }
        return newCompDept;
    }
    
    public ArrayList<CompDepartment> searchBySalary(Double salary){
        ArrayList<CompDepartment> newCompDept = new ArrayList<CompDepartment>();
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getSalaryPerHr().equals(salary)){
                newCompDept.add(compDepartment);
            }
        }
        return newCompDept;
    }
    
    public ArrayList<CompDepartment> searchByPosition(String position){
        ArrayList<CompDepartment> newCompDept = new ArrayList<CompDepartment>();
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getPosition().equals(position)){
                newCompDept.add(compDepartment);
            }
        }
        return newCompDept;
    }
    
    public void removeAllCompDepartment(){
        compDepartmentList.clear();
    }
    
    public ArrayList<CompDepartment> searchByLevel(String level){
        ArrayList<CompDepartment> newCompDept = new ArrayList<CompDepartment>();
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getLevel().equals(level)){
                newCompDept.add(compDepartment);
            }
        }
        return newCompDept;
    }

    
    public ArrayList<CompDepartment> searchByJobDesc(String jobDesc){
        ArrayList<CompDepartment> newCompDept = new ArrayList<CompDepartment>();
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getJobDescription().contains(jobDesc)){
                newCompDept.add(compDepartment);
            }
        }
        return newCompDept;
    }
    
    public CompDepartment searchByCompany(Company company){
        for(CompDepartment compDepartment : compDepartmentList){
            if(compDepartment.getCompany().equals(company)){
                return compDepartment;
            }
        }
        return null;
    }
    
    public ArrayList<CompDepartment> updateCompDepartment(CompDepartment oldCompDepartment,CompDepartment updateCompDepartment){
        Integer ind = compDepartmentList.indexOf(oldCompDepartment);
        compDepartmentList.set(ind, updateCompDepartment);
        return compDepartmentList;
    }
    
    public ArrayList<CompDepartment> deleteAllNonAccepted(JobAppointmentsDir jobApps){
        ArrayList<CompDepartment> newList = new ArrayList<CompDepartment>();
        for(CompDepartment dept : compDepartmentList){
            if(jobApps.searchByJobListingId(dept.getJobId()).get(0).getStatus().equalsIgnoreCase("Accepted")){
                newList.add(dept);
            }
        }
        compDepartmentList = newList;
        return compDepartmentList;
    }
}
