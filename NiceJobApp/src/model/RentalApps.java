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
public class RentalApps {
        private Integer id;
        private String title;
        private String description;
        private Integer rent;
        private String availability;
        private Double latitude;
        private Double longitude;
        private String location;
        private String status;
        private String nameOfLeasee;
        private String comments;
        private Integer leaseeId;
        private Integer ngoRentalId;
        private LocalDate startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameOfLeasee() {
        return nameOfLeasee;
    }

    public void setNameOfLeasee(String nameOfLeasee) {
        this.nameOfLeasee = nameOfLeasee;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getLeaseeId() {
        return leaseeId;
    }

    public void setLeaseeId(Integer leaseeId) {
        this.leaseeId = leaseeId;
    }

    public Integer getNgoRentalId() {
        return ngoRentalId;
    }

    public void setNgoRentalId(Integer ngoRentalId) {
        this.ngoRentalId = ngoRentalId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return id.toString();
    }

        
}

