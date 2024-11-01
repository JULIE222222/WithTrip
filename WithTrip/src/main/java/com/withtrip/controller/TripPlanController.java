package com.withtrip.controller;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class TripPlanController {

        private final TripPlanService tripPlanService;

        @PostMapping("/tripplan")
        public String saveTripPlan(@ModelAttribute TripPlanDTO tripPlanDTO) {
                // 현재 날짜로 생성/수정 날짜 설정
                tripPlanDTO.setPlanCreated(LocalDate.now());
                tripPlanDTO.setPlanUpdate(LocalDate.now());
                // 서비스 계층을 통해 데이터 저장
                tripPlanService.saveTripPlan(tripPlanDTO);
                // 저장 후 상세 페이지로 리다이렉트
                return "redirect:/tripdetail";
        }

        // tripdetail 페이지로 이동
        @GetMapping("/tripdetail")
        public String tripDetail() {
                return "tripdetail"; // 상세 페이지 반환
        }

}
