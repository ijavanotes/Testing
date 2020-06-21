package com.example.travelsearch.dao.repository;

import com.example.travelsearch.dao.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BusScheduleRepository extends JpaRepository<ScheduleEntity, Long> , JpaSpecificationExecutor<ScheduleEntity> {

}
