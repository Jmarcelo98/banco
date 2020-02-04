package model.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.dao.implementacao.AtendenteDaoJDBC;
import model.dao.implementacao.ClienteDaoJDBC;
import model.dao.implementacao.GerenteDaoJDBC;
import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Atendente;
import model.entities.Cliente;
import model.entities.Gerente;

public class CadastrarFuncionario {

	Scanner sc = new Scanner(System.in);

	Cliente cliente = new Cliente();
	Atendente atendente = new Atendente();
	Gerente gerente = new Gerente();

	SetorDaoJDBC setorDaoJDBC = new SetorDaoJDBC();
	ClienteDaoJDBC clienteDaoJDBC = new ClienteDaoJDBC();
	GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();
	AtendenteDaoJDBC atendenteDaoJDBC = new AtendenteDaoJDBC();

	ValidarEmail validarEmail = new ValidarEmail();

	public void cadastrarAtendente() {

		try {

			System.out.println();
			System.out.println("--- FORNE�A OS DADOS CORRETAMENTE ---");

			System.out.print("NOME COMPLETO: ");
			String nomeCompleto = sc.nextLine().toUpperCase();

			String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

			System.out.print("EMAIL: ");
			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				System.err.println("EMAIL INV�LIDADO");

			} else {

				System.out.print("TELEFONE COM (DD): ");
				String telefone = sc.nextLine();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

				System.out.println();

				gerenteDaoJDBC.retornarGerenteNome_Matricula();
				System.out.println();
				System.out.print("INFORME O VALOR DA \"MATRICULA\" DO GERENTE RESPONS�VEL: ");
				String valorMatricula = sc.nextLine().toUpperCase();

				System.out.println();
				System.out.println("NOME COMPLETO: " + nomeCompleto);
				System.out.println("MATRICULA: " + matricula);
				System.out.println("EMAIL: " + email);
				System.out.println("TELEFONE: " + telefone);
				System.out.println("GERENTE RESPONS�VEL: " + gerenteDaoJDBC.nomeMatriculaConfirmacao(valorMatricula));

				System.out.println();

				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE ATENDENTE (Y/N): ");
				char resposta = sc.next().charAt(0);

				if (resposta == 'y' || resposta == 'Y') {
					atendente = new Atendente(nomeCompleto, matricula, email, telefoneFomartado, valorMatricula);
					atendenteDaoJDBC.inserir(atendente);

				} else {
					System.out.println();
					System.out.println("ATENDENTE N�O CADASTRADO!! ");
				}
			}

		} catch (InputMismatchException e) {
			e.getMessage();
		}

	}

	public void cadastrarGerente() {

		try {

			System.out.println();
			System.out.println("--- FORNE�A OS DADOS CORRETAMENTE ---");

			System.out.print("NOME COMPLETO: ");
			String nomeCompleto = sc.nextLine().toUpperCase();

			String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

			System.out.print("EMAIL: ");
			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				System.err.println("EMAIL INV�LIDADO");

			} else {

				System.out.print("TELEFONE COM (DD): ");
				String telefone = sc.nextLine();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

				System.out.println();

				setorDaoJDBC.procurarTodos();
				System.out.println();
				System.out.print("INFORME O \"ID\" DE QUAL SETOR O GERENTE � RESPONS�VEL: ");
				int setorResponsavel = sc.nextInt();

				System.out.println();
				System.out.println("NOME COMPLETO: " + nomeCompleto);
				System.out.println("MATRICULA: " + matricula);
				System.out.println("EMAIL: " + email);
				System.out.println("TELEFONE: " + telefone);
				System.out.println("SETOR RESPONS�VEL: " + setorDaoJDBC.mostrarSetorDeAcordoComId(setorResponsavel));

				System.out.println();

				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE GERENTE (Y/N): ");
				char resposta = sc.next().charAt(0);

				if (resposta == 'y' || resposta == 'Y') {
					gerente = new Gerente(nomeCompleto, matricula, email, telefoneFomartado, setorResponsavel);
					gerenteDaoJDBC.inserir(gerente);
				} else {
					System.out.println();
					System.out.println("GERENTE N�O CADASTRADO!! ");
				}

			}
		} catch (InputMismatchException e) {
			e.getMessage();
		}
	}

	public void cadastrarCliente() {

		try {

			JOptionPane.showMessageDialog(null, "FORNE�A OS DADOS CORRETAMENTE ", "DADOS DO CLIENTE",
					JOptionPane.WARNING_MESSAGE);

			String nomeCompleto = JOptionPane.showInputDialog("NOME COMPLETO").toUpperCase();

//			System.out.print("NOME COMPLETO: ");
//			String nomeCompleto = sc.nextLine().toUpperCase();

			String CPF = JOptionPane.showInputDialog("CPF").replaceAll("-", "");
			CPF = FormatarStrings.formatarCPF(CPF);

//			System.out.print("CPF: ");
//			String CPF = sc.nextLine().replaceAll("-", "");

			String email = JOptionPane.showInputDialog("EMAIL").toUpperCase();

//			System.out.print("EMAIL: ");
//			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				JOptionPane.showMessageDialog(null, "EMAIL INV�LIDADO", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				String telefone = JOptionPane.showInputDialog("TELEFONE COM (DD)").toUpperCase();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

//				System.out.print("TELEFONE COM (DD): ");
//				String telefone = sc.nextLine();

				String dataNascimento = JOptionPane.showInputDialog("DATA DE NASCIMENTO (DD/MM/YYYY)").toUpperCase();
				String dataNascimentoFormatado = dataNascimento.replaceAll("/", "");
				dataNascimentoFormatado = FormatarStrings.formatarData(dataNascimentoFormatado);

//				System.out.print("DATA DE NASCIMENTO (DD/MM/YYYY): ");
//				String dataNascimento = sc.nextLine();

				Double salarioLiquido = Double.parseDouble(JOptionPane.showInputDialog("SAL�RIO L�QUIDO MENSAL"));

//				System.out.print("SAL�RIO L�QUIDO MENSAL: ");
//				double salarioLiquido = sc.nextDouble();

				int resposta = JOptionPane.showConfirmDialog(null,
						"NOME COMPLETO: " + nomeCompleto + "\n CPF: " + CPF + "\n EMAIL: " + email + "\n TELEFONE: "
								+ telefoneFomartado + "\n DATA DE NASCIMENTO: " + dataNascimentoFormatado
								+ "\n SAL�RIO L�QUIDO: " + salarioLiquido
								+ "\n \n TEM CERTEZA QUE DESEJA CADASTRAR ESSE CLIENTE? ",
						"CONFIRMA��O DE CADASTRADO", JOptionPane.YES_NO_OPTION);

//				System.out.println("NOME COMPLETO: " + nomeCompleto);
//				System.out.println("CPF: " + CPF);
//				System.out.println("EMAIL: " + email);
//				System.out.println("TELEFONE: " + telefoneFomartado);
//				System.out.println("DATA DE NASCIMENTO: " + dataNascimentoFormatado);
//				System.out.println("SAL�RIO: " + salarioLiquido);
//
//				System.out.println();
//
//				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE CLIENTE (Y/N): ");

				if (resposta == 0) {
					cliente = new Cliente(nomeCompleto, CPF, email, telefoneFomartado, dataNascimentoFormatado,
							salarioLiquido);
					clienteDaoJDBC.inserir(cliente);
				} else {
					JOptionPane.showMessageDialog(null, "CLIENTE N�O CADASTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		} catch (InputMismatchException e) {
			e.getMessage();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "DIGITE APENAS N�MEROS", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "CPF INV�LIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "CAMPO N�O PODE SER NULO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
