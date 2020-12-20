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

import controller.ClienteController;
import model.Cliente;

public class JFCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeCliente;
	private JTextField enderecoCliente;
	private JTextField idadeCliente;
	private ClienteController clienteController;
	private Cliente clienteEditar;

	/**
	 * Launch the application.
	 **/
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroCliente frame = new JFCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void editar(Cliente cliente) {
		nomeCliente.setText(cliente.getNome());
		enderecoCliente.setText(cliente.getEndereco());
		idadeCliente.setText(cliente.getIdade().toString());
		this.clienteEditar = cliente;
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFCadastroCliente() {
		this.clienteController = ClienteController.getInstance();
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 321, 272);
		contentPane.add(panel);
		panel.setLayout(null);

		nomeCliente = new JTextField();
		nomeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nomeCliente.setBounds(49, 41, 223, 31);
		panel.add(nomeCliente);
		nomeCliente.setColumns(10);

		enderecoCliente = new JTextField();
		enderecoCliente.setBounds(49, 116, 223, 31);
		panel.add(enderecoCliente);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 17, 96, 20);
		panel.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Endereço");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSenha.setBounds(49, 93, 96, 20);
		panel.add(lblSenha);

		idadeCliente = new JTextField();
		idadeCliente.setBounds(49, 197, 223, 31);
		panel.add(idadeCliente);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblIdade.setBounds(49, 175, 96, 20);
		panel.add(lblIdade);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				if (clienteEditar != null) {
					cliente.setIdCliente(clienteEditar.getIdCliente());
				}
				cliente.setNome(nomeCliente.getText());
				cliente.setEndereco(enderecoCliente.getText());
				cliente.setIdade(Integer.parseInt(idadeCliente.getText()));
				clienteController.saveOrUpdate(cliente);
				new JFListaClientes().atualizar();
				dispose();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSalvar.setBounds(100, 293, 101, 37);
		contentPane.add(btnSalvar);
	}
}
