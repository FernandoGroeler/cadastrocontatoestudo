package br.univel.apresentacao;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class Panel extends JPanel {

	private static final long serialVersionUID = 992370825373018238L;

	/**
	 * Create the panel.
	 */
	public Panel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}

}
