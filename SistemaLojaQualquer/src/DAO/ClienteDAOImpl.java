package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDAOImpl extends GenericDAO implements ClienteDAO {

	private Connection connection = null;

	public ClienteDAOImpl() throws SQLException, ClassNotFoundException {
		this.connection = getConnection("sistemalojaqualquer");
	}

	public void salvarCliente(Cliente cliente) {

		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO cliente (nome, endereco, idade)"
					+ "VALUES(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setInt(3, cliente.getIdade());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}
	
	public void editarCliente(Cliente cliente) {

		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE cliente SET nome = ?, endereco = ?, idade = ? WHERE idCliente = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getEndereco());
			pstmt.setInt(3, cliente.getIdade());
			pstmt.setInt(4, cliente.getIdCliente());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}
	
	public void deleteCliente(Integer idCliente) {

		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM cliente WHERE idCliente = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idCliente);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public Cliente getClienteById(Integer idCliente) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM cliente WHERE idCliente = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setIdade(rs.getInt("idade"));
				cliente.setEndereco(rs.getString("endereco"));
				return cliente;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}
	}

	public List<Cliente> getAllClientes() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			String sql = "SELECT * " + "FROM cliente";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setIdade(rs.getInt("idade"));
				cliente.setEndereco(rs.getString("endereco"));
				clientes.add(cliente);
			}

			return clientes;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}

	}

}