package com.carsforyouproject.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carsforyouproject.base.dao.AdminDao;
import com.carsforyouproject.base.dao.UserDao;
import com.carsforyouproject.base.dto.AdminDetails;
import com.carsforyouproject.base.dto.CarDetails;
import com.carsforyouproject.base.dto.MyAdminDetails;

@Service
public class AdminServiceImplimentation implements UserDetailsService, UserService {
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminDetails adminDetails = (AdminDetails) adminDao.findByUsername(username);
		if (adminDetails != null) {
			return new MyAdminDetails(adminDetails);
		} else {
			throw new UsernameNotFoundException("username not found ");
		}
	}

	public AdminDetails signUp(AdminDetails adminDetails) {
		AdminDetails adminObj = adminDao.findByUsername(adminDetails.getUsername());
		if (adminObj == null)
			return adminDao.save(adminDetails);
		else
			return null;
	}

	@Override
	public List<CarDetails> getAllCarDetails() {
		return dao.findAll();
	}

	@Override
	public CarDetails insertCarDetails(CarDetails carDetails) {
		return dao.save(carDetails);
	}

	@Override
	public CarDetails updateCarDetails(CarDetails carDetails) {
		return dao.save(carDetails);
	}

	@Override
	public void deleteCarDetails(CarDetails carDetails, Integer carId) {
		dao.delete(carDetails);
	}

}
