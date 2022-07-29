/*
 * Class: CMSC203 CRN 46519
 * Instructor: Farnaz Eivazi
 * Description: 
 * Due: 7/28/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   Print your Name here: Philip Song
*/

public class HolidayBonus extends java.lang.Object {
	
	public HolidayBonus() {};
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		/**
		 * get sum of each row
		 * 
		 * */
		
		double[][] bonus = new double[data.length][];	// 2D array that contains each store's bonus
		
		for(int row = 0; row < bonus.length; row++) 
		{
			bonus[row] = new double[data[row].length];	// adds columns to bonus array
			
			for (int column = 0; column < bonus[row].length; column++) 
			{ 
				if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column))
					bonus[row][column] = high;
				
				else if (data[row][column] <= 0) 
					bonus[row][column] = 0;
				
				else if ( (data[row][column] > 0) && (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)) )
						bonus[row][column] = low;
				
				else
					bonus[row][column] = other;
			}
		}
		
		double[] holidayBonus = new double[bonus.length];	// array that contains total bonus of each store
		
		for (int i = 0; i < data.length; i++)
			holidayBonus[i] = TwoDimRaggedArrayUtility.getRowTotal(bonus, i);
		
		
		return holidayBonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double sum = 0;
		double[] holidayBonus = calculateHolidayBonus(data, high, low, other);
		
		for (int i = 0; i < holidayBonus.length; i++) 
			sum += holidayBonus[i];
		
		return sum;
	}
	
}