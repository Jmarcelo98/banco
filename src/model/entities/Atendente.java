package model.entities;

import java.io.Serializable;

public class Atendente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome_completo;
	private String matricula;
	private String email;
	private String telefone;
	private String gerente_responsavel;

	public Atendente() {
	}

	public Atendente(String nome_completo, String matricula, String email, String telefone,
			String gerente_responsavel) {
		this.nome_completo = nome_completo;
		this.matricula = matricula;
		this.email = email;
		this.telefone = telefone;
		this.gerente_responsavel = gerente_responsavel;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGerente_responsavel() {
		return gerente_responsavel;
	}

	public void setGerente_responsavel(String gerente_responsavel) {
		this.gerente_responsavel = gerente_responsavel;
	}

}
