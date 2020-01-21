package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.services.CadastrarFuncionario;

public class Programa {

	public static void main(String[] args) {

		CadastrarFuncionario cadastrarFuncionario = new CadastrarFuncionario();

		Scanner sc = new Scanner(System.in);

		System.out.println("1 - Cadastrar");
		System.out.println("2 - Pesquisar");
		System.out.println("3 - Criar uma nova conta");
		System.out.print("Informe a opção desejada: ");

		try {

			int acaoEscolhida = sc.nextInt();
			cadastrarFuncionario.cadastro();

			

		} catch (InputMismatchException e) {
			System.out.println();
			System.err.println("ERA ESPERADO UM NÚMERO INTEIRO!");
		}

//		Atendente atendente = new Atendente();
//
//		
//		System.out.print("nome: ");
//		String nomeCom = sc.nextLine();
//		
//		String matricula = atendente.gerarMatriculaAtendente();
//	
//		System.out.print("email: ");
//		String email = sc.nextLine();
//		
//		System.out.print("telefone: ");
//		String telefone = sc.nextLine();
//		
//		System.out.print("gerente: ");
//		String gerente = sc.nextLine();
//		
//		Atendente at = new Atendente(nomeCom, matricula, email, telefone, gerente);
//		
//		AtendenteDaoJDBC ad = new AtendenteDaoJDBC();
//		ad.inserir(at);

		sc.close();

	}

}
