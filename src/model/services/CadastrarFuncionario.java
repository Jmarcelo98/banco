package model.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import model.entities.Atendente;
import model.entities.Gerente;

public class CadastrarFuncionario {

	Scanner sc = new Scanner(System.in);

	Atendente atendente = new Atendente();

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
		String nomeCompleto = sc.nextLine();

		String matricula = atendente.gerarMatriculaAtendente();
		atendente.setMatricula(matricula);

		System.out.print("EMAIL: ");
		String email = sc.nextLine();

		System.out.print("TELEFONE COM (DD): ");
		String telefone = sc.nextLine();
		String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""), "(##) #####-####");
	
		
		
		
		//Atendente atendente = new Atendente(nomeCompleto, matricula, email, telefoneFomartado, gerenteResponsavel);
		
		
		System.out.println("CHEGOU AQUI");

	}

	public void cadastrarGerente() {
		
		System.out.println();
		System.out.println("--- FORNEÇA OS DADOS CORRETAMENTE ---");

		System.out.print("NOME COMPLETO: ");
		sc.nextLine();
		String nomeCompleto = sc.nextLine();

		String matricula = atendente.gerarMatriculaAtendente();

		System.out.print("EMAIL: ");
		String email = sc.nextLine();

		System.out.print("TELEFONE COM (DD): ");
		String telefone = sc.nextLine();
		String telefoneFomartado = FormatarStrings.formatString(telefone.replaceAll(" ", ""), "(##) #####-####");
	
		
		System.out.println();
		
		System.out.println("SETOR RESPONSÁVEL");
		
		
		
		//Gerente gerente = new Gerente(nomeCompleto, matricula, email, telefoneFomartado, setorResponsavel)
		
		System.out.println("CHEGOU AQUI");


	}

	public void cadastrarCliente() {

	}

}
