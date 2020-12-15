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

import controller.ProdutoController;
import model.Produto;

public class JFListaProdutos extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private DefaultTableModel model;
	private ProdutoController produtoController;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListaProdutos frame = new JFListaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void pesquisarProdutos() throws ClassNotFoundException, SQLException {
		this.produtoController = ProdutoController.getInstance();

		List<Produto> lista = this.produtoController.getAllProdutos();

		model.setNumRows(0);

		for (Produto u : lista) {
			model.addRow(new Object[] { u.getIdProduto(), u.getNome(), u.getDescricao(), u.getCodigo(), u.getValor() });
		}

	}
	public void atualizar() {
		try {
			this.pesquisarProdutos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Produto preencherProduto() {

		if (table.getSelectionModel().isSelectionEmpty()) {
			return null;
		}

		int row = table.getSelectedRow();
		Integer idProduto = (Integer) table.getModel().getValueAt(row, 0);

		Produto produto = produtoController.findProdutoById(idProduto);
		System.out.println(produto.getValor());
		return produto;
	}

	/**
	 * Create the frame.
	 */
	public JFListaProdutos() {
		setTitle("Pesquisa de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(0, 75, 875, 565);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome", "Descrição", "Código", "Valor" }));
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
				JFCadastroProduto JFCadastroProduto = new JFCadastroProduto();
//				JFCadastroCliente.run();
				JFCadastroProduto.setVisible(true);
			}
		});
		btnInserir.setBackground(Color.LIGHT_GRAY);
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInserir.setBounds(10, 11, 104, 38);
		panel.add(btnInserir);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Produto produto = preencherProduto();
				JFCadastroProduto JFCadastroProduto = new JFCadastroProduto();

				if (produto != null) {
					JFCadastroProduto.editar(produto);
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
				Integer idProduto = (Integer) table.getModel().getValueAt(row, 0);
				if (idProduto != null) {
					produtoController.deleteProduto(idProduto);
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
