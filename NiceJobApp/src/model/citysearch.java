/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author naini
 */
public class citysearch {
    private String Company;
    private String City;

    public String getProperty() {
        return Property;
    }

    public void setProperty(String Property) {
        this.Property = Property;
    }
    private String Property;
    private String HRname;
    private String Avail_Date;
    private String Rate;
    private String Address;
    private Icon photo;

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getHRname() {
        return HRname;
    }

    public void setHRname(String HRname) {
        this.HRname = HRname;
    }

    public String getAvail_Date() {
        return Avail_Date;
    }

    public void setAvail_Date(String Avail_Date) {
        this.Avail_Date = Avail_Date;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Icon getPhoto() {
        return photo;
    }

    public void setPhoto(Icon photo) {
        this.photo = photo;
    }
   
     @Override
    public String toString(){
        return Company;
    }
}
