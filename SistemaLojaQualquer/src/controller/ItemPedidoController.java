package controller;

import java.sql.SQLException;
import java.util.List;

import DAO.ItemPedidoDAO;
import DAO.ItemPedidoDAOImpl;
import model.ItemPedido;

public class ItemPedidoController {

	private static ItemPedidoController instance;

	private ItemPedidoDAO itemPedidoDAO;

	private ItemPedidoController() {
		try {
			this.itemPedidoDAO = new ItemPedidoDAOImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ItemPedidoController getInstance() {
		if (instance == null) {
			instance = new ItemPedidoController();
		}
		return instance;
	}

	public void cadastrarItemPedido(ItemPedido itemPedido) {
		this.itemPedidoDAO.salvarItemPedido(itemPedido);
	}

	public ItemPedido findItemPedidoById(Integer idItemPedido) {
		return this.itemPedidoDAO.getItemPedidoById(idItemPedido);
	}

	public List<ItemPedido> getAllItensProdutos() {
		return itemPedidoDAO.getAllItensPedido();
	}

	public void editarItemPedido(ItemPedido itemPedido) {
		this.itemPedidoDAO.editarItemPedido(itemPedido);
	}

	public void deleteItemPedido(Integer idItemPedido) {
		this.itemPedidoDAO.deleteItemPedido(idItemPedido);
	}

	public void saveOrUpdate(ItemPedido itemPedido) {
		if (itemPedido.getIdItensPedido() == null) {
			this.cadastrarItemPedido(itemPedido);
		} else {
			this.editarItemPedido(itemPedido);
		}
	}
}
