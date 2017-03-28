package KlausurFNUM2_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Rahmen_GUIByMe extends JFrame {

	private static final long serialVersionUID = 1L;
	private Font f1 = new Font("Arial", Font.PLAIN, 13);
	private static boolean jButtonZeichneIsSelected = false;
	private double oldY = 0;
	private JPanel panel;
	private Box verticalBox;
	private Box horizontalBox;
	private JLabel lblAx;
	private JTextField textFieldAx;
	private JLabel lblBx;
	private JTextField textFieldBx;
	private JLabel lblC;
	private JTextField textFieldC;
	private JButton btnDraw;
	private JSeparator separator;
	private Component rigidArea;
	private Component rigidArea_1;
	private Component rigidArea_2;
	private Component rigidArea_3;
	private JPanel panelTools;
	private double a, b, c;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Rahmen_GUIByMe inst = new Rahmen_GUIByMe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Rahmen_GUIByMe() {
		super();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(1200, 800);
		setTitle("JFrameLK2_DarianKoehler");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
//		panel = new JPanelDraw();
//		getContentPane().add(panel, BorderLayout.CENTER);
		
		verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.SOUTH);
		
		separator = new JSeparator();
		verticalBox.add(separator);
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3);
		rigidArea_3.setPreferredSize(new Dimension(5, 5));
		rigidArea_3.setMinimumSize(new Dimension(5, 5));
		rigidArea_3.setMaximumSize(new Dimension(5, 5));
		
		horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		lblAx = new JLabel("ax\u00B2:");
		lblAx.setPreferredSize(new Dimension(50, 14));
		lblAx.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblAx);
		
		textFieldAx = new JTextField();
		textFieldAx.setColumns(10);
		horizontalBox.add(textFieldAx);
		
		lblBx = new JLabel("bx:");
		lblBx.setPreferredSize(new Dimension(50, 14));
		lblBx.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblBx);
		
		textFieldBx = new JTextField();
		textFieldBx.setColumns(10);
		horizontalBox.add(textFieldBx);
		
		lblC = new JLabel("c:");
		lblC.setPreferredSize(new Dimension(50, 14));
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblC);
		
		textFieldC = new JTextField();
		textFieldC.setColumns(10);
		horizontalBox.add(textFieldC);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox.add(rigidArea);
		
		btnDraw = new JButton("Draw!");
		btnDraw.setPreferredSize(new Dimension(250, 23));
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setFunction();
				jButtonZeichneIsSelected = true;
			}
		});
		horizontalBox.add(btnDraw);
		
		rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(5, 5));
		rigidArea_2.setMinimumSize(new Dimension(5, 5));
		rigidArea_2.setMaximumSize(new Dimension(5, 5));
		horizontalBox.add(rigidArea_2);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 5));
		rigidArea_1.setMinimumSize(new Dimension(20, 5));
		rigidArea_1.setMaximumSize(new Dimension(5, 5));
		verticalBox.add(rigidArea_1);
		
		panelTools = new JPanel();
		panelTools.setBounds(20, getHeight()-60, 350, 40);
	}

	public void paint(Graphics g) {
		super.paint(g);
	}
	
	private void setFunction() {
		try {
			a = Double.parseDouble(textFieldAx.getText());
		} catch (NumberFormatException e) {
			textFieldAx.setText("0");
			return;
		} try {
			b = Double.parseDouble(textFieldBx.getText());
		} catch (NumberFormatException e) {
			textFieldBx.setText("0");
			return;
		} try {
			c = Double.parseDouble(textFieldC.getText());
		} catch (NumberFormatException e) {
			textFieldC.setText("0");
			return;
		}
		textFieldAx.setText("");
		textFieldBx.setText("");
		textFieldC.setText("");		
		panel.repaint();
	}
	
	private double f(double x) {
		double y = a * Math.pow(x, 2) + b * x + c;
		return y;
	}
	
	private class JPanelDraw extends JPanel {
		
		private static final long serialVersionUID = 1L;

		public JPanelDraw() {
			setBounds(44, 442, 161, 205);
			setLayout(null);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
//			g.setFont(new Font("Helvetica", Font.PLAIN, 12));
//
//			//Koodinatenkreuz zeichen
//			g.setColor(Color.black);
//			g.drawLine(0, height/2-4, width, height/2-4);
//			g.drawLine(width/2, 0, width/2, height);
//
//			//Beschriftung der Achsen
//			g.setFont(f1);
//			g.drawString("x", width-10, height/2-5);
//			for(int i = -15; i <= 15; i++) {
//				String str = String.valueOf(i);
//				if ( i != 0) {
//					g.drawString("|" + str, width/2 + i * 50, height/2+10);				
//				}
//			}
//			
//			g.drawString("y", width/2-10, 10);
//			for(int i = 10; i >= -10; i--) {
//				if (i != 0) {
//					//String str = String.valueOf(i); // Werte als String
//					g.drawString("- " + i, width/2, ((-i * 50) + height/2));				
//				}
//			}
//			
//			if (jButtonZeichneIsSelected) {
//				int counter = 80;
//				for(double x = -15; x <= 15; x = x + 0.0001) {
//					double y = f(x);
//					if ((oldY > 0 && y < 0) || (oldY < 0 && y > 0) || y == 0) {
//						g.drawString("Nullstelle bei: " + x, 50, counter);
//						counter += 30;
//					}
//					g.drawString("'", (int) (width/2 + (x * 50)), height/2 - (int) (y * 50));
//					oldY = y;
//
//				}
//				g.drawString("f(x)=" + a +"x² + " + b +"x + " + c, 50, 50);
//			}
		}
	}
}
