package br.univel.apresentacao;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class PanelWrapper extends Panel {

	private static final long serialVersionUID = -3748545691001218815L;
	private JButton btnX;
	private JLabel lblTitulo;

	/**
	 * Create the panel.
	 */
	public PanelWrapper() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitulo = new JLabel("New label");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		btnX = new JButton("X");
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.anchor = GridBagConstraints.EAST;
		gbc_btnX.gridx = 1;
		gbc_btnX.gridy = 0;
		panel.add(btnX, gbc_btnX);

	}
	
	public void setConteudo(JPanel painel) {
		add(painel, BorderLayout.CENTER);
	}
	
	public void setAcaoFechar(ActionListener action) {
		btnX.addActionListener(action);
	}
	
	public void setTitulo(String titulo) {
		lblTitulo.setText(titulo);
	}
}
