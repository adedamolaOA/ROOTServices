/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 *
 * @author Adedamola
 */
@Getter
public class OccupancyState {

    private int economyRoomOccuiped;
    private int premiumRoomOccuiped;
    private int economyRoomTotalMade;
    private int premiumRoomTotalMade;

    public OccupancyState(List<Integer> paymentList,int availablePremiumRooms, int availableEconomyRooms) {
        logic(paymentList,availablePremiumRooms, availableEconomyRooms);
    }

    private void logic(List<Integer> paymentList,int availablePremiumRooms, int availableEconomyRooms) {
        List<Integer> economyList;
        List<Integer> premiumList;
        
        //Get Customer Payment List
        List<Integer> priceList = paymentList;
        priceList.sort(Comparator.naturalOrder());
        priceList.sort(Comparator.reverseOrder());
        

        List<Integer> sortedEconomyPriceList = priceList.stream().filter(i -> i < 100).collect(Collectors.toList());
        List<Integer> sortedPremiumPriceList = priceList.stream().filter(i -> i >= 100).collect(Collectors.toList());
        if (availableEconomyRooms == 0) {
            economyList = new ArrayList<>();
            premiumList = priceList.stream()
                    .limit(availablePremiumRooms)
                    .collect(Collectors.toList());
        } else if (availableEconomyRooms == 1 && availablePremiumRooms > sortedPremiumPriceList.size()) {
            economyList = sortedEconomyPriceList.stream()
                    .limit(availableEconomyRooms + (availablePremiumRooms - sortedPremiumPriceList.size()))
                    .filter(i -> i < sortedEconomyPriceList.get((availablePremiumRooms - sortedPremiumPriceList.size()) - 1))
                    .collect(Collectors.toList());
            premiumList = priceList.stream()
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

    public int getEconomyRoomOccuiped() {
        return economyRoomOccuiped;
    }

    public int getEconomyRoomTotalMade() {
        return economyRoomTotalMade;
    }

    public int getPremiumRoomOccuiped() {
        return premiumRoomOccuiped;
    }

    public int getPremiumRoomTotalMade() {
        return premiumRoomTotalMade;
    }

}
