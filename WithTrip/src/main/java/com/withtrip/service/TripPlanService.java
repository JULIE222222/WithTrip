package com.withtrip.service;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.mapper.TripPlanMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TripPlanService {

    private final TripPlanMapper tripPlanMapper;
    // 여행계획 저장
    public void saveTripPlan(TripPlanDTO tripPlanDTO){
        tripPlanMapper.saveTripPlan(tripPlanDTO);
    }
    // 모든 여행계획 조회
    public List<TripPlanDTO> getAllTripPlans(){
     return tripPlanMapper.getAllTripPlans(); //매퍼 메소드 호출
    }
    // 여행계획 조회
    TripPlanDTO getTripPlan(long planId){
        return tripPlanMapper.getTripPlan(planId); //매퍼 메소드 호출
    }
}
