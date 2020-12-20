package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemPedido;

public class ItemPedidoDAOImpl extends GenericDAO implements ItemPedidoDAO {

	private Connection connection = null;

	public ItemPedidoDAOImpl() throws SQLException, ClassNotFoundException {
		this.connection = getConnection("sistemalojaqualquer");
	}

	public void salvarItemPedido(ItemPedido itemPedido) {

		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO itenspedidos (pedidoIdPedido, pedidoDataEmissao, produtoIdProduto, quantidade, valorTotal)"
					+ "VALUES(?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, itemPedido.getPedidoIdPedido());
			pstmt.setDate(2, (Date) itemPedido.getPedidoDataEmissao());
			pstmt.setInt(3, itemPedido.getProdutoIdProduto());
			pstmt.setFloat(4, itemPedido.getQuantidadeTotal());
			pstmt.setFloat(5, itemPedido.getValorTotal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public void editarItemPedido(ItemPedido itemPedido) {

		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE itenspedidos SET pedidoIdPedido = ?, pedidoDataEmissao = ?, produtoIdProduto = ?,"
					+ "quantidade = ?, valorTotal = ? Where idItensPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, itemPedido.getPedidoIdPedido());
			pstmt.setDate(2, (Date) itemPedido.getPedidoDataEmissao());
			pstmt.setInt(3, itemPedido.getProdutoIdProduto());
			pstmt.setFloat(4, itemPedido.getQuantidadeTotal());
			pstmt.setFloat(5, itemPedido.getValorTotal());
			pstmt.setInt(6, itemPedido.getIdItensPedido());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public void deleteItemPedido(Integer idItemPedido) {

		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM itenspedido WHERE idItensPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idItemPedido);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public ItemPedido getItemPedidoById(Integer idItemPedido) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM itenspedido WHERE idItensPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idItemPedido);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setIdItensPedido(rs.getInt("idItensPedido"));
				itemPedido.setPedidoIdPedido(rs.getInt("pedidoIdPedido"));
				itemPedido.setPedidoDataEmissao(rs.getDate("pedidoDataEmissao"));
				itemPedido.setProdutoIdProduto(rs.getInt("produtoIdProduto"));
				itemPedido.setQuantidadeTotal(rs.getFloat("quantidade"));
				itemPedido.setValorTotal(rs.getFloat("valorTotal"));
				return itemPedido;
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

	public List<ItemPedido> getAllItensPedido() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();

		try {
			String sql = "SELECT * FROM pedido";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemPedido itemPedido = new ItemPedido();
				itemPedido.setIdItensPedido(rs.getInt("idItensPedido"));
				itemPedido.setPedidoIdPedido(rs.getInt("pedidoIdPedido"));
				itemPedido.setPedidoDataEmissao(rs.getDate("pedidoDataEmissao"));
				itemPedido.setProdutoIdProduto(rs.getInt("produtoIdProduto"));
				itemPedido.setQuantidadeTotal(rs.getFloat("quantidade"));
				itemPedido.setValorTotal(rs.getFloat("valorTotal"));
				itensPedido.add(itemPedido);
			}

			return itensPedido;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}

	}

}