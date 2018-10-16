/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Adedamola
 */
public class Occupancy {
    @Getter @Setter(AccessLevel.PROTECTED) private int economyRoomOccuiped;
    @Getter @Setter(AccessLevel.PROTECTED) private int premiumRoomOccuiped;
    @Getter @Setter(AccessLevel.PROTECTED) private int economyRoomTotalMade;
    @Getter @Setter(AccessLevel.PROTECTED) private int premiumRoomTotalMade;
    @Getter(AccessLevel.PROTECTED) @Setter private int availablePremiumRooms;
    @Getter(AccessLevel.PROTECTED) @Setter private int availableEconomyRooms;
    @Getter(AccessLevel.PROTECTED) @Setter private List<Integer> paymentList;


    //Getter For Results
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

    //Setters For Results
    protected void setPremiumRoomTotalMade(int premiumRoomTotalMade) {
        this.premiumRoomTotalMade = premiumRoomTotalMade;
    }

    protected void setPremiumRoomOccuiped(int premiumRoomOccuiped) {
        this.premiumRoomOccuiped = premiumRoomOccuiped;
    }

    protected void setEconomyRoomTotalMade(int economyRoomTotalMade) {
        this.economyRoomTotalMade = economyRoomTotalMade;
    }
    
    protected void setEconomyRoomOccuiped(int economyRoomOccuiped) {
        this.economyRoomOccuiped = economyRoomOccuiped;
    }
    
      
    // Setters for input parameters
    public void setAvailableEconomyRooms(int availableEconomyRooms) {
        this.availableEconomyRooms = availableEconomyRooms;
    }

    public void setAvailablePremiumRooms(int availablePremiumRooms) {
        this.availablePremiumRooms = availablePremiumRooms;
    }

    public void setPaymentList(List<Integer> paymentList) {
        this.paymentList = paymentList;
    }
    
    //Getters For Input Parameters
    protected int getAvailableEconomyRooms() {
        return availableEconomyRooms;
    }

    protected int getAvailablePremiumRooms() {
        return availablePremiumRooms;
    }

    protected List<Integer> getPaymentList() {
        return paymentList;
    }

   
}
