/**
 * Rect.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import java.awt.*;

/**
 *
 * Rect is an rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle's bounding rectangle
 */
public class Rect extends ClosedShape {
	//The width and height of the rectangle (major and minor axis)
	private int width, height;

	/**
	 * Creates an rectangle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the rectangle (in pixels).
	 * @param height The height of the rectangle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the rectangle is filled with colour, false if opaque.
	 */
	public Rect (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
		super (insertionTime, x, y, vx, vy, colour, isFilled);
		this.width = width;
		this.height = height;
	}

	/**
     * Method to convert an rectangle to a string.
     */
    public String toString () {
    	String result = "This is a rectangle\n";
    	result += super.toString ();
	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * @return The width of the rectangle.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the rectangle.
 	 */
 	public int getHeight() {
		return height;
	}

 	/**
 	 * Draw the rectangle.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (Graphics g) {
		g.setColor (colour);
		if (isFilled) {
			g.fillRect( xPos, yPos, width, height );
		} 
		else {
			g.drawRect( xPos, yPos, width, height );
		}
	}
}
