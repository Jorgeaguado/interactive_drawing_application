package interactive_drawing_application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class DrawFrame
 * 
 * @author Jorge Aguado
 */
public class DrawFrame extends JFrame {

	/**
	 * ButtonHandler, used to manage clear and undo buttons
	 */
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "Clear") {
				panel.clearDrawing();

			} else if (event.getActionCommand() == "Undo") {
				panel.clearLastShape();
			}
		}
	}

	/**
	 * CheckBoxHandler, used to manage the button filled
	 */
	private class CheckBoxHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED)
				panel.setFilledShape(true);
			else if (event.getStateChange() == ItemEvent.DESELECTED)
				panel.setFilledShape(false);
		}
	}

	/**
	 * ColorHandler
	 */
	private class ColorHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {

			if (event.getStateChange() == ItemEvent.SELECTED) {
				panel.setCurrentColor(colorNumbers[colourJComboBox
						.getSelectedIndex()]);
			}
		}
	}

	/**
	 * ShapeHandler
	 */
	private class ShapeHandler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				panel.setShapeType(shapeJComboBox.getSelectedIndex());
			}
		}
	}

	// This variables are used in inner classes
	private JComboBox<String> colourJComboBox;

	private JComboBox<String> shapeJComboBox;

	private DrawPanel panel;

	private JCheckBox filled;

	private Color colorNumbers[] = { Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };

	/**
	 * DrawFrame, provides a GUI that enables the user to control various
	 * aspects of drawing
	 */
	public DrawFrame() {
		JLabel labelStatus = new JLabel();// Label at the bottom,
		panel = new DrawPanel(labelStatus);// Panel used to draw shapes
		JPanel flowPanel = new JPanel(new FlowLayout());// Flow layout used to
														// add buttons at the
														// top of the panel
		JFrame frame = new JFrame();
		// Button undo and clear
		JButton bUndo = new JButton("Undo");
		JButton bClear = new JButton("Clear");
		ButtonHandler handler = new ButtonHandler();
		bUndo.addActionListener(handler);
		bClear.addActionListener(handler);
		// Button with a list of colours
		String[] colorNames = { "Black", "Blue", "Cyan", "DarkGrey", "Gray",
				"Green", "LightGray", "Magenta", "Orange", "Pink", "Red",
				"White", "Yellow" };
		colourJComboBox = new JComboBox<String>(colorNames);
		ColorHandler colorh = new ColorHandler();
		colourJComboBox.addItemListener(colorh);
		// Button with a list of shapes
		String[] shapes = { "Line", "Rectangle", "Oval" };
		shapeJComboBox = new JComboBox<String>(shapes);
		ShapeHandler shapeh = new ShapeHandler();
		shapeJComboBox.addItemListener(shapeh);
		// Check button filled
		CheckBoxHandler boxHandler = new CheckBoxHandler();
		JCheckBox filled = new JCheckBox("Filled", false);
		filled.addItemListener(boxHandler);
		// Buttons added to the flow layout
		flowPanel.add(bUndo);
		flowPanel.add(bClear);
		flowPanel.add(colourJComboBox);
		flowPanel.add(shapeJComboBox);
		flowPanel.add(filled);
		// Flowlayout added to the panel
		panel.add(BorderLayout.NORTH, flowPanel);
		// Label and panel added to the frame
		frame.add(labelStatus, BorderLayout.SOUTH);
		frame.add(panel);
		// Parameters of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.setTitle("Interactive Drawing Application");
	}
}
