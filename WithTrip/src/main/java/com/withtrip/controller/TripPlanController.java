package com.withtrip.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.withtrip.domain.TripPlanDTO;
import com.withtrip.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class TripPlanController {

        private final TripPlanService tripPlanService;

        @PostMapping("/tripplan")
        public String saveTripPlan(TripPlanDTO tripPlanDTO, RedirectAttributes redirectAttributes) {
                // 여행 계획을 저장하고 생성된 planId 반환
                Long planId = tripPlanService.saveTripPlan(tripPlanDTO);

                // 리다이렉트 시 planId를 파라미터로 전달
                redirectAttributes.addAttribute("planId", planId);

                return "redirect:/tripPlanInfo";  // 다음 페이지로 리다이렉트
        }

        // tripdetail 페이지로 이동
        @GetMapping("/tripdetail")
        public String tripDetail() {
                return "tripdetail"; // 상세 페이지 반환
        }


        @GetMapping("/tripDetail")
        public String getTripDetail(HttpSession session, Model model) {
                Long planId = (Long) session.getAttribute("planId");
                if (planId != null) {
                        TripPlanDTO tripPlan = tripPlanService.getTripPlan(planId);
                        model.addAttribute("planTitle", tripPlan.getPlanTitle());
                        model.addAttribute("destination", tripPlan.getDestination());
                        model.addAttribute("tripPlanId", tripPlan.getPlanId());
                } else {
                        // planId가 없을 경우 처리 (예: 오류 메시지 표시)
                }
                return "tripDetail";
        }

        // TripPlanController.java
        @GetMapping("/tripplan/{id}")
        public String getTripPlan(@PathVariable Long id, Model model) {
                TripPlanDTO tripPlan = tripPlanService.getTripPlan(id);
                model.addAttribute("startDate", tripPlan.getStartDate());
                model.addAttribute("endDate", tripPlan.getEndDate());
                return "tripplan";
        }
        }


