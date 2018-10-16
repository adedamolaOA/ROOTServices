/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import com.smarthosting.root.jsonreader.Mapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Adedamola
 */
public class OccupancyState {

    private int economyRoomOccuiped;
    private int premiumRoomOccuiped;
    private int economyRoomTotalMade;
    private int premiumRoomTotalMade;

    public OccupancyState(int availablePremiumRooms, int availableEconomyRooms) {
        logic(availablePremiumRooms, availableEconomyRooms);
    }

    private void logic(int availablePremiumRooms, int availableEconomyRooms) {
        List<Integer> economyList;
        List<Integer> premiumList;
        
        //Get Customer Payment List
        List<Integer> testArray = getPriceList();

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

    // Retrive Json and sort in desending order
    private List<Integer> getPriceList() {
        List<Integer> priceList = new Mapper().readJson();
        priceList.sort(Comparator.naturalOrder());
        priceList.sort(Comparator.reverseOrder());
        return priceList;
    }

    public Integer getPremiumOccupiedRooms() {
        return premiumRoomOccuiped;
    }

    public Integer getPremiumTotalPrice() {
        return premiumRoomTotalMade;
    }

    public Integer getEconomyOccupiedRooms() {
        return economyRoomOccuiped;
    }

    public Integer getEconomyTotalPrice() {
        return economyRoomTotalMade;
    }

}
