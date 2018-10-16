/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import com.smarthosting.root.models.Occupancy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Adedamola
 */

public class OccupancyState extends Occupancy{

    public void businessLogic(){
        logic();
    }

    // Business Logic for allocating rooms
    private void logic() {
        List<Integer> economyList;
        List<Integer> premiumList;
        
        
        int availablePremiumRoom = getAvailablePremiumRooms();
        int availableEconomyRoom = getAvailableEconomyRooms();
        
        //Get Customer Payment List and sort
        List<Integer> priceList = getPaymentList();
        priceList.sort(Comparator.naturalOrder());
        priceList.sort(Comparator.reverseOrder());
        

        List<Integer> sortedEconomyPriceList = priceList.stream().filter(i -> i < 100).collect(Collectors.toList());
        List<Integer> sortedPremiumPriceList = priceList.stream().filter(i -> i >= 100).collect(Collectors.toList());
        if (availableEconomyRoom == 0) {
            economyList = new ArrayList<>();
            premiumList = priceList.stream()
                    .limit(availablePremiumRoom)
                    .collect(Collectors.toList());
        } else if (availableEconomyRoom == 1 && availablePremiumRoom > sortedPremiumPriceList.size()) {
            economyList = sortedEconomyPriceList.stream()
                    .limit(availableEconomyRoom + (availablePremiumRoom - sortedPremiumPriceList.size()))
                    .filter(i -> i < sortedEconomyPriceList.get((availablePremiumRoom - sortedPremiumPriceList.size()) - 1))
                    .collect(Collectors.toList());
            premiumList = priceList.stream()
                    .limit(availablePremiumRoom)
                    .collect(Collectors.toList());
        } else {
            economyList = sortedEconomyPriceList.stream()
                    .limit(availableEconomyRoom)
                    .collect(Collectors.toList());
            premiumList = sortedPremiumPriceList.stream()
                    .limit(availablePremiumRoom)
                    .collect(Collectors.toList());
        }

        // Get Rooms Allocated
        setPremiumRoomOccuiped(premiumList.size());
        setEconomyRoomOccuiped(economyList.size());

        // Get total Price
        setPremiumRoomTotalMade(premiumList.stream().mapToInt(Integer::intValue).sum());
        setEconomyRoomTotalMade(economyList.stream().mapToInt(Integer::intValue).sum());

    }
    
}