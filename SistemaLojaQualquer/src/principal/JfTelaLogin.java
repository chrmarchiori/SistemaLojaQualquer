package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JEditorPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Canvas;
import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class JfTelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField psfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfTelaLogin frame = new JfTelaLogin();
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
	public JfTelaLogin() {
		setTitle("Sistema Loja Qualquer");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 308, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema Loja Qualquer");
		lblNewLabel.setBounds(51, 178, 206, 19);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JLabel lblVerso = new JLabel("v1.0.1");
		lblVerso.setForeground(Color.WHITE);
		lblVerso.setFont(new Font("Arial", Font.BOLD, 12));
		lblVerso.setBounds(61, 208, 177, 14);
		panel.add(lblVerso);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(308, 0, 357, 376);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ol\u00E1, fa\u00E7a seu login!");
		lblNewLabel_1.setBounds(64, 36, 228, 32);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(64, 107, 84, 17);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(64, 125, 228, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(64, 190, 84, 17);
		panel_1.add(lblNewLabel_2_1);
		
		psfSenha = new JPasswordField();
		psfSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		psfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		psfSenha.setBounds(64, 207, 228, 32);
		panel_1.add(psfSenha);
		
		JCheckBox ckUsuarioAdm = new JCheckBox("Administrador");
		ckUsuarioAdm.setHorizontalAlignment(SwingConstants.LEFT);
		ckUsuarioAdm.setBackground(Color.WHITE);
		ckUsuarioAdm.setFont(new Font("Arial", Font.PLAIN, 12));
		ckUsuarioAdm.setBounds(64, 246, 101, 17);
		panel_1.add(ckUsuarioAdm);
		
		JButton btnTrocarSenha = new JButton("Trocar Senha");
		btnTrocarSenha.setBackground(Color.WHITE);
		btnTrocarSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		btnTrocarSenha.setBounds(191, 243, 101, 23);
		panel_1.add(btnTrocarSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(113, 296, 134, 47);
		panel_1.add(btnLogin);
	}
}
