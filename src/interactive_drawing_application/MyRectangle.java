package interactive_drawing_application;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Declaration of class MyRectangle. It extends MyShape
 * 
 * @author Jorge Aguado
 */
public class MyRectangle extends BoundedShape {
	/**
	 * Constructor without arguments and default values
	 */
	public MyRectangle() {
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
	public MyRectangle(int x1, int x2, int y1, int y2, Color color, boolean f) {
		super(x1, x2, y1, y2, color, f);
	}

	/**
	 * Mehotd draw, This method draw an Rectangle using the function drawRect.
	 * It is an abstract method in MyShape.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(super.getColor());
		g.drawRect(super.getUpperLeftX(), super.getUpperLeftY(),
				super.getWidth(), super.getHeight());

		if (super.getFlag())
			g.fillRect(super.getUpperLeftX(), super.getUpperLeftY(),
					super.getWidth(), super.getHeight());
	}

}
