package aplicacao;

import banco_de_dados.Conexao_banco_dados;

public class Programa {

	public static void main(String[] args) {

		Conexao_banco_dados.abrirConexaoComOBanco();
		Conexao_banco_dados.fecharConexaoComoBanco();

	}

}
