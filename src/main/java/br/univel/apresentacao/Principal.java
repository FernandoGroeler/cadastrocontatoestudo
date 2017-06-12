package br.univel.apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;

public class Principal extends Formulario {

	private static final long serialVersionUID = 8511535364764818543L;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnContato = new JButton("Contato");
		btnContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAbaContato();
			}
		});
		GridBagConstraints gbc_btnContato = new GridBagConstraints();
		gbc_btnContato.gridx = 0;
		gbc_btnContato.gridy = 0;
		panel.add(btnContato, gbc_btnContato);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

	}
	
	private void adicionarAbaContato() {
		JPanel panelContato = new PanelContato();
		
		PanelWrapper panelWrapper = new PanelWrapper();
		panelWrapper.setConteudo(panelContato);
		panelWrapper.setTitulo("Cadastro de contato");
		panelWrapper.setAcaoFechar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.remove(panelWrapper);
			}
		});
		
		tabbedPane.addTab("Contato", panelWrapper);
	}
}