package br.univel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.univel.bancodados.Conexao;
import br.univel.entidade.Produto;

public class ProdutoDao {
	private static final String SQL_BUSCAR_TODOS = "SELECT * FROM PRODUTO";
	private static final String SQL_INSERIR = "INSERT INTO PRODUTO (DESCRICAO, VALOR) VALUES (?, ?)";
	private static final String SQL_EXCLUIR = "DELETE FROM PRODUTO WHERE ID = ?";
	private static final String SQL_ATUALIZAR = "UPDATE PRODUTO SET DESCRICAO = ?, VALOR = ? WHERE ID = ?";
	
	public List<Produto> getTodos() {
		Connection con = Conexao.getInstance().getCon();
		
		List<Produto> lista = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_BUSCAR_TODOS);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setDescricao(rs.getString(2));
				p.setValor(rs.getBigDecimal(3));
				
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void inserir(Produto p) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERIR);
			ps.setString(1, p.getDescricao());
			ps.setBigDecimal(2, p.getValor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Produto p) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_EXCLUIR);
			ps.setInt(1, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Produto p) {
		Connection con = Conexao.getInstance().getCon();
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_ATUALIZAR);
			ps.setString(1, p.getDescricao());
			ps.setBigDecimal(2, p.getValor());
			ps.setInt(3, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}