package model.services;

import java.util.Scanner;

import model.dao.implementacao.GerenteDaoJDBC;
import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Atendente;
import model.entities.Gerente;

public class CadastrarFuncionario {

	Scanner sc = new Scanner(System.in);

	Atendente atendente = new Atendente();
	Gerente gerente = new Gerente();
	SetorDaoJDBC setorDaoJDBC = new SetorDaoJDBC();
	GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();
	ValidarEmail validarEmail = new ValidarEmail();

	public void cadastrarAtendente() {

		System.out.println();
		System.out.println("--- FORNEÇA OS DADOS CORRETAMENTE ---");

		System.out.print("NOME COMPLETO: ");
		sc.nextLine();
		String nomeCompleto = sc.nextLine().toUpperCase();

		String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

		System.out.print("EMAIL: ");
		String email = sc.nextLine();

		System.out.print("TELEFONE COM (DD): ");
		String telefone = sc.nextLine();
		String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""), "(##) #####-####");

		System.out.println();

		gerenteDaoJDBC.retornarGerenteNome_Matricula();
		System.out.println();
		System.out.println("INFORME O VALOR DA \"MATRICULA\" DO GERENTE RESPONSÁVEL: ");
		String valorMatricula = sc.nextLine().toUpperCase();

		atendente = new Atendente(nomeCompleto, matricula, email, telefoneFomartado, valorMatricula);

	}

	public void cadastrarGerente() {

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

			System.err.println("EMAIL NÃO VÁLIDADO");

		} else {

			System.out.print("TELEFONE COM (DD): ");
			String telefone = sc.nextLine();
			String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""), "(##) #####-####");

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

			if (resposta == 'y') {
				gerente = new Gerente(nomeCompleto, matricula, email, telefoneFomartado, setorResponsavel);
				gerenteDaoJDBC.inserir(gerente);
			} else {
				System.out.println();
				System.out.println("GERENTE NÃO CADASTRADO!! ");
			}

		}
	}

	public void cadastrarCliente() {

	}

}
