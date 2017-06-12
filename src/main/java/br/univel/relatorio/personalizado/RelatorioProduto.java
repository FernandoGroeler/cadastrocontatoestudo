package br.univel.relatorio.personalizado;

import java.util.Iterator;
import java.util.List;

import br.univel.entidade.Produto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class RelatorioProduto implements JRDataSource {
	private Iterator<Produto> it;
	private Produto selecionado;
	
	public RelatorioProduto(List<Produto> lista) {
		this.it = lista.iterator();
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		if ("id".equals(arg0.getName()))
			return this.selecionado.getId();
		else if ("descricao".equals(arg0.getName()))
			return this.selecionado.getDescricao();
		else if ("valor".equals(arg0.getName()))
			return this.selecionado.getValor();
		
		throw new RuntimeException("Deu ruim!");
	}

	@Override
	public boolean next() throws JRException {
		if (this.it.hasNext()) {
			this.selecionado = this.it.next();
			return true;
		}
		
		return false;
	}

}
