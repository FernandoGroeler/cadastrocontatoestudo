package br.univel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.dao.ProdutoDao;
import br.univel.entidade.Produto;

public class ProdutoModel extends AbstractTableModel {
	private static final long serialVersionUID = 8587297925030685319L;
	List<Produto> lista;
	
	public ProdutoModel() {
		this((List<Produto>)null);
		
		for (int i = 0; i < 10; i++) {
			Produto p = new Produto();
			p.setDescricao("Produto " + (i + 1));
			p.setValor(new BigDecimal(i));
			this.lista.add(p);
		}
	}
	
	public ProdutoModel(List<Produto> _lista) {
		if (_lista == null)
			this.lista = new ArrayList<>();
		else
			this.lista = _lista;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Produto p = this.lista.get(arg0);
		
		switch (arg1) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
		case 2:
			return p.getValor();
		}
		
		throw new RuntimeException("Coluna " + arg0 + " solicitada não existe.");
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
		case 0:
			return "Código";
		case 1:
			return "Descrição";
		case 2:
			return "Valor";
		}
		
		return super.getColumnName(arg0);
	}
	
	public void adicionar(Produto p) {
		ProdutoDao dao = new ProdutoDao();
		
		this.lista.add(p);
		super.fireTableDataChanged();
		dao.inserir(p);
	}
	
	public void remover(Produto p) {
		ProdutoDao dao = new ProdutoDao();
		
		this.lista.remove(p);
		super.fireTableDataChanged();
		dao.excluir(p);
	}
	
	public Produto getProduto(int idx) {
		return this.lista.get(idx)
;	}
	
	public void atualizar(int idx) {
		ProdutoDao dao = new ProdutoDao();
		
		Produto p = getProduto(idx);
		dao.atualizar(p);
	}
}