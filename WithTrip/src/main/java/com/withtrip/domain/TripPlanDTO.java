package com.withtrip.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class TripPlanDTO {
	
	private Long planId;
	private String planTitle;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate planCreated;
	private LocalDate planUpdate;
	private Long userId;
}
