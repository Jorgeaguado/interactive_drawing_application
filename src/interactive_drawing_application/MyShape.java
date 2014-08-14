package interactive_drawing_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Declaration of class MyShape.
 * 
 * @author Jorge Aguado
 * @version 1.3 Part 3 Project 1
 */
public abstract class MyShape {

	private int x1;// x coordinate of the first point
	private int y1;// y coordinate of the first point
	private int x2;// x coordinate of the second point
	private int y2;// y coordinate of the second point
	private Color myColor;// Color of the shape

	/**
	 * Constructor with default values
	 */
	public MyShape() {
		this.setX1Coord(0);
		this.setX2Coord(0);
		this.setY1Coord(0);
		this.setY2Coord(0);
		this.setColor(Color.BLACK);
	}

	/**
	 * Constructor with input values
	 * 
	 * @param x1
	 *            x-coordinate of first point
	 * @param y1
	 *            y-coordinate of first point
	 * @param x2
	 *            x-coordinate of second point
	 * @param y2
	 *            y-coordinate of second point
	 * @param color
	 *            , It is the color of the shape
	 * @param f
	 *            flag, if it is true the shape is filled
	 */
	public MyShape(int x1, int x2, int y1, int y2, Color color) {
		this.setX1Coord(x1);
		this.setX2Coord(x2);
		this.setY1Coord(y1);
		this.setY2Coord(y2);
		this.setColor(color);
	}

	/**
	 * Abstract Mehotd draw. It is implemented in any of the clases that extends
	 * MyShape
	 */
	public abstract void draw(Graphics g);

	/**
	 * Mehotd getColor
	 * 
	 * @return the color of the shape
	 */
	public Color getColor() {
		return this.myColor;
	}

	/**
	 * Mehotd getX1Coord
	 * 
	 * @return x-coordinate of the first point
	 */
	public int getX1Coord() {
		return this.x1;
	}

	/**
	 * Mehotd getX2Coord
	 * 
	 * @return x-coordinate of the second point
	 */
	public int getX2Coord() {
		return this.x2;
	}

	/**
	 * Mehotd getY1Coord
	 * 
	 * @return y-coordinate of the first point
	 */
	public int getY1Coord() {
		return this.y1;
	}

	/**
	 * Mehotd getY2Coord
	 * 
	 * @return y-coordinate of the second point
	 */
	public int getY2Coord() {
		return this.y2;
	}

	/**
	 * Mehotd setColor, This method set the color
	 */
	public void setColor(Color color) {
		this.myColor = color;
	}

	/**
	 * Mehotd setX1Coord, This method set the x1 coordinate value if it is
	 * greater than or equal to zero
	 */
	public void setX1Coord(int x1) {
		if (x1 >= 0)
			this.x1 = x1;
		else
			this.x1 = 0;
	}

	/**
	 * Mehotd setX2Coord, This method set the X2 coordinate value if it is
	 * greater than or equal to zero
	 */
	public void setX2Coord(int x2) {
		if (x2 >= 0)
			this.x2 = x2;
		else
			this.x2 = 0;
	}

	/**
	 * Mehotd setY1Coord, This method set the y1 coordinate value if it is
	 * greater than or equal to zero
	 */
	public void setY1Coord(int y1) {
		if (y1 >= 0)
			this.y1 = y1;
		else
			this.y1 = 0;
	}

	/**
	 * Mehotd setY2Coord, This method set the y2 coordinate value if it is
	 * greater than or equal to zero
	 */
	public void setY2Coord(int y2) {
		if (y2 >= 0)
			this.y2 = y2;
		else
			this.y2 = 0;
	}

}
