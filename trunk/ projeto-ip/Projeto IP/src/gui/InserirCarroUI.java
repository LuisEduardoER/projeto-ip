package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import dados.carros.Adicionais;
import dados.carros.Carro;
import exceptions.BIException;
import exceptions.CCException;

import principal.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InserirCarroUI extends JFrame {

	
	private JPanel contentPane;
	private JTextField textPlaca;
	private JTextField textModelo;
	private JTextField textPorta;
	private JTextField textPotencia;
	private JTextField textMarca;
	private JTextField textCategoria;
	private Fachada fachada;
	
	private boolean ar = false;
	private boolean AIRBAG = false;
	private boolean direcaoH = false;
	private boolean som = false;
	private boolean freiosABS = false;
	private boolean GPS = false;
	private boolean travas = false;
	private JTextField textValor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirCarroUI frame = new InserirCarroUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InserirCarroUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 909, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Carro");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(319, 11, 204, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(76, 103, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modelo:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(76, 160, 61, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Porta:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(76, 213, 73, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pot\u00EAncia:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(76, 271, 73, 32);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marca:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_5.setBounds(76, 333, 73, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_6.setBounds(447, 97, 84, 27);
		panel.add(lblNewLabel_6);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(156, 102, 132, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setBounds(156, 162, 132, 20);
		panel.add(textModelo);
		textModelo.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setBounds(156, 218, 132, 20);
		panel.add(textPorta);
		textPorta.setColumns(10);
		
		textPotencia = new JTextField();
		textPotencia.setColumns(10);
		textPotencia.setBounds(156, 279, 132, 20);
		panel.add(textPotencia);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(156, 339, 132, 20);
		panel.add(textMarca);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(541, 102, 132, 20);
		panel.add(textCategoria);
		
		textValor = new JTextField();
		textValor.setBounds(591, 162, 86, 20);
		panel.add(textValor);
		textValor.setColumns(10);
		
		JRadioButton rdbtnAr = new JRadioButton("Ar");
		rdbtnAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 ar = true;
			}
		});
		rdbtnAr.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnAr.setBounds(447, 215, 109, 23);
		panel.add(rdbtnAr);
		
		JRadioButton rdbtnTravas = new JRadioButton("Travas El\u00E9tricas");
		rdbtnTravas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				travas = true;
			}
		});
		rdbtnTravas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnTravas.setBounds(591, 215, 171, 23);
		panel.add(rdbtnTravas);
		
		JRadioButton rdbtnSom = new JRadioButton("Som");
		rdbtnSom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				som = true;
			}
		});
		rdbtnSom.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnSom.setBounds(447, 285, 109, 23);
		panel.add(rdbtnSom);
		
		JRadioButton rdbtnAirbag = new JRadioButton("AIRBAG");
		rdbtnAirbag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AIRBAG = true;
			}
		});
		rdbtnAirbag.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnAirbag.setBounds(447, 320, 109, 23);
		panel.add(rdbtnAirbag);
		
		JRadioButton rdbtnGps = new JRadioButton("GPS");
		rdbtnGps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GPS = true;
			}
		});
		rdbtnGps.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnGps.setBounds(447, 250, 109, 23);
		panel.add(rdbtnGps);
		
		JRadioButton rdbtnFreiosAbs = new JRadioButton("Freios ABS");
		rdbtnFreiosAbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				freiosABS = true;
			}
		});
		rdbtnFreiosAbs.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnFreiosAbs.setBounds(591, 250, 109, 23);
		panel.add(rdbtnFreiosAbs);
		
		JRadioButton rdbtnDireoHidrulica = new JRadioButton("Dire\u00E7\u00E3o Hidr\u00E1ulica");
		rdbtnDireoHidrulica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				direcaoH = true;
			}
		});
		rdbtnDireoHidrulica.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnDireoHidrulica.setBounds(591, 280, 221, 23);
		panel.add(rdbtnDireoHidrulica);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
				dispose();
			}
		});
		btnNewButton.setBounds(529, 428, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(662, 428, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblValorDoAluguel = new JLabel("Valor do Aluguel:");
		lblValorDoAluguel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblValorDoAluguel.setBounds(447, 160, 149, 20);
		panel.add(lblValorDoAluguel);
		
	}
	
	private void salvar(){
		try {
			String numPorta = textPorta.getText();
			int porta = Integer.parseInt(numPorta);
			String aluguel = textValor.getText();
			System.out.println(aluguel);
			Adicionais adicionais = new Adicionais(ar, GPS, travas, som, freiosABS, AIRBAG, direcaoH);
			String placa = textPlaca.getText();
			Carro carro = new Carro(textPlaca.getText(), porta, textPotencia.getText(), textModelo.getText(), textMarca.getText(), textCategoria.getText(), adicionais, 0.0);
			fachada.cadastrarCarro(carro);
			
			System.out.println(carro.getCategoria()+carro.getModelo());
		} catch (CCException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
	}
}
