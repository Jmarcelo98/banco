package model.dao;

import model.dao.implementacao.AtendenteDaoJDBC;
import model.dao.implementacao.ClienteDaoJDBC;
import model.dao.implementacao.ContaEspecialDaoJDBC;
import model.dao.implementacao.ContaSimplesDaoJDBC;
import model.dao.implementacao.GerenteDaoJDBC;

public class DaoFabrica {

	public static ClienteDao criarClienteDao() {
		return new ClienteDaoJDBC();
	}

	public static AtendenteDao criarAtendenteDao() {
		return new AtendenteDaoJDBC();
	}
	
	public static GerenteDao criarGerenteDao() {
		return new GerenteDaoJDBC();
	}
	
	public static ContaSimplesDao criarContaSimplesDao() {
		return new ContaSimplesDaoJDBC();
	}

	public static ContaEspecialDao criarContaEspecialDao() {
		return new ContaEspecialDaoJDBC();
	}
	
}
