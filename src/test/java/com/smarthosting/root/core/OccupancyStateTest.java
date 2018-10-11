/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import com.smarthosting.root.jsonreader.PaymentMapper;
import java.io.IOException;
import java.util.Collections;
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
    
    EconomyRooms economyTest;
    PremiumRooms premiumTest;
    
    EconomyRooms economyTest1;
    PremiumRooms premiumTest1;
    
    EconomyRooms economyTest2;
    PremiumRooms premiumTest2;
    
    EconomyRooms economyTest3;
    PremiumRooms premiumTest3;
    
    EconomyRooms economyTest4;
    PremiumRooms premiumTest4;
    
    EconomyRooms economyTest5;
    PremiumRooms premiumTest5;
    
    EconomyRooms economyTest6;
    PremiumRooms premiumTest6;
    
    EconomyRooms economyTest7;
    PremiumRooms premiumTest7;
    
    EconomyRooms economyTest8;
    PremiumRooms premiumTest8;
    
    EconomyRooms economyTest9;
    PremiumRooms premiumTest9;
    
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public OccupancyStateTest() {
        logger.info("Testing Occupancy Class");
        try{
        //Convert Integer[] to List
        List<Integer> testArrayLive = new PaymentMapper().readJson();
        List<Integer> testArray = testArrayLive;
        Collections.sort(testArray,new PriceComparator());

        //Filter EconomyRooms Prices
        List<Integer> economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());
        
        //Filter Preium Prices
        List<Integer> premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        //Test Cases
        logger.info("Test Case 1");
        logger.info("Free PremiumRooms rooms: 3");
        logger.info("Free EconomyRooms rooms: 3");
        economyTest = new EconomyRooms(economyTestList, premiumTestList,3, 3);
        premiumTest = new PremiumRooms(premiumTestList, 3);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 2");
        logger.info("Free PremiumRooms rooms: 7");
        logger.info("Free EconomyRooms rooms: 5");
        economyTest1 = new EconomyRooms(economyTestList, premiumTestList,7, 5);
        premiumTest1 = new PremiumRooms(premiumTestList, 7);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 3");
        logger.info("Free PremiumRooms rooms: 2");
        logger.info("Free EconomyRooms rooms: 7");
        economyTest2 = new EconomyRooms(economyTestList, premiumTestList,2, 7);
        premiumTest2 = new PremiumRooms(premiumTestList, 2);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 4");
        logger.info("Free PremiumRooms rooms: 7");
        logger.info("Free EconomyRooms rooms: 1");
        economyTest3 = new EconomyRooms(economyTestList, premiumTestList,7, 1);
        premiumTest3 = new PremiumRooms(premiumTestList, 7);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 5");
        logger.info("Free PremiumRooms rooms: 9");
        logger.info("Free EconomyRooms rooms: 1");
        economyTest4 = new EconomyRooms(economyTestList, premiumTestList,9, 1);
        premiumTest4 = new PremiumRooms(premiumTestList, 9);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 6");
        logger.info("Free PremiumRooms rooms: 10");
        logger.info("Free EconomyRooms rooms: 0");
        economyTest5 = new EconomyRooms(economyTestList, premiumTestList,10, 0);
        premiumTest5 = new PremiumRooms(premiumTestList, 10);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 7");
        logger.info("Free PremiumRooms rooms: 0");
        logger.info("Free EconomyRooms rooms: 7");
        economyTest6 = new EconomyRooms(economyTestList, premiumTestList,0, 7);
        premiumTest6 = new PremiumRooms(premiumTestList, 0);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 8");
        logger.info("Free PremiumRooms rooms: 8");
        logger.info("Free EconomyRooms rooms: 1");
        economyTest7 = new EconomyRooms(economyTestList, premiumTestList,8, 1);
        premiumTest7 = new PremiumRooms(premiumTestList, 8);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 9");
        logger.info("Free PremiumRooms rooms: 1");
        logger.info("Free EconomyRooms rooms: 1");
        economyTest8 = new EconomyRooms(economyTestList, premiumTestList,1, 1);
        premiumTest8 = new PremiumRooms(premiumTestList, 1);
        
        // Need Refresh after every case test
        economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());        
        premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        logger.info("Test Case 10");
        logger.info("Free PremiumRooms rooms: 5");
        logger.info("Free EconomyRooms rooms: 1");
        economyTest9 = new EconomyRooms(economyTestList, premiumTestList,5, 1);
        premiumTest9 = new PremiumRooms(premiumTestList, 5);
        
        
        }catch(IOException e){
          System.out.println(e.getMessage());
        }
        
    }

    /**
     * Test of getPremiumRoomsOccupiedRooms method, of class Occupancy.
     */
    @Test
    public void testGetPremiumRoomsOccupiedRooms() {
        logger.info("Test Case (1) Occupied PremiumRooms Room(s): "+ premiumTest.getOccupied());
        assertEquals(new Integer(3), premiumTest.getOccupied());
        
        logger.info("Test Case (2) Occupied PremiumRooms Room(s): "+ premiumTest1.getOccupied());
        assertEquals(new Integer(6), premiumTest1.getOccupied());
        
        logger.info("Test Case (3) Occupied PremiumRooms Room(s): "+ premiumTest2.getOccupied());
        assertEquals(new Integer(2), premiumTest2.getOccupied());
        
        logger.info("Test Case (4) Occupied PremiumRooms Room(s): "+ premiumTest3.getOccupied());
        assertEquals(new Integer(7), premiumTest3.getOccupied());
        
        logger.info("Test Case (5) Occupied PremiumRooms Room(s): "+ premiumTest4.getOccupied());
        assertEquals(new Integer(9), premiumTest4.getOccupied());
        
        logger.info("Test Case (6) Occupied PremiumRooms Room(s): "+ premiumTest5.getOccupied());
        assertEquals(new Integer(10), premiumTest5.getOccupied());
        
        logger.info("Test Case (7) Occupied PremiumRooms Room(s): "+ premiumTest6.getOccupied());
        assertEquals(new Integer(0), premiumTest6.getOccupied());
        
        logger.info("Test Case (8) Occupied PremiumRooms Room(s): "+ premiumTest7.getOccupied());
        assertEquals(new Integer(8), premiumTest7.getOccupied());
        
        logger.info("Test Case (9) Occupied PremiumRooms Room(s): "+ premiumTest8.getOccupied());
        assertEquals(new Integer(1), premiumTest8.getOccupied());
        
        logger.info("Test Case (10) Occupied PremiumRooms Room(s): "+ premiumTest9.getOccupied());
        assertEquals(new Integer(5), premiumTest9.getOccupied());
        
        
    }

    /**
     * Test of getPremiumRoomsTotalPrice method, of class Occupancy.
     */
    @Test
    public void testGetPremiumRoomsTotalPrice() {
         logger.info("Test Case (1) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest.getTotal());
        assertEquals(new Integer(738), premiumTest.getTotal());
        
        logger.info("Test Case (2) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest1.getTotal());
        assertEquals(new Integer(1054), premiumTest1.getTotal());
        
        logger.info("Test Case (3) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest2.getTotal());
        assertEquals(new Integer(583), premiumTest2.getTotal());
        
        logger.info("Test Case (4) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest3.getTotal());
        assertEquals(new Integer(1153), premiumTest3.getTotal());
        
        logger.info("Test Case (5) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest4.getTotal());
        assertEquals(new Integer(1221), premiumTest4.getTotal());
        
        logger.info("Test Case (6) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest5.getTotal());
        assertEquals(new Integer(1243), premiumTest5.getTotal());
        
        logger.info("Test Case (7) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest6.getTotal());
        assertEquals(new Integer(0), premiumTest6.getTotal());
        
        logger.info("Test Case (8) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest7.getTotal());
        assertEquals(new Integer(1198), premiumTest7.getTotal());
        
        logger.info("Test Case (9) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest8.getTotal());
        assertEquals(new Integer(374), premiumTest8.getTotal());
        
        logger.info("Test Case (10) Total PremiumRooms Room(s) Cost: EUR "+ premiumTest9.getTotal());
        assertEquals(new Integer(954), premiumTest9.getTotal());
        
    }

    /**
     * Test of getEconomyRoomsOccupiedRooms method, of class Occupancy.
     */
    @Test
    public void testGetEconomyRoomsOccupiedRooms() {
        logger.info("Test Case (1) Occupied EconomyRooms Room(s): "+ economyTest.getOccupied());
        assertEquals(new Integer(3), economyTest.getOccupied());
        
         logger.info("Test Case (2) Occupied EconomyRooms Room(s): "+ economyTest1.getOccupied());
        assertEquals(new Integer(4), economyTest1.getOccupied());
        
         logger.info("Test Case (3) Occupied EconomyRooms Room(s): "+ economyTest2.getOccupied());
        assertEquals(new Integer(4), economyTest2.getOccupied());
        
         logger.info("Test Case (4) Occupied EconomyRooms Room(s): "+ economyTest3.getOccupied());
        assertEquals(new Integer(1), economyTest3.getOccupied());
        
         logger.info("Test Case (5) Occupied EconomyRooms Room(s): "+ economyTest4.getOccupied());
        assertEquals(new Integer(1), economyTest4.getOccupied());
        
         logger.info("Test Case (6) Occupied EconomyRooms Room(s): "+ economyTest5.getOccupied());
        assertEquals(new Integer(0), economyTest5.getOccupied());
        
         logger.info("Test Case (7) Occupied EconomyRooms Room(s): "+ economyTest6.getOccupied());
        assertEquals(new Integer(4), economyTest6.getOccupied());
        
         logger.info("Test Case (8) Occupied EconomyRooms Room(s): "+ economyTest7.getOccupied());
        assertEquals(new Integer(1), economyTest7.getOccupied());
        
         logger.info("Test Case (9) Occupied EconomyRooms Room(s): "+ economyTest8.getOccupied());
        assertEquals(new Integer(1), economyTest9.getOccupied());
        
         logger.info("Test Case (10) Occupied EconomyRooms Room(s): "+ economyTest9.getOccupied());
        assertEquals(new Integer(1), economyTest9.getOccupied());
    }

    /**
     * Test of getEconomyRoomsTotalPrice method, of class Occupancy.
     */
    @Test
    public void testGetEconomyRoomsTotalPrice() {
        logger.info("Test Case (1) Total EconomyRooms Room(s) Cost: EUR "+ economyTest.getTotal());
        assertEquals(new Integer(167), economyTest.getTotal());
        
        logger.info("Test Case (2) Total EconomyRooms Room(s) Cost: EUR "+ economyTest1.getTotal());
        assertEquals(new Integer(189), economyTest1.getTotal());
        
        logger.info("Test Case (3) Total EconomyRooms Room(s) Cost: EUR "+ economyTest2.getTotal());
        assertEquals(new Integer(189), economyTest2.getTotal());
        
        logger.info("Test Case (4) Total EconomyRooms Room(s) Cost: EUR "+ economyTest3.getTotal());
        assertEquals(new Integer(45), economyTest3.getTotal());
        
        logger.info("Test Case (5) Total EconomyRooms Room(s) Cost: EUR "+ economyTest4.getTotal());
        assertEquals(new Integer(22), economyTest4.getTotal());
        
        logger.info("Test Case (6) Total EconomyRooms Room(s) Cost: EUR "+ economyTest5.getTotal());
        assertEquals(new Integer(0), economyTest5.getTotal());
        
        logger.info("Test Case (7) Total EconomyRooms Room(s) Cost: EUR "+ economyTest6.getTotal());
        assertEquals(new Integer(189), economyTest6.getTotal());
        
        logger.info("Test Case (8) Total EconomyRooms Room(s) Cost: EUR "+ economyTest7.getTotal());
        assertEquals(new Integer(23), economyTest7.getTotal());
        
        logger.info("Test Case (9) Total EconomyRooms Room(s) Cost: EUR "+ economyTest8.getTotal());
        assertEquals(new Integer(99), economyTest8.getTotal());
        
        logger.info("Test Case (10) Total EconomyRooms Room(s) Cost: EUR "+ economyTest9.getTotal());
        assertEquals(new Integer(99), economyTest9.getTotal());
        
    }
}