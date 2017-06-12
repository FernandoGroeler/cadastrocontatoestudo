package br.univel.entidade;

import br.univel.base.IId;
import br.univel.base.INome;

public class Contato implements IId, INome {
	private int id;
	private String nome;
	private String telefone;
	
	@Override
	public int getId() {
		return this.id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}