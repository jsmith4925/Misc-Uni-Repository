/**
 * Arc.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import java.awt.*;

/**
 *
 * Arc is an arc shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * arc's bounding rectangle
 */
public class Arc extends ClosedShape {
	//The width and height of the arc (major and minor axis)
	private int width, height, startAngle, arcAngle;

	/**
	 * Creates an arc.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the arc (in pixels).
	 * @param height The height of the arc (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the arc is filled with colour, false if opaque.
	 * @param startAngle The beginning angle.
         * @param arcAngle The angular extent of the arc, relative to the start angle.
         */
	public Arc (int insertionTime, int x, int y, int vx, int vy, int width, int height, int arcAngle, int startAngle, Color colour, boolean isFilled) {
		super (insertionTime, x, y, vx, vy, colour, isFilled);
		this.width = width;
		this.height = height;
                this.arcAngle = arcAngle;
                this.startAngle = startAngle;
                
	}

	/**
     * Method to convert an arc to a string.
     */
    public String toString () {
    	String result = "This is an arc\n";
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
 	 * @return The width of the arc.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the arc.
 	 */
 	public int getHeight() {
		return height;
	}
        
        public int getStartAngle(){
                return startAngle;
        }
        
        public int getArcAngle(){
                return arcAngle;
        }

 	/**
 	 * Draw the arc.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (Graphics g) {
		g.setColor (colour);
		if (isFilled) {
			g.fillArc( xPos, yPos, width, height, startAngle, arcAngle);
		} 
		else {
			g.drawArc( xPos, yPos, width, height, startAngle, arcAngle);
		}
	}
}
