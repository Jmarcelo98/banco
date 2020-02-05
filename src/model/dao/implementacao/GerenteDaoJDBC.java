package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

			//conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("INSERT into gerente (NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, SETOR_RESPONSAVEL) values (?,?,?,?,?)");

			st.setString(1, gerenteObj.getNome_completo());
			st.setString(2, gerenteObj.getMatricula());
			st.setString(3, gerenteObj.getEmail());
			st.setString(4, gerenteObj.getTelefone());
			st.setInt(5, gerenteObj.getSetorResponsavel());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "GERENTE CADASTRADO COM SUCESSO", "CADASTRO GERENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O GERENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public void atualizar(Gerente gerenteObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPelaMatricula(String Matricula) {
		// TODO Auto-generated method stub

	}

	@Override
	public Gerente procurarPelaMatricula(String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"select NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, SETOR from GERENTE,SETOR where SETOR_RESPONSAVEL = ID AND MATRICULA = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			if (rs.next()) {

				System.out.println();

				String nome_Completo = rs.getString("NOME_COMPLETO");
				String matricula = rs.getString("MATRICULA");
				String email = rs.getString("EMAIL");
				String telefone = rs.getString("TELEFONE");
				String setorRespon = rs.getString("SETOR");

				System.out.println("NOME COMPLETO: " + nome_Completo);
				System.out.println("MATRICULA: " + matricula);
				System.out.println("EMAIL: " + email);
				System.out.println("TELEFONE: " + telefone);
				System.out.println("SETOR_RESPONSAVEL: " + setorRespon);

			}

			return null;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public List<Gerente> procurarTodos() {
		return null;

	}

	public List<Gerente> retornarGerenteNome_Matricula() {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			List<Gerente> lista = new ArrayList<>();

			st = conexao.prepareStatement("select NOME_COMPLETO, MATRICULA from gerente");

			rs = st.executeQuery();

			while (rs.next()) {

				String matriculaGerente = rs.getString("MATRICULA");
				String nomeGerente = rs.getString("NOME_COMPLETO");

				System.out.println("MATRICULA: " + matriculaGerente + "  NOME COMPLETO: " + nomeGerente);

			}
			return lista;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
		}

	}

	public String nomeMatriculaConfirmacao(String Matricula) {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("select nome_completo, matricula from gerente where matricula = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			String nomeCompleto = " ";

			while (rs.next()) {

				String matriculaGerente = rs.getString("MATRICULA");
				String nomeGerente = rs.getString("NOME_COMPLETO");

				nomeCompleto = nomeCompleto + nomeGerente + " | MATRICULA: " + matriculaGerente;

			}
			return nomeCompleto;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
		}
	}
}
