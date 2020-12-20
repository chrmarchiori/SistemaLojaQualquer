package DAO;

import java.util.List;

import model.Pedido;

public interface PedidoDAO {
	public void salvarPedido(Pedido pedido);

	public void editarPedido(Pedido pedido);

	public Pedido getPedidoById(Integer idPedido);

	public List<Pedido> getAllPedido();

	public void deletePedido(Integer idPedido);
}