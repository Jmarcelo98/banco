package model.dao;

import java.util.List;

import model.entities.ContaEspecial;

public interface ContaEspecialDao {

	void inserir (ContaEspecial contaEspecialObj);
	void atualizar (ContaEspecial contaEspecialObj);
	void deletarPeloCPF (String CPF);
	//SE NÃO EXISTIR, RETORNA NULL
	ContaEspecial procurarPeloCPF (String CPF);
	List<ContaEspecial> procurarTodos();
	
	
}
