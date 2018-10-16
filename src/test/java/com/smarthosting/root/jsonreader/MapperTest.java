/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.jsonreader;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adedamola
 */
public class MapperTest {
    final private Mapper pfn = new Mapper();
    public MapperTest() {
        
    }

    /**
     * Test of readJson method, of class PaymentMapper.
     */
    /**
     * Test of readJson method, of class Mapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadJson() throws Exception {
         
        List<Integer> result = pfn.getPayments();
        Integer[] test = {
            23,
            45,
            155,
            374,
            22,
            99,
            100,
            101,
            115,
            209
        };
        
        assertArrayEquals(test, result.toArray());
    }
    
}
