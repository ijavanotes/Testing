package com.example.travelsearch.dto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class SearchResultDTO {
    private final String busNumber;
    private final String operatorName;
    private final LocalTime departure;
    private final LocalTime arrivalTime;
    private final Duration duration;
    private final BigDecimal price;

    public SearchResultDTO(String busNumber, String operatorName, LocalTime departure, LocalTime arrivalTime, Duration duration, BigDecimal price) {
        this.busNumber = busNumber;
        this.operatorName = operatorName;
        this.departure = departure;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
