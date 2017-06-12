package br.univel.relatorio.personalizado;

import java.util.List;

import br.univel.dao.ContatoDao;
import br.univel.entidade.Contato;
import br.univel.relatorio.ReportManager;
import net.sf.jasperreports.engine.JRDataSource;

public class RelatorioContatoImpl {
	private static final String strFile = "C:\\Users\\Groeler\\JaspersoftWorkspace\\MyReports\\CustomFields.jasper";
	
	public void exportar() {
		ContatoDao dao = new ContatoDao();
		List<Contato> lista = dao.getTodos();
		
		JRDataSource ds = new RelatorioContato(lista);
		
		ReportManager rm = new ReportManager(strFile);
		rm.exportar(ds);
	}
}
