package com.example.travelsearch.dao.entity;

import com.sun.javafx.beans.IDProperty;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

@Entity(name="TB_BUS_OPERATOR")
public class BusOperatorEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BUS_NUMBER")
    private String busNumber;

    @Column(name = "DEPARTURE")
    private LocalTime departure;
    @Column(name = "ARRIVAL_TIME")
    private LocalTime arrivalTime;
    @Column(name = "DURATION")
    private Duration duration;
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId
    private ScheduleEntity busSchedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ScheduleEntity getBusSchedule() {
        return busSchedule;
    }

    public void setBusSchedule(ScheduleEntity busSchedule) {
        this.busSchedule = busSchedule;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }
}
