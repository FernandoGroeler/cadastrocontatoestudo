package br.univel.relatorio.personalizado;

import java.util.Iterator;
import java.util.List;

import br.univel.entidade.Contato;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class RelatorioContato implements JRDataSource {
	private Iterator<Contato> it;
	private Contato selecionado;
	
	public RelatorioContato(List<Contato> lista) {
		this.it = lista.iterator();
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		if ("id".equals(arg0.getName()))
			return this.selecionado.getId();
		else if ("nome".equals(arg0.getName()))
			return this.selecionado.getNome();
		else if ("telefone".equals(arg0.getName()))
			return this.selecionado.getTelefone();
		
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
