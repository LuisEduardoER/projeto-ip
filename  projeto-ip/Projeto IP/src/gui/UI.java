package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 359);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 77, 122, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(103, 138, 85, 29);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 137, 122, 30);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(103, 85, 85, 22);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblLogin);
		
		JPanel panel = new JPanel();
		panel.setBounds(229, 205, 102, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addMouseListener(new MouseAdapter() {
			
			
		});
		btnAcessar.setBounds(0, 0, 102, 23);
		panel.add(btnAcessar);
		btnAcessar.addActionListener(new ActionListener() {
			// Pesquisar o login e a senha,caso aquele n�o exista,enviar um exception e caso a senha esteja incorreta,enviar msg com senha incorreta.
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					SegundoUI ui2 = new SegundoUI();
					ui2.setVisible(true);
					DeletarFrame();
				} catch (Exception e) {
					
				}
			}
		});
		
		
		JLabel lblAluguelDeCarros_1 = new JLabel("Aluguel de Carros");
		lblAluguelDeCarros_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblAluguelDeCarros_1.setBounds(179, 17, 214, 48);
		contentPane.add(lblAluguelDeCarros_1);
	}
	@SuppressWarnings("unused")
	private class SwingAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private void DeletarFrame(){
		this.dispose();
	}
}
