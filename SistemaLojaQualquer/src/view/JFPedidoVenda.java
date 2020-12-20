package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import controller.ItemPedidoController;
import controller.PedidoController;
import controller.ProdutoController;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

public class JFPedidoVenda extends JFrame {

	private JPanel contentPane;
	private JTextField edPedido;
	private JTextField edDataHoraEmissao;
	private JTextField edQtdTotal;
	private JTextField edValorTotal;
	private JTextField edCliente;
	private JTable table;
	private JLabel lblNomecliente;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public void run(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFPedidoVenda frame = new JFPedidoVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void pesquisarItensPedido() {
		ItemPedidoController itemPedidoController = ItemPedidoController.getInstance();

		List<ItemPedido> lista = itemPedidoController.getAllItensProdutos();

		model.setNumRows(0);

		ProdutoController produtoController = ProdutoController.getInstance();

		for (ItemPedido u : lista) {
			Produto produto = produtoController.findProdutoById(u.getProdutoIdProduto());
			model.addRow(new Object[] { u.getProdutoIdProduto(), produto.getNome(), produto.getValor(),
					u.getQuantidadeTotal(), u.getValorTotal() });
		}
	}

	public void adicionaItemPedido(ItemPedido itemPedido) {

		ProdutoController produtoController = ProdutoController.getInstance();

		Produto produto = produtoController.findProdutoById(itemPedido.getProdutoIdProduto());

		model.addRow(new Object[] { itemPedido.getProdutoIdProduto(), produto.getNome(), produto.getValor(),
				itemPedido.getQuantidadeTotal(), itemPedido.getValorTotal() });

	}

	private void preenchelblCliente() {

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				ClienteController clienteController = ClienteController.getInstance();
				Cliente cliente = clienteController.findClienteById(Integer.parseInt(edCliente.getText()));

				if (cliente == null) {
					lblNomecliente.setText("");
					JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
				} else {
					lblNomecliente.setText(cliente.getNome());
				}
			}
		});
		t.start();

	}

	private void inserirItemPedido() {
		JFItemPedido JFItemPedido = new JFItemPedido(null);
		JFItemPedido.run(this);
	}

	public void atualizaQuantidadeValor() {
		Float quantidade = (float) 0;
		Float valor = (float) 0;
		edQtdTotal.setText("");
		edValorTotal.setText("");

		for (int i = 0; i <= table.getRowCount() - 1; i++) {
			quantidade = quantidade + (Float) table.getModel().getValueAt(i, 3);
			valor = valor + (Float) table.getModel().getValueAt(i, 4);
		}

		edQtdTotal.setText(String.valueOf(quantidade));
		edValorTotal.setText(String.valueOf(valor));

		this.setVisible(false);
		this.setVisible(true);
	}

	public void editarItem() {
		JFItemPedido JFItemPedido = new JFItemPedido(null);

		ItemPedido itemPedido = new ItemPedido();

		int i = table.getSelectedRowCount();

		Integer idProduto = (Integer) table.getModel().getValueAt(i, 0);
		float quantidadeTotal = (Float) table.getModel().getValueAt(i, 3);
		float valorTotal = (Float) table.getModel().getValueAt(i, 4);

		itemPedido.setProdutoIdProduto(idProduto);
		itemPedido.setQuantidadeTotal(quantidadeTotal);
		itemPedido.setValorTotal(valorTotal);

		if (itemPedido.getProdutoIdProduto() != null) {
			JFItemPedido.editar(itemPedido);
		}

	}

	public void salvarPedido() {
		List<ItemPedido> lista = new ArrayList<ItemPedido>();
		Pedido pedido = new Pedido();
		pedido.setIdCliente(Integer.parseInt(edCliente.getText()));
		long millis = System.currentTimeMillis();
		pedido.setDataEmissao(new Date(millis));
		pedido.setQuantidadeTotal(Float.parseFloat(edQtdTotal.getText()));
		pedido.setValorTotal(Float.parseFloat(edValorTotal.getText()));

		for (int i = 0; i <= table.getRowCount() - 1; i++) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setPedidoDataEmissao(pedido.getDataEmissao());
			itemPedido.setProdutoIdProduto((Integer) table.getModel().getValueAt(i, 0));
			itemPedido.setQuantidadeTotal((Float) table.getModel().getValueAt(i, 3));
			itemPedido.setValorTotal((Float) table.getModel().getValueAt(i, 4));
			lista.add(itemPedido);
		}

		pedido.setItensPedido(lista);

		PedidoController pedidoController = PedidoController.getInstance();
		pedidoController.cadastrarPedido(pedido);

		dispose();
	}

	/**
	 * Create the frame.
	 */
	public JFPedidoVenda() {
		setTitle("Pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 769, 92);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pedido:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(8, 13, 58, 14);
		panel.add(lblNewLabel);

		edPedido = new JTextField();
		edPedido.setFont(new Font("Arial", Font.PLAIN, 12));
		edPedido.setBounds(74, 8, 81, 27);
		panel.add(edPedido);
		edPedido.setColumns(10);

		JLabel lblEmisso = new JLabel("Emiss\u00E3o:");
		lblEmisso.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmisso.setBounds(163, 13, 63, 14);
		panel.add(lblEmisso);

		edDataHoraEmissao = new JTextField();
		edDataHoraEmissao.setFont(new Font("Arial", Font.PLAIN, 12));
		edDataHoraEmissao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String data = "dd/MM/yyyy";
				String hora = "HH:mm";
				String dataAtual, horaAtual;
				java.util.Date agora = new java.util.Date();
				SimpleDateFormat formata = new SimpleDateFormat(data);
				dataAtual = formata.format(agora);
				formata = new SimpleDateFormat(hora);
				horaAtual = formata.format(agora);
				edDataHoraEmissao.setText(dataAtual + " - " + horaAtual);
			}
		});
		edDataHoraEmissao.setColumns(10);
		edDataHoraEmissao.setBounds(234, 8, 111, 27);
		panel.add(edDataHoraEmissao);

		JLabel lblQuantidadeTotal = new JLabel("Quantidade Total:");
		lblQuantidadeTotal.setFont(new Font("Arial", Font.BOLD, 14));
		lblQuantidadeTotal.setBounds(353, 13, 131, 14);
		panel.add(lblQuantidadeTotal);

		edQtdTotal = new JTextField();
		edQtdTotal.setEditable(false);
		edQtdTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		edQtdTotal.setColumns(10);
		edQtdTotal.setBounds(492, 8, 81, 27);
		panel.add(edQtdTotal);

		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Arial", Font.BOLD, 14));
		lblValorTotal.setBounds(581, 13, 91, 14);
		panel.add(lblValorTotal);

		edValorTotal = new JTextField();
		edValorTotal.setEditable(false);
		edValorTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		edValorTotal.setColumns(10);
		edValorTotal.setBounds(680, 8, 81, 27);
		panel.add(edValorTotal);

		JLabel lblIdCliente = new JLabel("Cliente:");
		lblIdCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblIdCliente.setBounds(8, 60, 58, 14);
		panel.add(lblIdCliente);

		lblNomecliente = new JLabel("");
		lblNomecliente.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomecliente.setBounds(163, 61, 598, 14);
		panel.add(lblNomecliente);

		edCliente = new JTextField();
		edCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				preenchelblCliente();
			}
		});
		edCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		edCliente.setColumns(10);
		edCliente.setBounds(74, 55, 81, 27);
		panel.add(edCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setBounds(0, 116, 769, 411);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Descri\u00E7\u00E3o", "Valor", "Quantidade", "Valor Total" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);
		table.setFont(new Font("Arial", Font.PLAIN, 12));

		model = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarPedido();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
		btnSalvar.setBounds(324, 534, 120, 47);
		contentPane.add(btnSalvar);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 91, 769, 23);
		contentPane.add(panel_1);

		JButton btnInserirItem = new JButton("Inserir");
		btnInserirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirItemPedido();
			}
		});
		btnInserirItem.setFont(new Font("Arial", Font.BOLD, 12));
		btnInserirItem.setBorderPainted(false);
		btnInserirItem.setBackground(Color.GREEN);
		btnInserirItem.setBounds(26, 0, 89, 23);
		panel_1.add(btnInserirItem);

		JButton btnEditarItem = new JButton("Editar");
		btnEditarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarItem();
			}
		});
		btnEditarItem.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditarItem.setBorderPainted(false);
		btnEditarItem.setBackground(Color.YELLOW);
		btnEditarItem.setBounds(163, 0, 89, 23);
		panel_1.add(btnEditarItem);
	}
}
