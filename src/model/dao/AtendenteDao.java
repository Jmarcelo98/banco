package model.dao;

import java.util.List;

import model.entities.Atendente;

public interface AtendenteDao {

	void inserir (Atendente atendenteObj);
	void atualizar (Atendente atendenteObj);
	void deletarPelaMatricula (String CPF);
	//SE NÃO EXISTIR, RETORNA NULL
	Atendente procurarPelaMatricula (String CPF);
	List<Atendente> procurarTodos();
	
}
