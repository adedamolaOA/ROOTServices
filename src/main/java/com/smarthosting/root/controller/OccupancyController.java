/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.controller;

import com.smarthosting.root.core.OccupancyState;
import com.smarthosting.root.jsonreader.Mapper;
import com.smarthosting.root.models.OccupancyRequest;
import com.smarthosting.root.models.OccupancyResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adedamola
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OccupancyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
   
    private final Mapper mapper = new Mapper();
    
    @PostMapping("/occupancy")
    public OccupancyResponse getOccupancyState(@RequestBody OccupancyRequest data) {

        return getResponse(data);

    }

    @PostMapping("/occupancy/bulk")
    public List<OccupancyResponse> getOccupancyStates(@RequestBody List<OccupancyRequest> data) {

        List<OccupancyResponse> respOccupancyList = new ArrayList<>();

        data.forEach((or) -> {
            respOccupancyList.add(getResponse(or));
        });

        return respOccupancyList;

    }

    public OccupancyResponse getResponse(OccupancyRequest data) {
        OccupancyResponse respOccupancy = new OccupancyResponse();

        //Log Free Premium rooms and Free Economy rooms
        logger.info("Free Premium rooms: " + data.getAvailablePremiumRooms());
        logger.info("Free Economy rooms: " + data.getAvailableEconomyRooms());

        OccupancyState occupancyState = new OccupancyState(mapper.getPayments(),data.getAvailablePremiumRooms(), data.getAvailableEconomyRooms());
        //Log Results of Alogrithm
        logger.info("Usage Premium: " + occupancyState.getPremiumRoomOccuiped() + "(EUR " + occupancyState.getPremiumRoomTotalMade() + ")");
        logger.info("Usage Economy: " + occupancyState.getEconomyRoomOccuiped() + "(EUR " + occupancyState.getEconomyRoomTotalMade() + ")");

        //Set Response values for the request
        respOccupancy.setPremiumOccupiedRooms(occupancyState.getPremiumRoomOccuiped());
        respOccupancy.setPremiumTotal(occupancyState.getPremiumRoomTotalMade());
        respOccupancy.setEconomyOccuipedRooms(occupancyState.getEconomyRoomOccuiped());
        respOccupancy.setEconomyTotal(occupancyState.getEconomyRoomTotalMade());

        return respOccupancy;
    }

}
