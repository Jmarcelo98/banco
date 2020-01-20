package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import banco_de_dados.BdExcecao;
import model.dao.GerenteDao;
import model.entities.Gerente;

public class GerenteDaoJDBC implements GerenteDao {

	Connection conexao = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	@Override
	public void inserir(Gerente gerenteObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Gerente gerenteObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPelaMatricula(String CPF) {
		// TODO Auto-generated method stub

	}

	@Override
	public Gerente procurarPelaMatricula(String CPF) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gerente> procurarTodos() {

		try {

			st = conexao.prepareStatement("select id, setor from setor ");

			List<Gerente> list = new ArrayList<>();
			Map<Integer, Gerente> map = new HashMap<>();

			while (rs.next()) {
				Gerente ger = map.get(rs.getInt("id"));
			}

			return list;
		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		}

	}

}
