/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smarthosting.root.jsonreader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Adedamola
 */
public class PaymentMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Integer> readJson() throws IOException {

        //Read the customer price list from json smarthost_hotel_guests.json 
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Integer>> typeReference = new TypeReference<List<Integer>>() {
        };
       
        /*
        
        You can also use this to connect directly with the Json's URL for price list just uncomment and comment 
        The Json reader from file        
        */
        //URL priceUrl = new URL("https://gist.githubusercontent.com/fjahr/b164a446db285e393d8e4b36d17f4143/raw/75108c09a72a001a985d27b968a0ac5a867e830b/smarthost_hotel_guests.json");
        //List<Integer> payments = objectMapper.readValue(priceUrl, typeReference);
        
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/smarthost_hotel_guests.json");
        List<Integer> payments = objectMapper.readValue(inputStream, typeReference);
        
        

        logger.info(payments.toString());

        return payments;
    }
}
