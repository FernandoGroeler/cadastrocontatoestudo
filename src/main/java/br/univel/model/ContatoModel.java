package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.dao.ContatoDao;
import br.univel.entidade.Contato;

public class ContatoModel extends AbstractTableModel {
	private static final long serialVersionUID = -1263820018596765290L;
	private List<Contato> lista;

	public ContatoModel() {
		this((List<Contato>)null);
		
		for (int i = 0; i < 10; i++) {
			Contato c = new Contato();
			c.setNome("Contato " + (i + 1));
			c.setTelefone("99112-589" + i);
			this.lista.add(c);
		}
	}
	
	public ContatoModel(List<Contato> _lista) {
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
        Contato c = this.lista.get(arg0);
        
        switch (arg1) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		}

        throw new RuntimeException("Coluna " + arg0 + " solicitada não existe.");
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
		case 0:
			return "Código";
		case 1:
			return "Nome";
		case 2:
			return "Descrição";
		}
		return super.getColumnName(arg0);
	}
	
	public void adicionar(Contato c) {
		ContatoDao dao = new ContatoDao();
		
		this.lista.add(c);
		super.fireTableDataChanged();
		dao.inserir(c);
	}
	
	public void remover(Contato c) {
		ContatoDao dao = new ContatoDao();
		
		this.lista.remove(c);
		super.fireTableDataChanged();
		dao.excluir(c);		
	}
	
	public Contato getContato(int idx) {
		return this.lista.get(idx);
	}
	
	public void atualizar(int idx) {
		ContatoDao dao = new ContatoDao();
		
		Contato c = getContato(idx);
		dao.atualizar(c);
	}
}
