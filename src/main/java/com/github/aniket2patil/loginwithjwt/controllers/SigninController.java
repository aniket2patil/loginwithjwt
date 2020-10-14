package com.github.aniket2patil.loginwithjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.aniket2patil.loginwithjwt.models.ApiResponse;
import com.github.aniket2patil.loginwithjwt.models.AuthenticationRequest;
import com.github.aniket2patil.loginwithjwt.util.JwtTokenUtil;

@RestController
public class SigninController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/signin")
	public ApiResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
				
		
		ApiResponse apiResponse = new ApiResponse();		
		
		//Assuming valid credentials are passed		
		boolean isValidCreds = true;
		
		if(isValidCreds == true) {
			
			String token = jwtTokenUtil.generateToken(authenticationRequest.getEmail());
			
			apiResponse.setData(token);
			
		}
		
		return apiResponse;
		
	}

}
