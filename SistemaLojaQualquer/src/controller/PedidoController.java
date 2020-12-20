package controller;

import java.sql.SQLException;
import java.util.List;

import DAO.PedidoDAO;
import DAO.PedidoDAOImpl;
import model.Pedido;

public class PedidoController {

	private static PedidoController instance;

	private PedidoDAO pedidoDAO;

	private PedidoController() {
		try {
			this.pedidoDAO = new PedidoDAOImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PedidoController getInstance() {
		if (instance == null) {
			instance = new PedidoController();
		}
		return instance;
	}

	public void cadastrarPedido(Pedido pedido) {
		this.pedidoDAO.salvarPedido(pedido);
	}

	public Pedido findPedidoById(Integer idPedido) {
		return this.pedidoDAO.getPedidoById(idPedido);
	}

	public List<Pedido> getAllProdutos() {
		return pedidoDAO.getAllPedido();
	}

	public void editarPedido(Pedido pedido) {
		this.pedidoDAO.editarPedido(pedido);
	}

	public void deletePedido(Integer idPedido) {
		this.pedidoDAO.deletePedido(idPedido);
	}

	public void saveOrUpdate(Pedido pedido) {
		if (pedido.getIdPedido() == null) {
			this.cadastrarPedido(pedido);
		} else {
			this.editarPedido(pedido);
		}
	}
}
