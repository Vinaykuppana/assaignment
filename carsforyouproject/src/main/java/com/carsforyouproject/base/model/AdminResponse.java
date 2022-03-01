package com.carsforyouproject.base.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {
	private String message;
	 private boolean error;
    private String jwt;
   
}
