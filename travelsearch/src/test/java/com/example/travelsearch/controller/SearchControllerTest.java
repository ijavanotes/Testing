package com.example.travelsearch.controller;

import com.example.travelsearch.exception.SystemErrorException;
import com.example.travelsearch.TravelsearchApplication;
import com.example.travelsearch.dto.ResponseDTO;
import com.example.travelsearch.dto.SearchDTO;
import com.example.travelsearch.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = TravelsearchApplication.class)
@AutoConfigureMockMvc
class SearchControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private IService<SearchDTO, ResponseDTO> searchService;
    private static final ObjectMapper mapper = new ObjectMapper();
    @BeforeEach
    public void init() {
        ResponseDTO productResponse = new ResponseDTO();
        SearchDTO searchDTO = new SearchDTO("TMP", "CHNGI", LocalDate.now(), LocalDate.now(), "operatorName");
        when(searchService.execute(any(SearchDTO.class))).thenReturn(productResponse);
    }
    @Test
    public void test_search_return_ok() throws Exception {
        mvc.perform(get("/search?city=TMP&destination=CHNG&travelDate=01-05-2020&sort=departure")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()));

    }
    @Test
    public void test_search_return_failure() throws Exception {
        when(searchService.execute(any(SearchDTO.class))).thenThrow(new SystemErrorException());
        mvc.perform(get("/search?city=TMP&destination=CHNG&travelDate=01-05-2020&sort=departure")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));

    }

}