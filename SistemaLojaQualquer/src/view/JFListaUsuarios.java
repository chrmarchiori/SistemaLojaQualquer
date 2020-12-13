package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UsuarioController;
import model.Usuario;

public class JFListaUsuarios extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private DefaultTableModel model;
	private UsuarioController usuarioController;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListaUsuarios frame = new JFListaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void PesquisarUsuarios() {
		this.usuarioController = usuarioController.getInstance();

		List<Usuario> lista = this.usuarioController.getAllUsuarios();

		model.setNumRows(0);

		for (Usuario u : lista) {
			model.addRow(new Object[] { u.getIdUsuario(), u.getUsuarioLogin(), u.getUsuarioSenha(),
					u.isUsuarioAdministrador() });
		}

	}

	private Usuario PreencherUsuario() {

		if (table.getSelectionModel().isSelectionEmpty()) {
			return null;
		}

		int row = table.getSelectedRow();
		String usuarioLogin = table.getModel().getValueAt(row, 1).toString();
		String usuarioSenha = table.getModel().getValueAt(row, 2).toString();

		Usuario usuario = usuarioController.getUsuarioByLoginPassword(usuarioLogin, usuarioSenha);

		return usuario;

	}

	/**
	 * Create the frame.
	 */
	public JFListaUsuarios() {
		setTitle("Pesquisa de Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 75, 875, 565);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Login", "Senha", "Administrador" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		model = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroUsuario JFCadastroUsuario = new JFCadastroUsuario();
				JFCadastroUsuario.run();
				JFCadastroUsuario.setVisible(true);
			}
		});
		btnInserir.setBackground(Color.LIGHT_GRAY);
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInserir.setBounds(10, 11, 104, 38);
		panel.add(btnInserir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFCadastroUsuario JFCadastroUsuario = new JFCadastroUsuario();

				Usuario usuario = PreencherUsuario();

				if (usuario != null) {
					JFCadastroUsuario.run();
					JFCadastroUsuario.Editar(usuario);
				}

			}
		});
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(124, 11, 104, 38);
		panel.add(btnEditar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarUsuarios();
			}
		});
		btnPesquisar.setBackground(Color.LIGHT_GRAY);
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPesquisar.setBounds(238, 11, 104, 38);
		panel.add(btnPesquisar);
	}
}
