package fnum.lk.test2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JFrameLK2_DarianKoehler extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Font fontText = new Font("Tahoma", Font.PLAIN, 12);
	private Font fontFunction = new Font("Tahoma", Font.PLAIN, 16);
	private double a, b, c, d, oldY, oldYa;
	private DecimalFormat df = new DecimalFormat("#0.000");
	private boolean doDraw = false;
	private JTextField tfVarA;
	private JTextField tfVarB;
	private JTextField tfVarC;
	private JTextField tfVarD;
	private JPanel panelTools;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLK2_DarianKoehler frame = new JFrameLK2_DarianKoehler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameLK2_DarianKoehler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 100, 1200, 800);
		setTitle("JFrameLK2_DarianKoehler");
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelTools = new JPanel();
		panelTools.setBounds(20, getHeight()-130, 350, 75);
		panelTools.setBorder(new TitledBorder("Eingabe der Koeffizienten"));
		getContentPane().add(panelTools);
		panelTools.setLayout(new BoxLayout(panelTools, BoxLayout.X_AXIS));
		
		JLabel lblVarA = new JLabel("a =");
		panelTools.add(lblVarA);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(10, 10));
		rigidArea.setMinimumSize(new Dimension(0, 0));
		rigidArea.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea);
		
		tfVarA = new JTextField();
		tfVarA.setMaximumSize(new Dimension(2147483647, 23));
		panelTools.add(tfVarA);
		tfVarA.setColumns(10);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(10, 10));
		rigidArea_1.setMinimumSize(new Dimension(0, 0));
		rigidArea_1.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_1);
		
		JLabel lblVarB = new JLabel("b =");
		panelTools.add(lblVarB);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(10, 10));
		rigidArea_2.setMinimumSize(new Dimension(0, 0));
		rigidArea_2.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_2);
		
		tfVarB = new JTextField();
		tfVarB.setMaximumSize(new Dimension(2147483647, 23));
		panelTools.add(tfVarB);
		tfVarB.setColumns(10);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(10, 10));
		rigidArea_3.setMinimumSize(new Dimension(0, 0));
		rigidArea_3.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_3);
		
		JLabel lblVarC = new JLabel("c =");
		panelTools.add(lblVarC);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(10, 10));
		rigidArea_4.setMinimumSize(new Dimension(0, 0));
		rigidArea_4.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_4);
		
		tfVarC = new JTextField();
		tfVarC.setMaximumSize(new Dimension(2147483647, 23));
		panelTools.add(tfVarC);
		tfVarC.setColumns(10);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_5.setPreferredSize(new Dimension(10, 10));
		rigidArea_5.setMinimumSize(new Dimension(0, 0));
		rigidArea_5.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_5);
		
		JLabel lblVarD = new JLabel("d =");
		panelTools.add(lblVarD);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6.setPreferredSize(new Dimension(10, 10));
		rigidArea_6.setMinimumSize(new Dimension(0, 0));
		rigidArea_6.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_6);
		
		tfVarD = new JTextField();
		tfVarD.setMaximumSize(new Dimension(2147483647, 23));
		panelTools.add(tfVarD);
		tfVarD.setColumns(10);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_7.setMinimumSize(new Dimension(0, 0));
		rigidArea_7.setMaximumSize(new Dimension(0, 0));
		panelTools.add(rigidArea_7);
		
		Box verticalBox = Box.createVerticalBox();
		panelTools.add(verticalBox);
		
		JButton btnDraw = new JButton("Zeichne");
		btnDraw.setMnemonic('z');
		btnDraw.setFocusable(false);
		btnDraw.setMaximumSize(new Dimension(100, 23));
		btnDraw.setPreferredSize(new Dimension(80, 0));
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				doDraw = true;
				setVariables();
			}
		});
		verticalBox.add(btnDraw);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_8.setMinimumSize(new Dimension(0, 0));
		rigidArea_8.setMaximumSize(new Dimension(5, 5));
		verticalBox.add(rigidArea_8);
		
		JButton btnExit = new JButton("Ende");
		btnExit.setMnemonic('e');
		btnExit.setFocusable(false);
		btnExit.setMaximumSize(new Dimension(100, 23));
		btnExit.setPreferredSize(new Dimension(80, 0));
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		verticalBox.add(btnExit);
	}
	
	private double calculate(double x0, double x1) {
		double xStar = 0;
		
		do {
			xStar = x0 - f(x0) * ( (x0 - x1) / (f(x0) - f(x1) ));
			x1 = xStar;
			
		} while(Math.abs(f(xStar)) > 0.0001);
		
		return xStar;
	}
	
	private double calculateAbl(double x0, double x1) {
		double xStar = 0;
		
		do {
			xStar = x0 - fa(x0) * ( (x0 - x1) / (fa(x0) - fa(x1) ));
			x1 = xStar;
			
		} while(Math.abs(fa(xStar)) > 0.0001);
		
		return xStar;
	}
	
	private void setVariables() {
		try {
			a = Double.parseDouble(tfVarA.getText());
			b = Double.parseDouble(tfVarB.getText());
			c = Double.parseDouble(tfVarC.getText());
			d = Double.parseDouble(tfVarD.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Eingabe nicht Korrekt, bitte überprüfen.");
		}
		
		repaint();
	}
	
	private double f(double x) {
		double y = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
		return y;
	}
	
	private double fa(double x) {
		double y = (3*a) * Math.pow(x, 2) + (2*b) * x + c;
		return y;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		int width = getWidth();
		int height = getHeight();
		int diffW = width/24;
		int diffH = height/16;
		
		panelTools.setBounds(20, getHeight()-130, 350, 75);

		g.setFont(fontText);
		
		//Koodinatenkreuz zeichen
		g.setColor(Color.black);
		g.drawLine(0, height/2-4, width, height/2-4);
		g.drawLine(width/2, 0, width/2, height);

		//Beschriftung der Achsen
		g.drawString("x", width-20, height/2-5);
		for(int i = -15; i <= 15; i++) {
			String str = String.valueOf(i);
			if ( i != 0) {
				g.drawString("|" + str, width/2 + i * diffW, height/2+10);				
			}
		}
		
		g.drawString("y", width/2-10, 45);
		for(int i = 10; i >= -10; i--) {
			if (i != 0) {
				//String str = String.valueOf(i); // Werte als String
				g.drawString("- " + i, width/2, ((-i * diffH) + height/2));				
			}
		}
		
		if (doDraw) {
			int counter = 130;
			for(double x = -15; x <= 15; x = x + 0.001) {
				double y = f(x);
				double ya = fa(x);
				if ((oldY > 0 && y < 0) || (oldY < 0 && y > 0) || y == 0) {
					if (x != -15.0) { // Workaround wegen anzeigefehler
						g.drawString("Nullstelle bei: " + df.format(calculate(x-1, x+1)), 50, counter);
						counter += 20;
					}
				}
				if ((oldYa > 0 && ya < 0) || (oldYa < 0 && ya > 0) || ya == 0) {
					if (x != -15.0) { // Workaround wegen anzeigefehler
						g.drawString("Extrempunkt bei: " + df.format(calculateAbl(x-1, x+1)), 50, counter);
						counter += 20;
					}
				}
				g.setFont(fontFunction);
				g.drawString(".", (int) (width/2 + (x * diffW)), height/2 - (int) (y * diffH));
				g.setColor(Color.RED);
				g.drawString(".", (int) (width/2 + (x * diffW)), height/2 - (int) (ya * diffH));
				g.setColor(Color.BLACK);
				oldY = y;
				oldYa= ya;
				g.setFont(fontText);

			}
			g.drawString("Graphische Darstellung der ausgewählten Funktion", 50, 70);
			g.drawString("f(x)=" + a +"x³ + " + b +"x² + " + c + "x + " + d, 50, 90);
			g.drawString("die Nusllstellen der Funktion liegen:", 50, 110);
		}
	}

}
