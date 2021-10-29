package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import FIS_Papas.FIS_Papas;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class PapasUI extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TEMPERATURA;
	private JTextField ALTITUD;
	private JTextField LUZ;
	private JTextField AGUA;
	private JTextField PH;
    
	private static FIS_Papas fis = new FIS_Papas();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PapasUI frame = new PapasUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PapasUI() {
		super("FIS_Papas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new LineBorder(SystemColor.desktop));
		panel.setForeground(Color.GREEN);
		panel.setBounds(10, 274, 513, 225);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPh = new JLabel("PH: ");
		lblPh.setBounds(101, 135, 103, 35);
		panel.add(lblPh);
		lblPh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setBounds(101, 24, 103, 35);
		panel.add(lblTemperatura);
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		TEMPERATURA = new JTextField();
		TEMPERATURA.setBounds(214, 32, 96, 20);
		panel.add(TEMPERATURA);
		TEMPERATURA.setColumns(10);
		
		JLabel lblAltitud = new JLabel("Altitud: ");
		lblAltitud.setBounds(101, 50, 103, 35);
		panel.add(lblAltitud);
		lblAltitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLuz = new JLabel("Luz: ");
		lblLuz.setBounds(101, 78, 103, 35);
		panel.add(lblLuz);
		lblLuz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAgua = new JLabel("Agua: ");
		lblAgua.setBounds(101, 106, 103, 35);
		panel.add(lblAgua);
		lblAgua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		ALTITUD = new JTextField();
		ALTITUD.setBounds(214, 58, 96, 20);
		panel.add(ALTITUD);
		ALTITUD.setColumns(10);
		
		LUZ = new JTextField();
		LUZ.setBounds(214, 86, 96, 20);
		panel.add(LUZ);
		LUZ.setColumns(10);
		
		AGUA = new JTextField();
		AGUA.setBounds(214, 114, 96, 20);
		panel.add(AGUA);
		AGUA.setColumns(10);
		
		PH = new JTextField();
		PH.setBounds(214, 143, 96, 20);
		panel.add(PH);
		PH.setColumns(10);
		
		JButton VerVariables = new JButton("Variables");
		VerVariables.setBounds(216, 188, 89, 23);
		panel.add(VerVariables);
		
		JButton VerReglas = new JButton("Reglas");
		VerReglas.setBounds(101, 188, 89, 23);
		panel.add(VerReglas);
		
		JButton Calcular = new JButton("Calcular");
		Calcular.setBounds(326, 188, 89, 23);
		panel.add(Calcular);
		
		JLabel lblNewLabel = new JLabel("\u00B0C");
		lblNewLabel.setBounds(320, 38, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblMsnm = new JLabel("MSNM");
		lblMsnm.setBounds(320, 61, 46, 14);
		panel.add(lblMsnm);
		
		JLabel lblNewLabel_1_1 = new JLabel("HORAS");
		lblNewLabel_1_1.setBounds(320, 89, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("L/M^2");
		lblNewLabel_1_1_1_1.setBounds(320, 117, 46, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblc = new JLabel("[0 - 40]");
		lblc.setBounds(381, 38, 78, 14);
		panel.add(lblc);
		
		JLabel lblc_1_1 = new JLabel("[0- 16]");
		lblc_1_1.setBounds(381, 89, 78, 14);
		panel.add(lblc_1_1);
		
		JLabel lblc_1_2 = new JLabel("[0- 900]");
		lblc_1_2.setBounds(381, 117, 78, 14);
		panel.add(lblc_1_2);
		
		JLabel lblc_1_3 = new JLabel("[0- 14]");
		lblc_1_3.setBounds(381, 146, 78, 14);
		panel.add(lblc_1_3);
		
		JLabel lblc_1 = new JLabel("[0 - 3500]");
		lblc_1.setBounds(381, 61, 78, 14);
		panel.add(lblc_1);
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		        
		        String respuesta = fis.fisStart(Double.parseDouble(TEMPERATURA.getText().replace(",", ".")), 
		        								Double.parseDouble(ALTITUD.getText().replace(",", ".")), 
		        								Double.parseDouble(LUZ.getText().replace(",", ".")), 
		        								Double.parseDouble(AGUA.getText().replace(",", ".")), 
		        								Double.parseDouble(PH.getText().replace(",", ".")));
		        
		        JOptionPane.showMessageDialog(null, respuesta, "RESPUESTA",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		VerReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuffer rules = fis.MostrarReglas(); 
		        JOptionPane.showMessageDialog(null, rules, "REGLAS",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		VerVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fis.MostrarVariables();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/Interfaz/image/papita.jpeg"));
		lblNewLabel_1.setBounds(10, 11, 513, 252);
		contentPane.add(lblNewLabel_1);
	}
}
