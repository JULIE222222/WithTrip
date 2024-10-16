package com.withtrip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.withtrip.domain.TripDetailDTO;
import com.withtrip.domain.TripPlanDTO;

@Mapper
public interface TripPlanMapper {
	
	// 여행계획 저장
	int insertTripPlan(TripPlanDTO tripPlan);
	
	// 세부계획 저장
	int insertTripDetail(TripDetailDTO tripDetail);
	
	// 모든 여행계획 조회
	List<TripPlanDTO> getAllTripPlans();
	
	// 여행계획 조회
	TripPlanDTO getTripPlan(@Param("plan_id") long plan_id);
	
	// 세부계획 조회
	List<TripDetailDTO> getTripDetail(@Param("plan_id") long plan_id);
	
	// 단일 세부계획 조회
	TripDetailDTO getDetailById(@Param("derail_id") long detail_id);
	

}
