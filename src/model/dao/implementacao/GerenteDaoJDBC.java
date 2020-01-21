package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
		return null;

	}

}
