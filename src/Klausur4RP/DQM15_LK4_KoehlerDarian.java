/* Darian Köhler */
package Klausur4RP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class DQM15_LK4_KoehlerDarian extends JFrame {

	private static final long serialVersionUID = 1L;

	/* Final variables */
	private static final double PRICE = 1;			// Preis Pro Kugel
	private static final double TAXOUT = 7;			// Steuer wenn "zum mitnehmen"
	private static final double TAXIN = 19;			// Steier wenn "hier essen"

	private static final double WAFFEL = 0;			// Waffel Kosten
	private static final double PAPPBECHER = 0.3;	// Pappbecher Kosten
	private static final double SCHALE = 0.5;		// Schalen Kosten

	private static final double SAHNE = 0.5;		// Kosten für Sahne
	private static final double STREUSEL = 0.2;		// Kosten für Streusel
	private static final double KROKANT = 0.2;		// Kosten für Krokant

	/* Variables for calculation */
	private static int amount = 0;					// Anzahl der Eiskugeln
	private static double brutto = 0;				// Bruttopreis
	private static double netto = 0;				// Nettopreis
	private static double tax = 0;					// Mehrwertssteuern
	private static double containerprice = 0;		// Preis für den ausgewählten Behälter 

	/* Objects */
	private JPanel contentPane;
	private JLabel labelAmount;
	private JTextField textFieldAmount;
	private JComboBox<Object> comboBoxType;
	private JCheckBox checkBoxSahne;
	private JCheckBox checkBoxStreusel;
	private JCheckBox checkBoxKrokant;
	private JPanel panelIce;
	private JPanel panelPriceFinal;
	private JCheckBox checkBoxOutOfHouse;
	private JLabel labelNettoFinal;
	private JLabel labelTaxFinal;
	private JLabel labelBruttoFinal;
	private JLabel labelNetto;
	private JLabel labelTax;
	private JLabel labelBrutto;
	private JButton buttonGo;
	private JButton buttonUndo;
	private JPanel panelOut;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DQM15_LK4_KoehlerDarian frame = new DQM15_LK4_KoehlerDarian();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DQM15_LK4_KoehlerDarian() {
		setTitle("Eis 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Panel Eis */
		panelIce = new JPanel();
		panelIce.setToolTipText("Angaben zum Eis");
		panelIce.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelIce.setBounds(6, 11, 154, 156);
		contentPane.add(panelIce);
		panelIce.setLayout(null);

		labelAmount = new JLabel("Kuglen:");
		labelAmount.setToolTipText("Erl\u00E4uterung des rechten Textfeldes");
		labelAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelAmount.setBounds(6, 15, 46, 20);
		panelIce.add(labelAmount);

		comboBoxType = new JComboBox<Object>(getComboBoxData());
		comboBoxType.setToolTipText("Wahl des Beh\u00E4lters");
		comboBoxType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();

			}

		});
		comboBoxType.setBounds(6, 47, 142, 20);
		panelIce.add(comboBoxType);

		textFieldAmount = new JTextField();
		textFieldAmount.setToolTipText("Anzahl der Eis Kugeln");
		textFieldAmount.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				//Überprüft ob die Eingabe eine Zahl ist
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
					
				}
				calculate();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				calculate();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				calculate();

			}


		});
		textFieldAmount.setBounds(62, 16, 86, 20);
		panelIce.add(textFieldAmount);
		textFieldAmount.setColumns(10);

		checkBoxSahne = new JCheckBox("Sahne");
		checkBoxSahne.setMnemonic('Q');
		checkBoxSahne.setToolTipText("Sahne - ja/nein");
		checkBoxSahne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();

			}

		});
		checkBoxSahne.setBounds(6, 74, 109, 23);
		panelIce.add(checkBoxSahne);

		checkBoxStreusel = new JCheckBox("Streusel");
		checkBoxStreusel.setToolTipText("Streusel - ja/nein");
		checkBoxStreusel.setMnemonic('W');
		checkBoxStreusel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();

			}

		});
		checkBoxStreusel.setBounds(6, 100, 109, 23);
		panelIce.add(checkBoxStreusel);

		checkBoxKrokant = new JCheckBox("Krokant");
		checkBoxKrokant.setMnemonic('E');
		checkBoxKrokant.setToolTipText("Krokant - ja/nein");
		checkBoxKrokant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();

			}

		});
		checkBoxKrokant.setBounds(6, 126, 109, 23);
		panelIce.add(checkBoxKrokant);


		/* Panel Preis */
		panelPriceFinal = new JPanel();
		panelPriceFinal.setToolTipText("Ausgabe des Preises");
		panelPriceFinal.setLayout(null);
		panelPriceFinal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Preis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPriceFinal.setBounds(170, 11, 154, 156);
		contentPane.add(panelPriceFinal);

		labelNettoFinal = new JLabel("Netto:");
		labelNettoFinal.setToolTipText("Erl\u00E4uterung des rechten Lable");
		labelNettoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNettoFinal.setBounds(6, 45, 82, 20);
		panelPriceFinal.add(labelNettoFinal);

		labelTaxFinal = new JLabel("MwSt. " +TAXIN +"%:");
		labelTaxFinal.setToolTipText("Erl\u00E4uterung des rechten Lable");
		labelTaxFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTaxFinal.setBounds(6, 76, 82, 20);
		panelPriceFinal.add(labelTaxFinal);

		labelBruttoFinal = new JLabel("Brutto:");
		labelBruttoFinal.setToolTipText("Erl\u00E4uterung des rechten Lable");
		labelBruttoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelBruttoFinal.setBounds(6, 107, 82, 20);
		panelPriceFinal.add(labelBruttoFinal);

		labelNetto = new JLabel("0.00 \u20AC");
		labelNetto.setToolTipText("Nettopreis");
		labelNetto.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNetto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNetto.setBounds(98, 45, 46, 20);
		panelPriceFinal.add(labelNetto);

		labelTax = new JLabel("0.00 \u20AC");
		labelTax.setToolTipText("Mehrwertssteuer");
		labelTax.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTax.setBounds(98, 76, 46, 20);
		panelPriceFinal.add(labelTax);

		labelBrutto = new JLabel("0.00 \u20AC");
		labelBrutto.setToolTipText("Bruttopreis");
		labelBrutto.setHorizontalAlignment(SwingConstants.RIGHT);
		labelBrutto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelBrutto.setBounds(98, 107, 46, 20);
		panelPriceFinal.add(labelBrutto);

		checkBoxOutOfHouse = new JCheckBox("Au\u00DFer haus");
		checkBoxOutOfHouse.setMnemonic('R');
		checkBoxOutOfHouse.setToolTipText("Zum hier essen oder zum mitnehmen?");
		checkBoxOutOfHouse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
				getTax();

			}

		});
		checkBoxOutOfHouse.setBounds(6, 15, 109, 23);
		panelPriceFinal.add(checkBoxOutOfHouse);


		/* Panel Rechnung */
		panelOut = new JPanel();
		panelOut.setToolTipText("Berechnungen");
		panelOut.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rechnung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOut.setBounds(6, 178, 318, 80);
		contentPane.add(panelOut);
		panelOut.setLayout(null);

		buttonGo = new JButton("Kassieren");
		buttonGo.setToolTipText("Kassieren und Rechnung ausgeben");
		buttonGo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				print();
				
			}
			
		});
		buttonGo.setBounds(10, 15, 298, 23);
		panelOut.add(buttonGo);

		buttonUndo = new JButton("Stornieren");
		buttonUndo.setToolTipText("Daten zur\u00FCcksetzen");
		buttonUndo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				
			}
			
		});
		buttonUndo.setBounds(10, 46, 298, 23);
		panelOut.add(buttonUndo);
	}

	
	/* Erstellt den Array für die ComboBox */
	private String[] getComboBoxData() {
		String[] data = new String[3];
		data[0] = "Waffel";
		data[1] = "Pappbecher";
		data[2] = "Schale";

		return data;

	}

	
	/* Gibt die jevalige Mehrwertssteuer zurück und ändert die MwSt. im Label */
	private double getTax() {
		if (checkBoxOutOfHouse.isSelected()) {
			labelTaxFinal.setText("MwSt. " +TAXOUT +"%:");
			return TAXOUT;

		} else {
			labelTaxFinal.setText("MwSt. " +TAXIN +"%:");
			return TAXIN;

		}

	}

	
	/* Berechnung der Werte */
	private void calculate() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		
		/* Setzt den amount Wert, try/catch weil wenn der wert nicht einer Zahl entspricht das das Programm sich nicht beendet */
		try {
			amount = Integer.parseInt(textFieldAmount.getText().trim());

		} catch (NumberFormatException e) {
			if (textFieldAmount.getText().length() > 0)
			JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe bitte überprüfen sie die Eingabe auf nicht Nummerische zeichen.", "Eingabeferhler", 0);

		}

		
		/* Bestimmt den Brutto preis auf basis der Anzahl der Eiskugeln */
		brutto = amount * PRICE;

		
		/* Überprüft den ausgewählten Index der ComboBox und handelt dementsprechend */
		switch(comboBoxType.getSelectedIndex()) {
		case 0:
			brutto += WAFFEL;
			containerprice = WAFFEL;
			break;

		case 1:
			brutto += PAPPBECHER;
			containerprice = PAPPBECHER;
			break;

		case 2:
			brutto += SCHALE;
			containerprice = SCHALE;
			break;

		default:
			break;

		}

		
		/* Überprüft ob CheckBoxen ausgewählt sind und handelt dementsprechend */
		if (checkBoxSahne.isSelected()) {
			brutto += SAHNE;

		}

		if (checkBoxStreusel.isSelected()) {
			brutto += STREUSEL;

		}

		if (checkBoxKrokant.isSelected()) {
			brutto += KROKANT;

		}

		
		/* Berechnung der Steuern und Netto */
		netto = brutto;
		tax = (brutto * getTax()) / (100 +getTax());
		netto -= tax;

		
		/* Setzt die Werte in die Lables ein */
		if (textFieldAmount.getText().length() > 0 ) {
			labelNetto.setText(formatter.format(netto));
			labelTax.setText(formatter.format(tax));
			labelBrutto.setText(formatter.format(brutto));
		
		} else {
			labelNetto.setText("0.00 €");
			labelTax.setText("0.00 €");
			labelBrutto.setText("0.00 €");
			
		}

	}
	
	
	/* Setzt die Werte zurück */
	private void delete() {
		textFieldAmount.setText("");
		comboBoxType.setSelectedIndex(0);
		checkBoxSahne.setSelected(false);
		checkBoxStreusel.setSelected(false);
		checkBoxKrokant.setSelected(false);
		checkBoxOutOfHouse.setSelected(false);
		
		labelNetto.setText("0.00 €");
		labelTax.setText("0.00 €");
		labelBrutto.setText("0.00 €");
		getTax();
		
	}
	
	
	/* Gibt den "Bong" aus */
	private void print() {
		if (textFieldAmount.getText().length() > 0) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			String[] data = getComboBoxData();
			System.out.println(Integer.parseInt(textFieldAmount.getText().trim()) +" Kugeln: " +formatter.format(amount));
			System.out.println(data[comboBoxType.getSelectedIndex()] +": " +containerprice +" €");
			if (checkBoxSahne.isSelected()) {
				System.out.println("Sahne: " +SAHNE +" €");

			}

			if (checkBoxStreusel.isSelected()) {
				System.out.println("Streusel: " +STREUSEL +" €");

			}

			if (checkBoxKrokant.isSelected()) {
				System.out.println("Krokant: " +KROKANT +" €");

			}
			System.out.println("Netto: " +formatter.format(netto));
			System.out.println("MwSt. " +getTax() +"%: " +formatter.format(tax));
			System.out.println("===================");
			System.out.println("Brutto: " +formatter.format(brutto));
			
		} else {
			return;
			
		}
		
	}
	
}
