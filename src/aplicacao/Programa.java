package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.dao.implementacao.GerenteDaoJDBC;
import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Gerente;
import model.services.Atualizacao;
import model.services.Cadastramento;

public class Programa {

	public static void main(String[] args) {

		Cadastramento cadastrarFuncionario = new Cadastramento();
		Atualizacao atualizarDados = new Atualizacao();
		GerenteDaoJDBC gerenteJDBC = new GerenteDaoJDBC();
		Gerente gerente = new Gerente();
		SetorDaoJDBC setorDaoJDBC = new SetorDaoJDBC();

		Scanner sc = new Scanner(System.in);

		String mat = "G2231312";
		
		
		gerenteJDBC.deletarPelaMatricula(mat);
//		String resul = setorDaoJDBC.mostrarSetorDeAcordoComId(gerente.getSetorResponsavel());

//		 MENSAGEM
//		JOptionPane.showMessageDialog(null, "teste");
		// MENSAGEM DE ERRO
//		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);

//		Object[] possibleValues = { "EMAIL", "TELEFONE", "SETOR RESPONSÁVEL " };
//		Object selectedValue = JOptionPane.showInputDialog(null, "ESCOLHA O DADO QUE SEJA ATUALIZAR",
//				"ATUALIZAR DADOS DO GERENTE", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
//		
//		if (selectedValue == possibleValues[0]) {
//			System.out.println("0");
//		}  
//		else if (selectedValue == possibleValues[1]) {
//			System.out.println("1");
//		} 
//		else if (selectedValue == possibleValues[2]) {
//			System.out.println("2");
//		} 

		// ESCOLHA UM

//		int resposta = JOptionPane.showConfirmDialog(null, "choose one", "choose one", JOptionPane.YES_NO_OPTION);
//
//		if (resposta == 1) {
//			System.out.println("nao");
//		} else {
//			System.out.println("sim");
//		}

//		System.out.println(JOptionPane.showConfirmDialog(null, "choose one", "choose one", JOptionPane.YES_NO_OPTION));
//
//		// CLIQUE OK PARA CONTINUAR
//		Object[] options = { "OK", "CANCEL" };
//		JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION,
//				JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		// RECEBER DADOS
//		String resposta = JOptionPane.showInputDialog("Digite um valor:");
//		System.out.println(resposta);

//		try {
//
//			System.out.println("1 - Cadastrar");
//			System.out.println("2 - Pesquisar");
//			System.out.println("3 - Criar uma nova conta");
//			System.out.print("Informe a opção desejada: ");
//
//			int acaoEscolhida = sc.nextInt();
//
//			if (acaoEscolhida == 1) {
//

//				System.out.println();
//				System.out.println("1 - Cadastrar atendente");
//				System.out.println("2 - Cadastrar gerente");
//				System.out.println("3 - Cadastrar cliente");
//				System.out.print("Informe a opção desejada: ");
//
//				int opcaoDeCadastro = sc.nextInt();
//
//				if (opcaoDeCadastro == 1) {
//					Cadastramento.cadastrarAtendente();
//				} else if (opcaoDeCadastro == 2) {
//					Cadastramento.cadastrarGerente();
//				} else if (opcaoDeCadastro == 3) {
//					Cadastramento.cadastrarCliente();
//				} else {
//					System.err.println("Opção inválida!");
//				}
//
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
