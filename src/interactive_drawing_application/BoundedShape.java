package interactive_drawing_application;

import java.awt.Color;

/**
 * Declaration of class MyShape.
 * 
 * @author Jorge Aguado
 */
public abstract class BoundedShape extends MyShape {
	private boolean flag;// flag, if it is true the shape is filled

	/**
	 * Constructor with default values
	 */
	public BoundedShape() {
		super();
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
	public BoundedShape(int x1, int x2, int y1, int y2, Color color, boolean f) {
		super(x1, x2, y1, y2, color);
		this.setFlag(f);
	}

	/**
	 * Mehotd getFlag
	 * 
	 * @return the flag. If it is true the shape is filled
	 */
	public boolean getFlag() {
		return this.flag;
	}

	/**
	 * Mehotd getHeight
	 * 
	 * @return The height, it is the absolute value of the difference between
	 *         the two y-coordinate values
	 */
	public int getHeight() {
		return Math.abs(super.getY2Coord() - super.getY1Coord()); // Absolute
																	// value of
																	// the
																	// difference
	}

	/**
	 * Mehotd getUpperLeftX,
	 * 
	 * @return the upper-left x-coordinate, it is the smaller of the two
	 *         x-coordinate values
	 */
	public int getUpperLeftX() {
		if (super.getX1Coord() < super.getX2Coord()) // If x1 is smaller than x2
			return super.getX1Coord();
		else
			return super.getX2Coord();
	}

	/**
	 * Mehotd getUpperLeftY
	 * 
	 * @return The upper-left y-coordinate, it is the smaller of the two
	 *         y-coordinate values
	 */
	public int getUpperLeftY() {
		if (super.getY1Coord() < super.getY2Coord()) // If y1 is smaller than y2
			return super.getY1Coord();
		else
			return super.getY2Coord();
	}

	/**
	 * Mehotd getWidth
	 * 
	 * @return The width, it is the absolute value of the difference between the
	 *         two x-coordinate values
	 */
	public int getWidth() {
		return Math.abs(super.getX2Coord() - super.getX1Coord()); // Absolute
																	// value of
																	// the
																	// difference
	}

	/**
	 * Mehotd setFlag, This method set the flag. If it is true the shape is
	 * filled
	 */
	public void setFlag(boolean f) {
		this.flag = f;
	}
}
