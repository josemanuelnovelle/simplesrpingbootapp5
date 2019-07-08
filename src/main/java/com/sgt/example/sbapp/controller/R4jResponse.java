package com.sgt.example.sbapp.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The client response information. <br>
 * See {@link com.sgt.example.resilience.model.R4jResponse
 * IssuedOrder} for more information.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class R4jResponse {

 
    private String outputcode;

 
    private String outputmessage;

}