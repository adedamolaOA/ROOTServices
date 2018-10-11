/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adedamola
 */
public class PremiumRoomsTest {
    
    PremiumRooms premiumTest;
    public PremiumRoomsTest() {
        Integer[] test = {
            23,
            45,
            155,
            374,
            22,
            99,
            100,
            101,
            115,
            209
        };
        //Convert Integer[] to List
        List<Integer> testArray = Arrays.asList(test);
        Collections.sort(testArray,new PriceComparator());
        
        //Filter Preium Prices
        List<Integer> premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());
        
        premiumTest = new PremiumRooms(premiumTestList, 3);
    }

    /**
     * Test of getOccupied method, of class PremiumRooms.
     */
    @Test
    public void testGetOccupied() {
         assertEquals(new Integer(3), premiumTest.getOccupied());
    }

    /**
     * Test of getTotal method, of class PremiumRooms.
     */
    @Test
    public void testGetTotal() {
        assertEquals(new Integer(738), premiumTest.getTotal());
    }
    
}
