package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.Cliente;

public class JFListaClientes extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private DefaultTableModel model;
	private ClienteController clienteController;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListaClientes frame = new JFListaClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void pesquisarClientes() throws ClassNotFoundException, SQLException {
		this.clienteController = ClienteController.getInstance();

		List<Cliente> lista = this.clienteController.getAllCliente();

		model.setNumRows(0);

		for (Cliente u : lista) {
			model.addRow(new Object[] { u.getIdCliente(), u.getNome(), u.getEndereco(), u.getIdade() });
		}

	}
	public void atualizar() {
		try {
			this.pesquisarClientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Cliente preencherCliente() {

		if (table.getSelectionModel().isSelectionEmpty()) {
			return null;
		}

		int row = table.getSelectedRow();
		Integer idCliente = (Integer) table.getModel().getValueAt(row, 0);

		Cliente cliente = clienteController.findClienteById(idCliente);
		return cliente;
	}

	/**
	 * Create the frame.
	 */
	public JFListaClientes() {
		setTitle("Pesquisa de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 75, 875, 565);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome", "Endereço", "Idade" }));
		table.getColumnModel().getColumn(2).setPreferredWidth(100);

		model = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroCliente JFCadastroCliente = new JFCadastroCliente();
				JFCadastroCliente.run();
				JFCadastroCliente.setVisible(true);
			}
		});
		btnInserir.setBackground(Color.LIGHT_GRAY);
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInserir.setBounds(10, 11, 104, 38);
		panel.add(btnInserir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = preencherCliente();
				System.out.println(cliente.getNome());

				if (cliente != null) {
					new JFCadastroCliente().run();
					new JFCadastroCliente().editar(cliente);
				}

			}
		});
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(124, 11, 104, 38);
		panel.add(btnEditar);

		JButton btnPesquisar = new JButton("Excluir");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectionModel().isSelectionEmpty()) {
					return;
				}

				int row = table.getSelectedRow();
				Integer idCliente = (Integer) table.getModel().getValueAt(row, 0);
				if (idCliente != null) {
					clienteController.deleteCliente(idCliente);
					atualizar();
				}
			}
		});
		btnPesquisar.setBackground(Color.LIGHT_GRAY);
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPesquisar.setBounds(238, 11, 104, 38);
		panel.add(btnPesquisar);
		this.atualizar();
	}
}
