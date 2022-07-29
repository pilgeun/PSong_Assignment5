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

import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility extends java.lang.Object {

	public TwoDimRaggedArrayUtility() {}
	
	public static double getAverage(double[][] data) {
		double sum = getTotal(data);	
		int count = 0;	// number of values in 2D array
		
		for (int row = 0; row < data.length; row++) 
			count += data[row].length;	// adds of columns in each row
		
		return sum / count;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0;
		
		for (int row = 0; row < data.length; row++) 
		{
			try {
				colTotal += data[row][col];
			} catch(Exception e) {
				continue;
			}
		}
		return colTotal;
	}
	
	public static double getHighestInArray(double[][] data) {
		double max = data[0][0],	
				rowMax;		// maximum in row
		
		for (int row = 0; row < data.length; row++) { 
			/* 
			 * compares the highest value in each each row, 
			 * then finds the maximum of those values
			 */
			
			rowMax = getHighestInRow(data,row);
			
			if (max < rowMax)
				max = rowMax;
		}
		
		return max;
	}
	
	public static double getLowestInArray(double[][] data) {
		double min = data[0][0], 
				rowMin;		// minimum value in row
		
		for (int row = 0; row < data.length; row++) { 
			/* 
			 * compares the lowest value in each each row, 
			 * then finds the minimum of those values
			 */
			
			rowMin = getLowestInRow(data,row);
			
			if (min > rowMin)
				min = rowMin;
		}
		
		return min;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
	
		return data[getHighestInColumnIndex(data, col)][col];
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = getLowestInArray(data);
		int highestInColumnIndex = 0;
		
		for (int row = 0; row < data.length; row++) 
		{ 
			try {
				if (max < data[row][col]) 
				{
					max = data[row][col];
					highestInColumnIndex = row;
				}
			} catch(Exception e) {
				continue;
			}
		} 
		
		return highestInColumnIndex;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		
		return data[row][getHighestInRowIndex(data, row)];
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = data[0][0];
		int highestInRowIndex = 0;

		for (int column = 0; column < data[row].length; column++) 
		{ 
			try {
				max = data[row][column];
				break;
			} catch(Exception e) {
				continue;
			}
		}
				
		for (int column = 0; column < data[row].length; column++) 
		{ 
			if (max < data[row][column]) {
				max = data[row][column];
				highestInRowIndex = column;
			}
		} 
		
		return highestInRowIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		return data[getLowestInColumnIndex(data,col)][col];
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = getHighestInArray(data);
		int lowestInColumnIndex = 0;
		
		for (int row = 0; row < data.length; row++) 
		{ 
			try {
				if (min > data[row][col]) 
				{
					min = data[row][col];
					lowestInColumnIndex = row;
				}
			} catch(Exception e) {
				continue;
			}
		}
		
		return lowestInColumnIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		
		return data[row][getLowestInRowIndex(data, row)];
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = data[0][0];
		int lowestInRowIndex = 0;
		
		for (int column = 0; column < data[row].length; column++) 
		{ 
			if (min > data[row][column]) {
				min = data[row][column];
				lowestInRowIndex = column;
			}
		} 
		
		return lowestInRowIndex;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		
		for (int column = 0; column < data[row].length; column++) 
			rowTotal += data[row][column];
		
		return rowTotal;
	}
	
	public static double getTotal(double[][] data) {
		double sum = 0;
		
		for (int row = 0; row < data.length; row++) 
		{ 
			for (int column = 0; column < data[row].length; column++) 
				sum += data[row][column];
		} 
		 
		return sum;
	}
	
	
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {
		Scanner inputFile = new Scanner(file);
		
		String[][] tempArray = new String[10][10];
		
		String str;
		int numRows = 0;
		
		while (inputFile.hasNextLine()) {
			tempArray[numRows] = inputFile.nextLine().split(" ");
			numRows++;
		}
		
		double[][]array = new double[numRows][];
		
		for (int row = 0; row < array.length; row++) 
		{ 
			array[row] = new double[tempArray[row].length];	// add columns to double array
			
			for (int column = 0; column < array[row].length; column++) 
			{ 
				array[row][column] = Double.parseDouble(tempArray[row][column]);
			}
		}
		
		inputFile.close();
		return array;
	}
	
	
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		
		PrintWriter newFile = new PrintWriter(outputFile);
		
		for (int row = 0; row < data.length; row++) 
		{ 
			for (int column = 0; column < data[row].length; column++) 
				newFile.print(data[row][column] + " ");
				
			newFile.println();
		} 
		
		newFile.close();
	}
	
}