package com.withtrip.service;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.mapper.TripPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TripPlanService {

    private final TripPlanMapper tripPlanMapper;
    // 여행계획 저장
    public Long saveTripPlan(TripPlanDTO tripPlanDTO){
        tripPlanMapper.saveTripPlan(tripPlanDTO);
        return tripPlanDTO.getPlanId();
    }
    // 모든 여행계획 조회
    public List<TripPlanDTO> getAllTripPlans(){
     return tripPlanMapper.getAllTripPlans(); //매퍼 메소드 호출
    }

    public TripPlanDTO getTripPlan(Long planId) {
        // TripPlanMapper를 통해 데이터베이스에서 데이터 조회
        return tripPlanMapper.getTripPlan(planId);
    }
}
