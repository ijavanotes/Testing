package com.example.travelsearch.service;

import com.example.travelsearch.exception.SystemErrorException;
import com.example.travelsearch.dao.entity.ScheduleEntity;
import com.example.travelsearch.dao.repository.BuSearchSpecifications;
import com.example.travelsearch.dao.repository.BusScheduleRepository;
import com.example.travelsearch.dto.ResponseDTO;
import com.example.travelsearch.dto.SearchDTO;
import com.example.travelsearch.dto.SearchResultDTO;
import com.example.travelsearch.dto.SearchResultDTOBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService implements IService<SearchDTO, ResponseDTO> {
    private final BusScheduleRepository busScheduleRepository;

    public SearchService(BusScheduleRepository busScheduleRepository) {
        this.busScheduleRepository = busScheduleRepository;
    }

    @Override
    public ResponseDTO<List<SearchResultDTO>> execute(SearchDTO request) {
        try {
            BuSearchSpecifications busSearchSpecifications = new BuSearchSpecifications(request);
            Pageable page = PageRequest.of(0, Integer.MAX_VALUE, getSortOrder(request.getSort()));
            Page<ScheduleEntity> searchResult = busScheduleRepository.findAll(busSearchSpecifications, page);
            return convert(searchResult);
        } catch (Exception e) {
            throw new SystemErrorException("Database error please contact admin");
        }

    }

    private ResponseDTO<List<SearchResultDTO>> convert(Page<ScheduleEntity> searchResult) {
        ResponseDTO<List<SearchResultDTO>> responseDTO = new ResponseDTO<>();
        responseDTO.setResultCount(searchResult.getNumberOfElements());
        List<SearchResultDTO> result = searchResult.get().map(scheduleEntity -> scheduleEntity.getBusOperation())
                .flatMap(busOperatorEntity -> busOperatorEntity.stream())
                .map(busOperatorEntity -> {
                    SearchResultDTO searchResultDTO = new SearchResultDTOBuilder()
                            .setArrivalTime(busOperatorEntity.getArrivalTime())
                            .setBusNumber(busOperatorEntity.getBusNumber())
                            .setDuration(busOperatorEntity.getDuration())
                            .setDeparture(busOperatorEntity.getDeparture())
                            .setPrice(busOperatorEntity.getPrice())
                            .setOperatorName(busOperatorEntity.getName())
                            .setBusNumber(busOperatorEntity.getBusNumber()).build();
                    return searchResultDTO;
                })
                .collect(Collectors.toList());
        responseDTO.setResult(result);
        return responseDTO;
    }

    private Sort getSortOrder(String sort) {
        if (StringUtils.isEmpty(sort)) {
            return Sort.by(Sort.Direction.ASC, "busOperation.price");
        }
        if (sort.equals("operatorName")) {
            return Sort.by(Sort.Direction.ASC, "busOperation.name");
        }
        if (sort.equals("departure")) {
            return Sort.by(Sort.Direction.ASC, "busOperation.departure");

        }
        if (sort.equals("arrivalTime")) {
            return Sort.by(Sort.Direction.ASC, "busOperation.arrivalTime");

        }
        if (sort.equals("duration")) {
            return Sort.by(Sort.Direction.ASC, "busOperation.duration");

        }
        return Sort.by(Sort.Direction.ASC, "busOperation.price");


    }
}
