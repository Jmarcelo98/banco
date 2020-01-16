package model.entities;

import java.io.Serializable;

public class Gerente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome_completo;
	private String matricula;
	private String email;
	private String telefone;
	private Integer setorResponsavel;

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

	public Integer getSetorResponsavel() {
		return setorResponsavel;
	}

	public void setSetorResponsavel(Integer setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}

}
