package com.example.travelsearch.dto;

import java.time.LocalDate;

public class SearchDTO {
    private final String destination;
    private final String city;
    private final LocalDate travelDate;
    private final LocalDate returnDate;
    private final String sort;

    public SearchDTO(String destination, String city, LocalDate travelDate, LocalDate returnDate, String sort) {
        this.destination = destination;
        this.city = city;
        this.travelDate = travelDate;
        this.returnDate = returnDate;
        this.sort = sort;
    }

    public String getDestination() {
        return destination;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getSort() {
        return sort;
    }
}
