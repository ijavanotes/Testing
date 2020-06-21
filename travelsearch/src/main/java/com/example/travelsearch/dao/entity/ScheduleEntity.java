package com.example.travelsearch.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "TB_SCHEDULE")
public class ScheduleEntity {
    @GeneratedValue
    @Id
    private Long id;
    @Column(name="DESTINATION")
    private String destination;
    @Column(name="CITY")
    private String city;
    @Column(name="TRAVEL_DATE")
    private LocalDate  travelDate;
    @Column(name="RETURN_DATE")
    private LocalDate returnDate;
    @OneToMany(mappedBy = "busSchedule", cascade = {CascadeType.PERSIST,CascadeType.MERGE})

    private List<BusOperatorEntity> busOperation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<BusOperatorEntity> getBusOperation() {
        return busOperation;
    }

    public void setBusOperation(List<BusOperatorEntity> busOperation) {
        this.busOperation = busOperation;
    }
}
