package DAO;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {
	public void salvarProduto(Produto produto);
	
	public void editarProduto(Produto produto);
	
	public Produto getProdutoById(Integer idProduto);

	public List<Produto> getAllProdutos();
	
	public void deleteProduto(Integer idProduto);
}