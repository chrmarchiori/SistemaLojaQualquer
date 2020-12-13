package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Usuario;

public class JFCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField edUsuarioLogin;

	/**
	 * Launch the application.
<<<<<<< HEAD
	 **/
=======
	**/
>>>>>>> 08f1827399fc238f1df5c93452435f5c27911aa9
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroUsuario frame = new JFCadastroUsuario();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Editar(Usuario usuario) {
		edUsuarioLogin.setText(usuario.getUsuarioLogin());
		edUsuarioLogin.repaint();
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFCadastroUsuario() {
		setTitle("Cadastro de Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 337, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 321, 221);
		contentPane.add(panel);
		panel.setLayout(null);

		edUsuarioLogin = new JTextField();
		edUsuarioLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		edUsuarioLogin.setBounds(49, 41, 223, 31);
		panel.add(edUsuarioLogin);
		edUsuarioLogin.setColumns(10);

		JPasswordField pfUsuarioSenha = new JPasswordField();
		pfUsuarioSenha.setBounds(49, 133, 223, 31);
		panel.add(pfUsuarioSenha);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 17, 96, 20);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(49, 102, 96, 20);
		panel.add(lblSenha);

		JCheckBox ckUsuarioAdministrador = new JCheckBox("Administrador");
		ckUsuarioAdministrador.setBounds(49, 171, 110, 23);
		panel.add(ckUsuarioAdministrador);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvar.setBounds(49, 249, 101, 37);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 16));
		btnExcluir.setBounds(171, 249, 101, 37);
		contentPane.add(btnExcluir);
	}
}
