package aplicacao;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.dao.implementacao.AtendenteDaoJDBC;
import model.dao.implementacao.ClienteDaoJDBC;
import model.dao.implementacao.ContaDaoJDBC;
import model.dao.implementacao.GerenteDaoJDBC;
import model.dao.implementacao.SetorDaoJDBC;
import model.entities.Conta;
import model.entities.Gerente;
import model.services.Atualizacao;
import model.services.Cadastramento;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
//		
		Conta conta = new Conta();
//		conta.geradorNumeroConta();
//		conta.digitoConta();
		
		conta.geradorNumeroConta();
		conta.digitoConta();

		Object[] acoesIniciais = { "FUNCIONÁRIOS", "CLIENTES", "CONTAS" };

		Object acaoInicialSelecionada = JOptionPane.showInputDialog(null,
				"QUAL ÁREA DESEJA FAZER ALGUMA AÇÃO " + "\n\n", "ManDad", JOptionPane.INFORMATION_MESSAGE, null,
				acoesIniciais, acoesIniciais[0]);

		if (acaoInicialSelecionada == acoesIniciais[0]) {

			Object[] acoesFuncionario = { "INSERIR FUNCIONÁRIO", "PROCURAR FUNCIONÁRIO" };

			Object acaoFuncionarioSelecionado = JOptionPane.showInputDialog(null, "SELECIONE A AÇÃO DESEJADA" + "\n\n",
					"ManDad", JOptionPane.INFORMATION_MESSAGE, null, acoesFuncionario, acoesFuncionario[0]);

			if (acaoFuncionarioSelecionado == acoesFuncionario[0]) {

				Object[] acoesInserir = { "ATENDENTE", "GERENTE" };

				Object acaoInserirSelecionada = JOptionPane.showInputDialog(null,
						"SELECIONE O CARGO PARA INSERIR UM NOVO FUNCIONÁRIO" + "\n\n", "ManDad",
						JOptionPane.INFORMATION_MESSAGE, null, acoesInserir, acoesInserir[0]);

				if (acaoInserirSelecionada == acoesInserir[0]) {

					Cadastramento cadastrarAtendente = new Cadastramento();
					cadastrarAtendente.cadastrarAtendente();

				} else if (acaoInserirSelecionada == acoesInserir[1]) {

					Cadastramento cadastramentoGerente = new Cadastramento();
					cadastramentoGerente.cadastrarGerente();

				}

			} else if (acaoFuncionarioSelecionado == acoesFuncionario[1]) {

				Object[] acoesProcurar = { "ATENDENTE", "GERENTE" };

				Object acaoProcurarSelecionada = JOptionPane.showInputDialog(null,
						"SELECIONE O CARGO PARA PESQUISAR POR UM FUNCIONÁRIO" + "\n\n", "ManDad",
						JOptionPane.INFORMATION_MESSAGE, null, acoesProcurar, acoesProcurar[0]);

				if (acaoProcurarSelecionada == acoesProcurar[0]) {

					Object[] acoesProcurarAtendente = { "PROCURAR TODOS OS ATENDENTES",
							"PROCURAR O ATENDENTE PELA MATRÍCULA" };

					Object acaoProcurarAtendenteSelecionada = JOptionPane.showInputDialog(null,
							"O QUE DESEJA FAZER" + "\n\n", "ManDad", JOptionPane.INFORMATION_MESSAGE, null,
							acoesProcurarAtendente, acoesProcurarAtendente[0]);

					if (acaoProcurarAtendenteSelecionada == acoesProcurarAtendente[0]) {

						AtendenteDaoJDBC atendenteDaoJDBC = new AtendenteDaoJDBC();
						atendenteDaoJDBC.procurarTodos();

					} else if (acaoProcurarAtendenteSelecionada == acoesProcurarAtendente[1]) {

						AtendenteDaoJDBC atendenteDaoJDBC = new AtendenteDaoJDBC();
						String Matricula = JOptionPane.showInputDialog(null, "INFORME A MATRÍCULA DO ATENDENTE");
						atendenteDaoJDBC.procurarPelaMatricula(Matricula);

					}

				} else if (acaoProcurarSelecionada == acoesProcurar[1]) {

					Object[] acoesProcurarGerente = { "PROCURAR TODOS OS GERENTES",
							"PROCURAR O GERENTE PELA MATRÍCULA" };

					Object acaoProcurarGerenteSelecionada = JOptionPane.showInputDialog(null,
							"O QUE DESEJA FAZER" + "\n\n", "ManDad", JOptionPane.INFORMATION_MESSAGE, null,
							acoesProcurarGerente, acoesProcurarGerente[0]);

					if (acaoProcurarGerenteSelecionada == acoesProcurarGerente[0]) {

						GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();
						gerenteDaoJDBC.procurarTodos();

					} else {

						GerenteDaoJDBC gerenteDaoJDBC = new GerenteDaoJDBC();
						String Matricula = JOptionPane.showInputDialog(null, "INFORME A MATRÍCULA DO GERENTE");
						gerenteDaoJDBC.procurarPelaMatricula(Matricula);

					}

				}

			}

		} else if (acaoInicialSelecionada == acoesIniciais[1]) {

			Object[] acoesCliente = { "CADASTRAR CLIENTE E CONTA", "CADASTRAR CONTA", "PROCURAR CLIENTE" };

			Object acaoClienteSelecionado = JOptionPane.showInputDialog(null, "SELECIONE A AÇÃO DESEJADA" + "\n\n",
					"ManDad", JOptionPane.INFORMATION_MESSAGE, null, acoesCliente, acoesCliente[0]);

			if (acaoClienteSelecionado == acoesCliente[0]) {

				Cadastramento cadastramento = new Cadastramento();
				cadastramento.cadastrarCliente();

			} else if (acaoClienteSelecionado == acoesCliente[1]) {

				ClienteDaoJDBC cliente = new ClienteDaoJDBC();
				String CPF = JOptionPane.showInputDialog(null, "INFORME O CPF DO CLIENTE");
				

			}

		} else if (acaoInicialSelecionada == acoesIniciais[2]) {
			System.out.println("con");
		}

		sc.close();

	}

}
