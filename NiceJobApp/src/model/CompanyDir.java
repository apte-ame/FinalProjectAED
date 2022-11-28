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
public class CompanyDir {
    
    ArrayList<Company> companyList;

    public CompanyDir() {
        companyList = new ArrayList<>();
    }
    
    public Company addCompany(){
        Company newCompany = new Company();
        companyList.add(newCompany);
        return newCompany;
    }
    
    public void deleteCompany(Company delCompany){
        companyList.remove(delCompany);
    }
    
    public Company searchCompany(Company searchCompany){
        for(Company company : companyList){
            if(company.equals(searchCompany)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchById(Integer id){
        for(Company company : companyList){
            if(company.getId().equals(id)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchByName(String name){
        for(Company company : companyList){
            if(company.getName().equals(name)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchByDistrict(String district){
        for(Company company : companyList){
            if(company.getDistrict().equals(district)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchByState(String state){
        for(Company company : companyList){
            if(company.getState().equals(state)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchByCountry(String country){
        for(Company company : companyList){
            if(company.getCountry().equals(country)){
                return company;
            }
        }
        return null;
    }
    
    public Company searchByPincode(String pincode){
        for(Company company : companyList){
            if(company.getPincode().equals(pincode)){
                return company;
            }
        }
        return null;
    }
    
    public ArrayList<Company> updateCompany(Company oldCompany,Company updateCompany){
        Integer ind = companyList.indexOf(oldCompany);
        companyList.set(ind, updateCompany);
        return companyList;
    }
    
}
