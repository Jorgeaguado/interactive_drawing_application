package interactive_drawing_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Declaration of class MyLine, it extends MyShape
 * 
 * @author Jorge Aguado
 */
public class MyLine extends MyShape {
	/**
	 * Constructor with default values
	 */
	public MyLine() {
		super();// It calls to the contructor of MyShape
	} // end MyLine constructor

	/**
	 * Constructor with input values
	 * 
	 * @param x1
	 *            x-coordinate of first endpoint
	 * @param y1
	 *            y-coordinate of first endpoint
	 * @param x2
	 *            x-coordinate of second endpoint
	 * @param y2
	 *            y-coordinate of second endpoint
	 */
	public MyLine(int x1, int x2, int y1, int y2, Color color) {
		super(x1, x2, y1, y2, color);// It calls to the contructor of MyShape
	} // end MyLine constructor

	/**
	 * Method draw, draws the line. It is an abstract methods in MyShape
	 * 
	 * @param g
	 *            for all graphics contexts
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.drawLine(super.getX1Coord(), super.getY1Coord(), super.getX2Coord(),
				super.getY2Coord());
	} // end method draw
}
