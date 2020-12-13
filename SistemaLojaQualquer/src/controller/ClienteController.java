package controller;

import java.sql.SQLException;
import java.util.List;

import DAO.ClienteDAO;
import DAO.ClienteDAOImpl;
import model.Cliente;

public class ClienteController {

	private static ClienteController instance;
	
	private ClienteDAO clienteDAO;

	private ClienteController() {
		try {
			this.clienteDAO = new ClienteDAOImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	
	public void editarCliente(Cliente cliente) {
		this.clienteDAO.editarCliente(cliente);
	}
	
	public void deleteCliente(Integer idCliente) {
		this.clienteDAO.deleteCliente(idCliente);
	}
	
	public void saveOrUpdate(Cliente cliente) {
		if (cliente.getIdCliente() == null) {
			this.cadastrarCliente(cliente);
		} else {
			this.editarCliente(cliente);
		}
	}
}

