
package banco_de_dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao_banco_dados {

	private static Connection conexao = null;

	
	
	// CONECTAR COM O BANCO DE DADOS
	public static Connection abrirConexaoComOBanco() {

		if (conexao == null) {
			try {

				// PEGANDO AS PROPRIEDADES DO OUTRO METODO
				Properties propriedades = lerPropriedades();
				// DBURL SERÁ ATRIBUIDO A VARIAVEL URL
				String url = propriedades.getProperty("dburl");
				conexao = DriverManager.getConnection(url, propriedades);

			} catch (SQLException e) {
				throw new BdExcecao(e.getMessage());
			}
		}
		System.out.println("Conectou");
		return conexao;
	}

	
	
	
	// FECHAR CONEXÃO COM O BANCO DE DADOS
	public static void fecharConexaoComoBanco() {
		//CONFERINDO SE A CONEXÃO É EXISTENTE E FECHANDO
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new BdExcecao(e.getMessage());
			}
		}
		System.out.println("saiu");
	}

	
	
	// LER ARQUIVO COM OS CAMINHOS/ITENS NECESSÁRIOS PARA CONEXÃO
	private static Properties lerPropriedades() {
		// PEGANDO O ARQUIVO
		try (FileInputStream entradaDeArquivo = new FileInputStream("db.properties")) {
			Properties propriedades = new Properties();
			// LENDO O ARQUIVO
			propriedades.load(entradaDeArquivo);
			return propriedades;

		} catch (IOException e) {
			throw new BdExcecao(e.getMessage());
		}

	}

}