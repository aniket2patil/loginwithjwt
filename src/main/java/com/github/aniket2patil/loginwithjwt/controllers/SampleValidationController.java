package com.github.aniket2patil.loginwithjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.aniket2patil.loginwithjwt.models.ApiResponse;
import com.github.aniket2patil.loginwithjwt.models.AuthenticationRequest;
import com.github.aniket2patil.loginwithjwt.util.JwtTokenUtil;

@RestController
public class SampleValidationController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/verifytest")
	public ApiResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
				
		
		ApiResponse apiResponse = new ApiResponse();		
		
		if(jwtTokenUtil.isValidateToken(
				authenticationRequest.getVerificationToken(), 
				authenticationRequest.getEmail()) 
				== true) {
			
			apiResponse.setData("Success");
			
		}
		else {
			apiResponse.setData("Failure");
			apiResponse.setMessage("Failed to verify client");
		}
		
		return apiResponse;
		
	}
}
