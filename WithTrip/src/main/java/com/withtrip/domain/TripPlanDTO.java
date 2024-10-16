package com.withtrip.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripPlanDTO {
	
	private Long plan_id;
	private String user_email;
	private String user_name;
	private String user_pwd;
	private LocalDate start_date;
	private LocalDate end_date;
	private LocalDate plan_created;
	private LocalDate plan_update;

}
