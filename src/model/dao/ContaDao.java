package model.dao;

import java.util.List;

import model.entities.Conta;

public interface ContaDao {

	void inserir(Conta contaSimplesObj);

	void atualizar(Conta contaSimplesObj);

	void deletarPeloCPF(String CPF);

	// SE N�O EXISTIR, RETORNA NULL
	Conta procurarPeloCPF(String CPF);

	List<Conta> procurarTodos();

}
