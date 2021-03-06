package com.cohortautomation.utilities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static String getRandomPassword(int length) {
		char[] lowercaseAlphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] upperaseAlphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] specialCharacters = {'!','$','#','%','@','*','&'};
		char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
		
		String password = "";
		
		for(int i=0; i<length; i++)
		{
			int characterArrayChoice = (int) (Math.random()*100)%4;
			
			if(characterArrayChoice == 0) {
				password += Character.toString(lowercaseAlphabets[(int) (Math.random()*100)%26]);
			} else if(characterArrayChoice == 1) {
				password += Character.toString(upperaseAlphabets[(int) (Math.random()*100)%26]);
			} else if(characterArrayChoice == 2) {
				password += Character.toString(specialCharacters[(int) (Math.random()*100)%7]);
			} else if(characterArrayChoice == 3) {
				password += Character.toString(numbers[(int) (Math.random()*100)%10]);
			}
		}
		
		return password;
	}
	
	public static String getHashedLinkForPasswordReset(String key) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(key.getBytes(StandardCharsets.UTF_8));
		
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		
		while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        }
		
		System.out.println(hexString);
		
		return hexString.toString();
	}
}
