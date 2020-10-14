package com.github.aniket2patil.loginwithjwt.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aniket2patil.loginwithjwt.models.AuthenticationRequest;
import com.github.aniket2patil.loginwithjwt.util.JwtTokenUtil;

@WebMvcTest(controllers = SigninController.class)
public class SigninControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void shouldCreateJwtToken() throws Exception {
		
		final AuthenticationRequest authenticationRequest = 
				new AuthenticationRequest("test_email", 
						"test_phone", 
						"test_password",
						"");
		
	    given(jwtTokenUtil.generateToken("test_verification_token")).willReturn("test");
	
	    this.mockMvc.perform(post("/signin")
	    		.contentType(MediaType.APPLICATION_JSON)
	    		.content(objectMapper.writeValueAsString(authenticationRequest)))
	    		.andExpect(status().isOk());
	}
	

}
