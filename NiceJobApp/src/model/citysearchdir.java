/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author naini
 */
public class citysearchdir {
    
     public ArrayList<citysearch> citysearchitems;
    
         public  ArrayList<citysearch> searchByField(String searchField, String searchFieldFlag) {
       ArrayList<citysearch> CitySearchTemp = new ArrayList<citysearch>();
       
       switch(searchFieldFlag){
           case "Company":
               for (citysearch p : citysearchitems){
               if(p.getCompany().equals(searchField)){
                   CitySearchTemp.add(p);
                          }
                    }
             break;
            
                         
                case "Property":
               for (citysearch p : citysearchitems){
               if(p.getProperty().equals(searchField)){
                    CitySearchTemp.add(p);
                           }
                    }
               break;
               
                 case "Rate":
               for (citysearch p : citysearchitems){
               if(p.getRate().equals(searchField)){
                   CitySearchTemp.add(p);
                           }
                    }
               break;
               
                case "Avail_Date":
               for (citysearch p : citysearchitems){
               if(p.getRate().equals(searchField)){
                   CitySearchTemp.add(p);
                           }
                    }
                break;
                              
                             
       }
     
       return CitySearchTemp;
      }
 
    public citysearchdir(){
    this.citysearchitems = new ArrayList<citysearch>();
    }

    public ArrayList<citysearch> getItem() {
        return citysearchitems;
    }
 
    public void setItem(ArrayList<citysearch> history) { 
        this.citysearchitems = history;
    }

    public void setName(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  public citysearch addItem(){
  
  citysearch newProduct = new citysearch();
  citysearchitems.add(newProduct);
  return newProduct;
  
          }  

  public void  deleteItem(citysearch p){
 citysearchitems.remove(p);
  }
  
}
