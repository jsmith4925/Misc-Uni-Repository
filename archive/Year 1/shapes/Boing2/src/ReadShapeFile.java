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
     
	//TODO:  You will likely need to write four methods here.  One method to construct each shape
	//given the Scanner passed as a parameter.  I would suggest four static methods in this case.
	private static Circle constructCircle(int x, int y, int vx, int vy, boolean isFilled, int diameter, Color colour, int insertionTime) {
            
            //System.out.println ("Shape: Circle, " + x + y + vx + vy + isFilled + diameter + colour + insertionTime);
            
            Circle newCircle = new Circle (insertionTime, x, y, vx, vy, diameter, colour, isFilled);
            
            newCircle.toString();
            System.out.println(newCircle);
            
            return newCircle;
        }
        
        private static Oval constructOval(int x, int y, int vx, int vy, boolean isFilled, int width, int height, Color colour, int insertionTime) {
            
           // System.out.println ("Shape: Oval, " + x + y + vx + vy + isFilled + width + height + colour + insertionTime);
            
            Oval newOval = new Oval (insertionTime, x, y, vx, vy, width, height, colour, isFilled);
            
            newOval.toString();
            System.out.println(newOval);
            
            return newOval;
        }
        
        private static Square constructSquare(int x, int y, int vx, int vy, boolean isFilled, int side, Color colour, int insertionTime) {
            
            Square newSquare = new Square (insertionTime, x, y, vx, vy, side, colour, isFilled);
            
            newSquare.toString();
            System.out.println(newSquare);
            
            return newSquare;
        }
        
        private static Rect constructRect(int x, int y, int vx, int vy, boolean isFilled, int width, int height, Color colour, int insertionTime) {
               
            Rect newRect = new Rect (insertionTime, x, y, vx, vy, width, height, colour, isFilled);
            
            newRect.toString();
            System.out.println(newRect);
            
            return newRect;
        }
        
        private static Arc constructArc(int x, int y, int vx, int vy, boolean isFilled, int width, int height, int arcAngle, int startAngle, Color colour, int insertionTime) {
               
            Arc newArc = new Arc (insertionTime, x, y, vx, vy, width, height, arcAngle, startAngle ,colour, isFilled);
            
            newArc.toString();
            System.out.println(newArc);
            
            return newArc;
        }
        
        

            
            
    
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile (Scanner in) {
		Queue shapeQueue = new Queue ();
		
		while (in.hasNext()){

                    String name = in.next ();
                    
                    int x;
                    int y;
                    int vx;
                    int vy;
                    boolean isFilled;
                    int diameter;
                    int width;
                    int height;
                    int side;
                    int r;
                    int g;
                    int b;
                    int arcAngle;
                    int startAngle;
                    Color colour;
                    int insertionTime;
                    
                    switch (name) {
                        case "circle" : x = in.nextInt();
                                        y = in.nextInt();
                                        vx = in.nextInt();
                                        vy = in.nextInt();
                                        isFilled = in.nextBoolean();
                                        diameter = in.nextInt();
                                        r = in.nextInt();
                                        g = in.nextInt();
                                        b = in.nextInt();
                                        colour = new Color(r, g, b);
                                        insertionTime = in.nextInt();
                                        shapeQueue.enqueue(constructCircle(x, y, vx, vy, isFilled, diameter, colour, insertionTime));
                                        break;                                        
                        case "oval" :   x = in.nextInt();
                                        y = in.nextInt();
                                        vx = in.nextInt();
                                        vy = in.nextInt();
                                        isFilled = in.nextBoolean();
                                        width = in.nextInt();
                                        height = in.nextInt();
                                        r = in.nextInt();
                                        g = in.nextInt();
                                        b = in.nextInt();
                                        colour = new Color(r, g, b);
                                        insertionTime = in.nextInt();
                                        shapeQueue.enqueue(constructOval(x, y, vx, vy, isFilled, width, height, colour, insertionTime));
                                        break;
                        case "square":  x = in.nextInt();
                                        y = in.nextInt();
                                        vx = in.nextInt();
                                        vy = in.nextInt();
                                        isFilled = in.nextBoolean();
                                        side = in.nextInt();
                                        r = in.nextInt();
                                        g = in.nextInt();
                                        b = in.nextInt();
                                        colour = new Color(r, g, b);
                                        insertionTime = in.nextInt();
                                        shapeQueue.enqueue(constructSquare(x, y, vx, vy, isFilled, side, colour, insertionTime));
                                        break;
                        case "rect":    x = in.nextInt();
                                        y = in.nextInt();
                                        vx = in.nextInt();
                                        vy = in.nextInt();
                                        isFilled = in.nextBoolean();
                                        width = in.nextInt();
                                        height = in.nextInt();
                                        r = in.nextInt();
                                        g = in.nextInt();
                                        b = in.nextInt();
                                        colour = new Color(r, g, b);
                                        insertionTime = in.nextInt();
                                        shapeQueue.enqueue(constructRect(x, y, vx, vy, isFilled, width, height, colour, insertionTime));
                                        break;
                        case "arc":     x = in.nextInt();
                                        y = in.nextInt();
                                        vx = in.nextInt();
                                        vy = in.nextInt();
                                        isFilled = in.nextBoolean();
                                        width = in.nextInt();
                                        height = in.nextInt();
                                        arcAngle = in.nextInt();
                                        startAngle = in.nextInt();
                                        r = in.nextInt();
                                        g = in.nextInt();
                                        b = in.nextInt();
                                        colour = new Color(r, g, b);
                                        insertionTime = in.nextInt();
                                        shapeQueue.enqueue(constructArc(x, y, vx, vy, isFilled, width, height, arcAngle, startAngle, colour, insertionTime));
                                        break;                
                                        
                        default:        System.out.print("No More Shapes");
                                        break;
                    }
                               
                }
 
             
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
		File inputFile = new File (filename);
                Scanner in = null;
                try {
                    in = new Scanner (inputFile);//TODO: Change this to construct a proper scanner.
                }
                catch (FileNotFoundException e) {
                    System.out.println ("Cannot open " + filename);
                    System.exit (0);
                }
                  
		//TODO:  Read the input file specified by "filename" and return a queue containing
		//All of the shapes specified in this file
		
		//WARNING:  Do not put all of the code to read the file in this method.  Please,
		//break it up into smaller methods.  If you put all the code to read the file here
		//you'll lose style marks and it will be much, much harder to program.  
		
		return ReadShapeFile.readDataFile(in);
	}

}