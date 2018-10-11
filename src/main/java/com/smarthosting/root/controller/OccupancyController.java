/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.controller;

import com.smarthosting.root.core.OccupancyState;
import com.smarthosting.root.models.OccupancyRequest;
import com.smarthosting.root.models.OccupancyResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping("/occupancy")
    public OccupancyResponse getOccupancyState(@RequestBody OccupancyRequest data) {

        OccupancyResponse respOccupancy = new OccupancyResponse();
        try {
            //Log Free Premium rooms and Free Economy rooms
            logger.info("Free Premium rooms: " + data.getAvailablePremiumRooms());
            logger.info("Free Economy rooms: " + data.getAvailableEconomyRooms());

            OccupancyState occupancyState = new OccupancyState(data.getAvailablePremiumRooms(), data.getAvailableEconomyRooms());
            //Log Results of Alogrithm
            logger.info("Usage Premium: " + occupancyState.getPremiumOccupiedRooms() + "(EUR " + occupancyState.getPremiumTotalPrice() + ")");
            logger.info("Usage Economy: " + occupancyState.getEconomyOccupiedRooms() + "(EUR " + occupancyState.getEconomyTotalPrice() + ")");

            //Set Response values for the request
            respOccupancy.setPremiumOccupiedRooms(occupancyState.getPremiumOccupiedRooms());
            respOccupancy.setPremiumTotal(occupancyState.getPremiumTotalPrice());
            respOccupancy.setEconomyOccuipedRooms(occupancyState.getEconomyOccupiedRooms());
            respOccupancy.setEconomyTotal(occupancyState.getEconomyTotalPrice());

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return respOccupancy;

    }

    @PostMapping("/occupancy/bulk")
    public List<OccupancyResponse> getOccupancyStates(@RequestBody List<OccupancyRequest> data) {

        List<OccupancyResponse> respOccupancyList = new ArrayList<>();
        try {
            for (OccupancyRequest or : data) {
                //Log Free Premium rooms and Free Economy rooms
                logger.info("Free Premium rooms: " + or.getAvailablePremiumRooms());
                logger.info("Free Economy rooms: " + or.getAvailableEconomyRooms());

                OccupancyState occupancy = new OccupancyState(or.getAvailablePremiumRooms(), or.getAvailableEconomyRooms());
                //Log Results of Alogrithm
                logger.info("Usage Premium: " + occupancy.getPremiumOccupiedRooms() + "(EUR " + occupancy.getPremiumTotalPrice() + ")");
                logger.info("Usage Economy: " + occupancy.getEconomyOccupiedRooms() + "(EUR " + occupancy.getEconomyTotalPrice() + ")");

                OccupancyResponse respOccupancy = new OccupancyResponse();
                //Set Response values for the request
                respOccupancy.setPremiumOccupiedRooms(occupancy.getPremiumOccupiedRooms());
                respOccupancy.setPremiumTotal(occupancy.getPremiumTotalPrice());
                respOccupancy.setEconomyOccuipedRooms(occupancy.getEconomyOccupiedRooms());
                respOccupancy.setEconomyTotal(occupancy.getEconomyTotalPrice());
                respOccupancyList.add(respOccupancy);
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return respOccupancyList;

    }

}
