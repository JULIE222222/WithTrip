package com.withtrip.controller;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TripDetailController {

    private final TripPlanService tripPlanService;


    @GetMapping("/tripdetail")
    public String getTripDetail(@RequestParam("planId") Long planId, Model model) {
        TripPlanDTO tripPlan = tripPlanService.getTripPlan(planId);
        System.out.println("tripPlan.getPlanId() = " + tripPlan.getPlanId());

        // 모델에 tripplan이라는 이름으로 TripPlanDTO 객체 추가
        model.addAttribute("tripplan", tripPlan);

        return "tripDetail";
    }
}
