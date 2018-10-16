/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.models;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Adedamola
 */
@Setter @Getter
public class OccupancyRequest {

    //Input parameters for the Restful service
    private int availablePremiumRooms;
    private int availableEconomyRooms;

    public void setAvailableEconomyRooms(int availableEconomyRooms) {
        this.availableEconomyRooms = availableEconomyRooms;
    }

    public int getAvailableEconomyRooms() {
        return availableEconomyRooms;
    }

    public void setAvailablePremiumRooms(int availablePremiumRooms) {
        this.availablePremiumRooms = availablePremiumRooms;
    }

    public int getAvailablePremiumRooms() {
        return availablePremiumRooms;
    }
    
    

    
}
