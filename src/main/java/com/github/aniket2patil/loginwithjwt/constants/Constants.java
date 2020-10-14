package com.github.aniket2patil.loginwithjwt.constants;


public final class Constants {
	//Hide the constructor
	private Constants(){}
	
	//This is random string. 
	//Make sure that you get your own string secret key and it has to be secured. 	
	public final static String JWT_SECRET_KEY = "test_dsadsadeqeq21421sadsadfgtrytrt43543645tregsefewrewfrefvc22288570";
	public final static Integer JWT_EXPIRY_IN_MILLISECONDS = 1000 * 60 * 60 * 10;


}