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
import controller.PedidoController;
import model.Cliente;
import model.Pedido;

public class JFListaPedidos extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel model;
	private PedidoController pedidoController;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListaPedidos frame = new JFListaPedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void pesquisarPedidos() throws ClassNotFoundException, SQLException {
		this.pedidoController = PedidoController.getInstance();

		List<Pedido> lista = this.pedidoController.getAllProdutos();

		ClienteController clienteController = ClienteController.getInstance();

		model.setNumRows(0);

		for (Pedido u : lista) {
			Cliente cliente = clienteController.findClienteById(u.getIdCliente());
			model.addRow(new Object[] { u.getIdPedido(), u.getDataEmissao(), u.getIdCliente(), cliente.getNome() });
		}

	}

	public void atualizar() {
		try {
			this.pesquisarPedidos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Pedido preencherPedido() {

		if (table.getSelectionModel().isSelectionEmpty()) {
			return null;
		}

		int row = table.getSelectedRow();
		Integer idPedido = (Integer) table.getModel().getValueAt(row, 0);

		Pedido pedido = pedidoController.findPedidoById(idPedido);
		return pedido;
	}

	/**
	 * Create the frame.
	 */
	public JFListaPedidos() {
		setTitle("Pesquisa de Pedidos");
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
				new DefaultTableModel(new Object[][] {}, new String[] { "Pedido", "Emiss\u00E3o", "Cliente", "Nome" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(255);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 875, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFPedidoVenda JFPedidoVenda = new JFPedidoVenda();
				JFPedidoVenda.setVisible(true);
			}
		});
		btnInserir.setBackground(Color.LIGHT_GRAY);
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInserir.setBounds(10, 11, 104, 38);
		panel.add(btnInserir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Pedido pedido = preencherPedido();
				JFPedidoVenda JFPedidoVenda = new JFPedidoVenda();

				if (pedido != null) {
					// JFPedidoVenda.
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
				Integer idPedido = (Integer) table.getModel().getValueAt(row, 0);
				if (idPedido != null) {
					pedidoController.deletePedido(idPedido);
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
