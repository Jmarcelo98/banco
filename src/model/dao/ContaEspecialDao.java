package model.dao;

import java.util.List;

import model.entities.Conta;

public interface ContaEspecialDao {

	void inserir(Conta contaEspecialObj);

	void atualizar(Conta contaEspecialObj);

	void deletarPeloCPF(String CPF);

	// SE N�O EXISTIR, RETORNA NULL
	Conta procurarPeloCPF(String CPF);

	List<Conta> procurarTodos();

}
