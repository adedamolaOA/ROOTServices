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
public class EconomyRoomsTest {

    EconomyRooms economyTests;

    public EconomyRoomsTest() {
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
        Collections.sort(testArray, new PriceComparator());

        //Filter Economy Prices
        List<Integer> economyTestList = testArray.stream().filter((i) -> (i < 100)).collect(Collectors.toList());

        //Filter Preium Prices
        List<Integer> premiumTestList = testArray.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());

        economyTests = new EconomyRooms(economyTestList, premiumTestList, 8, 1);
    }

    /**
     * Test of getOccupied method, of class EconomyRooms.
     */
    @Test
    public void testGetOccupied() {
        assertEquals(new Integer(1), economyTests.getOccupied());
    }

    /**
     * Test of getTotal method, of class EconomyRooms.
     */
    @Test
    public void testGetTotal() {
        assertEquals(new Integer(23), economyTests.getTotal());
    }

}
