package br.univel.entidade;

import java.math.BigDecimal;

import br.univel.base.IDescricao;
import br.univel.base.IId;

public class Produto implements IId, IDescricao {
	private int id;
	private String descricao;
	private BigDecimal valor;
	
	@Override
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	
	@Override
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}