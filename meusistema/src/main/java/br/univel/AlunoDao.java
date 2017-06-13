package br.univel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

	private static final String SQL_BUSCA_TODOS = "SELECT * FROM ALUNO";

	public List<Aluno> getTodos() {
		
		Connection con = ConexaoDB.getInstance().getConnection();
		
		List<Aluno> lista = new ArrayList<>();
		try (PreparedStatement ps = con.prepareStatement(SQL_BUSCA_TODOS);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getLong(1));
				a.setNome(rs.getString(2));
				a.setIdade(rs.getInt(3));
				a.setTelefone(rs.getString(4));
				
				lista.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
