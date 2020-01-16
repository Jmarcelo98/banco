package model.dao;

import model.dao.implementacao.ClienteDaoJDBC;

public class DaoFabrica {

	public static ClienteDao criarClienteDao() {
		return new ClienteDaoJDBC();
	}
	
}
