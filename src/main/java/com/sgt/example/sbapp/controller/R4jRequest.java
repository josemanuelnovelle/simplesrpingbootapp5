package com.sgt.example.sbapp.controller;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The client response information. <br>
 * See {@link com.sgt.example.resilience.model.R4jRequest
 * IssuedOrder} for more information.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class R4jRequest {

    @NotNull(message = "error.inputcode.null")
    @NotEmpty(message = "error.inputcode.empty")
    private String inputcode; 
    
    @NotNull(message = "error.inputmessage.null")
    @NotEmpty(message = "error.inputmessage.empty")
    private String inputmessage;

}