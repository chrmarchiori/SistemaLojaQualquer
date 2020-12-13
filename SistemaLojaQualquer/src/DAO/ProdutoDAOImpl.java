package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAOImpl extends GenericDAO implements ProdutoDAO {

	private Connection connection = null;

	public ProdutoDAOImpl() throws SQLException, ClassNotFoundException {
		this.connection = getConnection("sistemalojaqualquer");
	}

	public void salvarProduto(Produto produto) {

		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO produto (nome, descricao, codigo, quantidade)"
					+ "VALUES(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setString(3, produto.getCodigo());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}
	
	public void editarProduto(Produto produto) {

		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE produto SET nome = ?, descricao = ?, codigo = ?, quantidade = ? WHERE idProduto = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setString(3, produto.getCodigo());
			pstmt.setInt(4, produto.getQuantidade());
			pstmt.setInt(5, produto.getIdProduto());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}
	
	public void deleteProduto(Integer idProduto) {

		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM produto WHERE idProduto = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idProduto);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close(connection);
		}

	}

	public Produto getProdutoById(Integer idProduto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM produto WHERE idProduto = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, idProduto);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setQuantidade(rs.getInt("quantidade"));
				return produto;
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

	public List<Produto> getAllProdutos() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<Produto>();

		try {
			String sql = "SELECT * " + "FROM produto";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produtos.add(produto);
			}

			return produtos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(rs);
			// close(connection);
		}

	}

}