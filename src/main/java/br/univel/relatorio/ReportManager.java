package br.univel.relatorio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.Locale;

import com.ibm.icu.text.SimpleDateFormat;

import br.univel.bancodados.Conexao;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportManager {
	private String caminhoRelatorio;
	private String nomeRelatorio;
	
	public ReportManager(String caminhoRelatorio) {
		this.caminhoRelatorio = caminhoRelatorio;
		
		File f = new File(caminhoRelatorio);
		this.nomeRelatorio = f.getName();
	}
	
	private JasperPrint getPrint() {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			return JasperFillManager.fillReport(this.caminhoRelatorio, null, con);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void viewer(JasperPrint jp) {
		Locale locale = Locale.getDefault();
		JasperViewer.viewReport(jp, false, locale);		
	}
	
	public void exportar() {
		JasperPrint jasperPrint = getPrint();
		
		SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd)_HH-mm-ss");
		
		String data = sdf.format(new Date());
		String nomePdf = this.nomeRelatorio + data + ".pdf";
		
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, nomePdf);
			Desktop.getDesktop().open(new File(nomePdf));
		} catch (JRException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exportar(JRDataSource ds) {
		JasperPrint jasperPrint;
		
		try {
			jasperPrint = JasperFillManager.fillReport(this.caminhoRelatorio, null, ds);
			viewer(jasperPrint);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void imprimir() {
		JasperPrint jasperPrint = getPrint();
		viewer(jasperPrint);
	}	
}