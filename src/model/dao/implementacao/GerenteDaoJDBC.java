package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import banco_de_dados.BdExcecao;
import banco_de_dados.Conexao_banco_dados;
import model.dao.GerenteDao;
import model.entities.Gerente;

public class GerenteDaoJDBC implements GerenteDao {

	Connection conexao = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	@Override
	public void inserir(Gerente gerenteObj) {
		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("INSERT INTO gerente "
					+ "(NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, SETOR_RESPONSAVEL)" + "values " + "(?,?,?,?,?)");

			st.setString(1, gerenteObj.getNome_completo());
			st.setString(2, gerenteObj.getMatricula());
			st.setString(3, gerenteObj.getEmail());
			st.setString(4, gerenteObj.getTelefone());
			st.setInt(5, gerenteObj.getSetorResponsavel());

			st.executeUpdate();

			st.close();

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

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
