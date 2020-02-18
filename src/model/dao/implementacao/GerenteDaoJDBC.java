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

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement(
					"INSERT into gerente (NOME_COMPLETO, MATRICULA, EMAIL, TELEFONE, SETOR_RESPONSAVEL) values (?,?,?,?,?)");

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
	public void atualizar(Gerente gerenteObj, String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			if (gerenteObj.getEmail() != null) {

				st = conexao.prepareStatement("update gerente set EMAIL = (?) where matricula = ?");
				st.setString(1, gerenteObj.getEmail());
				st.setString(2, Matricula);

			} else if (gerenteObj.getTelefone() != null) {

				st = conexao.prepareStatement("update gerente set TELEFONE = (?) where matricula = ?");
				st.setString(1, gerenteObj.getTelefone());
				st.setString(2, Matricula);

			} else if (gerenteObj.getSetorResponsavel() != null) {

				st = conexao.prepareStatement("update gerente set SETOR_RESPONSAVEL = (?) where matricula = ?");
				st.setInt(1, gerenteObj.getSetorResponsavel());
				st.setString(2, Matricula);

			}
//
//			st = conexao.prepareStatement(
//					"update gerente set EMAIL, TELEFONE, SETOR_RESPONSAVEL  = (?,?,?) where matricula = ?");
//
//			st.setString(1, gerenteObj.getEmail());
//			st.setString(2, gerenteObj.getTelefone());
//			st.setInt(3, gerenteObj.getSetorResponsavel());

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "CADASTRADO ALTERADO COM SUCESSO", "CADASTRO GERENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR DADOS DO GERENTE", "ERROR",
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

	public int idGerente() {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("select ID, NOME_COMPLETO, MATRICULA from gerente");

			rs = st.executeQuery();

			List<String> listaGerente = new ArrayList<>();

			while (rs.next()) {

				int idGerente = rs.getInt("ID");
				String matriculaGerente = rs.getString("MATRICULA");
				String nomeGerente = rs.getString("NOME_COMPLETO");

				listaGerente.add(
						"ID: " + idGerente + " | MATRÍCULA: " + matriculaGerente + " | NOME: " + nomeGerente + "\n");

			}

			String gerente = "";

			for (int i = 0; i < listaGerente.size(); i++) {

				gerente = gerente + listaGerente.get(i) + "\n";

			}

			int idGerenteEscolhido = Integer
					.parseInt(JOptionPane.showInputDialog(gerente + "\nINFORME O ID DO GERENTE"));

			return idGerenteEscolhido;

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

	public String emailTelefoneSetor(String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"select EMAIL, TELEFONE, setor.setor from GERENTE,SETOR where SETOR_RESPONSAVEL = setor.ID AND MATRICULA = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			String retorno = "";

			if (rs.next()) {

				System.out.println();

				String email = rs.getString("EMAIL");
				String telefone = rs.getString("TELEFONE");
				String setorRespon = rs.getString("SETOR");

				retorno = "EMAIL: " + email + "\nTELEFONE: " + telefone + "\nSETOR RESPONSÁVEL: " + setorRespon;

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

	public String voltarMatriculaAtravesDoId(Integer id) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"select gerente.MATRICULA from gerente, atendente where (gerente_responsavel and gerente.id) = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			String retorno = "";

			if (rs.next()) {

				String matricula = rs.getString("MATRICULA");

				retorno = retorno + matricula;

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
