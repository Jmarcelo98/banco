package model.services;

import java.util.InputMismatchException;
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

	public void cadastro() {

		System.out.println();
		System.out.println("1 - Cadastrar atendente");
		System.out.println("2 - Cadastrar gerente");
		System.out.println("3 - Cadastrar cliente");
		System.out.print("Informe a opção desejada: ");

		try {

			int opcaoDeCadastro = sc.nextInt();

			if (opcaoDeCadastro == 1) {
				cadastrarAtendente();
			} else if (opcaoDeCadastro == 2) {
				cadastrarGerente();
			} else if (opcaoDeCadastro == 3) {
				cadastrarCliente();
			} else {
				System.err.println("Opção inválida!");
			}

		} catch (InputMismatchException e) {
			System.out.println();
			System.err.println("ERA ESPERADO UM NÚMERO INTEIRO!");
		}

	}

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
		sc.nextLine();
		String nomeCompleto = sc.nextLine().toUpperCase();

		String matricula = atendente.gerarMatriculaAtendente().toUpperCase();

		System.out.print("EMAIL: ");
		String email = sc.nextLine().toUpperCase();

		ValidarEmail validarEmail = new ValidarEmail(email);
		boolean validacao = validarEmail.validarEmail();
		
		if (validacao == false) {
			System.err.println("EMAIL NÃO VÁLIDADO");
		}

		System.out.print("TELEFONE COM (DD): ");
		String telefone = sc.nextLine();
		String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""), "(##) #####-####");

		System.out.println();

		setorDaoJDBC.procurarTodos();
		System.out.println();
		System.out.println("INFORME O VALOR DO \"ID\" DO SETOR RESPONSÁVEL: ");
		int setorResponsavel = sc.nextInt();

//		gerente = new Gerente(nomeCompleto, matricula, email, telefoneFomartado, setorResponsavel);
//		gerenteDaoJDBC.inserir(gerente);

	}

	public void cadastrarCliente() {

	}

}
