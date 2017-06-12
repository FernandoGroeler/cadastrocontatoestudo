package br.univel.relatorio.personalizado;

import java.util.List;

import br.univel.dao.ProdutoDao;
import br.univel.entidade.Produto;
import br.univel.relatorio.ReportManager;
import net.sf.jasperreports.engine.JRDataSource;

public class RelatorioProdutoImpl {
	private static final String strFile = "C:\\Users\\Groeler\\JaspersoftWorkspace\\MyReports\\CustomFields.jasper";
	
	public void exportar() {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = dao.getTodos();
		
		JRDataSource ds = new RelatorioProduto(lista);
		
		ReportManager rm = new ReportManager(strFile);
		rm.exportar(ds);
	}
}