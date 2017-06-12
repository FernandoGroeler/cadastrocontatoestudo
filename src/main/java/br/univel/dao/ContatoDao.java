package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.bancodados.Conexao;
import br.univel.entidade.Contato;

public class ContatoDao {
	private static final String SQL_BUSCAR_TODOS = "SELECT * FROM CONTATO";
	private static final String SQL_INSERIR = "INSERT INTO CONTATO (NOME, TELEFONE) VALUES (?, ?)";
	private static final String SQL_EXCLUIR = "DELETE FROM CONTATO WHERE ID = ?";
	private static final String SQL_ATUALIZAR = "UPDATE CONTATO SET NOME = ?, TELEFONE = ? WHERE ID = ?";
	
	public List<Contato> getTodos() {
		Connection con = Conexao.getInstance().getCon();
		
		List<Contato> lista = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_TODOS);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setTelefone(rs.getString(3));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	public void inserir(Contato c) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERIR);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public void excluir(Contato c) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_EXCLUIR);
			ps.setInt(1, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Contato c) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_ATUALIZAR);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}