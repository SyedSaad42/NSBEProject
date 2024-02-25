/**
 * Programme Name:detector.java
 * Purpose:
 * @author      Syed Saad Qadeer
 * Date:        Feb 24, 2024
 */
import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
public class detector {

	/*
	Method name: main
	Purpose:
	Accepts:
	Return: void
	*/
	 static int counter = 25;

	public static void main(String[] args) throws IOException, InterruptedException {

		final double LATOFCAR = 2.000000078 , LONGOFCAR = 1.9000000054;
		String filename="C:\\Users\\saads\\OneDrive\\Desktop\\co-ordinatelist.txt";
		double firstValue =0.0;
		double secondValue =0.0;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line using comma as delimiter
                String[] parts = line.split(",");
                if (parts.length == 2) { // Ensure that there are two parts
                    // Parse and print the double values
                     firstValue = Double.parseDouble(parts[0]);
                     secondValue = Double.parseDouble(parts[1]);
                     System.out.println(isInRange(firstValue,secondValue,LATOFCAR,LONGOFCAR));
                     Thread.sleep(1000);
                     
                }
            }
            	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("You can drive now !, Have a safe journey.");
		
	
	      
	}
	//End main method
	
   public static double threshlat(double a) {
		
		
		 
		double A_latitude=a;
				
		int distance =300;
		
		double lat_diff = distance/(111.0*1000);
		
		double finalthreshlat=A_latitude+lat_diff;
		
		return finalthreshlat;
		
	}
	
public static double threshlong(double b) {
		
		double A_longitude=b;
				
		int distance =300;
		
		double long_diff = distance/(111*1000 * cos(toRadians(A_longitude)));
		
		double finalthreshlong=A_longitude+long_diff;
		
		return finalthreshlong;
		
	}
	public static String isInRange(double a, double b,double A, double B) throws InterruptedException {
		
		 double latcod= threshlat(a);
		 double longcod =threshlat(b);
		
		if(A <=latcod  &&B <=longcod) {
			 Thread.sleep(1000);
				counter-=5;
				if (counter < 0) {
	                counter = 0;
	            }
			String message = "Alarm!Pull over to your left or right an ambulance is coming in "+counter+" sec.";
			
			return message;
	
		 }
		return "Keep driving...";
	
	}
	
	
}
//End of class