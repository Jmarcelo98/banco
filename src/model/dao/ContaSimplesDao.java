package model.dao;

import java.util.List;

import model.entities.ContaSimples;

public interface ContaSimplesDao {

	void inserir(ContaSimples contaSimplesObj);

	void atualizar(ContaSimples contaSimplesObj);

	void deletarPeloCPF(String CPF);

	// SE NÃO EXISTIR, RETORNA NULL
	ContaSimples procurarPeloCPF(String CPF);

	List<ContaSimples> procurarTodos();

}
