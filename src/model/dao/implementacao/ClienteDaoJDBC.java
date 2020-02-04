package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import banco_de_dados.BdExcecao;
import banco_de_dados.Conexao_banco_dados;
import model.dao.ClienteDao;
import model.entities.Cliente;

public class ClienteDaoJDBC implements ClienteDao {

	Connection conexao = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	@Override
	public void inserir(Cliente clienteObj) {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement(
					"INSERT into cliente (NOME_COMPLETO, CPF, EMAIL, TELEFONE, DATA_NASCIMENTO, SALARIO) values (?,?,?,?,?,?)");

			st.setString(1, clienteObj.getNomeCompleto());
			st.setString(2, clienteObj.getCPF());
			st.setString(3, clienteObj.getEmail());
			st.setString(4, clienteObj.getTelefone());
			st.setString(5, clienteObj.getDataNascimento());
			st.setDouble(6, clienteObj.getSalarioLiquido());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println();
				System.out.println("CLIENTE CADASTRADO COM SUCESSO!!");
			} else {
				System.out.println();
				System.err.println("ERRO AO CADASTRAR O CLIENTE!!");
			}

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

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
