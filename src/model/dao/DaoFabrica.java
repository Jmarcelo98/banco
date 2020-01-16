package model.dao;

import model.dao.implementacao.AtendenteDaoJDBC;
import model.dao.implementacao.ClienteDaoJDBC;

public class DaoFabrica {

	public static ClienteDao criarClienteDao() {
		return new ClienteDaoJDBC();
	}

	public static AtendenteDao criarAtendenteDao() {
		return new AtendenteDaoJDBC();
	}

}
