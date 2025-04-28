package com.elasticpath.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
		
		/*
		 * String secret = "4SYypzLLiTSGoeLZAob498yIK3y2PoARMtpyaxgHzu"; String token =
		 * Jwts.builder() .setSubject("test-user") .claim("scope", "read write")
		 * .setIssuedAt(new Date()) .setExpiration(new Date(System.currentTimeMillis() +
		 * 3600000)) // 1 hour .signWith(SignatureAlgorithm.HS256, secret.getBytes())
		 * .compact();
		 * 
		 * System.out.println("Bearer " + token);
		 */
	}

}
