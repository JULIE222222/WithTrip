package com.withtrip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.withtrip.domain.TripPlanDTO;

@Mapper
public interface TripPlanMapper {

	// 여행계획 저장
	int saveTripPlan(TripPlanDTO tripPlanDTO);

	// 모든 여행계획 조회
    List<TripPlanDTO> getAllTripPlans();

	// 여행계획 조회
	TripPlanDTO getTripPlan(long planId);
}
