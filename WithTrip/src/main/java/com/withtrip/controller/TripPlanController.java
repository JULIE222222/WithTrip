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


import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class TripPlanController {

        private final TripPlanService tripPlanService;

        @PostMapping("/tripplan")
        public String saveTripPlan(TripPlanDTO tripPlanDTO, Model model){
                tripPlanService.saveTripPlan(tripPlanDTO);

                model.addAttribute("planId", tripPlanDTO.getPlanId());
                model.addAttribute("planTitle", tripPlanDTO.getPlanTitle());
                model.addAttribute("destination", tripPlanDTO.getDestination());
                model.addAttribute("startDate", tripPlanDTO.getStartDate());
                model.addAttribute("endDate", tripPlanDTO.getEndDate());

                return "redirect:/tripplan";
        }

        @GetMapping("/tripplan/{id}")
        public String getTripPlan(@PathVariable Long id, Model model) {
                TripPlanDTO tripPlan = tripPlanService.getTripPlan(id);
                model.addAttribute("startDate", tripPlan.getStartDate());
                model.addAttribute("endDate", tripPlan.getEndDate());
                return "tripplan";
        }
        }


