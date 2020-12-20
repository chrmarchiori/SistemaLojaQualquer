package model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Pedido {

	private Integer idPedido;
	private Date dataEmissao;
	private Time horaEmissao;
	private Integer idCliente;
	private Float quantidadeTotal;
	private Float valorTotal;
	private List<ItemPedido> itensPedido;

	public Float getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public void setQuantidadeTotal(Float quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido() {
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(java.sql.Date date) {
		this.dataEmissao = date;
	}

	public Time getHoraEmissao() {
		return horaEmissao;
	}

	public void setHoraEmissao(Time horaEmissao) {
		this.horaEmissao = horaEmissao;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
