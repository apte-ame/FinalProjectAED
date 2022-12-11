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
public class UniExamCellDir {
    
    ArrayList<UniExamCell> uniExamCells;

    public ArrayList<UniExamCell> getUniExamCells() {
        return uniExamCells;
    }

    public void setUniExamCells(ArrayList<UniExamCell> uniExamCells) {
        this.uniExamCells = uniExamCells;
    }

   public void clearAll(){
       uniExamCells.clear();
   }
    
    public UniExamCellDir() {
        uniExamCells = new ArrayList<>();
    }
    
    public UniExamCell addUniExamCell(){
        UniExamCell newUniExamCell = new UniExamCell();
        uniExamCells.add(newUniExamCell);
        return newUniExamCell;
    }
    
    public void deleteUniExamCell(UniExamCell delUniExamCell){
        uniExamCells.remove(delUniExamCell);
    }
    
    public UniExamCell searchUniExamCell(UniExamCell searchUniExamCell){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.equals(searchUniExamCell)){
                return uniExamCell;
            }
        }
        return null;
    }
    
    public ArrayList<UniExamCell> updateUniExamCell(UniExamCell oldUniExamCell,UniExamCell updateUniExamCell){
        Integer ind = uniExamCells.indexOf(oldUniExamCell);
        uniExamCells.set(ind, updateUniExamCell);
        return uniExamCells;
    }
    
    public UniExamCell searchById(Integer id){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getId().equals(id)){
                return uniExamCell;
            }
        }
        return null;
    }
    
    public UniExamCell searchByName(String name){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getName().equals(name)){
                return uniExamCell;
            }
        }
        return null;
    }
    public UniExamCell searchByUniversityId(Integer uniId){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getUniversityId().equals(uniId)){
                return uniExamCell;
            }
        }
        return null;
    }
    
    public UniExamCell searchByUsername(String username){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getUsername().equals(username)){
                return uniExamCell;
            }
        }
        return null;
    }
    
    public UniExamCell searchByPassword(String password){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getPassword().equals(password)){
                return uniExamCell;
            }
        }
        return null;
    }
    
    public UniExamCell searchByEmail(String email){
        for(UniExamCell uniExamCell : uniExamCells){
            if(uniExamCell.getEmail().equals(email)){
                return uniExamCell;
            }
        }
        return null;
    }
}
