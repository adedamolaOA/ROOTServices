/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import com.smarthosting.root.jsonreader.Mapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adedamola
 */
public class OccupancyStateTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int economyRoomOccuiped;
    private int premiumRoomOccuiped;
    private int economyRoomTotalMade;
    private int premiumRoomTotalMade;

    private final Mapper mapper = new Mapper();
    public OccupancyStateTest() {
        logger.info("Testing Occupancy Class");
        logic(mapper.getPayments(),7, 1);
    }

    private void logic(List<Integer> paymentList,int availablePremiumRooms, int availableEconomyRooms) {
        List<Integer> economyList;
        List<Integer> premiumList;
        
        //Get Customer Payment List
        List<Integer> testArray = paymentList;
        testArray.sort(Comparator.naturalOrder());
        testArray.sort(Comparator.reverseOrder());

        List<Integer> sortedEconomyPriceList = testArray.stream().filter(i -> i < 100).collect(Collectors.toList());
        List<Integer> sortedPremiumPriceList = testArray.stream().filter(i -> i >= 100).collect(Collectors.toList());
        if (availableEconomyRooms == 0) {
            economyList = new ArrayList<>();
            premiumList = testArray.stream().limit(availablePremiumRooms).collect(Collectors.toList());
        } else if (availableEconomyRooms == 1 && availablePremiumRooms > sortedPremiumPriceList.size()) {
            economyList = sortedEconomyPriceList.stream()
                    .limit(availableEconomyRooms + (availablePremiumRooms - sortedPremiumPriceList.size()))
                    .filter(i -> i < sortedEconomyPriceList.get((availablePremiumRooms - sortedPremiumPriceList.size()) - 1))
                    .collect(Collectors.toList());
            premiumList = testArray.stream()
                    .limit(availablePremiumRooms)
                    .collect(Collectors.toList());
        } else {
            economyList = sortedEconomyPriceList.stream()
                    .limit(availableEconomyRooms)
                    .collect(Collectors.toList());
            premiumList = sortedPremiumPriceList.stream()
                    .limit(availablePremiumRooms)
                    .collect(Collectors.toList());
        }

        // Get Rooms Allocated
        premiumRoomOccuiped = premiumList.size();
        economyRoomOccuiped = economyList.size();

        // Get total Price
        premiumRoomTotalMade = premiumList.stream().mapToInt(Integer::intValue).sum();
        economyRoomTotalMade = economyList.stream().mapToInt(Integer::intValue).sum();

    }


    /**
     * Test of getPremiumRoomsTotalPrice method, of class Occupancy.
     */
    @Test
    public void testGetPremiumRoomsTotalPrice() {
        
    }

    /**
     * Test of getEconomyRoomsOccupiedRooms method, of class Occupancy.
     */
    @Test
    public void testGetEconomyRoomsOccupiedRooms() {
       
    }

    /**
     * Test of getPremiumOccupiedRooms method, of class OccupancyState.
     */
    @Test
    public void testGetPremiumOccupiedRooms() {
         assertEquals(7, premiumRoomOccuiped);
    }

    /**
     * Test of getPremiumTotalPrice method, of class OccupancyState.
     */
    @Test
    public void testGetPremiumTotalPrice() {
        assertEquals(1153, premiumRoomTotalMade);
    }

    /**
     * Test of getEconomyOccupiedRooms method, of class OccupancyState.
     */
    @Test
    public void testGetEconomyOccupiedRooms() {
         assertEquals(1, economyRoomOccuiped);
    }

    /**
     * Test of getEconomyTotalPrice method, of class OccupancyState.
     */
    @Test
    public void testGetEconomyTotalPrice() {
         assertEquals(45, economyRoomTotalMade);
    }
}
