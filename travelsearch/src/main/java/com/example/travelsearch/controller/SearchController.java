package com.example.travelsearch.controller;

import com.example.travelsearch.dto.ResponseDTO;
import com.example.travelsearch.dto.SearchDTO;
import com.example.travelsearch.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SearchController {
    @Autowired
    private IService<SearchDTO, ResponseDTO> searchService;

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> search(@RequestParam(value = "city", required = true) String city,
                                              @RequestParam(value = "destination", required = true) String destination,
                                              @RequestParam(value = "travelDate", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate travelDate,
                                              @RequestParam(value = "returnDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate returnDate,
                                              @RequestParam(value = "sort", required = false) String sort) {

        SearchDTO searchDTO = new SearchDTO(destination, city, travelDate, returnDate, sort);
        return ResponseEntity.ok(searchService.execute(searchDTO));

    }

}
