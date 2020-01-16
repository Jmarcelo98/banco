package model.dao;

import java.util.List;

import model.entities.Atendente;
import model.entities.Cliente;

public interface AtendenteDao {

	void inserir (Atendente atendenteObj);
	void atualizar (Atendente atendenteObj);
	void deletarPelaMatricula (String CPF);
	//SE NÃO EXISTIR, RETORNA NULL
	Cliente procurarPelaMatricula (String CPF);
	List<Atendente> procurarTodos();
	
}
