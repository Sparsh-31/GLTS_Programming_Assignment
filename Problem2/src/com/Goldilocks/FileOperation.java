// 2. Write a program to read a CSV file and print the same in the output file. This csv file contains three columns having numeric value. The output file should additionally contain the sum of these numeric values


// For 


package com.Goldilocks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
	public static void main(String[] args) {
		
		 String inputFile = "C:\Users\kotwa\OneDrive\Desktop\New folder\GLTS_Programming_Assignment\Problem2\src\com\Goldilocks\\Input.csv";
	     String outputFile = "C:\Users\kotwa\OneDrive\Desktop\New folder\GLTS_Programming_Assignment\Problem2\src\com\Goldilocks\\Output.csv";
	
	     readOperation(inputFile,outputFile);
	
	     System.out.println("File Operations Are Completed Successfully.");
	 }
	
	 public static void readOperation(String inputFile, String outputFile) {
	     try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	          BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
	
	         String line;
	         boolean isLine = true;
	
	         while ((line = reader.readLine()) != null) {
	             String[] data = line.split(" ");
	             int sum = 0;
	    	     for (String value : data) {
	    	    	 String trimdata = value.trim();
	    	         sum += Integer.parseInt(trimdata);
	    	     }
	             String newLine = line + " = " + sum;
	
	             if (isLine) {
	                 isLine = false;
	             } else {
	                 writer.newLine();
	             }
	
	             writer.write(newLine);
	         }
	
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	
}