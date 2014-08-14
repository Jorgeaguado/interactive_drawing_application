package interactive_drawing_application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class DrawPanel
 * 
 * @author Jorge Aguado
 */
public class DrawPanel extends JPanel {

	/**
	 * Class MouseHandler used to track mouse events
	 */
	private class MouseHandler extends MouseAdapter implements
			MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent event) {
			currentShape.setX2Coord(event.getX());
			currentShape.setY2Coord(event.getY());
			statusLabel.setText(String.format("Moved at [%d, %d]",
					event.getX(), event.getY()));
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			statusLabel.setText(String.format("Moved at [%d, %d]",
					event.getX(), event.getY()));
		}

		@Override
		public void mousePressed(MouseEvent event) {
			MyShape auxShape = null;
			if (getShapeType() == 0)// It is a line
				auxShape = new MyLine(event.getX(), event.getX(), event.getY(),
						event.getY(), currentColor);
			else if (getShapeType() == 1)// It is an oval
				auxShape = new MyRectangle(event.getX(), event.getX(),
						event.getY(), event.getY(), currentColor, filledShape);
			else if (getShapeType() == 2)// It is a rectangule
				auxShape = new MyOval(event.getX(), event.getX(), event.getY(),
						event.getY(), currentColor, filledShape);

			setCurrentShape(auxShape);

		}

		@Override
		public void mouseReleased(MouseEvent event) {
			currentShape.setX2Coord(event.getX());
			currentShape.setY2Coord(event.getY());
			addShape(currentShape);
			setCurrentShape(null);
			repaint();
		}
	}

	private MyShape shapes[];// An array of type MyShape. Max 100 shapes
	private int shapeCount;// Numbers of shapes used in the array shapes[]
	private int shapeType;// 0- Line, 1- Rectangle, 2- Oval
	private MyShape currentShape;// The current shape the user is drawing
	private Color currentColor;// The current color drawing
	private boolean filledShape;// True - the shape is filled

	private JLabel statusLabel;// The status bar

	/**
	 * Constructor, creates a panel and initialize variables
	 * 
	 * @param status
	 *            , number of shapes specified in a input dialog
	 */
	public DrawPanel(JLabel status) {
		try {
			if (status != null) {
				this.statusLabel = status;
				this.shapes = new MyShape[100];
				this.shapeCount = 0;
				this.shapeType = 0;
				this.currentShape = null;
				this.filledShape = false;
				this.currentColor = Color.BLACK;

				setBackground(Color.WHITE);// Set the default color background
				MouseHandler handler = new MouseHandler();
				addMouseListener(handler);
				addMouseMotionListener(handler);
			} else
				throw null;
		} catch (NullPointerException NullPointerException) {
			System.err.printf("\nException: in contructor DrawPanel %s\n",
					NullPointerException);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	} // end DrawPanel constructor

	/**
	 * Method addShape
	 * 
	 * @parameter shape, it is added to the private vector shapes
	 */
	protected void addShape(MyShape shape) {
		if (this.shapeCount < 100) {
			this.shapes[this.getShapeCount()] = shape;
			this.shapeCount++;
		}
	}

	/**
	 * Method clearDrawing
	 */
	public void clearDrawing() {
		this.shapeCount = 0;
		this.repaint();
	}

	/**
	 * Method clearLastShape
	 */
	public void clearLastShape() {
		if (this.getShapeCount() > 0) {
			this.shapeCount--;
			this.repaint();
		}
	}

	/**
	 * Method currentShapePaint, draw the carruent shape
	 * 
	 * @parameter g, used to draw objects
	 */
	public void currentShapePaint(Graphics g) {
		if (this.getCurrentShape() != null)
			this.getCurrentShape().draw(g);
	}

	/**
	 * Method getCurrentColor
	 * 
	 * @return the value of the private variable currentColor
	 */
	public Color getCurrentColor(Color c) {
		return this.currentColor;
	}

	/**
	 * Method getCurrentShape,
	 * 
	 * @return the value of the private variable currentShape
	 */
	public MyShape getCurrentShape() {
		return this.currentShape;
	}

	/**
	 * Method getFilledShape
	 * 
	 * @parameter filled, Yes- The shape is filled
	 */
	public boolean getFilledShape(boolean filled) {
		return this.filledShape;
	}

	/**
	 * Method getShape
	 * 
	 * @return the shape of the position 'pos'
	 * @exception NullPointerException
	 *                , when pos parameter is not between 0 and 100
	 * @parameter pos, position of the private array where is the shape to be
	 *            returned
	 */
	public MyShape getShape(int pos) {
		MyShape localShape = null;
		try {
			if (pos >= 0 && pos < 100 && pos < this.getShapeCount())
				localShape = this.shapes[pos];
			else
				throw null;
		} catch (NullPointerException NullPointerException) {
			System.err.printf("\nException: in method getShape %s\n",
					NullPointerException);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return localShape;
	}

	/**
	 * Method getShapeCount
	 * 
	 * @return an integer, the number of the shapes
	 */
	public int getShapeCount() {
		return this.shapeCount;
	}

	/**
	 * Method getShapeType
	 * 
	 * @return an integer, 0- Line 1- Rectangle 2- Oval
	 */
	public int getShapeType() {
		return this.shapeType;

	}

	/**
	 * Method paintComponent, draw every shape of the array and call to draw the
	 * current shape
	 * 
	 * @parameter g, used to draw objects
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.getShapeCount(); i++)
			this.getShape(i).draw(g);

		this.currentShapePaint(g);
	}

	/**
	 * Method setCurrentColor, set the color passed as a parameter
	 * 
	 * @parameter c, this is set in the private parameter currentColor
	 */
	public void setCurrentColor(Color c) {
		this.currentColor = c;
	}

	/**
	 * Method setCurrentShape, set as a current the shape passed as a parameter
	 * 
	 * @parameter shape, this is set in the private parameter currentShape
	 */
	public void setCurrentShape(MyShape shape) {
		this.currentShape = shape;
	}

	/**
	 * Method setFilledShape
	 * 
	 * @parameter filled True- the shape is filled
	 */
	public void setFilledShape(boolean filled) {
		this.filledShape = filled;
	}

	/**
	 * Method setShapeType, set the color passed as a parameter
	 * 
	 * @parameter shape, this is set in the private parameter currentShape
	 */
	public void setShapeType(int type) {
		this.shapeType = type;
	}
}
