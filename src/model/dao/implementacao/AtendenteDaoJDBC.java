package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	ResultSet rs = null;

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
			st.setInt(5, atendenteObj.getGerente_responsavel());

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
	public void atualizar(Atendente atendenteObj, String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			if (atendenteObj.getEmail() != null) {

				st = conexao.prepareStatement("update atendente set EMAIL = (?) where matricula = ?");
				st.setString(1, atendenteObj.getEmail());
				st.setString(2, Matricula);

			} else if (atendenteObj.getTelefone() != null) {

				st = conexao.prepareStatement("update atendente set TELEFONE = (?) where matricula = ?");
				st.setString(1, atendenteObj.getTelefone());
				st.setString(2, Matricula);

			} else if (atendenteObj.getGerente_responsavel() != null) {

				st = conexao.prepareStatement("update atendente set GERENTE_RESPONSAVEL = (?) where matricula = ?");
				st.setInt(1, atendenteObj.getGerente_responsavel());
				st.setString(2, Matricula);

			}

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "CADASTRADO ALTERADO COM SUCESSO", "CADASTRO ATENDENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR DADOS DO ATENDENTE", "ERROR",
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

	public String emailTelefoneGerente(String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"select NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, GERENTE_RESPOSAVEL from GERENTE,SETOR where SETOR_RESPONSAVEL = ID AND MATRICULA = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			String retorno = "";

			if (rs.next()) {

				String email = rs.getString("EMAIL");
				String telefone = rs.getString("TELEFONE");
				String gerenteRespon = rs.getString("GERENTE_RESPONSAVEL");

				retorno = "EMAIL: " + email + "\nTELEFONE: " + telefone + "\nGERENTE RESPONSÁVEL: " + gerenteRespon;

			}

			return retorno;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

}
