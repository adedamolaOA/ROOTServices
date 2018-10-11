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

/**
 *
 * @author Adedamola
 */
public class OccupancyState {
    
    private final List<Integer> sortedEconomyPriceList;
    private final List<Integer> sortedPremiumPriceList;
    private List<Integer> priceList;
    private final PremiumRooms premiumRooms;
    private final EconomyRooms economyRooms;

    public OccupancyState(Integer availablePremiumRooms, Integer availableEconomyRooms) throws IOException {

        // Get the price list from the JSON File
        getPriceList();

        //Filter Economy Prices
        sortedEconomyPriceList = priceList.stream().filter((i) -> (i < 100)).collect(Collectors.toList());

        //Filter Preium Prices
        sortedPremiumPriceList = priceList.stream().filter((i) -> (i >= 100)).collect(Collectors.toList());

        //Initializing Economy and Premium Class to get process the rooms
        economyRooms = new EconomyRooms(sortedEconomyPriceList, sortedPremiumPriceList, availablePremiumRooms, availableEconomyRooms);
        premiumRooms = new PremiumRooms(sortedPremiumPriceList, availablePremiumRooms);
    }

    // Retrive Json and sort in desending order
    private void getPriceList() throws IOException {
        priceList = new PaymentMapper().readJson();
        Collections.sort(priceList, new PriceComparator());
    }

    public Integer getPremiumOccupiedRooms() {
        return premiumRooms.getOccupied();
    }

    public Integer getPremiumTotalPrice() {
        return premiumRooms.getTotal();
    }

    public Integer getEconomyOccupiedRooms() {
        return economyRooms.getOccupied();
    }

    public Integer getEconomyTotalPrice() {
        return economyRooms.getTotal();
    }
    
}
