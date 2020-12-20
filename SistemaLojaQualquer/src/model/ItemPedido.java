package model;

import java.sql.Date;

public class ItemPedido {

	private Integer idItensPedido;
	private Integer pedidoIdPedido;
	private Date pedidoDataEmissao;
	private Integer produtoIdProduto;
	private Float quantidade;
	private Float valorTotal;

	public ItemPedido() {
	}

	public Integer getIdItensPedido() {
		return idItensPedido;
	}

	public void setIdItensPedido(Integer idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	public Integer getPedidoIdPedido() {
		return pedidoIdPedido;
	}

	public void setPedidoIdPedido(Integer pedidoIdPedido) {
		this.pedidoIdPedido = pedidoIdPedido;
	}

	public Date getPedidoDataEmissao() {
		return pedidoDataEmissao;
	}

	public void setPedidoDataEmissao(java.sql.Date date) {
		this.pedidoDataEmissao = date;
	}

	public Integer getProdutoIdProduto() {
		return produtoIdProduto;
	}

	public void setProdutoIdProduto(Integer produtoIdProduto) {
		this.produtoIdProduto = produtoIdProduto;
	}

	public Float getQuantidadeTotal() {
		return quantidade;
	}

	public void setQuantidadeTotal(Float quantidadeTotal) {
		this.quantidade = quantidadeTotal;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

}
