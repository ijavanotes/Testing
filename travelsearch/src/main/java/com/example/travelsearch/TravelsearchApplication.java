package com.example.travelsearch;

import com.example.travelsearch.dao.entity.BusOperatorEntity;
import com.example.travelsearch.dao.entity.ScheduleEntity;
import com.example.travelsearch.dao.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TravelsearchApplication {
	@Autowired
	private BusScheduleRepository busScheduleRepository;

	public static void main(String[] args) {
		SpringApplication.run(TravelsearchApplication.class, args);
	}
	@PostConstruct
	public void setupData(){
		ScheduleEntity scheduleEntity = new ScheduleEntity();
		scheduleEntity.setCity("TMP");
		scheduleEntity.setDestination("CHNG");
		scheduleEntity.setTravelDate(LocalDate.of(2020,05,01));
		scheduleEntity.setReturnDate(LocalDate.of(2020,05,03));
		List<BusOperatorEntity> busOperatorEntityList = new ArrayList<>();
		BusOperatorEntity busOperatorEntity = new BusOperatorEntity();
		busOperatorEntity.setArrivalTime(LocalTime.of(11, 12));
		busOperatorEntity.setBusNumber("001");
		busOperatorEntity.setPrice(BigDecimal.valueOf(120));
		busOperatorEntity.setName("Changi");
		busOperatorEntity.setDeparture(LocalTime.of(10,02));
		busOperatorEntity.setDuration(Duration.ofDays(2));
		busOperatorEntityList.add(busOperatorEntity);
		scheduleEntity.setBusOperation(busOperatorEntityList);
		busOperatorEntity.setBusSchedule(scheduleEntity);
		busScheduleRepository.save(scheduleEntity);

	}



}
