/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UniStudentDir {
    
    ArrayList<UniStudent> uniStudentList;

    public UniStudentDir() {
        uniStudentList = new ArrayList<>();
    }

    public ArrayList<UniStudent> getUniStudentList() {
        return uniStudentList;
    }

    public void setUniStudentList(ArrayList<UniStudent> uniStudentList) {
        this.uniStudentList = uniStudentList;
    }
    
    
    
    public UniStudent addUniStudent(){
        UniStudent newUniStudent = new UniStudent();
        uniStudentList.add(newUniStudent);
        return newUniStudent;
    }
    
    public void deleteUniStudent(UniStudent delUniStudent){
        uniStudentList.remove(delUniStudent);
    }
    
    public UniStudent searchUniStudent(UniStudent searchUniStudent){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.equals(searchUniStudent)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public ArrayList<UniStudent> updateUniStudent(UniStudent oldUniStudent,UniStudent updateUniStudent){
        Integer ind = uniStudentList.indexOf(oldUniStudent);
        uniStudentList.set(ind, updateUniStudent);
        return uniStudentList;
    }
    
    public UniStudent searchById(Integer id){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getId().equals(id)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public ArrayList<UniStudent> searchByName(String name){
        ArrayList<UniStudent> resultStudents = new ArrayList<UniStudent>();
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getName().equals(name)){
                resultStudents.add(uniStudent);
            }
        }
        return resultStudents;
    }
    
    public UniStudent searchByAge(Integer age){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getAge().equals(age)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public ArrayList<UniStudent> searchByDepartment(UniDepartment department){
        ArrayList<UniStudent> resultStudents = new ArrayList<UniStudent>();
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getDepartment().equals(department)){
                resultStudents.add(uniStudent);
            }
        }
        return resultStudents;
    }
    
    public UniStudent searchByStartDate(LocalDate startDate){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getStartDate().equals(startDate)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchByEndDate(LocalDate endDate){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getEndDate().equals(endDate)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public ArrayList<UniStudent> searchByCourse(String course){
        ArrayList<UniStudent> resultStudents = new ArrayList<UniStudent>();
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getCourse().equals(course)){
                resultStudents.add(uniStudent);
            }
        }
        return resultStudents;
    }
    
    public ArrayList<UniStudent> searchBySemester(Integer sem){
        ArrayList<UniStudent> resultStudents = new ArrayList<UniStudent>();
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getSemester().equals(sem)){
                resultStudents.add(uniStudent);
            }
        }
        return resultStudents;
    }
    
    public ArrayList<UniStudent> searchByIntake(String intake){
        ArrayList<UniStudent> resultStudents = new ArrayList<UniStudent>();
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getIntake().equals(intake)){
                resultStudents.add(uniStudent);
            }
        }
        return resultStudents;
    }
    
    public UniStudent searchByCareerAdvisor(UniCareerAdvisor careerAdvisor){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getCareerAdvisor().equals(careerAdvisor)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchByEmailId(String emailId){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getEmailId().equals(emailId)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchByContactNo(Long contactNo){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getContactNo().equals(contactNo)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchByWorkEligibilityFlag(Boolean workEligibilityFlag){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getWorkEligibilityFlag().equals(workEligibilityFlag)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchBySevisId(String sevisId){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getSevisId().equals(sevisId)){
                return uniStudent;
            }
        }
        return null;
    }
    
    public UniStudent searchByCountryOfOrigin(String countryOfOrigin){
        for(UniStudent uniStudent : uniStudentList){
            if(uniStudent.getCountryOfOrigin().equals(countryOfOrigin)){
                return uniStudent;
            }
        }
        return null;
    }
    
}
