package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProdutoController;
import model.Produto;

public class JFCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField nomeProduto;
	private JTextField descricaoProduto;
	private JTextField idadeCliente;
	private JTextField codigoProduto;
	private ProdutoController produtoController;
	private Produto produtoEditar;
	private JTextField quantidadeProduto;
	private JTextField valorProduto;

	/**
	 * Launch the application.
	 **/
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroProduto frame = new JFCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void editar(Produto produto) {
		nomeProduto.setText(produto.getNome());
		descricaoProduto.setText(produto.getDescricao());
		codigoProduto.setText(produto.getCodigo());
		quantidadeProduto.setText(produto.getQuantidade().toString());
		valorProduto.setText(produto.getValor().toString());
		this.produtoEditar = produto;
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFCadastroProduto() {
		this.produtoController = ProdutoController.getInstance();
		setTitle("Cadastro de Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 321, 414);
		contentPane.add(panel);
		panel.setLayout(null);

		nomeProduto = new JTextField();
		nomeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nomeProduto.setBounds(49, 41, 223, 31);
		panel.add(nomeProduto);
		nomeProduto.setColumns(10);

		descricaoProduto = new JTextField();
		descricaoProduto.setBounds(49, 116, 223, 31);
		panel.add(descricaoProduto);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 17, 96, 20);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Descrição");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(49, 93, 96, 20);
		panel.add(lblSenha);

		codigoProduto = new JTextField();
		codigoProduto.setBounds(49, 197, 223, 31);
		panel.add(codigoProduto);
		
		idadeCliente = new JTextField();
		idadeCliente.setBounds(49, 197, 223, 31);
		panel.add(idadeCliente);
		
		JLabel lblIdade = new JLabel("Código");
		lblIdade.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblIdade.setBounds(49, 175, 96, 20);
		panel.add(lblIdade);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuantidade.setBounds(49, 260, 96, 20);
		panel.add(lblQuantidade);
		
		quantidadeProduto = new JTextField();
		quantidadeProduto.setBounds(49, 282, 223, 31);
		panel.add(quantidadeProduto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblValor.setBounds(49, 338, 96, 20);
		panel.add(lblValor);
		
		valorProduto = new JTextField();
		valorProduto.setBounds(49, 360, 223, 31);
		panel.add(valorProduto);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();
				if (produtoEditar != null) {
					produto.setIdProduto(produtoEditar .getIdProduto());
				}
				produto.setNome(nomeProduto.getText());
				produto.setDescricao(descricaoProduto.getText());
				produto.setCodigo(codigoProduto.getText());
				produto.setQuantidade(Integer.parseInt(quantidadeProduto.getText()));
				produto.setValor(Float.parseFloat(valorProduto.getText()));
				produtoController.saveOrUpdate(produto);
				new JFListaProdutos().atualizar();
				dispose();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvar.setBounds(98, 447, 101, 37);
		contentPane.add(btnSalvar);
	}
}
