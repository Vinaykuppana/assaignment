package com.carsforyouproject.base.service;

import java.util.List;

import com.carsforyouproject.base.dto.CarDetails;

public interface UserService {
	 
	public List<CarDetails>  getAllCarDetails();
	
	public CarDetails insertCarDetails(CarDetails carDetails); 
	
	public CarDetails updateCarDetails(CarDetails carDetails);
	
	public void deleteCarDetails(CarDetails carDetails,Integer carId);
	
	
	

}
