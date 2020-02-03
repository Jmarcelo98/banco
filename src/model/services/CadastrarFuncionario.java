package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			System.out.println("--- FORNEÇA OS DADOS CORRETAMENTE ---");

			System.out.print("NOME COMPLETO: ");
			String nomeCompleto = sc.nextLine().toUpperCase();

			String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

			System.out.print("EMAIL: ");
			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				System.err.println("EMAIL INVÁLIDADO");

			} else {

				System.out.print("TELEFONE COM (DD): ");
				String telefone = sc.nextLine();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

				System.out.println();

				gerenteDaoJDBC.retornarGerenteNome_Matricula();
				System.out.println();
				System.out.print("INFORME O VALOR DA \"MATRICULA\" DO GERENTE RESPONSÁVEL: ");
				String valorMatricula = sc.nextLine().toUpperCase();

				System.out.println();
				System.out.println("NOME COMPLETO: " + nomeCompleto);
				System.out.println("MATRICULA: " + matricula);
				System.out.println("EMAIL: " + email);
				System.out.println("TELEFONE: " + telefone);
				System.out.println("GERENTE RESPONSÁVEL: " + gerenteDaoJDBC.nomeMatriculaConfirmacao(valorMatricula));

				System.out.println();

				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE ATENDENTE (Y/N): ");
				char resposta = sc.next().charAt(0);

				if (resposta == 'y' || resposta == 'Y') {
					atendente = new Atendente(nomeCompleto, matricula, email, telefoneFomartado, valorMatricula);
					atendenteDaoJDBC.inserir(atendente);

				} else {
					System.out.println();
					System.out.println("ATENDENTE NÃO CADASTRADO!! ");
				}
			}

		} catch (InputMismatchException e) {
			e.getMessage();
		}

	}

	public void cadastrarGerente() {

		try {

			System.out.println();
			System.out.println("--- FORNEÇA OS DADOS CORRETAMENTE ---");

			System.out.print("NOME COMPLETO: ");
			String nomeCompleto = sc.nextLine().toUpperCase();

			String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

			System.out.print("EMAIL: ");
			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				System.err.println("EMAIL INVÁLIDADO");

			} else {

				System.out.print("TELEFONE COM (DD): ");
				String telefone = sc.nextLine();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

				System.out.println();

				setorDaoJDBC.procurarTodos();
				System.out.println();
				System.out.print("INFORME O \"ID\" DE QUAL SETOR O GERENTE É RESPONSÁVEL: ");
				int setorResponsavel = sc.nextInt();

				System.out.println();
				System.out.println("NOME COMPLETO: " + nomeCompleto);
				System.out.println("MATRICULA: " + matricula);
				System.out.println("EMAIL: " + email);
				System.out.println("TELEFONE: " + telefone);
				System.out.println("SETOR RESPONSÁVEL: " + setorDaoJDBC.mostrarSetorDeAcordoComId(setorResponsavel));

				System.out.println();

				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE GERENTE (Y/N): ");
				char resposta = sc.next().charAt(0);

				if (resposta == 'y' || resposta == 'Y') {
					gerente = new Gerente(nomeCompleto, matricula, email, telefoneFomartado, setorResponsavel);
					gerenteDaoJDBC.inserir(gerente);
				} else {
					System.out.println();
					System.out.println("GERENTE NÃO CADASTRADO!! ");
				}

			}
		} catch (InputMismatchException e) {
			e.getMessage();
		}
	}

	public void cadastrarCliente() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {

			System.out.println();
			System.out.println("--- FORNEÇA OS DADOS CORRETAMENTE ---");

//			System.out.print("NOME COMPLETO: ");
//			String nomeCompleto = sc.nextLine().toUpperCase();
//
//			System.out.print("CPF: ");
//			String CPF = sc.nextLine().replaceAll("-", "");
//			CPF = FormatarStrings.formatCPF(CPF);

			System.out.print("RG: ");
			String RG = sc.nextLine().replaceAll(".", "");
			RG = FormatarStrings.formatRG(RG);
			
			System.out.println(RG);

			System.out.print("EMAIL: ");
			String email = sc.nextLine().toUpperCase();

			ValidarEmail validarEmail = new ValidarEmail(email);
			boolean validacao = validarEmail.validarEmail();

			if (validacao == false) {

				System.err.println("EMAIL INVÁLIDADO");

			} else {

				System.out.print("TELEFONE COM (DD): ");
				String telefone = sc.nextLine();
				String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""),
						"(##) #####-####");

				System.out.print("DATA DE NASCIMENTO (DD/MM/YYYY): ");
				String dataNascimento = sc.nextLine();
				String dataNascimentoFormatado = dataNascimento.replaceAll("/", "");
				dataNascimentoFormatado = FormatarStrings.formatDate(dataNascimentoFormatado);

				System.out.print("SÁLARIO BRUTO MENSAL: ");
				double salarioBruto = sc.nextDouble();

				System.out.println();

				System.out.print("TEM CERTEZA QUE DESEJA CADASTRAR ESSE GERENTE (Y/N): ");
				char resposta = sc.next().charAt(0);

				if (resposta == 'y' || resposta == 'Y') {

				}

			}
		} catch (InputMismatchException e) {
			e.getMessage();
		} catch (NumberFormatException e) {
			System.out.println();
			System.err.println("DIGITE APENAS NÚMEROS!! ");
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println();
			System.err.println("CPF/RG INVÁLIDO!! ");
		}
	}
}
