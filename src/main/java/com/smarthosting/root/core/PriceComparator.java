/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.core;

import java.util.Comparator;

/**
 *
 * @author Adedamola
 */
public class PriceComparator  implements Comparator<Integer> {

    @Override
    public int compare(Integer p1, Integer p2) {
        
        return p1 > p2 ? -1 : (p1 < p2 ? 1 : 0); // Sort customer prices in Descending Order
    }

}
