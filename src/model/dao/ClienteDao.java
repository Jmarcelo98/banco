package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {
	
	void inserir (Cliente clienteObj);
	void atualizar (Cliente clienteObj);
	void deletarPeloCPF (String CPF);
	//SE NÃO EXISTIR, RETORNA NULL
	Cliente procurarPeloCPF (String CPF);
	List<Cliente> procurarTodos();

}
