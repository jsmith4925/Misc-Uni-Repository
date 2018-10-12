/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import java.awt.Color;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadShapeFile {
	
	//TODO:  You will likely need to write four methods here.  One method to construct each shape
	//given the Scanner passed as a parameter.  I would suggest four static methods in this case.
	public static constructCircle() {
		java.io.File file = new java.io.File(filename);
		ArrayList<Circle> circleData = new ArrayList<>();
		
		try {
			Scanner in = new Scanner (file);
			
			String name = in.next();
			int x = in.nextInt();
			int y = in.nextInt();
			int vx = in.nextInt();
			int vy = in.nextInt();
			boolean isFilled = in.nextBoolean();
			int diameter = in.nextInt();
			int r = in.nextInt();
			int g = in.nextInt();
			int b = in.nextInt();
			Color color = new Color(r, g, b);
			int insertionTime = in.nextInt();
				
			System.out.println ("Shape: " + name + x + y + vx + vy + isFilled + diameter + color + insertionTime);
			
			Circle circleOne = new Circle(insertionTime, x, y, vx, vy, diameter, color, isFilled);
			toString();
		}
		catch (FileNotFoundException e) {
			System.err.format("Cannot find file");
			
		}
	}
	
	public static constructOval() {
		java.io.File file = new java.io.File(filename);
		ArrayList<Oval> ovalData = new ArrayList<>();
		
		try {
			Scanner in = new Scanner (file);
			
			String name = in.next();
			int x = in.nextInt();
			int y = in.nextInt();
			int vx = in.nextInt();
			int vy = in.nextInt();
			boolean isFilled = in.nextBoolean();
			int width = in.nextInt();
			int height = in.nextInt();
			int r = in.nextInt();
			int g = in.nextInt();
			int b = in.nextInt();
			Color color = new Color(r, g, b);
			int insertionTime = in.nextInt();
				
			System.out.println ("Shape: " + name + x + y + vx + vy + isFilled + width + height + color + insertionTime);
			
			Oval ovalOne = new oval(insertionTime, x, y, vx, vy, width, height, color, isFilled);
			toString();
		}
		catch (FileNotFoundException e) {
			System.err.format("Cannot find file");
			
		}
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile (Scanner in) {
		Queue shapeQueue = new Queue ();
		
		//TODO:  Your loop goes here.
		
		return shapeQueue;
	}
	
	/**
	 * Method to read the file and return a queue of shapes from this file.  The program should handle
	 * the file not found exception here and shut down the program gracefully.
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue readFile (String filename) {
		//HINT:  You might want to open a file here.
		Scanner in = null; //TODO: Change this to construct a proper scanner.
		
		//TODO:  Read the input file specified by "filename" and return a queue containing
		//All of the shapes specified in this file
		
		//WARNING:  Do not put all of the code to read the file in this method.  Please,
		//break it up into smaller methods.  If you put all the code to read the file here
		//you'll lose style marks and it will be much, much harder to program.  
		
		return ReadShapeFile.readDataFile(in);
	}
}