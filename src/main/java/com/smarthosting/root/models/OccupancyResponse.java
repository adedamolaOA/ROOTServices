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
public class OccupancyResponse {

    //Responses that will recieved by the RESTful service after a request
    private Integer premiumOccupiedRooms;
    private Integer premiumTotal;

    private Integer economyOccuipedRooms;
    private Integer economyTotal;

    //Getters and Setters for the responses
    public Integer getPremiumOccupiedRooms() {
        return premiumOccupiedRooms;
    }

    public Integer getPremiumTotal() {
        return premiumTotal;
    }

    public Integer getEconomyOccuipedRooms() {
        return economyOccuipedRooms;
    }

    public Integer getEconomyTotal() {
        return economyTotal;
    }

    public void setPremiumOccupiedRooms(Integer premiumOccupiedRooms) {
        this.premiumOccupiedRooms = premiumOccupiedRooms;
    }

    public void setPremiumTotal(Integer premiumTotal) {
        this.premiumTotal = premiumTotal;
    }

    public void setEconomyOccuipedRooms(Integer economyOccuipedRooms) {
        this.economyOccuipedRooms = economyOccuipedRooms;
    }

    public void setEconomyTotal(Integer economyTotal) {
        this.economyTotal = economyTotal;
    }

}
