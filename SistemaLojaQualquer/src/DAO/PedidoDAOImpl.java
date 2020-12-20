package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ItemPedidoController;
import model.ItemPedido;
import model.Pedido;

public class PedidoDAOImpl extends GenericDAO implements PedidoDAO {

	private Connection connection = null;

	public PedidoDAOImpl() throws SQLException, ClassNotFoundException {
		this.connection = getConnection("sistemalojaqualquer");
	}

	public void salvarPedido(Pedido pedido) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		java.sql.Statement stmt = null;

		try {
			String sql = "INSERT INTO pedido (dataEmissao, HoraEmissao, codigoCliente, quantidadeTotal, valorTotal)"
					+ "VALUES(?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, (Date) pedido.getDataEmissao());
			pstmt.setTime(2, pedido.getHoraEmissao());
			pstmt.setInt(3, pedido.getIdCliente());
			pstmt.setFloat(4, pedido.getQuantidadeTotal());
			pstmt.setFloat(5, pedido.getValorTotal());
			pstmt.executeUpdate();

			Integer idPedido = pegaIdPedido();

			List<ItemPedido> lista = pedido.getItensPedido();

			for (int i = 0; i <= lista.size() - 1; i++) {
				ItemPedido itemPedido = lista.get(i);
				ItemPedidoController itemPedidoController = ItemPedidoController.getInstance();
				itemPedido.setIdItensPedido(idPedido);
				itemPedidoController.cadastrarItemPedido(itemPedido);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	private Integer pegaIdPedido() {
		ResultSet rs = null;
		java.sql.Statement stmt = null;

		try {
			String sql = "SELECT MAX(idPedido) FROM pedido";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			Integer idPedido = 0;

			if (rs.next()) {
				idPedido = rs.getInt("idPedido");
			}

			return idPedido;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void editarPedido(Pedido pedido) {

		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE pedido SET dataEmissao = ?, HoraEmissao = ?, codigoCliente = ?, quantidadeTotal = ?, valorTotal = ? WHERE idPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, pedido.getDataEmissao());
			pstmt.setTime(2, pedido.getHoraEmissao());
			pstmt.setInt(3, pedido.getIdCliente());
			pstmt.setFloat(4, pedido.getQuantidadeTotal());
			pstmt.setFloat(5, pedido.getValorTotal());
			pstmt.setInt(6, pedido.getIdPedido());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public void deletePedido(Integer idPedido) {

		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM pedido WHERE idPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idPedido);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public Pedido getPedidoById(Integer idPedido) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM pedido WHERE idPedido = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idPedido);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPedido((rs.getInt("idPedido")));
				pedido.setDataEmissao((rs.getDate("dataEmissao")));
				pedido.setHoraEmissao(rs.getTime("horaEmissao"));
				pedido.setIdCliente(rs.getInt("codigoCliente"));
				pedido.setQuantidadeTotal(rs.getFloat("quantidadeTotal"));
				pedido.setValorTotal(rs.getFloat("valorTotal"));
				return pedido;
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

	public List<Pedido> getAllPedido() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Pedido> pedidos = new ArrayList<Pedido>();

		try {
			String sql = "SELECT * FROM pedido";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPedido((rs.getInt("idPedido")));
				pedido.setDataEmissao((rs.getDate("dataEmissao")));
				pedido.setHoraEmissao(rs.getTime("horaEmissao"));
				pedido.setIdCliente(rs.getInt("codigoCliente"));
				pedido.setQuantidadeTotal(rs.getFloat("quantidadeTotal"));
				pedido.setValorTotal(rs.getFloat("valorTotal"));
				pedidos.add(pedido);
			}

			return pedidos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}

	}

}