package DAO;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	public void salvarCliente(Cliente cliente);
	
	public void editarCliente(Cliente cliente);
	
	public Cliente getClienteById(Integer idCliente);

	public List<Cliente> getAllClientes();
	
	public void deleteCliente(Integer idCliente);
}