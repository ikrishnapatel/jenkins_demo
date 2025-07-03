package com.springk.apidemos.JwtAuthentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtToGenerateToken {

    private SecretKey secretKey = Keys.hmacShaKeyFor("secretKey123".getBytes()); // Secret key for signing the JWT

    // Method to generate a JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Set the username as the subject (claim)
                .setIssuedAt(new Date())  // Set the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // Set expiration time (1 hour)
                .signWith(secretKey, SignatureAlgorithm.HS256)  // Sign the token using HMAC SHA256 and the secret key
                .compact();  // Create the token
    }

    // Method to validate the token
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);  // Extract the username from the token
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Method to extract the username from the token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)  // Set the key to verify the token
                .build()
                .parseClaimsJws(token)  // Parse the claims of the token
                .getBody()
                .getSubject();  // Extract the subject (username) from the token
    }

    // Method to check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Method to extract the expiration time of the token
    public Date extractExpiration(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();  // Get the expiration time of the token
    }
}