package com.example.travelsearch.dao.repository;

import com.example.travelsearch.dao.entity.ScheduleEntity;
import com.example.travelsearch.dto.SearchDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BuSearchSpecifications implements Specification<ScheduleEntity> {
    private final SearchDTO searchDTO;
    public BuSearchSpecifications(SearchDTO searchDTO) {
        this.searchDTO= searchDTO;
    }

    @Override
    public Predicate toPredicate(Root<ScheduleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicateList= new ArrayList<>();
        if (!StringUtils.isEmpty(searchDTO.getCity())){
            predicateList.add(criteriaBuilder.equal(root.get("city"), searchDTO.getCity()));
        }
        if (!StringUtils.isEmpty(searchDTO.getDestination())){
            predicateList.add(criteriaBuilder.equal(root.get("destination"), searchDTO.getDestination()));
        }
        if (!StringUtils.isEmpty(searchDTO.getDestination())){
            predicateList.add(criteriaBuilder.equal(root.get("destination"), searchDTO.getDestination()));
        }

        if (!StringUtils.isEmpty(searchDTO.getTravelDate())){
            predicateList.add(criteriaBuilder.equal(root.get("travelDate"), searchDTO.getTravelDate()));
        }
        if (!StringUtils.isEmpty(searchDTO.getReturnDate())){
            predicateList.add(criteriaBuilder.equal(root.get("returnDate"), searchDTO.getTravelDate()));
        }
        return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
    }
}
