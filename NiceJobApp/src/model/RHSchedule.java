/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author User
 */
public class RHSchedule {
    
    private Integer id;
    private UniStudent student;
    private CompRecruitingTeam recruitingTeam;
    private RHJobPosting jobPosting;
    private LocalDate date;
    private LocalTime time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UniStudent getStudent() {
        return student;
    }

    public void setStudent(UniStudent student) {
        this.student = student;
    }

    public CompRecruitingTeam getRecruitingTeam() {
        return recruitingTeam;
    }

    public void setRecruitingTeam(CompRecruitingTeam recruitingTeam) {
        this.recruitingTeam = recruitingTeam;
    }

    public RHJobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(RHJobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
}
