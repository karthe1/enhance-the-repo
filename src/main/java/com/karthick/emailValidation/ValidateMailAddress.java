package com.karthick.emailValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * 
 * @author zkarrxx
 *
 * This application validating the input mail address.
 */
public class ValidateMailAddress {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
    	System.out.println(emailValidation(line));
    }
  }
  
  private static boolean emailValidation(String emailAddress) {
	  
	  boolean valid = false;
	  
	  String[] emailInfo = emailAddress.split("@");
	  
	  if(emailInfo.length == 2) {
		  String emailName = emailInfo[0]; 
		  boolean firstMatch = Pattern.compile("[A-z|0-9|\\.|\\_]+").matcher(emailName).matches();
		  String postEmailString = emailInfo[1];
		  boolean secondMatch = Pattern.compile("[a-z|\\-]+(?=(\\.com$|\\.net$|\\.org$))").matcher(postEmailString).find();
		  if(firstMatch && secondMatch) {
			  valid = true;
		  }
	  }
	  
	  return valid;
  }
  
}