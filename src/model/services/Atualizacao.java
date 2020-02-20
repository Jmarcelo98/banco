package model.services;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import model.dao.implementacao.AtendenteDaoJDBC;
import model.dao.implementacao.ClienteDaoJDBC;
import model.dao.implementacao.GerenteDaoJDBC;
import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Atendente;
import model.entities.Cliente;
import model.entities.Gerente;

public class Atualizacao {

	SetorDaoJDBC setorDaoJDBC = new SetorDaoJDBC();
	GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();
	AtendenteDaoJDBC atendenteDaoJDBC = new AtendenteDaoJDBC();
	ClienteDaoJDBC clienteDaoJDBC = new ClienteDaoJDBC();
	Atendente atendente = new Atendente();
	Gerente gerente = new Gerente();
	Cliente cliente = new Cliente();

	public void atualizarAtendente(String Matricula) {

		try {

			String matricula = Matricula.toUpperCase();

			String aqui = atendenteDaoJDBC.emailTelefoneGerente(matricula);

			Object[] valoresPossiveis = { "EMAIL", "TELEFONE", "GERENTE RESPONS�VEL" };

			Object selectedValue = JOptionPane.showInputDialog(null, aqui + "\n\nINFORME QUAL DADO DESEJA ATUALIZAR\n\n",
					"DADOS DO ATENDENTE", JOptionPane.INFORMATION_MESSAGE, null, valoresPossiveis,
					valoresPossiveis[0]);

			if (selectedValue == valoresPossiveis[0]) {
				String email = JOptionPane.showInputDialog("NOVO EMAIL").toUpperCase();

				ValidarEmail validarEmail = new ValidarEmail(email);
				boolean validacao = validarEmail.validarEmail();

				if (validacao == false) {

					JOptionPane.showMessageDialog(null, "NOVO EMAIL INV�LIDADO", "ERROR", JOptionPane.ERROR_MESSAGE);

				} else {

					atendente = new Atendente(email, null, null);
					atendenteDaoJDBC.atualizar(atendente, matricula);
				}

			} else if (selectedValue == valoresPossiveis[1]) {

				String telefone = JOptionPane.showInputDialog("NOVO TELEFONE COM (DD)").toUpperCase();
				String telefoneFormatado = FormatarStrings
						.formatString(telefone.replaceAll(" ", "").replaceAll("() -", ""), "(##) #####-####");

				atendente = new Atendente(null, telefoneFormatado, null);
				atendenteDaoJDBC.atualizar(atendente, matricula);

			} else if (selectedValue == valoresPossiveis[2]) {

				int gerenteResponsavel = gerenteDaoJDBC.idGerente();

				atendente = new Atendente(null, null, gerenteResponsavel);
				atendenteDaoJDBC.atualizar(atendente, matricula);

			}

		} catch (InputMismatchException e) {
			e.getMessage();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "CAMPO N�O PODE SER NULO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void atualizarGerente(String Matricula) {

		try {

			String matricula = Matricula.toUpperCase();

			String aqui = gerenteDaoJDBC.emailTelefoneSetor(matricula);

			Object[] possibleValues = { "EMAIL", "TELEFONE", "SETOR RESPONS�VEL " };

			Object selectedValue = JOptionPane.showInputDialog(null, aqui + "\nINFORME QUAL DADO DESEJA ATUALIZAR \n\n",
					"DADOS DO GERENTE", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
					possibleValues[0]);

			if (selectedValue == possibleValues[0]) {
				String email = JOptionPane.showInputDialog("NOVO EMAIL").toUpperCase();

				ValidarEmail validarEmail = new ValidarEmail(email);
				boolean validacao = validarEmail.validarEmail();

				if (validacao == false) {

					JOptionPane.showMessageDialog(null, "NOVO EMAIL INV�LIDADO", "ERROR", JOptionPane.ERROR_MESSAGE);

				} else {

					gerente = new Gerente(email, null, null);
					gerenteDaoJDBC.atualizar(gerente, matricula);
				}

			} else if (selectedValue == possibleValues[1]) {

				String telefone = JOptionPane.showInputDialog("NOVO TELEFONE COM (DD)").toUpperCase();
				String telefoneFormatado = FormatarStrings
						.formatString(telefone.replaceAll(" ", "").replaceAll("() -", ""), "(##) #####-####");
				gerente = new Gerente(null, telefoneFormatado, null);
				gerenteDaoJDBC.atualizar(gerente, matricula);

			} else if (selectedValue == possibleValues[2]) {

				int setorResponsavel = setorDaoJDBC.idSetor();

				gerente = new Gerente(null, null, setorResponsavel);
				gerenteDaoJDBC.atualizar(gerente, matricula);
			}

		} catch (InputMismatchException e) {
			e.getMessage();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "CAMPO N�O PODE SER NULO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void atualizarCliente() {

		try {

			String CPF = JOptionPane.showInputDialog("FORNE�A O CPF DO CLIENTE QUE DESEJA ATUALIZAR OS DADOS \n")
					.replaceAll("-", "").replaceAll("\\.", "");
			CPF = FormatarStrings.formatarCPF(CPF);

			System.out.println(CPF);

			String aqui = clienteDaoJDBC.emailTelefoneSalario(CPF);

			Object[] possibleValues = { "EMAIL", "TELEFONE", "SAL�RIO " };

			Object selectedValue = JOptionPane.showInputDialog(null,
					aqui + "\n \n" + "INFORME QUAL DADO DESEJA ATUALIZAR", "ATUALIZAR DADOS DO CLIENTE",
					JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);

			if (selectedValue == possibleValues[0]) {
				String email = JOptionPane.showInputDialog("NOVO EMAIL").toUpperCase();

				ValidarEmail validarEmail = new ValidarEmail(email);
				boolean validacao = validarEmail.validarEmail();

				if (validacao == false) {

					JOptionPane.showMessageDialog(null, "NOVO EMAIL INV�LIDADO", "ERROR", JOptionPane.ERROR_MESSAGE);

				} else {

					cliente = new Cliente(email, null, 0);
					clienteDaoJDBC.atualizar(cliente, CPF);
				}

			} else if (selectedValue == possibleValues[1]) {

				String telefone = JOptionPane.showInputDialog("NOVO TELEFONE COM (DD)").toUpperCase();
				String telefoneFormatado = FormatarStrings
						.formatString(telefone.replaceAll(" ", "").replaceAll("() -", ""), "(##) #####-####");
				cliente = new Cliente(null, telefoneFormatado, 0);
				clienteDaoJDBC.atualizar(cliente, CPF);

			} else if (selectedValue == possibleValues[2]) {

				Double salario = Double.parseDouble(JOptionPane.showInputDialog("NOVO SAL�RIO L�QUIDO"));

				cliente = new Cliente(null, null, salario);
				clienteDaoJDBC.atualizar(cliente, CPF);
			}

		} catch (InputMismatchException e) {
			e.getMessage();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "CAMPO N�O PODE SER NULO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}
}
