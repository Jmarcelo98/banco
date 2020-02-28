package model.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO", "CADASTRO CLIENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR O CLIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public void atualizar(Cliente clienteObj, String CPF) {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			if (clienteObj.getEmail() != null) {

				st = conexao.prepareStatement("update cliente set EMAIL = (?) where cpf = ?");

				st.setString(1, clienteObj.getEmail());
				st.setString(2, CPF);

			} else if (clienteObj.getTelefone() != null) {

				st = conexao.prepareStatement("update cliente set TELEFONE = (?) where cpf = ?");

				st.setString(1, clienteObj.getTelefone());
				st.setString(2, CPF);

			} else if (clienteObj.getSalarioLiquido() != 0) {

				st = conexao.prepareStatement("update cliente set SALARIO = (?) where cpf = ?");

				st.setDouble(1, clienteObj.getSalarioLiquido());
				st.setString(2, CPF);

			}

			int linhasAfetadas = st.executeUpdate();

			if (linhasAfetadas > 0) {
				JOptionPane.showMessageDialog(null, "CADASTRADO ALTERADO COM SUCESSO", "CADASTRO CLIENTE",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR DADOS DO CLIENTE", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao_banco_dados.fecharStatement(st);
			Conexao_banco_dados.fecharConexaoComoBanco();
		}

	}

	@Override
	public void deletarPeloCPF(String CPF) {

	}

	@Override
	public Cliente procurarPeloCPF(String CPF) {

		try {

			conexao = Conexao_banco_dados.abrirConexaoComOBanco();

			st = conexao.prepareStatement(
					"select cliente.nome_completo, cliente.cpf, cliente.email, cliente.telefone, cliente.data_nascimento, "
							+ "cliente.salario from cliente where CPF = ?");
			st.setString(1, CPF);
			
			
			

		} catch (SQLException e) {

		}

		return null;
	}

	@Override
	public List<Cliente> procurarTodos() {

		return null;
	}

	public String emailTelefoneSalario(String CPF) {

		conexao = Conexao_banco_dados.abrirConexaoComOBanco();

		try {

			st = conexao.prepareStatement("SELECT email, telefone, salario FROM cliente where CPF = ?");

			st.setString(1, CPF);

			rs = st.executeQuery();

			String retorno = "";

			if (rs.next()) {

				String email = rs.getString("EMAIL");
				String telefone = rs.getString("TELEFONE");
				Double salario = rs.getDouble("SALARIO");

				retorno = "EMAIL: " + email + "\nTELEFONE: " + telefone + "\nSALÁRIO: " + salario;

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
