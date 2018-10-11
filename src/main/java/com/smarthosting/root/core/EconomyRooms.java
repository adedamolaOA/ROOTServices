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
public class EconomyRooms implements Rooms {

    private Integer occupied = 0;
    private Integer totalPayment = 0;

    public EconomyRooms(List<Integer> sortedPrice, List<Integer> premiumPriceList, Integer availablePremiumRooms, Integer availableEconomyRooms) {
        optimization(sortedPrice, premiumPriceList, availablePremiumRooms, availableEconomyRooms);
    }

    private void optimization(List<Integer> sortedPrice, List<Integer> sortedPremiumPriceList, Integer availablePremiumRooms, Integer availableEconomyRooms) {
        List<Integer> economyPriceList = new ArrayList<>();

        if (availableEconomyRooms.equals(0)) {
            //Fill the sorted Premium Price List with that of Sorted Economy Price List
            sortedPremiumPriceList.addAll(sortedPrice);
        } else if (availableEconomyRooms.equals(1) && availablePremiumRooms.compareTo(sortedPremiumPriceList.size()) > 0) {
            //flow for upgrading economy room clients to premium
            economyPriceList = upgradeEconomy(sortedPrice, sortedPremiumPriceList, availablePremiumRooms, availableEconomyRooms);
        } else {
            //standard flow of allocation for enonomy rooms
            economyPriceList = standardEnconomyAllocation(sortedPrice, availableEconomyRooms);
        }

        //Populate total number of occupied Premium Rooms and total amount realized
        occupied = economyPriceList.size();
        totalPayment = economyPriceList.stream().mapToInt(Integer::intValue).sum();

    }

    // Alogthrim For Economy Room upgrade
    private List<Integer> upgradeEconomy(List<Integer> sortedPrice, List<Integer> sortedPremiumPriceList, Integer availablePremiumRooms, Integer availableEconomyRooms) {
        List<Integer> economyPriceList = new ArrayList<>();
        //Get the esitmated size of the new Premium Price List
        Integer esitmatedPremiumRoomSize = sortedPremiumPriceList.size() + (sortedPrice.size() - 1);
        /*If the Available Premium Rooms is equal or greater then esitmated size 
              add the last price on the sorted economy price list to the current economy 
              price list then add the remaining ecomony price to sorted premium price list                          
         */
        if (availablePremiumRooms.compareTo(esitmatedPremiumRoomSize) >= 0) {
            economyPriceList.add(sortedPrice.get(sortedPrice.size() - 1));
            for (int i = 0; i < sortedPrice.size() - 1; i++) {
                sortedPremiumPriceList.add(sortedPrice.get(i));
            }
        } /*else if the Available Premium Rooms is less then esitmated size, 
          the difference between Esitmated Size Premium Customers(Price) and Available Premium Rooms 
          is equal to location pointer for the price to select for the only Available Economy Rooms 
         */ else {
            // Get the pointer location for the best price for the only economy room
            Integer choicePriceForEcoPointer = esitmatedPremiumRoomSize - availablePremiumRooms;

            // Check if the pointer location is equal to available room which in this method is always the Integer value 1
            if (choicePriceForEcoPointer.equals(availableEconomyRooms)) {

                /*If pointer location and available economy room is 1 the sum of choicePriceForEcoPointer(Pinter Location) 
                and availableEconomyRooms gets the final price pointer location used to pick the price from the sorted economy List*/
                Integer finalPricePointer = choicePriceForEcoPointer + availableEconomyRooms;
                economyPriceList.add(sortedPrice.get(finalPricePointer));

                //Once the economy room filled, this loop fills in the sorted premium list with the remaing economy price list 
                for (int i = 0; i < finalPricePointer; i++) {
                    sortedPremiumPriceList.add(sortedPrice.get(i));
                }
            } else {

                /*In this case pointer location and available economy room is not equal to '1', so the difference between choicePriceForEcoPointer(Pinter Location) 
                and availableEconomyRooms gets the final price pointer location used to pick the price from the sorted economy List*/
                Integer finalPricePointer = choicePriceForEcoPointer - availableEconomyRooms;

                //Once the economy room filled, this loop fills in the sorted premium list with the remaing economy price list 
                economyPriceList.add(sortedPrice.get(finalPricePointer));
                for (int i = 0; i < finalPricePointer; i++) {
                    sortedPremiumPriceList.add(sortedPrice.get(i));
                }
            }
        }
        return economyPriceList;
    }

    //Method for standard flow of allocation for enonomy rooms
    private List<Integer> standardEnconomyAllocation(List<Integer> sortedPrice, Integer availableEconomyRooms) {
        List<Integer> economyPriceList = new ArrayList<>();
        for (int i = 0; i < sortedPrice.size(); i++) {
            economyPriceList.add(sortedPrice.get(i));
            if (availableEconomyRooms.equals((i + 1))) {
                break;
            }
        }
        return economyPriceList;
    }

    @Override
    public Integer getOccupied() {
        return occupied;
    }

    @Override
    public Integer getTotal() {
        return totalPayment;
    }
}
