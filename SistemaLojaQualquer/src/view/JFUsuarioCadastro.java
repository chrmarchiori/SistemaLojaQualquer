package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.UsuarioController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class JFUsuarioCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField edUsuarioLogin;
	private JPasswordField pfUsuarioSenha;
	private JPasswordField pfUsuarioRedefinirSenha;
	private UsuarioController usuarioController;
	private JTextField textField;
	private JTextField edUsuario;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmeSenha;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFUsuarioCadastro frame = new JFUsuarioCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void SalvarUsuario() {

	}

	/**
	 * Create the frame.
	 */
	public JFUsuarioCadastro() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setBounds(25, 103, 81, 14);
		getContentPane().add(lblSenha);
		
		JLabel lblConfirmeSuaSenha = new JLabel("Confirme sua Senha");
		lblConfirmeSuaSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblConfirmeSuaSenha.setBounds(25, 197, 160, 14);
		getContentPane().add(lblConfirmeSuaSenha);
		
		edUsuario = new JTextField();
		edUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		edUsuario.setBounds(25, 36, 322, 36);
		getContentPane().add(edUsuario);
		edUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		pfSenha.setBounds(25, 128, 322, 36);
		getContentPane().add(pfSenha);
		
		pfConfirmeSenha = new JPasswordField();
		pfConfirmeSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		pfConfirmeSenha.setBounds(25, 222, 322, 36);
		getContentPane().add(pfConfirmeSenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBorderPainted(false);
		btnSalvar.setBackground(new Color(0, 204, 0));
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
		btnSalvar.setBounds(25, 295, 117, 36);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 51, 0));
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setBounds(230, 295, 117, 36);
		getContentPane().add(btnCancelar);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(38, 32, 96, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		setTitle("Cadastro de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Digite seu Usu\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(55, 22, 120, 17);
		contentPane.add(lblNewLabel_2);

		edUsuarioLogin = new JTextField();
		edUsuarioLogin.setHorizontalAlignment(SwingConstants.LEFT);
		edUsuarioLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		edUsuarioLogin.setColumns(10);
		edUsuarioLogin.setBounds(55, 40, 282, 32);
		contentPane.add(edUsuarioLogin);

		JLabel lblNewLabel_2_1 = new JLabel("Digite sua senha:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(55, 105, 153, 17);
		contentPane.add(lblNewLabel_2_1);
 
		pfUsuarioSenha = new JPasswordField();
		pfUsuarioSenha.setHorizontalAlignment(SwingConstants.LEFT);
		pfUsuarioSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pfUsuarioSenha.setBounds(55, 122, 282, 32);
		contentPane.add(pfUsuarioSenha);

		JLabel lblNewLabel_2_1_1 = new JLabel("Confirme sua senha:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(55, 196, 140, 17);
		contentPane.add(lblNewLabel_2_1_1);

		pfUsuarioRedefinirSenha = new JPasswordField();
		pfUsuarioRedefinirSenha.setHorizontalAlignment(SwingConstants.LEFT);
		pfUsuarioRedefinirSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		pfUsuarioRedefinirSenha.setBounds(55, 213, 282, 32);
		contentPane.add(pfUsuarioRedefinirSenha);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalvarUsuario();
			}
		});
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvar.setBounds(55, 303, 120, 38);
		contentPane.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(217, 303, 120, 38);
		contentPane.add(btnCancelar);
		
		this.usuarioController = new UsuarioController(model, view, dao)
	}
}
