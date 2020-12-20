package DAO;

import java.util.List;

import model.ItemPedido;

public interface ItemPedidoDAO {
	public void salvarItemPedido(ItemPedido itemPedido);

	public void editarItemPedido(ItemPedido itemPedido);

	public ItemPedido getItemPedidoById(Integer idItemPedido);

	public List<ItemPedido> getAllItensPedido();

	public void deleteItemPedido(Integer idItemPedido);
}