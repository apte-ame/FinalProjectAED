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
    
    public ArrayList<Company> updateCompany(Company oldCompany,Company updateCompany){
        Integer ind = companyList.indexOf(oldCompany);
        companyList.set(ind, updateCompany);
        return companyList;
    }
    
}
