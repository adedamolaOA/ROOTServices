/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.models;

/**
 *
 * @author Adedamola
 */
public class OccupancyRequest {

    //Input parameters for the Restful service
    private Integer availablePremiumRooms;
    private Integer availableEconomyRooms;

    //Getter and Setters for Available Rooms in Premium and Economy
    public Integer getAvailablePremiumRooms() {
        return availablePremiumRooms;
    }

    public Integer getAvailableEconomyRooms() {
        return availableEconomyRooms;
    }

    public void setAvailablePremiumRooms(Integer availablePremiumRooms) {
        this.availablePremiumRooms = availablePremiumRooms;
    }

    public void setAvailableEconomyRooms(Integer availableEconomyRooms) {
        this.availableEconomyRooms = availableEconomyRooms;
    }
}
