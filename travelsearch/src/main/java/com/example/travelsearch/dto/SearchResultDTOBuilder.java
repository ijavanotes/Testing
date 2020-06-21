package com.example.travelsearch.dto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class SearchResultDTOBuilder {
    private String busNumber;
    private String operatorName;
    private LocalTime departure;
    private LocalTime arrivalTime;
    private Duration duration;
    private BigDecimal price;

    public SearchResultDTOBuilder setBusNumber(String busNumber) {
        this.busNumber = busNumber;
        return this;
    }

    public SearchResultDTOBuilder setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public SearchResultDTOBuilder setDeparture(LocalTime departure) {
        this.departure = departure;
        return this;
    }

    public SearchResultDTOBuilder setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public SearchResultDTOBuilder setDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public SearchResultDTOBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public SearchResultDTO build() {
        return new SearchResultDTO(busNumber, operatorName, departure, arrivalTime, duration, price);
    }
}