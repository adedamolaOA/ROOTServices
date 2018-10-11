/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adedamola
 */
public class PremiumRooms implements Rooms {

    private Integer occupiedRooms = 0;
    private Integer total = 0;

    public PremiumRooms(List<Integer> sortedPrice, Integer availablePremiumRooms) {
        optimization(sortedPrice, availablePremiumRooms);
    }

    private void optimization(List<Integer> sortedPrice, Integer availablePremiumRooms) {
        List<Integer> premiumPriceList = new ArrayList<>();
        //Get all sorted premium price list and pick the highest till the rooms are filled up.
        if (!availablePremiumRooms.equals(0)) {
            for (Integer i = 0; i < sortedPrice.size(); i++) {
                premiumPriceList.add(sortedPrice.get(i));
                
                //Break from this loop once max available rooms has been reached
                if (availablePremiumRooms.equals((i + 1))) {
                    break;
                }
            }
        }
        
        //Populate total number of occupied Premium Rooms and total amount realized
        occupiedRooms = premiumPriceList.size();
        total = premiumPriceList.stream().mapToInt(Integer::intValue).sum();

    }

    @Override
    public Integer getOccupied() {
        return occupiedRooms;
    }

    @Override
    public Integer getTotal() {
        return total;
    }
}
