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

public class ReadShapeFile {
	
	public static constructCircle() {
		
	}
	
	//TODO:  You will likely need to write four methods here.  One method to construct each shape
	//given the Scanner passed as a parameter.  I would suggest four static methods in this case.
	
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
		
		java.io.File file = new java.io.File(filename);
		
		ArrayList<Shapes> shapeData = new ArrayList<>();
		
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
				
			System.out.println ("Shape: %s, %d, %d %d, %d, %d, %d" + color + " " + isFilled);
						
			
		}
		catch (FileNotFoundException e) {
			System.err.format("Cannot find file");
			
		}
	}
		return ReadShapeFile.readDataFile(in);
	}
}