/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

/**
 *
 * @author Adedamola
 */
public interface Rooms {
    //This two methods will be used by EconomyRooms and PremiumRooms Class
    public Integer getOccupied();
    public Integer getTotal();
}
