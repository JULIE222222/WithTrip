package com.withtrip.mapper;

import com.withtrip.domain.TripDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TripDetailMapper {

    // 세부계획 저장
    int insertTripDetail(TripDetailDTO tripDetail);

    // 세부계획 조회
    List<TripDetailDTO> getTripDetail(@Param("plan_id") long plan_id);

    // 단일 세부계획 조회
    TripDetailDTO getDetailById(@Param("derail_id") long detail_id);

}
