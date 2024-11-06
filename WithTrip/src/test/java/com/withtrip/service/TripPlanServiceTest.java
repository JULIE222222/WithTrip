package com.withtrip.service;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.mapper.TripPlanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class TripPlanServiceTest {

    @Autowired
    private TripPlanMapper tripPlanMapper;

    @Autowired
    private TripPlanService tripPlanService;

    @Test
    public void testOfgetTripPlan() {
        // Arrange: 테스트용 planId 및 예상되는 TripPlanDTO 객체 생성
        Long planId = 1L;
        TripPlanDTO expectedTripPlan = new TripPlanDTO();
        expectedTripPlan.setPlanId(planId);
        // 필요한 다른 속성도 설정

        // When: TripPlanMapper의 getTripPlan 메서드 호출 시 예상 객체 반환 설정
        when(tripPlanMapper.getTripPlan(planId)).thenReturn(expectedTripPlan);

        // Act: TripPlanService의 getTripPlan 메서드를 호출하여 실제 결과 얻기
        TripPlanDTO result = tripPlanService.getTripPlan(planId);

        // Assert: 반환된 결과가 예상한 값과 일치하는지 확인
        assertEquals(expectedTripPlan.getPlanId(), result.getPlanId());
        // 필요한 다른 필드들도 assert로 확인 가능
    }
}
