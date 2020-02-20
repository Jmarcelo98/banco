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
import model.services.Atualizacao;

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

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement("delete from atendente where matricula = ?");
			st.setString(1, Matricula);

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "ATENDENTE EXCLUÍDO COM SUCESSO", "CADASTRO GERENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O ATENDENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public Atendente procurarPelaMatricula(String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"select atendente.NOME_COMPLETO, atendente.MATRICULA, atendente.EMAIL, atendente.TELEFONE, GERENTE_RESPONSAVEL from atendente left join gerente on gerente_responsavel = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			while (rs.next()) {

				Atendente atendente = new Atendente();

				atendente.setNome_completo(rs.getString("NOME_COMPLETO"));
				atendente.setMatricula(rs.getString("MATRICULA"));
				atendente.setEmail(rs.getString("EMAIL"));
				atendente.setTelefone(rs.getString("TELEFONE"));
				atendente.setGerente_responsavel(rs.getInt("GERENTE_RESPONSAVEL"));

				int idGerenteResponsavel = atendente.getGerente_responsavel();

				GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();

				String nomeGerente = gerenteDaoJDBC.mostrarGerenteDeAcordoComId(idGerenteResponsavel);

				Object[] valoresPossiveis = { "ATUALIZAR DADOS DO ATENDENTE", "DELETAR DADOS DO ATENDENTE" };

				Object selectedValue = JOptionPane.showInputDialog(null,
						"NOME COMPLETO: " + atendente.getNome_completo() + "\nMATRÍCULA: " + atendente.getMatricula()
								+ "\nEMAIL: " + atendente.getEmail() + "\nTELEFONE: " + atendente.getTelefone()
								+ "\nGERENTE RESPONSÁVEL: " + nomeGerente + "\n\n",
						"ATUALIZAR DADOS DO GERENTE", JOptionPane.INFORMATION_MESSAGE, null, valoresPossiveis,
						valoresPossiveis[0]);

				if (selectedValue == valoresPossiveis[0]) {
					Atualizacao atu = new Atualizacao();
					atu.atualizarAtendente(Matricula);

				} else if (selectedValue == valoresPossiveis[1]) {

					int resposta = JOptionPane.showConfirmDialog(null,
							"TEM CERTEZA QUE DESEJA EXCLUIR ESSE ATENDENTE '" + atendente.getNome_completo() + " '",
							"EXCLUSÃO DE GERENTE", JOptionPane.YES_NO_OPTION);

					if (resposta == 0) {
						deletarPelaMatricula(Matricula);
					} else {
						JOptionPane.showMessageDialog(null, "ATENDENTE NÃO EXCLUÍDO", "EXCLUIR ATENDENTE",
								JOptionPane.ERROR_MESSAGE);
					}

				}
				return atendente;

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
	public List<Atendente> procurarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String emailTelefoneGerente(String Matricula) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement(
					"SELECT atendente.email, atendente.telefone, gerente.nome_completo FROM atendente, "
							+ "gerente WHERE atendente.GERENTE_RESPONSAVEL = gerente.id AND atendente.matricula = ?");

			st.setString(1, Matricula);

			rs = st.executeQuery();

			String retorno = "";

			if (rs.next()) {

				String email = rs.getString("EMAIL");
				String telefone = rs.getString("TELEFONE");
				String gerenteRespon = rs.getString("NOME_COMPLETO");

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
