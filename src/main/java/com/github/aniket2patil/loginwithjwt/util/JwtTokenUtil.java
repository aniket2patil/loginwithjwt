package com.github.aniket2patil.loginwithjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import com.github.aniket2patil.loginwithjwt.constants.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtTokenUtil {

	
	public Boolean isValidateToken(String token, String userId) {
		
        final String extractedUserId = extractedUserId(token);
        
        return (!isTokenExpired(token) && extractedUserId.equals(userId));
    }
	
    private String extractedUserId(String token) {
    	
    	final Claims claims = Jwts
    			.parser()
    			.setSigningKey(Constants.JWT_SECRET_KEY)
    			
		.parseClaimsJws(token).getBody();
    	
        return claims.getSubject();
    }

    private Date extractedExpiration(String token) {
    	
    	final Claims claims = Jwts
    			.parser()
    			.setSigningKey(Constants.JWT_SECRET_KEY)
    			.parseClaimsJws(token).getBody();
    	    	
        return claims.getExpiration();
    }

    private Boolean isTokenExpired(String token) {
    	
        return extractedExpiration(token).before(new Date());
    }

    public String generateToken(String userId) {
    	
        Map<String, Object> claims = new HashMap<>();
        
        String token = createToken(claims, userId);
        
        return token;
        
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
        		.setClaims(claims)
        		.setSubject(subject)
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Constants.JWT_EXPIRY_IN_MILLISECONDS))
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SECRET_KEY).compact();
        
    }

}