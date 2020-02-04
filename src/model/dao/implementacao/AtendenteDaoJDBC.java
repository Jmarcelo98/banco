package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import banco_de_dados.BdExcecao;
import banco_de_dados.Conexao_banco_dados;
import model.dao.AtendenteDao;
import model.entities.Atendente;

public class AtendenteDaoJDBC implements AtendenteDao {

	Connection conexao = null;
	PreparedStatement st = null;

	@Override
	public void inserir(Atendente atendenteObj) {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("INSERT INTO atendente "
					+ "(NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, GERENTE_RESPONSAVEL)" + "values " + "(?,?,?,?,?)");

			st.setString(1, atendenteObj.getNome_completo());
			st.setString(2, atendenteObj.getMatricula());
			st.setString(3, atendenteObj.getEmail());
			st.setString(4, atendenteObj.getTelefone());
			st.setString(5, atendenteObj.getGerente_responsavel());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "ATENDENTE CADASTRADO COM SUCESSO", "CADASTRO ATENDENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O ATENDENTE", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public void atualizar(Atendente atendenteObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPelaMatricula(String Matricula) {

	}

	@Override
	public Atendente procurarPelaMatricula(String Matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atendente> procurarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
