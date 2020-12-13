package controller;

import java.util.List;

import DAO.ClienteDAO;
import model.Cliente;

public class ClienteController {

	private static ClienteController instance;

	private ClienteDAO clienteDAO;

	private ClienteController() {
	}

	public static ClienteController getInstance() {
		if (instance == null) {
			instance = new ClienteController();
		}
		return instance;
	}

	public void cadastrarCliente(Cliente cliente) {
		this.clienteDAO.salvarCliente(cliente);
	}
	
	public Cliente findClienteById(Integer idCliente) {
		return this.clienteDAO.getClienteById(idCliente);
	}

	public List<Cliente> getAllCliente() {
		return clienteDAO.getAllClientes();
	}

}