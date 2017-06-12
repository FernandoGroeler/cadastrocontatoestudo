package br.univel.bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Conexao self;

	public static Conexao getInstance() {
		if (self == null)
			self = new Conexao();
		
		return self;
	}
	
	public Conexao() {
		conectar();
	}
	
	private Connection con;
	private static final String USUARIO = "postgres";
	private static final String SENHA = "pr4gr1m1d4r";	
	
	public Connection getCon() {
		return this.con;
	}
	
	private void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cadastroexemplo", USUARIO, SENHA);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				public void run() {
					try {
						Conexao.this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Só pode existir uma conexão!");
	}
}