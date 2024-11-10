package com.withtrip.service;

import com.withtrip.domain.TripPlanDTO;
import com.withtrip.mapper.TripPlanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class TripPlanServiceTest {

    @Mock
    private TripPlanMapper tripPlanMapper;

    @InjectMocks
    private TripPlanService tripPlanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTripPlan() {
        // given
        TripPlanDTO tripPlanDTO = new TripPlanDTO();
        tripPlanDTO.setPlanId(1L);

        // when
        when(tripPlanMapper.saveTripPlan(any(TripPlanDTO.class))).thenReturn(1L);
        Long savedPlanId = tripPlanService.saveTripPlan(tripPlanDTO);

        // then
        assertEquals(1L, savedPlanId);
        verify(tripPlanMapper, times(1)).saveTripPlan(tripPlanDTO);
    }

    @Test
    void testGetAllTripPlans() {
        // given
        List<TripPlanDTO> tripPlans = new ArrayList<>();
        tripPlans.add(new TripPlanDTO());

        // when
        when(tripPlanMapper.getAllTripPlans()).thenReturn(tripPlans);
        List<TripPlanDTO> result = tripPlanService.getAllTripPlans();

        // then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(tripPlanMapper, times(1)).getAllTripPlans();
    }

    @Test
    void testGetTripPlan() {
        // given
        TripPlanDTO tripPlanDTO = new TripPlanDTO();
        tripPlanDTO.setPlanId(1L);

        // when
        when(tripPlanMapper.getTripPlan(anyLong())).thenReturn(tripPlanDTO);
        TripPlanDTO result = tripPlanService.getTripPlan(1L);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getPlanId());
        verify(tripPlanMapper, times(1)).getTripPlan(1L);
    }
}
