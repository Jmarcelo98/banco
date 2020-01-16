package model.dao;

import java.util.List;

import model.entities.Gerente;

public interface GerenteDao {

	void inserir (Gerente gerenteObj);
	void atualizar (Gerente gerenteObj);
	void deletarPelaMatricula (String CPF);
	//SE NÃO EXISTIR, RETORNA NULL
	Gerente procurarPelaMatricula (String CPF);
	List<Gerente> procurarTodos();
	
}
