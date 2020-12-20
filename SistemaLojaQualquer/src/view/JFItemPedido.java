package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProdutoController;
import model.ItemPedido;
import model.Produto;

public class JFItemPedido extends JFrame {

	private JPanel contentPane;
	private JTextField edProduto;
	private JTextField edQuantidade;
	private JTextField edValor;
	private JTextField textField_3;
	private ItemPedido itemPedidoEditar;
	private ItemPedido itemPedidoAdicionar;
	private JFPedidoVenda jfPedidoVenda;

	/**
	 * Launch the application.
	 */
	public void run(JFPedidoVenda jfPedidoVenda) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFItemPedido frame = new JFItemPedido(jfPedidoVenda);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void devolverItemPedido() {
		jfPedidoVenda.adicionaItemPedido(itemPedidoAdicionar);
		jfPedidoVenda.atualizaQuantidadeValor();
	}

	public void editar(ItemPedido itemPedido) {
		edProduto.setText(String.valueOf(itemPedido.getProdutoIdProduto()));
		edQuantidade.setText(String.valueOf(itemPedido.getQuantidadeTotal()));
		edValor.setText(String.valueOf(itemPedido.getValorTotal()));
		this.itemPedidoEditar = itemPedido;
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFItemPedido(JFPedidoVenda jfPedidoVenda) {
		this.jfPedidoVenda = jfPedidoVenda;
		setTitle("Item Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 321, 259);
		contentPane.add(panel);

		edProduto = new JTextField();
		edProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ProdutoController produtoController = ProdutoController.getInstance();
				Produto produto = produtoController.findProdutoById(Integer.parseInt(edProduto.getText()));

				if (produto == null) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
					edProduto.setText("");
				} else {
					edQuantidade.setText(String.valueOf(produto.getQuantidade()));
					edValor.setText(String.valueOf(produto.getValor()));
				}
			}
		});
		edProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		edProduto.setColumns(10);
		edProduto.setBounds(49, 41, 223, 31);
		panel.add(edProduto);

		edQuantidade = new JTextField();
		edQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		edQuantidade.setBounds(49, 116, 223, 31);
		panel.add(edQuantidade);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblProduto.setBounds(49, 17, 96, 20);
		panel.add(lblProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantidade.setBounds(49, 93, 96, 20);
		panel.add(lblQuantidade);

		edValor = new JTextField();
		edValor.setEditable(false);
		edValor.setFont(new Font("Arial", Font.PLAIN, 12));
		edValor.setBounds(49, 197, 223, 31);
		panel.add(edValor);

		textField_3 = new JTextField();
		textField_3.setBounds(49, 197, 223, 31);
		panel.add(textField_3);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblValor.setBounds(49, 175, 96, 20);
		panel.add(lblValor);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemPedidoAdicionar = new ItemPedido();
				if (itemPedidoEditar != null) {
					itemPedidoAdicionar.setIdItensPedido(itemPedidoEditar.getIdItensPedido());
				}

				itemPedidoAdicionar.setProdutoIdProduto(Integer.parseInt(edProduto.getText()));
				itemPedidoAdicionar.setQuantidadeTotal(Float.parseFloat(edQuantidade.getText()));
				itemPedidoAdicionar
						.setValorTotal(Float.parseFloat(edValor.getText()) * Float.parseFloat(edQuantidade.getText()));

				devolverItemPedido();

				dispose();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvar.setBounds(95, 270, 101, 37);
		contentPane.add(btnSalvar);
	}
}
