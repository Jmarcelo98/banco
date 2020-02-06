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
import model.dao.SetorDao;
import model.entities.Setor;

public class SetorDaoJDBC implements SetorDao {

	Connection conexao = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	@Override
	public void inserir(Setor setorObj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Setor setorOb) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPelaMatricula(String CPF) {
		// TODO Auto-generated method stub

	}

	@Override
	public Setor procurarPelaMatricula(String CPF) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Setor> procurarTodos() {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			List<Setor> lista = new ArrayList<>();

			st = conexao.prepareStatement("select id, setor from setor");

			rs = st.executeQuery();

			List<String> listando = new ArrayList<>();

			while (rs.next()) {

				int idSetor = rs.getInt("ID");
				String nomeSetor = rs.getString("SETOR");

				listando.add("ID: " + idSetor + " | SETOR: " + nomeSetor + "\n");

				System.out.println("ID: " + idSetor + " SETOR: " + nomeSetor);
			}

			return lista;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	public int idSetor() {

		try {

			conexao = null;

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement("select id, setor from setor");

			rs = st.executeQuery();

			List<String> listando = new ArrayList<>();

			while (rs.next()) {

				int idSetor = rs.getInt("ID");
				String nomeSetor = rs.getString("SETOR");

				listando.add("ID: " + idSetor + " | SETOR: " + nomeSetor + "\n");

				// System.out.println("ID: " + idSetor + " SETOR: " + nomeSetor);
			}

			// PARA O JOPptionP
			String admin = listando.get(0);
			String comer = listando.get(1);
			String finan = listando.get(2);
			String oper = listando.get(3);
			String rh = listando.get(4);

			int idSetor = Integer.parseInt(
					JOptionPane.showInputDialog(admin + "\n" + comer + "\n" + finan + "\n" + oper + "\n" + rh + "\n"));

			return idSetor;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();

		}

	}

	public String mostrarSetorDeAcordoComId(int id) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement("select setor from setor where id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			String finals = null;

			while (rs.next()) {
				String setor = rs.getString("SETOR");
				finals = setor;
			}
			return finals;

		} catch (SQLException e) {
			throw new BdExcecao(e.getMessage());
		} finally {
			Conexao_banco_dados.fecharResultSet(rs);
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

}
