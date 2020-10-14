package com.github.aniket2patil.loginwithjwt.models;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String email;
    private final String phone;
    private final String password;
    private final String verificationToken;

    
    public String getPassword() {
        return this.password;
    }

    public AuthenticationRequest(String email,
    							String phone,
    							String password,
    							String verificationToken) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.verificationToken = verificationToken;
        
    }
    
	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}
	
	public String getVerificationToken() {
		return this.verificationToken;
	}

}
