package com.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class passwordEncoder_service {
	public static String encodePassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes(StandardCharsets.UTF_8));
	        byte[] digest = md.digest();
	        StringBuilder sb = new StringBuilder();
	        for (byte i : digest) {
	        	String hex = Integer.toHexString(0xff & i);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
	        }
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		
	}
	public static boolean checkPassword(String password, String encodedPassword) {
		return encodePassword(password).equals(encodedPassword);
	}
}
