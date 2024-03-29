package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAOImpl;
import controller.UsuarioController;
import model.Usuario;

public class JFTelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField edtUsuario;
	private JPasswordField psfSenha;
	private UsuarioController usuarioController;

	private Usuario usuario;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFTelaLogin frame = new JFTelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void ExecutarLogin(String usuarioLogin, char[] senha) throws ClassNotFoundException, SQLException {

		if (!usuarioLogin.equals("") && senha != null) {
			Usuario usuarioModel = new Usuario();
			usuarioModel.setUsuarioLogin(usuarioLogin);
			String strPass = new String(senha).trim();
			usuarioModel.setUsuarioSenha(strPass);

			UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();

			this.usuarioController = UsuarioController.getInstance();

			this.usuarioController.iniciaDadosUsuario(usuarioModel, usuarioDAOImpl);

			this.usuarioController.RealizaLogin(usuarioLogin, senha);

			Usuario usuario = this.usuarioController.getUsuarioLogado();

			if (usuario == null) {
				JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado, Tente novamente!");
				edtUsuario.setText("");
				psfSenha.setText("");
			} else {
				new JFMenuPrincipal().run();
				this.dispose();
			}

		} else
			JOptionPane.showMessageDialog(null, "� necess�rio informar usu�rio e senha!");

	}

	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Create the frame.
	 */
	public JFTelaLogin() {
		setResizable(false);
		setType(Type.UTILITY);
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

		edtUsuario = new JTextField();
		edtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		edtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		edtUsuario.setBounds(64, 125, 228, 32);
		panel_1.add(edtUsuario);
		edtUsuario.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(64, 190, 84, 17);
		panel_1.add(lblNewLabel_2_1);

		psfSenha = new JPasswordField();
		psfSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		psfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		psfSenha.setBounds(64, 207, 228, 32);
		panel_1.add(psfSenha);

		JButton btnTrocarSenha = new JButton("Trocar Senha");
		btnTrocarSenha.setBackground(Color.WHITE);
		btnTrocarSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		btnTrocarSenha.setBounds(64, 248, 101, 23);
		panel_1.add(btnTrocarSenha);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ExecutarLogin(edtUsuario.getText(), psfSenha.getPassword());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(113, 296, 134, 47);
		panel_1.add(btnLogin);

	}
}
