package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Setor;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SetorDaoJDBC td = new SetorDaoJDBC();

		List<Setor> list = new ArrayList<>();

		list = td.procurarTodos();
		
		for (Setor setor : list) {
			System.out.println(setor);
		}
		System.out.println();

//		System.out.println("1 - Cadastrar");
//		System.out.println("2 - Pesquisar");
//		System.out.println("3 - Criar uma nova conta");
//		System.out.print("Informe a opção desejada: ");
//
//		try {
//
//			int acaoEscolhida = sc.nextInt();
//
//			if (acaoEscolhida == 1) {
//				CadastrarFuncionario cadastrarFuncionar = new CadastrarFuncionario();
//				cadastrarFuncionar.cadastro();
//			}
//
//		} catch (InputMismatchException e) {
//			System.out.println();
//			System.err.println("ERA ESPERADO UM NÚMERO INTEIRO!");
//		}

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
