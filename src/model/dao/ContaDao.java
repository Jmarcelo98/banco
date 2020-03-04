package model.dao;

import java.util.List;

import model.entities.Conta;

public interface ContaDao {

	void inserir(Conta contaSimplesObj);

	void atualizar(Conta contaSimplesObj);

	void deletarPeloNumeroConta(int numero_Conta);

	// SE NÃO EXISTIR, RETORNA NULL
	Conta procurarPeloNumeroConta(int numero_Conta);

	List<Conta> procurarTodos();

}
