package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.dao.ClienteDao;
import model.entities.Cliente;

public class ClienteDaoJDBC implements ClienteDao {

	Connection conexao = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	@Override
	public void inserir(Cliente clienteObj) {

	}

	@Override
	public void atualizar(Cliente clienteObj) {

	}

	@Override
	public void deletarPeloCPF(String CPF) {

	}

	@Override
	public Cliente procurarPeloCPF(String CPF) {

		return null;
	}

	@Override
	public List<Cliente> procurarTodos() {

		return null;
	}

}
