package controller;

import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDAO;
import DAO.ProdutoDAOImpl;
import model.Produto;

public class ProdutoController {

	private static ProdutoController instance;
	
	private ProdutoDAO produtoDAO;

	private ProdutoController() {
		try {
			this.produtoDAO = new ProdutoDAOImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ProdutoController getInstance() {
		if (instance == null) {
			instance = new ProdutoController();
		}
		return instance;
	}

	public void cadastrarProduto(Produto produto) {
		this.produtoDAO.salvarProduto(produto);
	}
	
	public Produto findProdutoById(Integer idProduto) {
		return this.produtoDAO.getProdutoById(idProduto);
	}

	public List<Produto> getAllProdutos() {
		return produtoDAO.getAllProdutos();
	}

	
	public void editarProduto(Produto produto) {
		this.produtoDAO.editarProduto(produto);
	}
	
	public void deleteProduto(Integer idProduto) {
		this.produtoDAO.deleteProduto(idProduto);
	}
	
	public void saveOrUpdate(Produto produto) {
		if (produto.getIdProduto() == null) {
			this.cadastrarProduto(produto);
		} else {
			this.editarProduto(produto);
		}
	}
}

