package com.withtrip.mapper;

import ch.qos.logback.core.model.Model;
import com.withtrip.domain.TripPlanDTO;
import com.withtrip.service.TripPlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TripPlanMapperTest {

    @Autowired
    private TripPlanMapper tripPlanMapper;

    @Test
    public void testOfInsert(){
        TripPlanDTO params = new TripPlanDTO();
        params.setPlanTitle("여수밤바다~");
        params.setDestination("여수");

        // 날짜 설정 (LocalDate 사용)
        params.setStartDate(LocalDate.of(2024, 11, 24)); // yyyy, mm, dd 형식으로
        params.setEndDate(LocalDate.of(2024, 11, 26));

        // TripPlanMapper를 사용하여 데이터베이스에 삽입
       Long result = tripPlanMapper.saveTripPlan(params); // 실제 메서드 호출

        // 결과 확인 (예: 성공적으로 1개의 레코드가 삽입되었는지 확인)
        assertEquals(1, result, "레코드 삽입에 실패했습니다.");
    }



}