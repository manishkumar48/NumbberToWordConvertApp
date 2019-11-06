package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {


	public static void main(String[] args) {
		
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
         
       String name;
		try {
			System.out.print("Enter the number :");  
			name = reader.readLine();
			System.out.println("Converted word is==>>>    " + NumberToWordConverter.convertToWord(name));
	
		} catch (IOException e) {
			e.printStackTrace();
		} 
  
      
	}

}