package com.carsforyouproject.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsforyouproject.base.dto.AdminDetails;
import com.carsforyouproject.base.dto.CarDetails;
import com.carsforyouproject.base.model.AdminRequest;
import com.carsforyouproject.base.model.AdminResponse;
import com.carsforyouproject.base.service.AdminServiceImplimentation;
import com.carsforyouproject.base.service.UserService;
import com.carsforyouproject.base.util.JwtUtil;

@RestController
public class AdminController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AdminServiceImplimentation adminservice;

	@Autowired
	private UserService service;

	@PostMapping("/loginauth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AdminRequest adminRequest) throws Exception {
		try {
			authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(adminRequest.getUsername(), adminRequest.getPassword()));
			UserDetails userDetails = userDetailsService.loadUserByUsername(adminRequest.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AdminResponse("logged in successfully", false, jwt));
		} catch (Exception e) {
			return ResponseEntity.ok((new AdminResponse("invalid username", true, null)));
		}

	}

	@PostMapping("/signupauth")
	public ResponseEntity<AdminResponse> signUpDetails(@RequestBody  AdminDetails adminDetails) {
		AdminDetails signUpData = adminservice.signUp(adminDetails);
		if (signUpData != null) {
			return ResponseEntity.created(null).body(new AdminResponse("User created!", false, null));
		}
		// return ResponseEntity.ok(new AdminResponse("username already exists", true,
		// null));
		return ResponseEntity.badRequest().body(new AdminResponse("Username already exists!", true, null));
	}

	@GetMapping("/carsforyou")
	public List<CarDetails> getAllCarDetails(CarDetails carDetails) {
		List<CarDetails> details = service.getAllCarDetails();
		return details;
	}

	@PostMapping("/add")
	public ResponseEntity<?> insertCarDetails(@RequestBody CarDetails carDetails) {
		try {
			service.insertCarDetails(carDetails);
			return new ResponseEntity<String>("data added successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("OOPS something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/carsforyou/{carId}")
	public ResponseEntity<?> updateCarDetails(@RequestBody CarDetails carDetails, @PathVariable Integer carId) {
		try {
			carDetails.setCarId(carId);
			service.updateCarDetails(carDetails);
			return new ResponseEntity<String>("data updated successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("OOPS something went wrong ", null);
		}

	}

	@DeleteMapping("carsforyou/{carId}")
	public ResponseEntity<?> deleteCarDetails(CarDetails carDetails, @PathVariable Integer carId) {
		try {
			service.deleteCarDetails(carDetails, carId);
			return new ResponseEntity<String>("data deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("data not found for id" + "" + carId, HttpStatus.OK);
		}

	}

}
